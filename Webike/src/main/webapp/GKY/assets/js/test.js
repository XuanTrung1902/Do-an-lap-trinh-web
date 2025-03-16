document.addEventListener("DOMContentLoaded", async function () {
    document.getElementById("loadData").addEventListener("click", async function () {
        fetch(getContextPath() + "/DataServlet") // Gọi API
            .then(response => response.text()) // Lấy dữ liệu dưới dạng text trước
            .then(data => {
                console.log("Dữ liệu đã parse:", data);
                var x = `Server Response : ${data.message}`;
                console.log(x);
                document.getElementById("rs").innerText = x;
            })
            .catch(error => console.error("Lỗi Fetch API:", error));
    });
});

// Hàm lấy context path từ JSP
function getContextPath() {
    return document.getElementById("contextPath").value;
}
