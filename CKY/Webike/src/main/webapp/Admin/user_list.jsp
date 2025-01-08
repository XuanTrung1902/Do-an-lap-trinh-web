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
    <link rel="stylesheet" href="https://cdn.datatables.net/2.1.8/css/dataTables.dataTables.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Admin/assets/css/user_list.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Admin/assets/css/base.css">
    <style>
        .table {
            font-size: 1.2rem; /* Tăng kích thước chữ */
        }

        .table th, .table td {
            padding: 10px; /* Tăng khoảng cách giữa các ô */
        }
    </style>
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
                            <a href="<%= request.getContextPath() %>/userList">
                                <i class="ri-file-list-line"></i>
                                Người dùng
                                <i class="ri-add-box-line"></i>
                            </a>
                            <ul class="sub-menu">
                                <div class="sub-menu-items">
                                    <li><a href="#">
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
                                    <li>
                                        <a href="order_edit.jsp">
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
                                <img style="width: 50px;" src="<%= request.getContextPath() %>/Admin/assets/images/logo.png" alt="">
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
                        <h1>Người dùng</h1>
                        <button class="btn-add__user">Thêm người dùng</button>
                    </div>
                    <div class="admin-content-main-container">
                        <table id="list-user" class="table table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên đăng nhập</th>
                                <th>Mật khẩu</th>
                                <th>Ngày sinh</th>
                                <th>Giới tính</th> <!-- Thêm cột Giới tính -->
                                <th>Địa chỉ</th>
                                <th>SĐT</th>
                                <th>Vai trò</th> <!-- Thêm cột Vai trò -->
                                <th>Khóa</th> <!-- Thêm cột Khóa -->
<%--                                <th>Xác minh</th> <!-- Thêm cột Xác minh -->--%>
                                <th>Tuỳ chỉnh</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${userList}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.password}</td>
                                    <td>${user.DOB}</td>
                                    <td>${user.sex}</td> <!-- Hiển thị giới tính -->
                                    <td>${user.address}</td>
                                    <td>${user.phoneNum}</td>
                                    <td>${user.role}</td> <!-- Hiển thị vai trò -->
                                    <td>${user.locked}</td> <!-- Hiển thị trạng thái khóa -->
<%--                                    <td>${user.verify}</td> <!-- Hiển thị trạng thái xác minh -->--%>
                                    <td>
                                        <a href="<%= request.getContextPath() %>/updateUser?id=${user.id}" class="btn-edit">Sửa</a>
                                        <form action="<%= request.getContextPath() %>/deleteUser" method="post" style="display:inline;">
                                            <input type="hidden" name="id" value="${user.id}">
                                            <button type="submit" class="delete-button" onclick="return confirm('Bạn có chắc chắn muốn xóa người dùng này?');">Xóa</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Modal thêm người dùng -->
    <!-- Modal thêm người dùng -->
    <div class="modal" id="modal">
        <div class="modal-content">
            <span class="close-button">&times;</span>
            <h2>Thêm người dùng</h2>
            <form id="add-user-form" action="<%= request.getContextPath() %>/addUser" method="post">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger" role="alert">
                            ${error}
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="username">Tên đăng nhập:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Mật khẩu:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="phone">SĐT:</label>
                    <input type="text" id="phone" name="phone" required>
                </div>
                <div class="form-group">
                    <label for="address">Địa chỉ:</label>
                    <input type="text" id="address" name="address" required>
                </div>
                <div class="form-group">
                    <label for="birthday">Ngày sinh:</label>
                    <input type="date" id="birthday" name="birthday" required>
                </div>
                <div class="form-group-inline">
                    <label for="sex">Giới tính:</label>
                    <select id="sex" name="sex" required>
                        <option value="">Chọn giới tính</option>
                        <option value="Nam">Nam</option>
                        <option value="Nữ">Nữ</option>
                    </select>
                </div>
                <div class="form-group-inline">
                    <label for="status">Trạng thái:</label>
                    <select id="status" name="status" required>
                        <option value="0">Active</option>
                        <option value="1">Locked</option>
                    </select>
                    <label for="verify">Xác minh:</label>
                    <select id="verify" name="verify" required>
                        <option value="0">Đã xác minh</option>
                        <option value="1">Chưa xác minh</option>
                    </select>
                    <label for="role">Role:</label>
                    <select id="role" name="role" required>
                        <option value="1">User</option>
                        <option value="0">Admin</option>
                    </select>
                </div>
                <button type="submit" class="btn-submit">Thêm</button>
            </form>
        </div>
    </div>


    <script>
        document.querySelector('.btn-add__user').addEventListener('click', function() {
            document.getElementById('modal').style.display = 'block';
        });

        document.querySelector('.close-button').addEventListener('click', function() {
            document.getElementById('modal').style.display = 'none';
        });

        document.getElementById('add-user-form').addEventListener('submit', function(e) {
            // Không ngăn chặn việc gửi form
            document.getElementById('modal').style.display = 'none';
        });

        window.addEventListener('click', function(event) {
            const modal = document.getElementById('modal');
            if (event.target === modal) {
                modal.style.display = 'none';
            }
        });
    </script>



    <script src="<%= request.getContextPath()%>/Admin/assets/js/user_list.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>
    <script>
        $(document).ready(function () {
        $('#list-user').DataTable({
            language: {
                search: "Tìm kiếm:",
                lengthMenu: "Hiển thị _MENU_ dòng",
                info: "Hiển thị _START_ đến _END_ của _TOTAL_ dòng",
                paginate: {
                    first: "Đầu",
                    last: "Cuối",
                    next: ">",
                    previous: "<",
                },
                infoFiltered: "(Lọc từ _MAX_ dòng)",
                infoEmpty: "Không có dữ liệu",
                zeroRecords: "Không tìm thấy dữ liệu phù hợp",
            },
            pageLength: 5, // Số dòng mặc định
            lengthMenu: [5, 10, 20], // Tuỳ chọn số dòng hiển thị
        });
        $("#list-user").on({
            mouseenter: function () {
                $(this).css("background-color", "white");
            },
            mouseleave: function () {
                $(this).css("background-color", "white");
            },
        });
       });
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>