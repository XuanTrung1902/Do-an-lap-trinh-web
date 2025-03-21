
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <meta charset="utf-8">
  <title>Webike: Đăng nhập</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/js/all.min.js" integrity="sha512-6sSYJqDreZRZGkJ3b+YfdhB3MzmuP9R7X1QZ6g5aIXhRvR1Y/N/P47jmnkENm7YL3oqsmI6AK+V6AD99uWDnIw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<%--  <base href="/GKY/assets/">--%>
  <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/dangky.css">

</head>

<body>
<div class="sub-root">
  <div class="box-root flex-flex flex-direction--column" style="min-height: 100vh;flex-grow: 1;">

    <!--animation back ground-->
    <div class="loginbackground box-background--white padding-top--48";>
    <div class="loginbackground-gridContainer">
      <div class="box-root flex-flex" style="grid-area: top / start / 8 / end;">
        <div class="box-root" style="background-image: linear-gradient(black 0%, #111111 33%); flex-grow: 1;">
        </div>
      </div>
      <div class="box-root flex-flex" style="grid-area: 4 / 2 / auto / 5;">
        <div class="box-root box-divider--light-all-2 animationLeftRight tans3s" style="flex-grow: 1;"></div>
      </div>
      <div class="box-root flex-flex" style="grid-area: 6 / start / auto / 2;">
        <div class="box-root box-background--blue800" style="flex-grow: 1;"></div>
      </div>
      <div class="box-root flex-flex" style="grid-area: 7 / start / auto / 4;">
        <div class="box-root box-background--blue animationLeftRight" style="flex-grow: 1;"></div>
      </div>
      <div class="box-root flex-flex" style="grid-area: 8 / 4 / auto / 6;">
        <div class="box-root box-background--gray100 animationLeftRight tans3s" style="flex-grow: 1;"></div>
      </div>
      <div class="box-root flex-flex" style="grid-area: 2 / 15 / auto / end;">
        <div class="box-root box-background--cyan200 animationRightLeft tans4s" style="flex-grow: 1;"></div>
      </div>
      <div class="box-root flex-flex" style="grid-area: 3 / 14 / auto / end;">
        <div class="box-root box-background--blue animationRightLeft" style="flex-grow: 1;"></div>
      </div>
      <div class="box-root flex-flex" style="grid-area: 4 / 17 / auto / 20;">
        <div class="box-root box-background--gray100 animationRightLeft tans4s" style="flex-grow: 1;"></div>
      </div>
      <div class="box-root flex-flex" style="grid-area: 5 / 14 / auto / 17;">
        <div class="box-root box-divider--light-all-2 animationRightLeft tans3s" style="flex-grow: 1;"></div>
      </div>
    </div>
  </div>

  <div class="box-root flex-flex flex-direction--column" style="flex-grow: 1; z-index: 9;">
    <!--header-->
    <div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
      <h1><a href="#">
        <img src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827" alt="Webike VN" style="height: 60px;">
      </a></h1>
    </div>

    <div class="form_container">
      <div class="form_sub_header">
        <a href="Dangnhap.html"><h2>Đăng ký</h2></a>
      </div>

<%--        onsubmit="return validateForm()"--%>
<%--        onsubmit="return validatePhone(event)"--%>
        <form class="form_center" method="post" action="<%= request.getContextPath()%>/register"  >
            <div class="input_field">
                   <input type="text" name="fullname" placeholder="Họ Tên" value="<%= request.getAttribute("fullname") != null ? request.getAttribute("fullname") : "" %>" required>
            </div>
            <% if (request.getAttribute("error") != null) { %>
            <div class="error-message" style="color: red;">
                <%= request.getAttribute("error") %>
            </div>
            <% } %>
            <div class="input_field">
                    <input type="tel" name="phone" placeholder="Số điện thoại" value="<%= request.getAttribute("phone") != null ? request.getAttribute("phone") : "" %>" required>
            </div>
            <div class="input_field">
                    <input type="text" name="address" placeholder="Địa chỉ" value="<%= request.getAttribute("address") != null ? request.getAttribute("address") : "" %>" required>
            </div>
            <div class="input_field">
                <input type="email" id="email" name="email" placeholder="Email" value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>" required>
            </div>
            <button type="button" onclick="sendOtp()" style="width: 100%; padding: 12px; background-color: #e31c25; color: #fff; border: none; border-radius: 8px; font-size: 16px; cursor: pointer; transition: background-color 0.3s ease, box-shadow 0.3s ease; margin-bottom: 10px;">
                Gửi OTP
            </button>
            <div class="input_field">
                <input type="text" name="otp" placeholder="OTP" required>
            </div>
            <div class="form-group">
                <div class="gender-group">
                    <label class="custom-radio">
                        <input type="radio" id="male" name="gender" value="Nam" <%= "Nam".equals(request.getAttribute("gender")) ? "checked" : "" %>>
                        <span class="checkmark"></span> Nam
                    </label>
                    <label class="custom-radio">
                        <input type="radio" id="female" name="gender" value="Nữ" <%= "Nữ".equals(request.getAttribute("gender")) ? "checked" : "" %>>
                        <span class="checkmark"></span> Nữ
                    </label>

                </div>
            </div>
            <div class="form-group">
                <div class="birth-date">
                    <select id="day-select" name="day"></select>
                    <select id="month-select" name="month"></select>
                    <select id="year-select" name="year"></select>
                </div>
            </div>
            <div class="input_field">
                <input type="password" name="password" placeholder="Mật khẩu" required>
            </div>
            <div class="input_field">
                <input type="password" name="confirm_password" placeholder="Nhập lại mật khẩu" required>
            </div>
            <div class="checkbox">
                <input type="checkbox" name="terms" required>
                <label>Tôi đã đọc và chấp nhận <a href="#">Chính sách quyền riêng tư và chính sách bảo mật</a></label>
            </div>
            <button type="submit" class="submit_btn"><i class="fa-regular fa-user"></i> ĐĂNG KÝ</button>
            <p class="login-link">Bạn có sẵn sàng để tạo một tài khoản? <a href="<%= request.getContextPath()%>/Login" >Đăng nhập</a></p>
        </form>


    </div>

  </div>
  </div>
</div>
</div>


<script src="<%= request.getContextPath()%>/GKY/assets/js/dangKy.js"></script>
<script>
    function sendOtp() {
        // const email = document.querySelector('input[name="email"]').value;
        const email = document.getElementById('email').value;
        if (email) {
            fetch('<%= request.getContextPath()%>/sendotp?email=' + email, {
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
            alert('Vui lòng nhập email.');
        }
    }
</script>
</body>

</html>