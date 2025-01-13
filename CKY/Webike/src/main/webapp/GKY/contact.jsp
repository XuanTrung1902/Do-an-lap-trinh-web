
<<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Webike</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="assets/css/base.css">
    <link rel="stylesheet" href="assets/css/homepage.css">
    <link rel="stylesheet" href="assets/css/contact.css">
    <link rel="stylesheet" href="assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.min.css"> -->
     <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
</head>
<body>
    <div class="app">
        <header class="header">
            <div class="grid__full-width">
                <a href="homepage.jsp" class="logo">
                    <img src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827" alt="Webike VN">
                </a>
                <nav class="header__navbar">
                    <div class="header__navbar--top">
                        <ul class="header__navbar--top_left">
                            <li class="header__navbar--item">
                                <a href="homepage.jsp">Trang chủ</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="product.jsp">Chợ xe máy</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="news.jsp">Tin tức</a>
                            </li>
                            <!-- <li class="header__navbar--item">
                                <a href="#">Đại lí</a>
                            </li> -->
                            <li class="header__navbar--item">
                                <a href="#">Liên hệ</a>
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
                                <img src="assets/img/avt1.jpg" alt="" class="header__navbar--user-img">
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
                            </div>
                            <button class="header__search--btn">
                                <i class="header__search--btn-icon fa-solid fa-search"></i>
                            </button>
                        </div>

                        <div class="header__cart">
                            <a href="cart.jsp" class="header__cart-link" >
                                <i class="header__cart-icon ti-shopping-cart"></i>
                                <span class="header__cart--text">Giỏ Hàng</span>
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
        </header>

        <div class="container" style="padding: 0;">
            <div class="contact">
                <div class="contact__title">
                    <h1>Liên hệ</h1>
                </div>
                <div class="contact__content">
                    <div class="contact__content--left">
                        <div class="contact__form">
                            <h2>Gửi tin nhắn cho chúng tôi</h2>
                            <form action="#">
                                <div class="form-group">
                                    <label for="name">
                                        <i class="fa-solid fa-user"></i>
                                        Họ và tên:</label>
                                    <input type="text" id="name" name="name" placeholder="Tên" required>
                                </div>
                                <div class="form-group">
                                    <label for="email">
                                        <i class="fa-solid fa-envelope"></i>
                                        Email:</label>
                                    <input type="email" id="email" name="email" placeholder="Email" required>
                                </div>
                                <div class="form-group">
                                    <label for="phone">
                                        <i class="fa-solid fa-phone"></i>
                                        SDT:</label>
                                    <input type="phone" id="phone" name="phone" placeholder="Số điện thoại" required>
                                </div>
                                <div class="form-group">
                                    <label for="editor">
                                        <i class="fa-solid fa-message"></i>
                                        Tin nhắn:</label>
                                    <textarea id="editor" name="message" rows="5" required></textarea>
                                </div>
                                <button type="submit">Gửi</button>
                            </form>
                        </div>
                    </div>
                    <div class="contact__content--right">
                        <h2>Thông tin liên hệ</h2>
                        <p>Nếu bạn có bất kỳ câu hỏi nào, vui lòng liên hệ với chúng tôi qua các thông tin dưới đây:</p>
                        <ul>
                            <li><strong>Địa chỉ:</strong> Khu phố 6, phường Linh Trung, thành phố Thủ Đức, thành phố Hồ Chí Minh</li>
                            <li><strong>Điện thoại:</strong> 0123 456 789</li>
                            <li><strong>Email:</strong> 22130049@st.hcmuaf.edu.vn</li>
                        </ul>
                        <div class="contact_map">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.2145947051067!2d106.78918677480638!3d10.871276389283311!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBOw7RuZyBMw6JtIFRQLiBI4buTIENow60gTWluaA!5e0!3m2!1svi!2s!4v1731764191110!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                        </div>
                    </div>

                </div>
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
                            <img class="footer__banking" src="assets/img/bankcard1.png" alt="">
                            <img class="footer__banking" src="assets/img/bankcard2.png" alt="">
                            <img class="footer__banking" src="assets/img/bankcard3.png" alt="">
                            <img class="footer__banking" src="assets/img/bankcard4.png" alt="">
                            <img class="footer__banking" src="assets/img/bankcard5.png" alt="">
                            <img class="footer__banking" src="assets/img/bankcard6.png" alt="">
                        </div>
                        <div class="footer__rectangle">
                            <img src="assets/img/Rectangle.png" alt="">
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


    <script src="https://cdn.ckeditor.com/4.22.1/standard/ckeditor.js"></script>
    <script>
        CKEDITOR.replace( 'editor' );
    </script>
</body>
</html>