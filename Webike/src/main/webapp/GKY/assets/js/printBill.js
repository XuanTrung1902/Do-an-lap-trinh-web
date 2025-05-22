document.addEventListener("DOMContentLoaded", function () {
    const confirmBtn = document.getElementById("confirmDownload");
    if (confirmBtn) {
        confirmBtn.addEventListener("click", async function () {
            try {
                const selectedInput = document.querySelector('input[name="format"]:checked');
                if (!selectedInput) {
                    alert("Vui lòng chọn định dạng trước khi xác nhận.");
                    return;
                }
                const selectedFormat = selectedInput.value;
                const billingCard = document.querySelector(".billing-card");
                const billingContainer = document.querySelector(".billing-container");
                const appContainer = document.querySelector(".app");

                if (!billingCard) {
                    alert("Không tìm thấy thông tin hóa đơn.");
                    return;
                }

                // Đảm bảo tất cả hình ảnh được tải trước khi chụp
                await Promise.all(Array.from(billingCard.querySelectorAll('img')).map(img => {
                    if (!img.complete) {
                        return new Promise(resolve => {
                            img.onload = img.onerror = resolve;
                        });
                    }
                    return Promise.resolve();
                }));

                // Lưu trữ kiểu dáng gốc
                const originalStyles = {
                    billingCard: {
                        height: billingCard.style.height,
                        overflow: billingCard.style.overflow,
                        position: billingCard.style.position,
                        width: billingCard.style.width,
                        maxWidth: billingCard.style.maxWidth,
                        margin: billingCard.style.margin,
                        top: billingCard.style.top
                    },
                    billingContainer: {
                        overflow: billingContainer.style.overflow,
                        minHeight: billingContainer.style.minHeight
                    },
                    appContainer: {
                        overflow: appContainer.style.overflow
                    }
                };

                // Tạm thời điều chỉnh kiểu dáng để chụp toàn bộ nội dung
                billingCard.style.height = 'auto';
                billingCard.style.overflow = 'visible';
                billingCard.style.position = 'absolute';
                billingCard.style.width = '1000px';
                billingCard.style.maxWidth = 'none';
                billingCard.style.margin = '0';
                billingCard.style.top = '0'; // Đảm bảo không bị đẩy xuống

                billingContainer.style.overflow = 'visible';
                billingContainer.style.minHeight = 'auto';

                appContainer.style.overflow = 'visible'; // Đảm bảo lớp cha không giới hạn

                // Ẩn các phần tử không cần thiết
                const overlay = document.querySelector('.modal__overlay');
                const modal = document.querySelector('.modal');
                const billingButton = document.querySelector('.billing-button');
                if (overlay) overlay.style.display = 'none';
                if (modal) modal.style.display = 'none';
                if (billingButton) billingButton.style.display = 'none'; // Ẩn nút "In hóa đơn" trong ảnh chụp

                // Debug kích thước
                console.log("Kích thước billing-card trước khi chụp:", billingCard.getBoundingClientRect());

                // Chụp ảnh
                let dataUrl;
                if (selectedFormat === "png" || selectedFormat === "jpg") {
                    dataUrl = await domtoimage.toJpeg(billingCard, {
                        quality: 1,
                        scale: 2,
                        bgcolor: '#fff',
                        style: {
                            'transform': 'none',
                            'left': '0',
                            'top': '0'
                        }
                    });
                    const link = document.createElement("a");
                    link.download = `hoa_don_${Date.now()}.png`;
                    link.href = dataUrl;
                    link.click();
                } else if (selectedFormat === "pdf") {
                    dataUrl = await domtoimage.toPng(billingCard, {
                        quality: 1,
                        scale: 2,
                        bgcolor: '#fff',
                        style: {
                            'transform': 'none',
                            'left': '0',
                            'top': '0'
                        }
                    });
                    const { jsPDF } = window.jspdf;
                    const pdf = new jsPDF({ orientation: 'portrait', unit: 'mm', format: 'a4' });
                    const imgProps = pdf.getImageProperties(dataUrl);
                    const pdfWidth = pdf.internal.pageSize.getWidth();
                    const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;

                    if (pdfHeight > pdf.internal.pageSize.getHeight()) {
                        const ratio = pdf.internal.pageSize.getHeight() / pdfHeight;
                        pdf.addImage(dataUrl, 'PNG', 0, 0, pdfWidth, pdfHeight * ratio);
                    } else {
                        pdf.addImage(dataUrl, 'PNG', 0, 0, pdfWidth, pdfHeight);
                    }
                    pdf.save(`hoa_don_${Date.now()}.pdf`);
                }

                // Khôi phục kiểu dáng gốc
                Object.assign(billingCard.style, originalStyles.billingCard);
                Object.assign(billingContainer.style, originalStyles.billingContainer);
                Object.assign(appContainer.style, originalStyles.appContainer);
                if (overlay) overlay.style.display = '';
                if (modal) modal.style.display = '';
                if (billingButton) billingButton.style.display = '';

                // Đóng modal bằng API của Bootstrap
                const modalElement = document.getElementById('printModal');
                const bootstrapModal = bootstrap.Modal.getInstance(modalElement);
                if (bootstrapModal) {
                    bootstrapModal.hide();
                }

            } catch (error) {
                alert("Có lỗi xảy ra khi tạo file. Vui lòng thử lại.\nChi tiết lỗi: " + error.message);
                console.error(error);

                // Đảm bảo khôi phục kiểu dáng ngay cả khi có lỗi
                const billingCard = document.querySelector(".billing-card");
                const billingContainer = document.querySelector(".billing-container");
                const appContainer = document.querySelector(".app");
                const overlay = document.querySelector('.modal__overlay');
                const modal = document.querySelector('.modal');
                const billingButton = document.querySelector('.billing-button');

                Object.assign(billingCard.style, originalStyles.billingCard);
                Object.assign(billingContainer.style, originalStyles.billingContainer);
                Object.assign(appContainer.style, originalStyles.appContainer);
                if (overlay) overlay.style.display = '';
                if (modal) modal.style.display = '';
                if (billingButton) billingButton.style.display = '';

                // Đóng modal trong trường hợp lỗi
                const modalElement = document.getElementById('printModal');
                const bootstrapModal = bootstrap.Modal.getInstance(modalElement);
                if (bootstrapModal) {
                    bootstrapModal.hide();
                }
            }
        });
    }
});