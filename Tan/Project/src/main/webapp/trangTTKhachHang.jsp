<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WeBike</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/headerFooter.css">
    <link rel="stylesheet" href="./assets/css/trangTTKhachHang.css">

    <link rel="stylesheet" href="./assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="./assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.min.css"> -->
     <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.css">

</head>
<body>
    <div class="app">
        <header class="header">
            <div class="grid__full-width">
                <a href="#" class="logo">
                    <img src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827" alt="Webike VN">
                </a>
                <nav class="header__navbar">
                    <div class="header__navbar--top">
                        <ul class="header__navbar--top_left">
                            <li class="header__navbar--item">
                                <a href="#">Trang chủ</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="product.html">Chợ xe máy</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="#">Tin tức</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="#">Đại lí</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="contact.html">Liên hệ</a>
                            </li>
                        </ul>

                        <ul class="header__navbar--top_right">
                            <li class="header__navbar--icon">
                                <a href="#">
                                    <i class="fa-brands fa-facebook m-r-8"></i>
                                </a>
                            </li>
                            <li class="header__navbar--icon">
                                <a href="#">
                                    <i class="fa-brands fa-youtube m-r-8"></i>
                                </a>
                            </li>

                            <!-- <li class="header__navbar--item header__navbar--separate">
                                <a href="#"><i class="fa-solid fa-user m-r-8" ></i>Đăng nhập</a>
                            </li>
                            <li class="header__navbar--item"><a href="#">Đăng ký</a></li> -->

                            <li class="header__navbar--item header__navbar--user">
                                <img src="./assets/imgs/images/avt1.jpg" alt="" class="header__navbar--user-img">
                                <span class="header__navbar--user-name">Trí Đức</span>

                                <ul class="header__navbar--user-menu">
                                    <li class="header__navbar--user-menu-item">
                                        <a href="#"><i class="fa-solid fa-user m-r-8"></i>Thông tin cá nhân</a>
                                    </li>
                                    <li class="header__navbar--user-menu-item">
                                        <a href="#"><i class="fa-solid fa-shopping-cart m-r-8"></i>Lịch sử mua hàng</a>
                                    </li>
                                    <li class="header__navbar--user-menu-item">
                                        <a href="#"><i class="fa-solid fa-sign-out m-r-8"></i>Đăng xuất</a>
                                    </li>
                                </ul>
                            </li>
                            
                        </ul>
                    </div>

                    <div class="header__navbar--bot">
                        <div class="header__search">
                            <input type="text" class="header__search--input" placeholder="Nhập từ khoá tìm kiếm">
                            <div class="header__search-select">
                                <span class="header__search-select-label">Tìm xe</span>
                                <i class="header__search-select-icon "></i>

                                <!-- <ul class="header__search-option">
                                    <li class="header__search-option-item">
                                        <span >Tìm phụ tùng</span>
                                    </li>
                                </ul> -->
                            </div>
                            <button class="header__search--btn">
                                <i class="header__search--btn-icon fa-solid fa-search"></i>
                            </button>
                        </div>

                        <div class="header__cart">
                            <a href="#" class="header__cart-link" >
                                <i class="header__cart-icon ti-shopping-cart"></i>
                                <span class="header__cart--text">Giỏ Hàng</span>
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
        </header>

        <div class="container-center">
            <div class="sidebar">
                <h3>TÀI KHOẢN</h3>
                <ul class="sidebar-menu">
                    <li><a href="#" id="show-profile">Thông tin tài khoản</a></li>
                    <li><a href="#" id="change-password">Đổi mật khẩu</a></li>
                    <li><a href="#" id="change-picture">Đổi ảnh đại diện</a></li>
                    <li><a href="#">Đăng xuất</a></li>
                </ul>
            </div>

            <div class="profile-form" id="profile-form">
                <form>
                    <div class="form-group">
                        <label for="username">Tên đăng nhập</label>
                        <input type="text" id="username" value="Trí Đức" disabled>
                    </div>

                    <div class="form-group">
                        <label for="fullname">Tên</label>
                        <input type="text" id="fullname" placeholder="Trí Đức">
                    </div>

                    <div class="form-group email-facebook-group">
                        <label for="email">Email   </label>
                        <div class="info-edit">
                            <input type="email" id="email" value="TriDuc@gmail.com" disabled>
                            <a href="#" class="email-change link-toggle" id="email-link">Liên Kết</a>
                        </div>

                        <label for="facebook">Facebook</label>
                        <div class="info-edit">
                            <input type="text" id="facebook" value="(Chưa liên Kêt)" disabled>
                            <a href="#" class="facebook-change link-toggle" id="facebook-link">Liên Kết</a>
                        </div>
                    </div>

                    <div class="form-group">
                        <label >Số điện thoại</label>
                        <input type="tel"  placeholder="0312358497">
                    </div>
                    <div class="form-group">
                        <label >Địa chỉ</label>
                        <input type="addres"  placeholder="Tỉnh/Thành Phố, Huyện, Xã">
                    </div>

                    <div class="form-group">
                        <label>Giới tính</label>
                        <div class="gender-group">
                            <label class="custom-radio">
                                <input type="radio" id="male" name="gender" value="male">
                                <span class="checkmark"></span> Nam
                            </label>
                            <label class="custom-radio">
                                <input type="radio" id="female" name="gender" value="female">
                                <span class="checkmark"></span> Nữ
                            </label>
                            <label class="custom-radio">
                                <input type="radio" id="other" name="gender" value="other">
                                <span class="checkmark"></span> Khác
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label >Ngày sinh</label>
                        <div class="birth-date">
                            <select id="day-select"></select>
                            <select id="month-select"></select>
                            <select id="year-select"></select>
                        </div>
                    </div>

                    <button type="submit" class="save-btn">Lưu</button>
                </form>
            </div>


<!--            form đổi mật khẩu-->
            <div class="change-password-form"  id="change-password-form" style="display: none;">
                <form id="password-form">
                    <div class="form-group">
                        <label for="current-password">Mật khẩu cũ</label>
                        <input type="password" id="current-password" placeholder="Nhập mật khẩu cũ" required>
                    </div>
                    <div class="form-group">
                        <label for="new-password">Mật khẩu mới</label>
                        <input type="password" id="new-password" placeholder="Nhập mật khẩu mới" required>
                    </div>
                    <div class="form-group">
                        <label for="confirm-password">Xác nhận mật khẩu mới</label>
                        <input type="password" id="confirm-password" placeholder="Xác nhận mật khẩu mới" required>
                    </div>
                    <button type="submit" class="save-btn">Đổi mật khẩu</button>
                </form>
            </div>

            <!-- Form đỏi ảnh -->
            <div class="change-picture-form" id="change-picture-form" style="display: none;">
                <form id="picture-form">
                    <div class="form-group">
                        <label>Ảnh đại diện hiện tại</label>
                        <img src="./assets/imgs/images/avt1.jpg" alt="Profile Picture" id="current-profile-image" class="profile-image-preview">
                    </div>
                    <div class="form-group">
                        <label for="new-profile-picture">Chọn ảnh mới</label>
                        <input type="file" id="new-profile-picture" accept=".jpg, .jpeg, .png">
                    </div>
                    <button type="submit" class="save-btn">Lưu ảnh đại diện</button>
                </form>
            </div>


        </div>
        

        <footer class="footer">
              <div class="container">
                <footer class="py-5">
                  <div class="row">
                    <div class="col-6 col-md-2 mb-3">
                      <h5>Chợ xe máy</h5>
                      <ul class="nav flex-column">
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Phân khối lớn</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Hãng xe</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Loại xe</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Thịnh hành</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Cửa hàng</a></li>
                      </ul>
                    </div>
              
                    <div class="col-6 col-md-2 mb-3">
                      <h5>Thông tin khác</h5>
                      <ul class="nav flex-column">
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Quy chế hoạt động</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Chính sách bảo mật</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Hỗ trợ khách hàng</a></li>
                        <!-- <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Bản quyền</a></li> -->
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Liên hệ</a></li>
                      </ul>
                    </div>
              
                    <div class="col-6 col-md-2 mb-3">
                      <h5>Tin tức xe máy</h5>
                      <ul class="nav flex-column">
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Trang chủ</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Tin tức - sự kiện</a></li>
                        <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Thông tin xe máy</a></li>
                        <!-- <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Kinh nghiệm</a></li> -->
                        <!-- <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Video giải trí</a></li> -->
                      </ul>
                    </div>
              
                    <div class="col-md-5 offset-md-1 mb-3">
                      <form>
                        <h5>Phương thức thanh toán</h5>
                        <!-- <p>Monthly digest of what's new and exciting from us.</p> -->
                        <div class="d-flex flex-column flex-sm-row w-100 gap-2">
                            <img class="footer__banking" src="./assets/imgs/images/bankcard1.png" alt="">
                            <img class="footer__banking" src="./assets/imgs/images/bankcard2.png" alt="">
                            <img class="footer__banking" src="./assets/imgs/images/bankcard3.png" alt="">
                            <img class="footer__banking" src="./assets/imgs/images/bankcard4.png" alt="">
                            <img class="footer__banking" src="./assets/imgs/images/bankcard5.png" alt="">
                            <img class="footer__banking" src="./assets/imgs/images/bankcard6.png" alt="">
                        </div>
                        <div class="footer__rectangle">
                            <img src="./assets/imgs/images/Rectangle.png" alt="">
                        </div>
                      </form>
                    </div>
                  </div>
              
                  <div class="d-flex flex-column flex-sm-row justify-content-between py-4 my-4 border-top">
                    <p>&copy; 2024 Company, Inc. All rights reserved.</p>
                    <ul class="list-unstyled d-flex">
                      <li class="ms-3"><a class="link-body-emphasis" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"/></svg></a></li>
                      <li class="ms-3"><a class="link-body-emphasis" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"/></svg></a></li>
                      <li class="ms-3"><a class="link-body-emphasis" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"/></svg></a></li>
                    </ul>
                  </div>
                </footer>
              </div>
        </footer>
    </div>

    <script src="./assets/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="./assets/bootstrap/js/popper.min.js"></script>
    <script src="./assets/js/trangTTKhachHang.js"></script>
</body>
</html>