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
                    <img src="<%= request.getContextPath() %>/Admin/assets/images/logo.png" alt="">
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
                                    <li><a href="<%= request.getContextPath() %>/admin">
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
                                    <li><a href="<%= request.getContextPath() %>/userList">
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
                                    <li><a href="order_list.html">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Danh sách
                                        </a>
                                    </li>
                                    <li><a href="order_edit.html">
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
                                    <li><a href="product_list.html">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Danh sách
                                        </a>
                                    </li>
                                    <li><a href="product_add.html">
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
                                    <li><a href="<%= request.getContextPath() %>/discountList">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Danh sách
                                        </a>
                                    </li>
                                    <li><a href="<%= request.getContextPath() %>/addDiscount">
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
                            <li class="flex-box user__login">
<%--                                <img style="width: 50px;" src="<%= request.getContextPath() %>/Admin/assets/images/logo.png" alt="">--%>
                                <img src="<%= request.getContextPath() %>/${sessionScope.auth.image}" alt="" class="header__navbar--user-img">
                                <p>${sessionScope.auth.name}</p>
                                <i class="ri-arrow-down-s-fill"></i>
                                <ul class="header__navbar--user-menu">
                                    <li class="header__navbar--user-menu-item">
                                        <a href="${pageContext.request.contextPath}/Logout">Đăng xuất</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="admin-content-main">
                    <div class="admin-content-main-title">
                        <h1>Chỉnh sửa thông tin người dùng</h1>
                    </div>
                    <div class="admin-content-main-container">
                        <form class="edit-user-form" action="<%= request.getContextPath() %>/updateUser" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="userId" value="${user.id}">
                            <div class="form-group">
                                <label for="username">Tên đăng nhập:</label>
                                <input type="text" id="username" name="username" value="${user.name}" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Mật khẩu:</label>
                                <input type="password" id="password" name="password" value="${user.password}" required>
                            </div>
                            <div class="form-group">
                                <label for="phone">SĐT:</label>
                                <input type="text" id="phone" name="phone" value="${user.phoneNum}" required>
                            </div>
                            <div class="form-group">
                                <label for="birthday">Ngày sinh:</label>
                                <input type="date" id="birthday" name="birthday" value="${user.DOB}" required>
                            </div>
                            <div class="form-group">
                                <label for="address">Địa chỉ:</label>
                                <input type="text" id="address" name="address" value="${user.address}" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" id="email" name="email" value="${user.email}" required>
                            </div>
                            <div class="form-group">
                                <label for="currentImage">Ảnh hiện tại:</label>
                                <img src="<%= request.getContextPath() %>/${user.image}" alt="User Image" width="100" height="100">
                            </div>
                            <div class="form-group">
                                <label for="image">Ảnh mới:</label>
                                <input type="file" id="image" name="image">
                            </div>
                            <div class="form-group-inline">
                                <label for="sex">Giới tính:</label>
                                <select class="form-control" id="sex" name="sex" required>
                                    <option value="">Chọn giới tính</option>
                                    <option value="Nam" ${user.sex == 'Nam' ? 'selected' : ''}>Nam</option>
                                    <option value="Nữ" ${user.sex == 'Nữ' ? 'selected' : ''}>Nữ</option>
                                </select>
                            </div>
                            <div class="form-group-inline">
                                <label for="created_at">Ngày tạo:</label>
                                <input type="datetime-local" class="form-control" id="created_at" name="created_at" value="${user.created}" required>
                                <label for="status">Trạng thái:</label>
                                <select class="form-control" id="status" name="status" required>
                                    <option value="0" ${user.locked == 0 ? 'selected' : ''}>Active</option>
                                    <option value="1" ${user.locked == 1 ? 'selected' : ''}>Locked</option>
                                </select>
                                <label for="verify">Xác minh:</label>
                                <select class="form-control" id="verify" name="verify" required>
                                    <option value="0" ${user.verify == 0 ? 'selected' : ''}>Đã xác minh</option>
                                    <option value="1" ${user.verify == 1 ? 'selected' : ''}>Chưa xác minh</option>
                                </select>
                                <label for="role">Vai trò:</label>
                                <select class="form-control" id="role" name="role" required>
                                    <option value="1" ${user.role == 1 ? 'selected' : ''}>User</option>
                                    <option value="0" ${user.role == 0 ? 'selected' : ''}>Admin</option>
                                </select>
                            </div>
                            <button type="submit" class="btn-save">Lưu</button>
                            <button type="button" class="btn-cancel" onclick="window.location.href='<%= request.getContextPath() %>/userList'">Hủy</button>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </section>

    <script src="<%= request.getContextPath() %>/Admin/assets/js/sidebar.js"></script>
</body>
</html>