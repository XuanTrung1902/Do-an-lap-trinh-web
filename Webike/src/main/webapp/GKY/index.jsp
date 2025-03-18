<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo ajax</title>
<%--    <script src="<%= request.getContextPath()%>/GKY/assets/js/test.js"></script>--%>
    <script src="/Webike/GKY/assets/js/test.js"></script>

</head>
<body>
<h2>AJAX Fetch API với JSP & Servlet</h2>
<label for="nameInput">Nhập tên của bạn:</label>
<input type="text" id="nameInput">
<button onclick="sendRequest()">Gửi</button>

<h3>Kết quả:</h3>
<p id="responseText"></p>
</body>
</html>
