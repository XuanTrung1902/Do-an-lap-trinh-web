<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Quên Mật Khẩu</title>
    <base href="${pageContext.request.contextPath}/GKY/assets/">
    <link rel="stylesheet" href="css/quenMatKhau.css">

</head>
<body>

<div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
    <h1>
        <a href="#">
            <img src="img/logo.png" alt="Webike VN" class="logo" /></a>
    </h1>
</div>

<div class="form-container">
    <h2>Quên mật khẩu?</h2>
    <form action="${pageContext.request.contextPath}/QuenMatKhau" method="post">
<%--        <c:if test="${not empty error}">--%>
<%--            <div class="error">${error}</div>--%>
<%--        </c:if>--%>
<%--        <c:if test="${not empty message}">--%>
<%--            <div class="message">${message}</div>--%>
<%--        </c:if>--%>

        <label for="phone">SDT:</label>
        <input type="tel" id="phone" name="phone" required>

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required>

        <label for="confirm_password">Nhập lại mật khẩu:</label>
        <input type="password" id="confirm_password" name="confirm_password" required>

        <button type="submit">Gửi</button>
    </form>
</div>
<%--<script src="js/quenMatKhau.js"></script>--%>
</body>
</html>
