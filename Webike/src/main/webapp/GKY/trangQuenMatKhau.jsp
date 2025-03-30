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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/js/all.min.js" integrity="sha512-b+nQTCdtTBIRIbraqNEwsjB6UvL3UEMkXnhzd8awtCYh0Kcsjl9uEgwVFVbhoj3uu1DO1ZMacNvLoyJJiNfcvg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<%--    <base href="${pageContext.request.contextPath}/GKY/assets/">--%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/quenMatKhau.css">
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>

</head>
<body>

<div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
    <h1>
        <a href="#">
            <img src="<%= request.getContextPath()%>/GKY/assets/img/logo.png" alt="Webike VN" class="logo"/></a>
    </h1>
</div>


        <div class="form-container">
            <a href="<%= request.getContextPath()%>/Login" style="text-decoration: none; color: black; font-size: 24px;">
                <i class="fa-solid fa-backward"></i>
            </a>
            <h2>Quên mật khẩu?</h2>
            <form action="<%= request.getContextPath()%>/forgot-password" method="post">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%= request.getAttribute("phone") != null ? request.getAttribute("phone") : "" %>" required>

                <% if (request.getAttribute("error") != null) { %>
                <div class="error-message" style="color: red;">
                    <%= request.getAttribute("error") %>
                </div>
                <% } %>

                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required>

                <label for="confirm_password">Nhập lại mật khẩu:</label>
                <input type="password" id="confirm_password" name="confirm_password" required>

                <label for="otp">OTP:</label>
                <input type="text" id="otp" name="otp">

                <button type="button" onclick="sendOtp()" style="width: 100%; padding: 12px; background-color: #e31c25; color: #fff; border: none; border-radius: 8px; font-size: 16px; cursor: pointer; transition: background-color 0.3s ease, box-shadow 0.3s ease; margin-bottom: 10px;">
                    Gửi OTP</button>
                <div class="g-recaptcha" data-sitekey="6LfYyu4qAAAAADQyzw-_afuoVxOh-VJAkfjPvd7N"></div>

                <button type="submit">Gửi</button>
            </form>
        </div>
    <script>
        function sendOtp() {
            const email = document.getElementById('email').value;
            if (email) {
                fetch('<%= request.getContextPath()%>/send-otp?email='+email, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    body: `email=${email}`
                }).then(response => response.text()).then(data => {
                    alert(data);
                }).catch(error => {
                    console.error('Error:', error);
                });
            } else {
                alert('Vui lòng nhập Email.');
            }
        }
    </script>



<%--<script src="<%= request.getContextPath()%>/GKY/assets/js/quenMatKhau.js"></script>--%>
</body>
</html>
