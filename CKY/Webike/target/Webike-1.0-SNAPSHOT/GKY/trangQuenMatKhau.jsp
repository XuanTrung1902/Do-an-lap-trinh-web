<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %><!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Quên Mật Khẩu</title>
<%--    <base href="${pageContext.request.contextPath}/GKY/assets/">--%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/quenMatKhau.css">
<%--    <script>--%>
<%--        function validatePhone() {--%>
<%--            var phone = document.forms["stripe-login"]["phone"].value;--%>
<%--            var password = document.forms["stripe-login"]["password"].value;--%>
<%--            if (phone == "" || password == "") {--%>
<%--                alert("SĐT và Mật khẩu không được để trống");--%>
<%--                return false;--%>
<%--            }--%>
<%--            return true;--%>
<%--        }--%>
<%--    </script>--%>

</head>
<body>

<div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
    <h1>
        <a href="#">
            <img src="<%= request.getContextPath()%>/GKY/assets/img/logo.png" alt="Webike VN" class="logo"/></a>
    </h1>
</div>

<div class="form-container">
    <h2>Quên mật khẩu?</h2>
<%--    onsubmit="return validatePhone()"--%>
    <form action="<%= request.getContextPath()%>/QuenMatKhau" method="post" >
        <label for="phone">SDT:</label>
<%--        <input type="tel" id="phone" name="phone" required>--%>
        <input type="tel" id="phone" name="phone" value="<%= request.getAttribute("phone") != null ? request.getAttribute("phone") : "" %>" required>
        <% if (request.getAttribute("error") != null) { %>
        <div class="error-message" style="color: red;">
            <%= request.getAttribute("error") %>
        </div>
        <% } %>
        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required>

        <label for="confirm_password">Nhập lại mật khẩu:</label>
        <input type="password" id="confirm_password" name="confirm_password" required>

        <button type="submit">Gửi</button>

    </form>
</div>
<%--<script src="<%= request.getContextPath()%>/GKY/assets/js/quenMatKhau.js"></script>--%>
</body>
</html>
