document.addEventListener("DOMContentLoaded", () => {
    // Debug biến contextPath
    console.log("contextPath:", contextPath);

    // Gắn sự kiện cho tất cả nút sửa
    document.querySelectorAll('.btn-edit').forEach(btn => {
        btn.addEventListener('click', function (e) {
            e.preventDefault();
            const logId = this.dataset.id;
            console.log("Log ID:", logId);

            const url = `${contextPath}/updateLog?id=${logId}`;
            console.log("Fetch URL:", url);

            fetch(url)
                .then(response => {
                    console.log("Fetch status:", response.status);
                    return response.text();
                })
                .then(text => {
                    console.log("Response text:", text);
                    let data;
                    try {
                        data = JSON.parse(text);
                    } catch (err) {
                        console.error("Không parse được JSON:", err);
                        alert("Dữ liệu server trả về không hợp lệ. Kiểm tra lại servlet.");
                        return;
                    }

                    // Đổ dữ liệu lên form modal
                    document.getElementById("logId").value = data.id;
                    document.getElementById("level").value = data.level;

                    // Định dạng thời gian
                    const dt = new Date(data.logTime);
                    const dtLocal = dt.toISOString().slice(0, 16);
                    document.getElementById("logTime").value = dtLocal;

                    document.getElementById("location").value = data.location;
                    document.getElementById("userInfo").value = data.userInfo;
                    document.getElementById("before").value = data.before;
                    document.getElementById("after").value = data.after;

                    document.getElementById("editLogModal").style.display = "block";
                })
                .catch(error => {
                    console.error("Lỗi khi fetch log:", error);
                    alert("Không thể tải log. Kiểm tra console.");
                });
        });
    });

    // Đóng modal sửa log
    document.querySelectorAll('.close-edit-log-modal').forEach(btn => {
        btn.addEventListener('click', () => {
            document.getElementById("editLogModal").style.display = "none";
        });
    });

    // Submit form sửa log
    document.getElementById("editLogForm").addEventListener("submit", function (e) {
        e.preventDefault();
        const formData = new FormData(this);

        fetch(`${contextPath}/updateLog`, {
            method: 'POST',
            body: new URLSearchParams(formData)
        })
            .then(res => res.text())
            .then(result => {
                alert("Cập nhật thành công");
                location.reload();
            })
            .catch(error => {
                console.error("Lỗi cập nhật log:", error);
                alert("Cập nhật thất bại");
            });
    });
});
