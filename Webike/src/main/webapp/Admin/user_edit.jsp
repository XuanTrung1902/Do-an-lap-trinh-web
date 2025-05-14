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
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/sidebar.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/base.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/header.css">
    <title>Admin</title>
</head>
<body>
    <section class="admin">
        <div class="row__grid">
            <jsp:include page="/Admin/sidebar.jsp"/>

            <div class="admin__content">
                <jsp:include page="/Admin/header.jsp"/>

                <div class="admin-content-main">
                    <div class="admin-content-main-title">
                        <h1>Chỉnh sửa thông tin người dùng</h1>
                    </div>
                    <div class="admin-content-main-container">
<%--                        <form class="edit-user-form" action="<%= request.getContextPath() %>/updateUser" method="post" enctype="multipart/form-data">--%>
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
                                    <option value="0" ${user.locked == 0 ? 'selected' : ''}>Hoạt động</option>
                                    <option value="1" ${user.locked == 1 ? 'selected' : ''}>Đã khóa</option>
                                </select>
                                <label for="verify">Xác minh:</label>
                                <select class="form-control" id="verify" name="verify" required>
                                    <option value="0" ${user.verify == 0 ? 'selected' : ''}>Đã xác minh</option>
                                    <option value="1" ${user.verify == 1 ? 'selected' : ''}>Chưa xác minh</option>
                                </select>
                                <label for="role">Vai trò:</label>
                                <select class="form-control" id="role" name="role" required>
                                    <option value="1" ${user.role == 1 ? 'selected' : ''}>Người dùng</option>
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
    <script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>

</body>
</html>