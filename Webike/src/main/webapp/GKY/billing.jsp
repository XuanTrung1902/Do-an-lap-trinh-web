<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/base.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/billing.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/font/themify-icons/themify-icons.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css"/>
    <title>Thông tin đơn thanh toán</title>
</head>
<body>
<div class="app">
    <jsp:include page="/GKY/header.jsp"/>

    <div class="billing-container">
        <div class="billing-card">
            <div class="billing-header">
                <h1>Hóa đơn thanh toán</h1>
                <p>Số hoá đơn: <%=request.getParameter("vnp_TxnRef")%></p>
            </div>
            <div class="billing-info">
                <div class="billing-info__item">
                    <span class="billing-info__label">Tiền cọc:</span>
                    <span class="billing-info__value">
                        <f:formatNumber value="${sessionScope.deposit}" pattern="#,##0.###" />đ
                    </span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Tiền trả tiếp:</span>
                    <span class="billing-info__value">
                        <f:formatNumber value="${sessionScope.remain}" pattern="#,##0.###" />đ
                    </span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Ngày cọc:</span>
                    <span class="billing-info__value">${sessionScope.order.depositDate}</span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Ngày hẹn:</span>
                    <span class="billing-info__value"><%=request.getSession().getAttribute("appointment")%></span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Chi nhánh:</span>
                    <span class="billing-info__value">${shopAddress}</span>
                </div>                <div class="billing-info__item">
                    <span class="billing-info__label">Địa chỉ:</span>
                    <span class="billing-info__value"><%=request.getSession().getAttribute("address")%></span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Tên khách hàng:</span>
                    <span class="billing-info__value">${userName}</span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Số điện thoai:</span>
                    <span class="billing-info__value">${phoneNum}</span>
                </div>
            </div>
            <div class="order-items">
                <h2>Chi tiết sản phẩm</h2>
                <c:forEach var="o" items="${orderItem}">
                    <div class="order-item">
                        <img src="${o.img}" alt="${o.name}" class="order-item__img">
                        <div class="order-item__details">
                            <div class="order-item__detail">
                                <span class="order-item__label">Tên sản phẩm:</span>
                                <span class="order-item__value">${o.name}</span>
                            </div>
                            <div class="order-item__detail">
                                <span class="order-item__label">Số lượng:</span>
                                <span class="order-item__value">${o.quantity}</span>
                            </div>
                            <div class="order-item__detail">
                                <span class="order-item__label">Màu sản phẩm:</span>
                                <span class="order-item__value">${o.color.name}</span>
                            </div>
                            <div class="order-item__detail">
                                <span class="order-item__label">Giá sản phẩm:</span>
                                <span class="order-item__value">
                                    <f:formatNumber value="${o.price}" pattern="#,##0.###" />đ
                                </span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <%-- Button in hoa don --%>
        <div class="billing-button">
            <button class="print-invoice" data-bs-toggle="modal" data-bs-target="#printModal">In hóa đơn</button>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="printModal" tabindex="-1" aria-labelledby="printModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="printModalLabel">Chọn định dạng in</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="format" id="pngFormat" value="png" checked>
                        <label class="form-check-label" for="pngFormat">PNG</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="format" id="pdfFormat" value="pdf">
                        <label class="form-check-label" for="pdfFormat">PDF</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="button" class="btn btn-primary" id="confirmDownload">Xác nhận</button>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/GKY/footer.jsp"/>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/html2canvas@1.4.1/dist/html2canvas.min.js"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/dom-to-image-more@2.8/dist/dom-to-image-more.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>

<%--<script>--%>
<%--    document.getElementById('confirmPrint').addEventListener('click', function () {--%>
<%--        const format = document.querySelector('input[name="printFormat"]:checked').value;--%>
<%--        const billingCard = document.querySelector('.billing-card');--%>

<%--        // Thêm kiểm tra xem html2canvas và jsPDF có được tải không--%>
<%--        if (typeof html2canvas === 'undefined') {--%>
<%--            alert('Lỗi: Thư viện html2canvas không được tải. Vui lòng kiểm tra kết nối hoặc thử lại.');--%>
<%--            return;--%>
<%--        }--%>
<%--        if (typeof window.jspdf === 'undefined') {--%>
<%--            alert('Lỗi: Thư viện jsPDF không được tải. Vui lòng kiểm tra kết nối hoặc thử lại.');--%>
<%--            return;--%>
<%--        }--%>

<%--        // Fix tạm thời: tránh lỗi `oklch` nếu có--%>
<%--        billingCard.querySelectorAll("*").forEach(el => {--%>
<%--            const style = getComputedStyle(el);--%>
<%--            if (style.color.includes("oklch")) {--%>
<%--                el.style.color = "#000"; // fallback--%>
<%--            }--%>
<%--            if (style.backgroundColor.includes("oklch")) {--%>
<%--                el.style.backgroundColor = "#fff"; // fallback--%>
<%--            }--%>
<%--        });--%>

<%--        // Đảm bảo nội dung hiển thị đầy đủ trước khi chụp--%>
<%--        billingCard.style.height = 'auto';--%>
<%--        billingCard.style.overflow = 'visible';--%>

<%--        // Tùy chọn cho html2canvas--%>
<%--        const options = {--%>
<%--            scale: 2, // Tăng độ phân giải--%>
<%--            useCORS: true, // Cho phép tải hình ảnh từ URL khác--%>
<%--            allowTaint: true, // Cho phép xử lý hình ảnh bị tainted--%>
<%--            logging: true // Bật logging để debug--%>
<%--        };--%>

<%--        // Chụp .billing-card cho cả hai định dạng--%>
<%--        html2canvas(billingCard, options).then(canvas => {--%>
<%--            console.log('Canvas được tạo thành công:', canvas);--%>

<%--            if (format === 'png') {--%>
<%--                const imgData = canvas.toDataURL('image/png');--%>
<%--                const link = document.createElement('a');--%>
<%--                link.download = 'hoa_don_' + Date.now() + '.png';--%>
<%--                link.href = imgData;--%>
<%--                link.click();--%>
<%--            } else if (format === 'pdf') {--%>
<%--                const { jsPDF } = window.jspdf;--%>
<%--                const doc = new jsPDF({--%>
<%--                    orientation: 'portrait',--%>
<%--                    unit: 'mm',--%>
<%--                    format: 'a4'--%>
<%--                });--%>

<%--                const imgData = canvas.toDataURL('image/png');--%>
<%--                const imgProps = doc.getImageProperties(imgData);--%>
<%--                const pdfWidth = doc.internal.pageSize.getWidth();--%>
<%--                const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;--%>
<%--                doc.addImage(imgData, 'PNG', 0, 0, pdfWidth, pdfHeight);--%>
<%--                doc.save('hoa_don_' + Date.now() + '.pdf');--%>
<%--            }--%>
<%--        }).catch(err => {--%>
<%--            console.error('Lỗi khi tạo file:', err);--%>
<%--            alert('Có lỗi xảy ra khi tạo file. Vui lòng thử lại. Chi tiết lỗi: ' + err.message);--%>
<%--        });--%>

<%--        // Đóng modal--%>
<%--        bootstrap.Modal.getInstance(document.getElementById('printModal')).hide();--%>
<%--    });--%>
<%--</script>--%>
<script>
    window.onload = function () {
        const confirmBtn = document.getElementById("confirmDownload");
        if (confirmBtn) {
            confirmBtn.addEventListener("click", async function () {
                try {
                    // Kiểm tra xem domtoimage có tồn tại không
                    if (typeof domtoimage === 'undefined') {
                        alert("Lỗi: Thư viện domtoimage không được tải. Vui lòng kiểm tra kết nối hoặc thử lại.");
                        return;
                    }

                    const selectedInput = document.querySelector('input[name="format"]:checked');
                    if (!selectedInput) {
                        alert("Vui lòng chọn định dạng trước khi xác nhận.");
                        return;
                    }
                    const selectedFormat = selectedInput.value;
                    const billingCard = document.querySelector(".billing-card");

                    if (!billingCard) {
                        alert("Không tìm thấy thông tin hóa đơn.");
                        return;
                    }

                    // Đảm bảo nội dung hiển thị đầy đủ trước khi chụp
                    const originalHeight = billingCard.style.height;
                    const originalOverflow = billingCard.style.overflow;
                    billingCard.style.height = 'auto'; // Bỏ giới hạn chiều cao
                    billingCard.style.overflow = 'visible'; // Hiển thị toàn bộ nội dung

                    if (selectedFormat === "png" || selectedFormat === "jpg") {
                        const dataUrl = await domtoimage.toJpeg(billingCard, {
                            quality: 1, // Chất lượng tối đa (0-1)
                            scale: 2 // Tăng độ phân giải gấp 2 lần
                        });
                        const link = document.createElement("a");
                        link.download = `hoa_don_${Date.now()}.${selectedFormat}`;
                        link.href = dataUrl;
                        link.click();
                    } else if (selectedFormat === "pdf") {
                        const dataUrl = await domtoimage.toPng(billingCard, {
                            quality: 1, // Chất lượng tối đa
                            scale: 2 // Tăng độ phân giải
                        });
                        const { jsPDF } = window.jspdf;
                        const pdf = new jsPDF({
                            orientation: 'portrait',
                            unit: 'mm',
                            format: 'a4'
                        });
                        const imgProps = pdf.getImageProperties(dataUrl);
                        const pdfWidth = pdf.internal.pageSize.getWidth();
                        const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;

                        // Nếu nội dung quá dài, chia thành nhiều trang
                        if (pdfHeight > pdf.internal.pageSize.getHeight()) {
                            const ratio = pdf.internal.pageSize.getHeight() / pdfHeight;
                            const adjustedHeight = pdfHeight * ratio;
                            pdf.addImage(dataUrl, 'PNG', 0, 0, pdfWidth, adjustedHeight);
                        } else {
                            pdf.addImage(dataUrl, 'PNG', 0, 0, pdfWidth, pdfHeight);
                        }
                        pdf.save(`hoa_don_${Date.now()}.pdf`);
                    }

                    // Khôi phục lại style ban đầu
                    billingCard.style.height = originalHeight;
                    billingCard.style.overflow = originalOverflow;
                } catch (error) {
                    alert("Có lỗi xảy ra khi tạo file. Vui lòng thử lại.\nChi tiết lỗi: " + error.message);
                    console.error(error);
                }
            });
        }
    };
</script>


</body>
</html>