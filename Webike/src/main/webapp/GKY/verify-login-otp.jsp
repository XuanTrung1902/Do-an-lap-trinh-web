<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="vn.edu.hcmuaf.fit.webike.models.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%
  User pendingUser = (User) session.getAttribute("pending2fa");
  if (pendingUser == null) {
    response.sendRedirect("/Webike/Login");
    return;
  }

  String error = (String) request.getAttribute("error");
%>
<html>
<head>
    <meta charset="utf-8">
    <title>Webike: Đăng nhập</title>
    <%--  <base href="${pageContext.request.contextPath}/GKY/assets/">--%>
    <%--    <base href="<%= request.getContextPath()%>/GKY/assets/">--%>
    <%--  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/GKY/assets/css/Dangnhap.css">--%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/Dang nhap.css">
    <%--  <script src="https://www.google.com/recaptcha/api.js" async defer></script>--%>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>

<body>
<div class="login-root">
    <div class="box-root flex-flex flex-direction--column" style="min-height: 100vh;flex-grow: 1;">

        <!--animation back ground-->
        <div class="loginbackground box-background--white padding-top--48">
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
                    <img src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827" alt="Webike VN"
                         style="height: 60px;">
                </a></h1>
            </div>

            <div class="formbg-outer">
                <div class="formbg">
                    <div class="formbg-inner padding-horizontal--48">
                        <span class="padding-bottom--15">Xác minh mã OTP</span>

                                    <% if (request.getAttribute("error") != null) { %>
                                    <div class="error-message" style="color: red;">
                                      <%= request.getAttribute("error") %>
                                    </div>
                                    <% } %>

                        <form action="verify-otp" method="post">
                            <div class="field padding-bottom--24">
                                <label for="otp">Nhập mã OTP</label>
                                <input type="text" name="otp" id="otp" maxlength="6" required pattern="\\d{6}" placeholder="Nhập 6 số OTP">
                            </div>

                            <div class="field padding-bottom--24">
                                <input type="submit" value="Xác minh">
                            </div>

                            <div class="text-center">
                                <a href="resend-otp" style="color: #e31c25; font-weight: 600;">Gửi lại mã OTP</a>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="footer-link" style="padding: 10px;">
                    <span style="color: #fdeded">Quay lại <a href="${pageContext.request.contextPath}/Login" style="color: #e31c25">Đăng nhập</a></span>
                </div>
            </div>


        </div>
    </div>
</div>
<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>