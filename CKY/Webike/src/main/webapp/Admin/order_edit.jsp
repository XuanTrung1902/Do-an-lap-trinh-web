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
    <!-- <link rel="stylesheet" href="./assets/css/admin.css"> -->
    <link rel="stylesheet" href="./assets/css/order_edit.css">
    <link rel="stylesheet" href="./assets/css/base.css">
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
                                <img style="width: 50px;" src="assets/images/logo.png" alt="">
                                <p>Trí Đức</p>
                                <i class="ri-arrow-down-s-fill"></i>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="admin-content-main">
                    <div class="admin-content-main-title">
                        <h1>Chỉnh sửa đơn hàng</h1>
                    </div>
                    <div class="admin-content-main-container">
                        <form action="#" method="post" class="order-edit-form">
                            <div class="form-group">
                                <label for="order-id">ID Đơn hàng</label>
                                <input type="text" id="order-id" name="order-id" readonly>
                            </div>
                            <div class="form-group">
                                <label for="customer-name">Tên khách hàng</label>
                                <input type="text" id="customer-name" name="customer-name">
                            </div>
                            <div class="form-group">
                                <label for="customer-phone">Số điện thoại</label>
                                <input type="text" id="customer-phone" name="customer-phone" >
                            </div>
                            <div class="form-group">
                                <label for="customer-email">Email</label>
                                <input type="email" id="customer-email" name="customer-email" >
                            </div>
                            <div class="form-group">
                                <label for="customer-address">Địa chỉ</label>
                                <input type="text" id="customer-address" name="customer-address">
                            </div>
                            <div class="form-group">
                                <label for="order-status">Trạng thái</label>
                                <select id="order-status" name="order-status">
                                    <option value="success">Đã thanh toán</option>
                                    <option value="warning">Đã đặt cọc</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="order-date">Ngày</label>
                                <input type="date" id="order-date" name="order-date" value="2024-11-13">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="save-button">Lưu</button>
                                <button type="reset" class="cancel-button">Hủy</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="assets/js/sidebar.js"></script>
</body>
</html>