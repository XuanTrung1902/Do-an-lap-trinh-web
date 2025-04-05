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
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Admin/assets/css/sidebar.css">
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
            <jsp:include page="/Admin/sidebar.jsp"/>

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
                        <h1>Người dùng</h1>
                        <button class="btn-add__user">Thêm người dùng</button>
                        <button class="btn-import__user">Nhập từ file</button>
                    </div>
                    <div class="admin-content-main-container">
                        <table id="list-user" class="table table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên đăng nhập</th>
<%--                                <th>Mật khẩu</th>--%>
                                <th>Ngày sinh</th>
                                <th>Giới tính</th> <!-- Thêm cột Giới tính -->
                                <th>Địa chỉ</th>
                                <th>SĐT</th>
                                <th>Vai trò</th> <!-- Thêm cột Vai trò -->
                                <th>Khóa</th> <!-- Thêm cột Khóa -->
<%--                                <th>Xác minh</th> <!-- Thêm cột Xác minh -->--%>
                                <th>Ảnh</th>

                                <th>Tuỳ chỉnh</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${userList}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
<%--                                    <td>${user.password}</td>--%>
                                    <td>${user.DOB}</td>
                                    <td>${user.sex}</td> <!-- Hiển thị giới tính -->
                                    <td>${user.address}</td>
                                    <td>${user.phoneNum}</td>
                                    <td>${user.role}</td> <!-- Hiển thị vai trò -->
                                    <td>${user.locked}</td> <!-- Hiển thị trạng thái khóa -->
<%--                                    <td>${user.verify}</td> <!-- Hiển thị trạng thái xác minh -->--%>
                                    <td><img src="${user.image}" alt="User Image" style="width: 50px; height: 50px; border-radius: 50%;"></td>
                                    <td>
                                        <a href="<%= request.getContextPath() %>/updateUser?id=${user.id}" class="btn-edit">Sửa</a>
                                        <form action="<%= request.getContextPath() %>/deleteUser" method="post" style="display:inline;">
                                            <input type="hidden" name="id" value="${user.id}">
                                            <button type="submit" class="delete-button" onclick="return confirm('Bạn có chắc chắn muốn xóa người dùng ${user.name}?');">Xóa</button>                                        </form>
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
    <div class="modal" id="modal">
        <div class="modal-content">
            <span class="close-button">&times;</span>
            <h2>Thêm người dùng</h2>
            <form id="add-user-form" action="<%= request.getContextPath() %>/addUser" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="username">Tên đăng nhập:</label>
<%--                    <input type="text" id="username" name="username" required>--%>
                    <input type="text" id="username" name="username" value="${username}" required>
                </div>
                <div class="form-group">
                    <label for="password">Mật khẩu:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger" role="alert" style="color: red ">
                            ${error}
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="phone">SĐT:</label>
<%--                    <input type="text" id="phone" name="phone" required>--%>
                    <input type="text" id="phone" name="phone" value="${phone}" required>

                </div>
                <div class="form-group">
                    <label for="address">Địa chỉ:</label>
<%--                    <input type="text" id="address" name="address" required>--%>
                    <input type="text" id="address" name="address" value="${address}" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="${email}" required>
                </div>
                <div class="form-group">
                    <label for="image">Ảnh:</label>
                    <input type="file" id="image" name="image" required>
                </div>
                <div class="form-group">
                    <label for="birthday">Ngày sinh:</label>
<%--                    <input type="date" id="birthday" name="birthday" required>--%>
                    <input type="date" id="birthday" name="birthday" value="${birthday}" required>
                </div>
                <div class="form-group-inline">
                    <label for="sex">Giới tính:</label>
<%--                    <select id="sex" name="sex" required>--%>
<%--                        <option value="">Chọn giới tính</option>--%>
<%--                        <option value="Nam">Nam</option>--%>
<%--                        <option value="Nữ">Nữ</option>--%>
<%--                    </select>--%>
                    <select id="sex" name="sex" required>
                        <option value="">Chọn giới tính</option>
                        <option value="Nam" ${sex == 'Nam' ? 'selected' : ''}>Nam</option>
                        <option value="Nữ" ${sex == 'Nữ' ? 'selected' : ''}>Nữ</option>
                    </select>
                </div>
                <div class="form-group-inline">
                    <label for="status">Trạng thái:</label>
                    <select id="status" name="status" required>
                        <option value="0" ${status == 0 ? 'selected' : ''}>Active</option>
                        <option value="1" ${status == 1 ? 'selected' : ''}>Locked</option>
                    </select>
                    <label for="verify">Xác minh:</label>
                    <select id="verify" name="verify" required>
                        <option value="0" ${verify == 0 ? 'selected' : ''}>Đã xác minh</option>
                        <option value="1" ${verify == 1 ? 'selected' : ''}>Chưa xác minh</option>
                    </select>
                    <label for="role">Role:</label>
                    <select id="role" name="role" required>
<%--                        <option value="1">User</option>--%>
<%--                        <option value="0">Admin</option>--%>
                            <option value="1" ${role == 1 ? 'selected' : ''}>User</option>
                            <option value="0" ${role == 0 ? 'selected' : ''}>Admin</option>
                    </select>
                </div>
                <button type="submit" class="btn-submit">Thêm</button>
            </form>
        </div>
    </div>

    <div class="modal" id="import-modal">
        <div class="modal-content">
            <span class="close-import-button">&times;</span>
            <h2>Nhập người dùng từ file Excel</h2>
            <form id="import-user-form" action="<%= request.getContextPath() %>/importUser" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="userFile">Chọn file Excel:</label>
                    <input type="file" id="userFile" name="userFile" accept=".xls,.xlsx" required>
                </div>
                <button type="submit" class="btn-submit">Nhập</button>
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

        document.querySelector('.btn-import__user').addEventListener('click', function() {
            document.getElementById('import-modal').style.display = 'block';
        });

        document.querySelector('.close-import-button').addEventListener('click', function() {
            document.getElementById('import-modal').style.display = 'none';
        });

        window.addEventListener('click', function(event) {
            const modal = document.getElementById('import-modal');
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