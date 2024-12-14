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
    <link rel="stylesheet" href="./assets/css/user_list.css">
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
                        <h1>Người dùng</h1>
                    </div>
                    <div class="admin-content-main-container">
                        <!-- <div class="admin-content-main-search">
                            <input type="text" id="searchInput" placeholder="Tìm kiếm người dùng...">
                            <select id="filterType">
                                <option value="name">Tên đăng nhập</option>
                                <option value="address">Địa chỉ</option>
                                <option value="phone">SĐT</option>
                            </select>
                        </div> -->
                        <table id="list-user" style="background-color: white; font-size: 1.6rem;" >
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên đăng nhập</th>
                                    <th>Mật khẩu</th>
                                    <th>Ngày sinh</th>
                                    <th>Địa chỉ</th>
                                    <th>SĐT</th>
                                    <th>Tuỳ chỉnh</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td</td>
                                    <td></td>
                                    <td>
                                        <a href="#" class="delete-button">Xoá</a>
                                    </td>
                                </tr> -->
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="assets/js/user_list.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>
    <script>
       var table ;
        function initTableData () {
            var data = [
                {
                    id: 1,
                    name: 'LeTriDuc',
                    password: '123456',
                    birthday: '11/6/2004',
                    address: 'Đồng Nai',
                    phone: '0123456789'
                },
                {
                    id: 2,
                    name: 'TongXuanTrung',
                    password: '147258',
                    birthday: '11/6/2004',
                    address: 'Đà Nẵng',
                    phone: '0123456789'
                },
                {
                    id: 3,
                    name: 'NguyenQuocTan',
                    password: '258369',
                    birthday: '11/6/2004',
                    address: 'Hà Nội',
                    phone: '0123456789'
                },
                {
                    id: 4,
                    name: 'TranNhutAnh',
                    password: '145678',
                    birthday: '11/6/2004',
                    address: 'Long An',
                    phone: '0123456789'
                },
                {
                    id: 5,
                    name: 'DoDucDuong',
                    password: '145789',
                    birthday: '11/6/2004',
                    address: 'Đồng Tháp',
                    phone: '0123456789'
                }
            ];
            // var jsonData = JSON.stringify(data);
            // console.log(jsonData);
            table = $('#list-user').DataTable({
                "processing" : true,
                data,
                columns: [
                    { data: 'id' },
                    { data: 'name' },
                    { data: 'password' },
                    { data: 'birthday' },
                    { data: 'address' },
                    { data: 'phone' },
                    {
                        data: null,
                        render: function (data, type, row) {
                            return `
                                <a href="#" class="delete-button">Xóa</a>
                            `;
                        }
                    }
                ],
                // paging: true,
                // searching: true
                "paging": true,
                "searching": true,
                "info": true,
                "lengthChange": true,
                "pageLength": 5,
                "dom": '<"top"f>rt<"bottom"ip><"clear">',
                "language": {
                    "search": "Tìm kiếm:",
                    "paginate": {
                        "first": "Đầu",
                        "last": "Cuối",
                        "next": "Sau",
                        "previous": "Trước"
                    },
                    "info": "Hiển thị _START_ đến _END_ của _TOTAL_ mục",
                    "infoEmpty": "Không có dữ liệu",
                    "infoFiltered": "(lọc từ _MAX_ mục)",
                    "zeroRecords": "Không tìm thấy kết quả"
                }
            });
        }
        // initTableData();

        $(document).ready(function() {
            initTableData();
            $('#list-user').on({
                mouseenter: function () {
                    $(this).css('background-color', 'white');
                },
                mouseleave: function () {
                    $(this).css('background-color', 'white');
                }
            })
        });
    </script>
</body>
</html>