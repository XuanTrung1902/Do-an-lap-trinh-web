<%@ page import="java.sql.Date" %>
<%@ page import="vn.edu.hcmuaf.fit.webike.models.User" %>

<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WeBike</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />


<%--    <base href="${pageContext.request.contextPath}/GKY/assets/">--%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/base.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/headerFooter.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/trangTTKhachHang.css">



    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.min.css"> -->
     <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/bootstrap/css/bootstrap.css">

</head>
<body>
    <div class="app">
        <header class="header">
            <div class="grid__full-width">
                <a href="#" class="logo">
                    <img src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827" alt="Webike VN">
                </a>
                <nav class="header__navbar">
                    <div class="header__navbar--top">
                        <ul class="header__navbar--top_left">
                            <li class="header__navbar--item">
                                <a href="#">Trang chủ</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="product.html">Chợ xe máy</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="#">Tin tức</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="#">Đại lí</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="contact.html">Liên hệ</a>
                            </li>
                        </ul>

                        <ul class="header__navbar--top_right">
                            <li class="header__navbar--icon">
                                <a href="#">
                                    <i class="fa-brands fa-facebook m-r-8"></i>
                                </a>
                            </li>
                            <li class="header__navbar--icon">
                                <a href="#">
                                    <i class="fa-brands fa-youtube m-r-8"></i>
                                </a>
                            </li>

                            <!-- <li class="header__navbar--item header__navbar--separate">
                                <a href="#"><i class="fa-solid fa-user m-r-8" ></i>Đăng nhập</a>
                            </li>
                            <li class="header__navbar--item"><a href="#">Đăng ký</a></li> -->

                            <li class="header__navbar--item header__navbar--user">
<%--                                <img src="<%= request.getContextPath()%>/GKY/assets/img/avt1.jpg" alt="" class="header__navbar--user-img">--%>
                                <img src="<%= request.getContextPath() %>/${sessionScope.auth.image}" alt="" class="header__navbar--user-img">
                                <span class="header__navbar--user-name">${sessionScope.auth.name}</span>
                                <ul class="header__navbar--user-menu">
                                    <li class="header__navbar--user-menu-item">
                                        <a href="#"><i class="fa-solid fa-user m-r-8"></i>Thông tin cá nhân</a>
                                    </li>
                                    <li class="header__navbar--user-menu-item">
                                        <a href="#"><i class="fa-solid fa-shopping-cart m-r-8"></i>Lịch sử mua hàng</a>
                                    </li>
                                    <li class="header__navbar--user-menu-item">
                                        <a href="<%= request.getContextPath()%>/Logout"><i class="fa-solid fa-sign-out m-r-8"></i>Đăng xuất</a>
                                    </li>
                                </ul>
                            </li>


                        </ul>
                    </div>

                    <div class="header__navbar--bot">
                        <div class="header__search">
                            <input type="text" class="header__search--input" placeholder="Nhập từ khoá tìm kiếm">
                            <div class="header__search-select">
                                <span class="header__search-select-label">Tìm xe</span>
                                <i class="header__search-select-icon "></i>

                                <!-- <ul class="header__search-option">
                                    <li class="header__search-option-item">
                                        <span >Tìm phụ tùng</span>
                                    </li>
                                </ul> -->
                            </div>
                            <button class="header__search--btn">
                                <i class="header__search--btn-icon fa-solid fa-search"></i>
                            </button>
                        </div>

                        <div class="header__cart">
                            <a href="#" class="header__cart-link" >
                                <i class="header__cart-icon ti-shopping-cart"></i>
                                <span class="header__cart--text">Giỏ Hàng</span>
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
        </header>

        <div class="container-center">
            <div class="sidebar">
                <h3>TÀI KHOẢN</h3>
                <ul class="sidebar-menu">
                    <li><a href="<%= request.getContextPath()%>/Profile" id="show-profile">Thông tin tài khoản</a></li>
                    <li><a href="<%= request.getContextPath()%>/ChangePassword" id="change-password"  >Đổi mật khẩu</a></li>
                    <li><a href="#" id="change-avatar">Đổi ảnh đại diện</a></li>


                </ul>
            </div>

            <div class="profile-form" id="profile-form">
                <form action="<%= request.getContextPath()%>/Profile" method="post">
                    <c:if test="${not empty message}">
                        <div class="message" style="color: red">${message}</div>
                    </c:if>
                    <c:if test="${not empty error}">
                        <div class="error" style="color: red">${error}</div>
                    </c:if>
                    <div class="form-group">
                        <label for="username">Tên đăng nhập</label>
                        <input type="text" id="username" value="${sessionScope.auth.name}" disabled>
                    </div>

                    <div class="form-group">
                        <label for="fullname">Tên</label>
                        <input type="text" id="fullname" name="fullname" value="${sessionScope.auth.name}" placeholder="Văn Chương">
                    </div>

                    <div class="form-group">
                        <label for="phone">Số điện thoại</label>
                        <input type="tel" id="phone" name="phone" value="${sessionScope.auth.phoneNum}" placeholder="0312358497">
                    </div>
                    <div class="form-group">
                        <label for="address">Địa chỉ</label>
                        <input type="text" id="address" name="address" value="${sessionScope.auth.address}" placeholder="Tỉnh/Thành Phố, Huyện, Xã">
                    </div>

                    <div class="form-group">
                        <label>Giới tính</label>
                        <div class="gender-group">
                            <label class="custom-radio">
                                <input type="radio" id="male" name="gender" value="Nam" ${sessionScope.auth.sex == 'Nam' ? 'checked' : ''}>
                                <span class="checkmark"></span> Nam
                            </label>
                            <label class="custom-radio">
                                <input type="radio" id="female" name="gender" value="Nữ" ${sessionScope.auth.sex == 'Nữ' ? 'checked' : ''}>
                                <span class="checkmark"></span> Nữ
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Ngày sinh</label>
                        <div class="birth-date">
                            <select id="day-select" name="day">
                                <!-- Add options for days -->
                            </select>
                            <select id="month-select" name="month">
                                <!-- Add options for months -->
                            </select>
                            <select id="year-select" name="year">
                                <!-- Add options for years -->
                            </select>
                        </div>
                    </div>

                    <button type="submit" class="save-btn"  >Lưu</button>
                </form>
            </div>


            <!--            form đổi mật khẩu-->
            <div class="change-password-form" id="change-password-form" style="display: none;">
                    <form id="password-form" action="<%= request.getContextPath()%>/ChangePassword" method="post">
                    <div class="form-group">
                        <label for="current-password">Mật khẩu cũ</label>
<%--                        <input type="password" id="current-password" name="current-password" placeholder="Nhập mật khẩu cũ" required>--%>
                        <input type="password" id="current-password" name="current-password" placeholder="Nhập mật khẩu cũ" value="<%= request.getAttribute("current-password") != null ? request.getAttribute("current-password") : "" %>" required>
                    </div>
                        <% if (request.getAttribute("error") != null) { %>
                        <div class="error-message" style="color: red;">
                            <%= request.getAttribute("error") %>
                        </div>
                        <% } %>
                    <div class="form-group">
                        <label for="new-password">Mật khẩu mới</label>
                        <input type="password" id="new-password" name="new-password" placeholder="Nhập mật khẩu mới" required>
                    </div>
                    <div class="form-group">
                        <label for="confirm-password">Xác nhận mật khẩu mới</label>
                        <input type="password" id="confirm-password" name="confirm-password" placeholder="Xác nhận mật khẩu mới" required>
                    </div>
                    <button type="submit" class="save-btn">Đổi mật khẩu</button>
                </form>
            </div>

            <div class="change-avatar-form" style="display:none;">
                <h3>Đổi ảnh đại diện</h3>
                <div class="form-group">
                    <img id="avatar-preview" src="<%= request.getContextPath() %>/${sessionScope.auth.image}" alt="Ảnh đại diện" class="avatar-preview header__navbar--user-img">
                </div>
                <form id="change-avatar-form" action="<%= request.getContextPath() %>/ChangeAvatar" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="avatar-upload">Chọn ảnh:</label>
                        <input type="file" id="avatar-upload" name="avatar" accept="image/*" required>
                    </div>
                    <button type="submit" class="save-btn">Lưu thay đổi</button>
                </form>
            </div>



        </div>
        

        <footer class="footer">
              <div class="container">
                <footer class="py-5">
                  <div class="row">
                    <div class="col-6 col-md-2 mb-3">
                      <h5>Chợ xe máy</h5>
                      <ul class="nav flex-column">
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Phân khối lớn</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Hãng xe</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Loại xe</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Thịnh hành</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Cửa hàng</a></li>
                      </ul>
                    </div>
              
                    <div class="col-6 col-md-2 mb-3">
                      <h5>Thông tin khác</h5>
                      <ul class="nav flex-column">
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Quy chế hoạt động</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Chính sách bảo mật</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Hỗ trợ khách hàng</a></li>
                        <!-- <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Bản quyền</a></li> -->
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Liên hệ</a></li>
                      </ul>
                    </div>
              
                    <div class="col-6 col-md-2 mb-3">
                      <h5>Tin tức xe máy</h5>
                      <ul class="nav flex-column">
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Trang chủ</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Tin tức - sự kiện</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Thông tin xe máy</a></li>
                        <!-- <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Kinh nghiệm</a></li> -->
                        <!-- <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Video giải trí</a></li> -->
                      </ul>
                    </div>
              
                    <div class="col-md-5 offset-md-1 mb-3">
                      <form>
                        <h5>Phương thức thanh toán</h5>
                        <!-- <p>Monthly digest of what's new and exciting from us.</p> -->
                        <div class="d-flex flex-column flex-sm-row w-100 gap-2">
                            <img class="footer__banking" src="<%= request.getContextPath()%>/GKY/assets/img/bankcard1.png" alt="">
                            <img class="footer__banking" src="<%= request.getContextPath()%>/GKY/assets/img/bankcard2.png" alt="">
                            <img class="footer__banking" src="<%= request.getContextPath()%>/GKY/assets/img/bankcard3.png" alt="">
                            <img class="footer__banking" src="<%= request.getContextPath()%>/GKY/assets/img/bankcard4.png" alt="">
                            <img class="footer__banking" src="<%= request.getContextPath()%>/GKY/assets/img/bankcard5.png" alt="">
                            <img class="footer__banking" src="<%= request.getContextPath()%>/GKY/assets/img/bankcard6.png" alt="">
                        </div>
                        <div class="footer__rectangle">
                            <img src="<%= request.getContextPath()%>/GKY/assets/img/Rectangle.png" alt="">
                        </div>
                      </form>
                    </div>
                  </div>
              
                  <div class="d-flex flex-column flex-sm-row justify-content-between py-4 my-4 border-top">
                    <p>&copy; 2024 Company, Inc. All rights reserved.</p>
                    <ul class="list-unstyled d-flex">
                      <li class="ms-3"><a class="link-body-emphasis" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"/></svg></a></li>
                      <li class="ms-3"><a class="link-body-emphasis" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"/></svg></a></li>
                      <li class="ms-3"><a class="link-body-emphasis" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"/></svg></a></li>
                    </ul>
                  </div>
                </footer>
              </div>
        </footer>
    </div>
    <%
        User user = (User) request.getAttribute("user");
        Date date = user.getDOB();
        String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(formattedDate);

    %>

    <script>
        let dob = "<%= formattedDate %>";
        console.log(dob);
    </script>

    <script>
        document.getElementById('change-avatar').addEventListener('click', function() {
            document.querySelector('.change-avatar-form').style.display = 'block';
        });

        document.getElementById('avatar-upload').addEventListener('change', function(event) {
            const reader = new FileReader();
            reader.onload = function() {
                document.getElementById('avatar-preview').src = reader.result;
            };
            reader.readAsDataURL(event.target.files[0]);
        });
    </script>

    <script src="<%= request.getContextPath()%>/GKY/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="<%= request.getContextPath()%>/GKY/assets/bootstrap/js/popper.min.js"></script>



    <script src="<%= request.getContextPath()%>/GKY/assets/js/trangTTKhachHang.js">

    </script>

</body>
</html>