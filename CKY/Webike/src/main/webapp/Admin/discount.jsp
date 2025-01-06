<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                    <li><a href="#">
                                            <i class="ri-arrow-right-s-fill"></i>
                                            Danh sách
                                        </a>
                                    </li>
                                    <li><a href="discount_add.jsp">
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
                                <img style="width: 50px;" src="<%= request.getContextPath() %>/Admin/assets/images/logo.png" alt="">                                <p>Trí Đức</p>
                                <i class="ri-arrow-down-s-fill"></i>
                            </li>
                        </ul>
                    </div>
                </div>

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
                                        <a href="<%= request.getContextPath() %>/updateDiscount?id=${discount.id}" class="btn-edit">Sửa</a>
                                        <form action="<%= request.getContextPath() %>/deleteDiscount" method="post" style="display:inline;">
                                            <input type="hidden" name="id" value="${discount.id}">
                                            <button type="submit" class="btn-delete" onclick="return confirm('Bạn có chắc chắn muốn xóa giảm giá này?');">Xóa</button>
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
     

</body>
</html>