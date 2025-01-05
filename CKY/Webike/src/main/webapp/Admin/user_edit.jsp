<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="./assets/css/admin.css"> -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/user_edit.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/base.css">
    <title>Admin</title>
</head>
<body>
    <section class="admin">
        <div class="row__grid">
            <div class="admin__sidebar">
                <div class="admin__sidebar--top">
                    <img src="./assets/images/logo.png" alt="">
                </div>
                <div class="admin__sidebar--content">
                    <ul>
                        <li><a href="#">
                                <i class="ri-dashboard-line"></i>
                                Dashboard
                                <i></i>
                            </a>
                            <ul class="sub-menu">
                                <div class="sub-menu-items">
                                    <li><a href="admin.jsp">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Tổng quan
                                        </a>
                                    </li>
                                </div>
                            </ul>
                        </li>
                        <li>
                            <a href="#">
                                <i class="ri-file-list-line"></i>
                                Người dùng
                                <i class="ri-add-box-line"></i>
                            </a>
                            <ul class="sub-menu">
                                <div class="sub-menu-items">
                                    <li><a href="user_list.jsp">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Danh sách
                                        </a>
                                    </li>
                                </div>
                            </ul>
                        </li>
                        <li>
                            <a href="#">
                                <i class="ri-file-list-line"></i>
                                Đơn hàng
                                <i class="ri-add-box-line"></i>
                            </a>
                            <ul class="sub-menu">
                                <div class="sub-menu-items">
                                    <li><a href="order_list.jsp">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Danh sách
                                        </a>
                                    </li>
                                    <li><a href="order_edit.jsp">
                                        <i class="ri-arrow-right-s-fill"></i>
                                        Sửa
                                    </a>
                                </li>
                                </div>
                            </ul>
                        </li>
                        <li>
                            <a href="#">
                                <i class="ri-file-list-line"></i>
                                Sản phẩm
                                <i class="ri-add-box-line"></i>
                            </a>
                            <ul class="sub-menu">
                                <div class="sub-menu-items">
                                    <li><a href="product_list.jsp">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Danh sách
                                        </a>
                                    </li>
                                    <li><a href="product_add.jsp">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Thêm
                                        </a>
                                    </li>
                                </div>
                            </ul>
                        </li>
                        <li>
                            <a href="#">
                                <i class="ri-file-list-line"></i>
                                Giảm giá
                                <i class="ri-add-box-line"></i>
                            </a>
                            <ul class="sub-menu">
                                <div class="sub-menu-items">
                                    <li><a href="discount.jsp">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Danh sách
                                        </a>
                                    </li>
                                    <li><a href="#">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Thêm
                                        </a>
                                    </li>
                                </div>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
    
            <div class="admin__content">
                <div class="admin__content-top flex-box">
                    <div class="admin__content-top-left">
                        <ul class="flex-box">
                            <li><i class="ri-search-line"></i></li>
                            <li> <i class="ri-drag-move-line"></i></li>
                        </ul>
                    </div>
                    <div class="admin__content-top-right flex-box">
                        <ul class="flex-box">
                            <li><i class="ri-notification-line" number="3"></i></li>
                            <li><i class="ri-message-2-line" number="5"></i></li>
                            <li class="flex-box">
                                <img style="width: 50px;" src="<%= request.getContextPath() %>/Admin/assets/images/logo.png" alt="">
                                <p>Trí Đức</p>
                                <i class="ri-arrow-down-s-fill"></i>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="admin-content-main">
                    <div class="admin-content-main-title">
                        <h1>Chỉnh sửa thông tin người dùng</h1>
                    </div>
                    <div class="admin-content-main-container">
                        <form class="edit-user-form" action="<%= request.getContextPath() %>/updateUser" method="post">
                            <div class="form-group">
                                <label for="userId">ID</label>
                                <input type="text" id="userId" name="userId" value="${user.id}" readonly>
                            </div>
                            <div class="form-group">
                                <label for="username">Tên đăng nhập</label>
                                <input type="text" id="username" name="username" value="${user.name}">
                            </div>
                            <div class="form-group">
                                <label for="password">Mật khẩu</label>
                                <input type="password" id="password" name="password" value="${user.password}">
                            </div>
                            <div class="form-group">
                                <label for="birthday">Ngày sinh</label>
                                <input type="date" id="birthday" name="birthday" value="${user.DOB}">
                            </div>
                            <div class="form-group">
                                <label for="address">Địa chỉ</label>
                                <input type="text" id="address" name="address" value="${user.address}">
                            </div>
                            <div class="form-group">
                                <label for="phone">SĐT</label>
                                <input type="text" id="phone" name="phone" value="${user.phoneNum}">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn-save">Lưu</button>
                                <button type="button" class="btn-cancel" onclick="window.location.href='<%= request.getContextPath() %>/userList'">Hủy</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="<%= request.getContextPath() %>/Admin/assets/js/sidebar.js"></script>
</body>
</html>