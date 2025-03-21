<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AJAX Fetch API với JSP & Servlet</title>
</head>
<body>
<h2>AJAX Fetch API với JSP & Servlet</h2>
<button id="loadData">Tải dữ liệu</button>
<p id="result"></p>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        document.getElementById("loadData").addEventListener("click", function () {
            fetch("DataServlet")
                .then(response => response.json())
                .then(data => {
                    console.log(">>> JSON Response:", data);
                    console.log("Kiểm tra message:", data.message);
                    console.log(`Server Response: ${data.message}`);


                    // document.getElementById("result").innerText = "Server Response 1: " + data.message;

                    <%--document.getElementById("result").innerText = `Server Response: ${data.message}`;--%>

                })
                .catch(error => console.error("Fetch error:", error));
        });
    });
</script>
</body>
</html>