<%@page import="java.io.Console" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/discount.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/sidebar.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/base.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/header.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/2.3.1/css/dataTables.dataTables.css" />


    <style>
        #logTable {
            table-layout: auto;
            width: 100%;
        }

        #logTable td, #logTable th {
            vertical-align: middle !important;
            text-align: center;
            white-space: nowrap;
        }

        #logTable .btn-edit,
        #logTable .btn-delete {
            font-size: 1.3rem;
            padding: 6px 10px;
            margin: 2px;
        }

        #logTable td:nth-child(5),
        #logTable td:nth-child(6) {
            word-break: break-word;
            max-width: 200px;
            width: 180px;
            text-align: left;
        }

        #logTable .btn-edit,
        #logTable .btn-delete {
            font-size: 1.3rem;
            padding: 6px 12px;
            margin: 0;
        }

        div.dt-container .dt-paging .dt-paging-button {
            min-width: 0; !important;
        }

        #logTable td.wrap-text {
            overflow-x: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }

    </style>
    <title>Admin</title>
</head>
<body>
<section class="admin">
    <div class="row__grid">
        <jsp:include page="/Admin/sidebar.jsp"/>

        <div class="admin__content">
            <jsp:include page="/Admin/header.jsp"/>
            <c:set var="canWritetDiscount" value="false"/>
            <c:set var="canDeletetDiscount" value="false"/>

            <c:forEach var="p" items="${sessionScope.permissions}">
                <c:if test="${p.resource eq 'discount' and p.action eq 'write'}">
                    <c:set var="canWritetDiscount" value="true"/>
                </c:if>
                <c:if test="${p.resource eq 'discount' and p.action eq 'delete'}">
                    <c:set var="canDeletetDiscount" value="true"/>
                </c:if>

            </c:forEach>

            <div class="admin-content-main">
                <div class="admin-content-main-title">
                    <h1>Nhật ký hoạt động</h1>
                </div>
                <div class="admin-content-main-container">
                    <table id="logTable" class="display" style="background-color: white; font-size: 1.6rem;">
                        <thead>
                        <tr>
                            <th>Level</th>
                            <th>Thời gian</th>
                            <th>Vị trí</th>
                            <th>Người dùng</th>
                            <th>Dữ liệu trước</th>
                            <th>Dữ liệu sau</th>
                            <th>Tùy chỉnh</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="log" items="${logs}">
                            <tr>
                                <td>${log.level}</td>
                                <td>${log.logTime}</td>
                                <td>${log.location}</td>
                                <td>${log.userInfo}</td>
                                <td class="wrap-text">${log.before}</td>
                                <td class="wrap-text">${log.after}</td>
                                <td>
                                    <div style="display: flex; gap: 5px; justify-content: center;">
                                            <c:if test="${canDeletetDiscount}">
<%--                                                <a href="#" class="btn-edit" data-id="${log.id}">Sửa</a>--%>
<%--                                                <a href="updateLog?id=${log.id}" class="btn btn-primary">Sửa</a>--%>
                                                <a href="#" class="btn-edit" data-id="${log.id}">Sửa</a>

                                                <a href="<%= request.getContextPath() %>/delete-log?id=${log.id}"
                                                   class="btn-delete"
                                                   onclick="return confirm('Bạn có chắc chắn muốn xóa log này?')"
                                                >Xóa</a>
<%--                                                <a href="#" class="btn-edit" style="background-color: #17a2b8;">Quay lại</a>--%>
                                            </c:if>
                                    </div>
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
<!-- Modal Sửa Log -->
<div class="modal" id="editLogModal" tabindex="-1" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title">Sửa log</h5>
                <button type="button" class="close close-edit-log-modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editLogForm">
                    <input type="hidden" name="logId" id="logId">
                    <div class="form-group">
                        <label for="level">Level:</label>
                        <select class="form-control" name="level" id="level">
                            <option value="INFO">INFO</option>
                            <option value="WARNING">WARNING</option>
                            <option value="ERROR">ERROR</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="logTime">Thời gian log:</label>
                        <input type="datetime-local" class="form-control" name="logTime" id="logTime">
                    </div>

                    <div class="form-group">
                        <label for="location">Vị trí:</label>
                        <input type="text" class="form-control" name="location" id="location">
                    </div>

                    <div class="form-group">
                        <label for="userInfo">Thông tin người dùng:</label>
                        <input type="text" class="form-control" name="userInfo" id="userInfo">
                    </div>

                    <div class="form-group">
                        <label for="before">Trạng thái trước:</label>
                        <textarea class="form-control" name="before" id="before" rows="3"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="after">Trạng thái sau:</label>
                        <textarea class="form-control" name="after" id="after" rows="3"></textarea>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary close-edit-log-modal">Đóng</button>
                <button type="submit" class="btn btn-primary" form="editLogForm">Lưu thay đổi</button>
            </div>
        </div>
    </div>
</div>


<script src="<%= request.getContextPath() %>/Admin/assets/js/discount.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/2.3.1/js/dataTables.js"></script>
<script>
    $(document).ready(function() {
        $('#logTable').DataTable({
            language: {
                search: "Tìm kiếm:",
                lengthMenu: "Hiển thị _MENU_ dòng mỗi trang",
                info: "Hiển thị từ _START_ đến _END_ của _TOTAL_ dòng",
                paginate: {
                    next: "Sau",
                    previous: "Trước"
                },
                zeroRecords: "Không tìm thấy dữ liệu phù hợp",
                infoEmpty: "Không có dữ liệu",
                infoFiltered: "(lọc từ tổng số _MAX_ dòng)"
            },
            pageLength: 10,
            lengthMenu: [5, 10, 25, 50, 100],
            columnDefs: [
                { targets: [4, 5], className: 'text-start' }, // căn trái cho dữ liệu
                { targets: 6, orderable: false } // không cho sort cột nút
            ],
            responsive: true
        });
    });
</script>
<script>
    document.querySelectorAll('.btn-edit').forEach(btn => {
        btn.addEventListener('click', function () {
            document.getElementById('editLogModal').style.display = 'block';
        });
    });

    // Đóng modal sửa log
    document.querySelectorAll('.close-edit-log-modal').forEach(btn => {
        btn.addEventListener('click', function () {
            document.getElementById('editLogModal').style.display = 'none';
        });
    });

</script>
<script>
    const contextPath = '<%= request.getContextPath() %>';
</script>
<script src="<%= request.getContextPath()%>/Admin/assets/js/Log.js"></script>
<script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>
</body>
</html>