<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WeBike</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/homepage.css">
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
                                <a href="product.jsp">Chợ xe máy</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="news.jsp">Tin tức</a>
                            </li>
                            <!-- <li class="header__navbar--item">
                                <a href="#">Đại lí</a>
                            </li> -->
                            <li class="header__navbar--item">
                                <a href="contact.jsp">Liên hệ</a>
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
                                <img src="./assets/img/avt1.jpg" alt="" class="header__navbar--user-img">
                                <span class="header__navbar--user-name">Trí Đức</span>

                                <ul class="header__navbar--user-menu">
                                    <li class="header__navbar--user-menu-item">
                                        <a href="trangTTKhachHang.jsp"><i class="fa-solid fa-user m-r-8"></i>Thông tin cá nhân</a>
                                    </li>
                                    <!-- <li class="header__navbar--user-menu-item">
                                        <a href="#"><i class="fa-solid fa-shopping-vn.edu.hcmuaf.fit.webike.t.services.cart m-r-8"></i>Lịch sử mua hàng</a>
                                    </li> -->
                                    <li class="header__navbar--user-menu-item">
                                        <a href="Dangnhap.jsp"><i class="fa-solid fa-sign-out m-r-8"></i>Đăng xuất</a>
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
                            <a href="Gio%20hang.jsp" class="header__cart-link" >
                                <i class="header__cart-icon ti-shopping-cart"></i>
                                <span class="header__cart--text">Giỏ Hàng</span>
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
        </header>

        <div class="container" style="padding: 0;">
            <!-- Slider -->
            <a href="Chi%20tiet%20san%20pham.jsp">
            <div class="slider">
                <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators bg__control ">
                      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img src="./assets/img/xe1.png" class="d-block w-100 slider_img" alt="">
                        <div class="carousel-caption d-none d-md-block">
                          <h5>SH 350i</h5>
                          <p>Một biểu tượng của sự đẳng cấp, sang trọng và hoàn mỹ.</p>
                        </div>
                      </div>
                      <div class="carousel-item">
                        <img src="./assets/img/xe2.jpg" class="d-block w-100 slider_img" alt="">
                        <div class="carousel-caption d-none d-md-block">
                          <h5>Winner X 2024</h5>
                          <p>Khẳng định chất riêng biệt hướng tới hình ảnh một mẫu siêu mô tô</p>
                        </div>
                      </div>
                      <div class="carousel-item">
                        <img src="./assets/img/xe3.jpg" class="d-block w-100 slider_img " alt="">
                        <div class="carousel-caption d-none d-md-block">
                          <h5>Vespa Sprint S125</h5>
                          <p>Cho những tâm hồn bản lĩnh, khát khao và cá tính</p>
                        </div>
                      </div>
                    </div>
                    <button class="carousel-control-prev bg__control " type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next bg__control" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Next</span>
                    </button>
                  </div>
            </div>
            </a>
            <!-- Motorbike Category -->
            <div id="motorSelectionCategory">
               <div class="motorbike__row">
                    <div class="motorbike-item">
                        <a href="product.jsp" class="motorbike-item-link">
                            <div class="motorbike__content">
                                <div class="motorbike__thumb">
                                    <img class="motorbike-item-img" src="./assets/img/product1.png" alt="xe">
                                </div>
                                <div class="motorbike__body">
                                    <h3 class="motorbike__title">Xe tay ga</h3>
                                    <div class="motorbike__body--bf">
                                        <div class="motorbike__body-icon"></div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>

                    <div class="motorbike-item">
                        <a href="product.jsp" class="motorbike-item-link">
                            <div class="motorbike__content">
                                <div class="motorbike__thumb">
                                    <img class="motorbike-item-img" src="./assets/img/product2.png" alt="xe">
                                </div>
                                <div class="motorbike__body">
                                    <h3 class="motorbike__title">Xe số</h3>
                                    <div class="motorbike__body--bf">
                                        <div class="motorbike__body-icon"></div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>

                    <div class="motorbike-item">
                        <a href="product.jsp" class="motorbike-item-link">
                            <div class="motorbike__content">
                                <div class="motorbike__thumb">
                                    <img class="motorbike-item-img" src="./assets/img/product3.png" alt="xe">
                                </div>
                                <div class="motorbike__body">
                                    <h3 class="motorbike__title">Xe côn tay</h3>
                                    <div class="motorbike__body--bf">
                                        <div class="motorbike__body-icon"></div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>

                    <div class="motorbike-item">
                        <a href="product.jsp" class="motorbike-item-link">
                            <div class="motorbike__content">
                                <div class="motorbike__thumb">
                                    <img class="motorbike-item-img" src="./assets/img/product4.png" alt="xe">
                                </div>
                                <div class="motorbike__body">
                                    <h3 class="motorbike__title">Xe phân khối lớn</h3>
                                    <div class="motorbike__body--bf">
                                        <div class="motorbike__body-icon"></div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>

                    <div class="motorbike-item">
                        <a href="product.jsp" class="motorbike-item-link">
                            <div class="motorbike__content">
                                <div class="motorbike__thumb">
                                    <img class="motorbike-item-img" src="./assets/img/product5.png" alt="xe">
                                </div>
                                <div class="motorbike__body">
                                    <h3 class="motorbike__title">Xe điện</h3>
                                    <div class="motorbike__body--bf">
                                        <div class="motorbike__body-icon"></div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>

                    <div class="motorbike-item">
                        <a href="product.jsp" class="motorbike-item-link motorbike__title d-block ">
                           <span class="motorbike__body-see-all">
                                <i class="motorbike__body-see-all-icon fa-solid fa-plus"></i>
                                 Xem tất cả
                           </span>
                        </a>
                    </div>
               </div>
            </div>

            <div class="motor__brand">
                <div class="motor__brand--heading">
                    <h3 class="motor__brand--title">
                        Thương hiệu nổi bật
                    </h3>
                </div>
                <div class="motor__brand--list">
                    <div class="brand-item">
                        <a href="#" class="brand-link">
                            <img src="./assets/img/brand1.jpg" alt="">
                        </a>
                    </div>
                    <div class="brand-item">
                        <a href="#" class="brand-link">
                            <img src="./assets/img/brand2.jpg" alt="">
                        </a>
                    </div>
                    <div class="brand-item">
                        <a href="#" class="brand-link">
                            <img src="./assets/img/brand3.jpg" alt="">
                        </a>
                    </div>
                    <div class="brand-item">
                        <a href="#" class="brand-link">
                            <img src="./assets/img/brand4.jpg" alt="">
                        </a>
                    </div>
                    <div class="brand-item">
                        <a href="#" class="brand-link">
                            <img src="./assets/img/brand5.jpg" alt="">
                        </a>
                    </div>
                    <div class="brand-item">
                        <a href="#" class="brand-link">
                            <img src="./assets/img/brand6.jpg" alt="">
                        </a>
                    </div>
                    <div class="brand-item">
                        <a href="#" class="brand-link">
                            <img src="./assets/img/brand7.jpg" alt="">
                        </a>
                    </div>
                </div>
            </div>

            <!-- dealer -->
             <div class="dealer">
                <div class="dealer__heading">
                    <h3 class="dealer__heading--title">Chi nhánh</h3>
                </div>
                <div class="dealer__list">
                    <div class="dealer__list--row">
                        <a href="https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+N%C3%B4ng+L%C3%A2m+TP.+H%E1%BB%93+Ch%C3%AD+Minh/@10.8712764,106.7917617,15z/data=!4m2!3m1!1s0x0:0x9672b7efd0893fc4?sa=X&ved=1t:2428&ictx=111" class="dealer__list--item">
                            <div class="dealer__list--img">
                                <img src="./assets/img/banner.jpg" alt="#">
                                <span class="dealer__list--name">Quận 12</span>
                            </div>
                            <div class="dealer__list--description">
                                <p>Chi nhánh Quận 12 tọa lạc tại trung tâm thành phố, cung cấp các dịch vụ bảo dưỡng và sửa chữa xe máy chuyên nghiệp. Đội ngũ nhân viên tận tâm và giàu kinh nghiệm luôn sẵn sàng phục vụ khách hàng.</p>
                            </div>
                        </a>
                        <a href="#" class="dealer__list--item">
                            <div class="dealer__list--img">
                                <img src="./assets/img/banner.jpg" alt="#">
                                <span class="dealer__list--name">Quận 2</span>
                            </div>
                            <div class="dealer__list--description">
                                <p>Chi nhánh Quận 2 với không gian rộng rãi và hiện đại, cung cấp đa dạng các loại xe máy và phụ tùng chính hãng. Đội ngũ kỹ thuật viên chuyên nghiệp luôn sẵn sàng hỗ trợ khách hàng.</p>
                            </div>
                        </a>
                        <a href="#" class="dealer__list--item">
                            <div class="dealer__list--img">
                                <img src="./assets/img/banner.jpg" alt="#">
                                <span class="dealer__list--name">Quận 3</span>
                            </div>
                            <div class="dealer__list--description">
                                <p>Chi nhánh Quận 3 nổi bật với dịch vụ chăm sóc khách hàng tận tình và chu đáo. Chúng tôi cam kết mang đến cho khách hàng những trải nghiệm tốt nhất.</p>
                            </div>
                        </a>
                        <a href="#" class="dealer__list--item">
                            <div class="dealer__list--img">
                                <img src="./assets/img/banner.jpg" alt="#">
                                <span class="dealer__list--name">Quận 4</span>
                            </div>
                            <div class="dealer__list--description">
                                <p>Chi nhánh Quận 4 cung cấp các dịch vụ bảo dưỡng và sửa chữa xe máy với trang thiết bị hiện đại và đội ngũ kỹ thuật viên giàu kinh nghiệm.</p>
                            </div>
                        </a>
                        <a href="#" class="dealer__list--item">
                            <div class="dealer__list--img">
                                <img src="./assets/img/banner.jpg" alt="#">
                                <span class="dealer__list--name">Quận 5</span>
                            </div>
                            <div class="dealer__list--description">
                                <p>Chi nhánh Quận 5 với vị trí thuận lợi, cung cấp các dịch vụ bảo dưỡng và sửa chữa xe máy nhanh chóng và hiệu quả. Đội ngũ nhân viên thân thiện và chuyên nghiệp.</p>
                            </div>
                        </a>
                        <a href="#" class="dealer__list--item">
                            <div class="dealer__list--img">
                                <img src="./assets/img/banner.jpg" alt="#">
                                <span class="dealer__list--name">Quận 6</span>
                            </div>
                            <div class="dealer__list--description">
                                <p>Chi nhánh Quận 6 chuyên cung cấp các dịch vụ bảo dưỡng và sửa chữa xe máy với chất lượng cao. Chúng tôi luôn đặt lợi ích của khách hàng lên hàng đầu.</p>
                            </div>
                        </a>
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
                            <img class="footer__banking" src="./assets/img/bankcard1.png" alt="">
                            <img class="footer__banking" src="./assets/img/bankcard2.png" alt="">
                            <img class="footer__banking" src="./assets/img/bankcard3.png" alt="">
                            <img class="footer__banking" src="./assets/img/bankcard4.png" alt="">
                            <img class="footer__banking" src="./assets/img/bankcard5.png" alt="">
                            <img class="footer__banking" src="./assets/img/bankcard6.png" alt="">
                        </div>
                        <div class="footer__rectangle">
                            <img src="./assets/img/Rectangle.png" alt="">
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
</body>
</html>