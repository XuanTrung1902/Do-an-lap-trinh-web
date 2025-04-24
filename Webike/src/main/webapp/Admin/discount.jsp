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
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/discount.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/sidebar.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/base.css">
    <style>
        .table th, .table td {
            padding: 10px; /* Tăng khoảng cách giữa các ô */
        }

        .table th:nth-child(2), .table td:nth-child(2) {
            width: 100px; /* Điều chỉnh chiều rộng của cột "Giảm giá" */
        }

        .table th:nth-child(3), .table td:nth-child(3),
        .table th:nth-child(4), .table td:nth-child(4),
        .table th:nth-child(5), .table td:nth-child(5) {
            width: 150px; /* Điều chỉnh chiều rộng của các cột "Ngày bắt đầu", "Ngày kết thúc", và "Mã sản phẩm" */
        }

        .table th:last-child, .table td:last-child {
            width: 200px; /* Điều chỉnh chiều rộng của cột "Tuỳ chỉnh" */
        }

        .btn-edit, .btn-delete {
            display: inline-block; /* Đảm bảo các nút nằm chung một hàng */
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
                <c:set var="canWritetDiscount" value="false" />
                <c:set var="canDeletetDiscount" value="false" />

                <c:forEach var="p" items="${sessionScope.permissions}">
                    <c:if test="${p.resource eq 'discount' and p.action eq 'write'}">
                        <c:set var="canWritetDiscount" value="true" />
                    </c:if>
                    <c:if test="${p.resource eq 'discount' and p.action eq 'delete'}">
                        <c:set var="canDeletetDiscount" value="true" />
                    </c:if>

                </c:forEach>

                <div class="admin-content-main">
                    <div class="admin-content-main-title">
                        <h1>Giảm giá</h1>
                    </div>
                    <div class="admin-content-main-container">
                        <table id="list-disount" style="background-color: white; font-size: 1.6rem;" >
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Giảm giá (%)</th>
                                <th>Ngày bắt đầu</th>
                                <th>Ngày kết thúc</th>
                                <th>Mã sản phẩm</th>
                                <th>Tuỳ chỉnh</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="discount" items="${discountList}">
                                <tr>
                                    <td>${discount.id}</td>
                                    <td>${discount.amount}</td>
                                    <td>${discount.start}</td>
                                    <td>${discount.end}</td>
                                    <td>${discount.productID}</td>
                                    <td>
                                        <c:if test="${canWritetDiscount}">
                                        <a href="<%= request.getContextPath() %>/updateDiscount?id=${discount.id}" class="btn-edit" style="width: 100%; margin-bottom: 4px;">
                                            Sửa</a>
                                        </c:if>
                                        <c:if test="${canDeletetDiscount}">
                                        <form action="<%= request.getContextPath() %>/deleteDiscount" method="post" style="display:inline;">
                                            <input type="hidden" name="id" value="${discount.id}">
                                            <button type="submit" class="btn btn-danger btn-sm btn-delete" onclick="return confirm('Bạn có chắc chắn muốn xóa giảm giá cho sản phẩm này ${discount.id}?');">Xóa</button>
                                        </form>
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

    <script src="<%= request.getContextPath() %>/Admin/assets/js/discount.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>
    <script>
        $(document).ready(function () {
            // Khởi tạo DataTable
            $('#list-disount').DataTable({
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
     
            // Hiệu ứng hover cho bảng
            $("#list-disount").on({
                mouseenter: function () {
                    $(this).css("background-color", "white");
                },
                mouseleave: function () {
                    $(this).css("background-color", "white");
                },
            });
        });
     </script>

    <script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>

</body>
</html>