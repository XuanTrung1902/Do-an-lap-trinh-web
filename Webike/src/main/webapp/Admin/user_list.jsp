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
    <link rel="stylesheet" href="<%= request.getContextPath()%>/Admin/assets/css/header.css">
    <title>Admin</title>
</head>
<body>
    <section class="admin">
        <div class="row__grid">
            <jsp:include page="/Admin/sidebar.jsp"/>

            <div class="admin__content">
                <jsp:include page="/Admin/header.jsp"/>

                <c:set var="canEditUser" value="false" />
                <c:set var="canDeleteUser" value="false" />
                <c:set var="canReadPQ" value="false" />

                <c:forEach var="p" items="${sessionScope.permissions}">
                    <c:if test="${p.resource eq 'userlist' and p.action eq 'write'}">
                        <c:set var="canEditUser" value="true" />
                    </c:if>
                    <c:if test="${p.resource eq 'userlist' and p.action eq 'delete'}">
                        <c:set var="canDeleteUser" value="true" />
                    </c:if>
                    <c:if test="${p.resource eq 'Phân Quyền' and p.action eq 'read'}">
                        <c:set var="canReadPQ" value="true" />
                    </c:if>

                </c:forEach>
                <div class="admin-content-main">
                    <div class="admin-c ontent-main-title">
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
                                <th>Ngày sinh</th>
                                <th>Giới tính</th>
                                <th>Địa chỉ</th>
                                <th>SĐT</th>
                                <th>Vai trò</th>
                                <th>Khóa</th>
                                <th>Ảnh</th>

                                <th>Tuỳ chỉnh</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${userList}">
                                <tr data-id="${user.id}">
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.DOB}</td>
                                    <td>${user.sex}</td>
                                    <td>${user.address}</td>
                                    <td>${user.phoneNum}</td>
                                    <td>${user.role}</td>
                                    <td>${user.locked}</td>
                                    <td>
                                        <img src="${pageContext.request.contextPath}/${user.image}"
                                             alt="User Image"
                                             onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/img/Users/default.png';"
                                             style="width: 50px; height: 50px; border-radius: 50%;">
                                    </td>
                                    <td>
                                        <c:if test="${canEditUser}">
                                        <a href="<%= request.getContextPath() %>/updateUser?id=${user.id}" class="btn-edit">Sửa</a>
                                        </c:if>
                                        <c:if test="${canDeleteUser}">
                                            <button class="delete-button" onclick="confirmDeleteUser(${user.id}, '${user.name}')">Xóa</button>
                                        </c:if>
                                        <c:if test="${canReadPQ}">
                                        <button type="button" class="btn btn-secondary btn-sm btn-assign" onclick="openAssignPermissionModal(${user.id})">
                                            Phân quyền
                                        </button>
                                        </c:if>
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
    <c:if test="${canEditUser}">
    <div class="modal" id="modal">
        <div class="modal-content">
            <span class="close-button">&times;</span>
            <h2>Thêm người dùng</h2>
            <form id="add-user-form" action="<%= request.getContextPath() %>/addUser" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="username">Tên đăng nhập:</label>
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
                    <input type="text" id="phone" name="phone" value="${phone}" required>

                </div>
                <div class="form-group">
                    <label for="address">Địa chỉ:</label>
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
                    <input type="date" id="birthday" name="birthday" value="${birthday}" required>
                </div>
                <div class="form-group-inline">
                    <label for="sex">Giới tính:</label>
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
                            <option value="1" ${role == 1 ? 'selected' : ''}>User</option>
                            <option value="0" ${role == 0 ? 'selected' : ''}>Admin</option>
                    </select>
                </div>
                <button type="submit" class="btn-submit">Thêm</button>
            </form>
        </div>
    </div>
    </c:if>

    <div class="modal" id="import-modal">
        <div class="modal-content" style="max-width: 700px">
            <span class="close-import-button">&times;</span>
            <h2>Nhập người dùng từ file Excel</h2>
            <form id="import-user-form" action="<%= request.getContextPath() %>/importUser" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="userFile">Chọn file Excel:</label>
                    <input type="file" id="userFile" name="userFile" accept=".xls,.xlsx" required>
                </div>
                <div id="import-feedback" style="margin-top: 10px; font-weight: bold;"></div>
                <button type="submit" class="btn-submit">Nhập</button>
            </form>
        </div>
    </div>
    <!-- Modal phân quyền -->
    <div class="modal" id="assignPermissionModal">
        <div class="modal-content">
            <span class="close-button" onclick="closeModal('assignPermissionModal')">&times;</span>
            <h2>Phân quyền cho người dùng</h2>
            <form id="assign-permission-form" action="assignPermission" method="post">
                <input type="hidden" name="userId" id="assignUserId" style="background-color: #0dcaf0">

                <table class="permission-table">
                    <thead>
                    <tr>
                        <th>Trang</th>
                        <th>Quyền</th>
                        <th>Chọn</th>
                    </tr>
                    </thead>
                    <tbody id="permissionTableBody">
                    <c:forEach var="res" items="${allResources}">
                        <c:forEach var="perm" items="${allPermissions}">
                            <tr>
                                <td>${res.name}</td>
                                <td>${perm.name}</td>
                                <td>
                                    <input type="checkbox"
                                           class="perm-checkbox"
                                           name="permissions"
                                           data-resource="${res.id}"
                                           data-permission="${perm.id}"
                                           value="${res.id}-${perm.id}" />
                                </td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                    </tbody>
                </table>

                <button type="submit" class="btn-submit">Lưu phân quyền</button>
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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

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

    <script>
        var dataTable;

        function loadUserList() {
            if ($.fn.DataTable.isDataTable('#list-user')) {
                $('#list-user').DataTable().destroy(); // Hủy nếu đã tồn tại
            }

            dataTable = $('#list-user').DataTable({
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
                pageLength: 5,
                lengthMenu: [5, 10, 20],
            });
        }

        $(document).ready(function () {
            loadUserList(); // Khởi tạo bảng
        });
    </script>
    <script>
         document.getElementById("add-user-form").addEventListener("submit", function (e) {
         e.preventDefault();
         const form = e.target;
         const formData = new FormData(form);

         fetch(form.action, {
             method: "POST",
             body: formData,
             headers: {
                 "X-Requested-With": "XMLHttpRequest"
             }
         })
             .then(res => {
                 if (!res.ok) {
                     throw new Error("Server trả về lỗi: " + res.status);
                 }
                 return res.text();
             })
             .then(text => {
                 console.log("Phản hồi từ server (raw):", text);

                 const data = JSON.parse(text);

                 if (data.success) {
                     const user = data.user;
                     const contextPath = data.contextPath;

                     console.log("user:", user);

                     const tableBody = document.querySelector("#list-user tbody");
                     dataTable.row.add([
                         user.id,
                         user.name,
                         user.DOB,
                         user.sex,
                         user.address,
                         user.phoneNum,
                         user.role,
                         user.locked,
                         `<img src="${contextPath}/Webike/${user.image.startsWith('/') ? user.image.substring(1) : user.image}"
          onerror="this.onerror=null; this.src='${contextPath}/Webike/img/Users/default.png';"
          style="width:50px;height:50px;border-radius:50%;">`,
                         `<a href="${contextPath}/Webike/updateUser?id=${user.id}" class="btn-edit">Sửa</a>
     <form action="${contextPath}/Webike/deleteUser" method="post" style="display:inline;">
         <input type="hidden" name="id" value="${user.id}">
         <button type="submit" class="delete-button">Xóa</button>
     </form>
     <button type="button" class="btn btn-secondary btn-sm btn-assign" onclick="openAssignPermissionModal(${user.id})">
         Phân quyền
     </button>`
                     ]).draw(false);

                     form.reset();
                     document.getElementById("modal").style.display = "none";
                     alert("Thêm người dùng thành công!");
                 } else {
                     alert("Thêm thất bại: " + data.message);
                 }
             })
             .catch(error => {
                 console.error("Lỗi khi gửi yêu cầu:", error);
                 alert("Đã xảy ra lỗi khi gửi yêu cầu.");
             });
     });
    </script>
    <script>
        document.getElementById('import-user-form').addEventListener('submit', function (e) {
            e.preventDefault();
            console.log("Đang gửi dữ liệu...");

            const contextPath = '<%= request.getContextPath() %>';
            const form = e.target;
            const formData = new FormData(form);
            const feedback = document.getElementById('import-feedback');

            fetch(contextPath + '/importUser', {
                method: 'POST',
                body: formData
            })
                .then(res => res.text())
                .then(text => {
                    console.log("Phản hồi từ server:", text);

                    let data;
                    try {
                        data = JSON.parse(text);
                    } catch (e) {
                        feedback.style.color = 'red';
                        feedback.innerText = "Phản hồi không hợp lệ. Có thể server trả về HTML.";
                        return;
                    }

                    if (data.success && Array.isArray(data.users)) {
                        const dataTable = $('#list-user').DataTable();

                        data.users.forEach(user => {
                            // Xử lý hình ảnh an toàn
                            let imagePath = 'img/Users/default.png';
                            if (user.image && user.image.trim() !== '') {
                                imagePath = user.image.startsWith('/') ? user.image.substring(1) : user.image;
                            }
                            const fullImagePath = `${contextPath}/${imagePath}`;

                            dataTable.row.add([
                                user.id,
                                user.name,
                                user.DOB,
                                user.sex,
                                user.address,
                                user.phoneNum,
                                user.role,
                                user.locked,
                                `<img src="${fullImagePath}"
                          onerror="this.onerror=null; this.src='${contextPath}/Webike/img/Users/default.png';"
                          style="width:50px;height:50px;border-radius:50%;">`,
                                `<a href="${contextPath}/Webike/updateUser?id=${user.id}" class="btn-edit">Sửa</a>
                     <button type="button" class="delete-button" onclick="confirmDeleteUser(${user.id}, '${user.name}')">Xóa</button>
                     <button type="button" class="btn btn-secondary btn-sm btn-assign" onclick="openAssignPermissionModal(${user.id})">
                         Phân quyền
                     </button>`
                            ]).draw(false);
                        });

                        feedback.style.color = 'green';
                        feedback.innerText = data.message;
                        form.reset();
                        document.getElementById('import-modal').style.display = 'none';

                    } else {
                        feedback.style.color = 'red';
                        feedback.innerText = data.message || 'Không thể nhập dữ liệu.';
                    }
                })
                .catch(error => {
                    console.error("Lỗi kết nối:", error);
                    feedback.style.color = 'red';
                    feedback.innerText = "Không thể kết nối server.";
                });
        });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%= request.getContextPath()%>/Admin/assets/js/user_list.js"></script>
    <script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>
</body>
</html>