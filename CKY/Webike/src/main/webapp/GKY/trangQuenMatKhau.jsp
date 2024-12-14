<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Quên Mật Khẩu</title>
    <link rel="stylesheet" href="assets/css/quenMatKhau.css">

</head>
<body>

<div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
    <h1>
        <a href="#">
            <img src="assets/img/logo.png" alt="Webike VN" class="logo" /></a>
    </h1>
</div>

<div class="form-container">
    <h2>Quên mật khẩu?</h2>
    <form action="Dangnhap.jsp">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="username" required>

        <label for="email">Địa chỉ Email hoặc SDT:</label>
        <input type="email" id="email" name="email" required>

        <label for="captcha">Nhập mã captcha:</label>
        <div class="captcha-container">
            <input type="text" id="captcha" name="captcha" required>
            <img src="assets/img/quenMatKhau.png" height="34" width="128"/>
        </div>
        <button type="submit">Gửi</button>
    </form>
</div>
<script src="assets/js/quenMatKhau.js"></script>
</body>
</html>
