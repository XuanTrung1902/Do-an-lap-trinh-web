<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>AJAX Fetch API với JSP Servlet</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Nhập tên của bạn:</h2>--%>
<%--<input type="text" id="nameInput" placeholder="Nhập tên...">--%>
<%--<button onclick="sendRequest()">Gửi</button>--%>

<%--<h3>Kết quả:</h3>--%>
<%--<p id="result"></p>--%>

<%--<script>--%>
<%--    function sendRequest() {--%>
<%--        const name = document.getElementById("nameInput").value;--%>
<%--        fetch(`<%= request.getContextPath()%>/hello?name=${name}`)--%>
<%--            .then(response => response.json())--%>
<%--            .then(data => {--%>
<%--                document.getElementById("result").innerText = data.message;--%>
<%--            })--%>
<%--            .catch(error => console.error("Lỗi:", error));--%>
<%--    }--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kiểm tra Template Literal</title>
</head>
<body>
<script>
    let name = "JSP";
    document.write(`Hello, ${name}!`); // Kiểm tra xem có lỗi không
</script>
</body>
</html>
