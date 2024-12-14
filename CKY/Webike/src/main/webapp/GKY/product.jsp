<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Chợ xe máy</title>
    <title>WeBike</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="./assets/css/base.css" />
    <link rel="stylesheet" href="./assets/css/product.css" />
    <link rel="stylesheet" href="./assets/font/fontawesome-free-6.5.1-web/css/all.min.css"/>
    <link rel="stylesheet" href="./assets/font/themify-icons/themify-icons.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet"/>
    <!-- <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.css" />
  </head>
  <body>
    <div class="app">
      <header class="header">
        <div class="grid__full-width">
          <a href="homepage.jsp" class="logo">
            <img src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827" alt="Webike VN"/>
          </a>
          <nav class="header__navbar">
            <div class="header__navbar--top">
              <ul class="header__navbar--top_left">
                <li class="header__navbar--item">
                  <a href="homepage.jsp">Trang chủ</a>
                </li>
                <li class="header__navbar--item">
                  <a href="#">Chợ xe máy</a>
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
                  <a href="#"><i class="fa-solid fa-user m-r-8"></i>Đăng nhập</a>
                </li>
                <li class="header__navbar--item">a href="#">Đăng ký</a></li> -->

                <li class="header__navbar--item header__navbar--user">
                  <img src="./assets/img/avt1.jpg" alt="" class="header__navbar--user-img">
                  <span class="header__navbar--user-name">Trí Đức</span>

                  <ul class="header__navbar--user-menu">
                      <li class="header__navbar--user-menu-item">
                          <a href="trangTTKhachHang.jsp"><i class="fa-solid fa-user m-r-8"></i>Thông tin cá nhân</a>
                      </li>
                      <li class="header__navbar--user-menu-item">
                          <a href="#"><i class="fa-solid fa-shopping-cart m-r-8"></i>Lịch sử mua hàng</a>
                      </li>
                      <li class="header__navbar--user-menu-item">
                          <a href="Dangnhap.jsp"><i class="fa-solid fa-sign-out m-r-8"></i>Đăng xuất</a>
                      </li>
                  </ul>
              </li>
              </ul>
            </div>

            <div class="header__navbar--bot">
              <div class="header__search">
                <input type="text" class="header__search--input" placeholder="Nhập từ khoá tìm kiếm"/>
                <div class="header__search-select">
                  <span class="header__search-select-label">Tìm xe</span>
                  <i class="header__search-select-icon"></i>

                </div>
                <button class="header__search--btn">
                  <i class="header__search--btn-icon fa-solid fa-search"></i>
                </button>
              </div>

              <div class="header__cart">
                <a href="Gio%20hang.jsp" class="header__cart-link">
                  <i class="header__cart-icon ti-shopping-cart"></i>
                  <span class="header__cart--text">Giỏ Hàng</span>
                </a>
              </div>
            </div>
          </nav>
        </div>
      </header>

      <div class="container" style="padding: 0">
        <div class="banner">
          <img src="./assets/img/banner.jpg" alt="">
        </div>
        <div class="search__container">
          <div class="search__bike">
            <div class="search--title">
              <h2 class="search--title-name">Tìm kiếm xe máy</h2>
            </div>
            <form class="search-initialized">
              <input type="text" placeholder="Hãng xe">
              <input type="text" placeholder="Loại xe">
              <select name="" id="" class="bike--cubic">
                <option value="" selected>Phân khối</option>
                <option value="">50cc</option>
                <option value="">50cc - 125cc</option>
                <option value="">125cc - 175cc</option>
                <option value="">175cc - 250cc</option>
              </select>
              <select name="" id="" class="bike--price">
                <option value="">Đến giá</option>
                <option value="">10.000.000đ</option>
                <option value="">50.000.000đ</option>
                <option value="">100.000.000đ</option>
                <option value="">300.000.000đ</option>
              </select>
              <button class="bike__search--btn">
                <i class="bike__search--btn-icon fa-solid fa-search"></i>
                Tìm kiếm
              </button>
            </form>
          </div>
          <div class="motor__brand">
            <div class="motor__brand--heading">
              <h3 class="search--title-name">
                  Thương hiệu nổi bật
              </h3>
            </div>
            <div class="motor__brand--list">
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/hang1.jpg" alt="">
                  </a>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/hang2.jpg" alt="">
                  </a>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/hang3.jpg" alt="">
                  </a>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/hang4.jpg" alt="">
                  </a>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/hang5.jpg" alt="">
                  </a>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/hang6.jpg" alt="">
                  </a>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/hang7.jpg" alt="">
                  </a>
              </div>
              <div class="brand-item">
                <a href="#" class="brand-link">
                    <img src="./assets/img/hang8.jpg" alt="">
                </a>
              </div>
              <div class="brand-item">
                <a href="#" class="brand-link">
                    <img src="./assets/img/hang9.jpg" alt="">
                </a>
              </div>
              <div class="brand-item">
                <a href="#" class="brand-link">
                    <img src="./assets/img/hang10.jpg" alt="">
                </a>
              </div>
            </div>
          </div>

          <div class="motor__brand">
            <div class="motor__brand--heading">
              <h3 class="search--title-name">
                  Theo loại xe
              </h3>
            </div>
            <div class="motor__brand--list">
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/type1.jpg" alt="">
                  </a>
                  <span class="type__bike">Xe tay ga</span>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/type2.jpg" alt="">
                  </a>
                  <span class="type__bike">Xe số</span>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/type3.jpg" alt="">
                  </a>
                  <span class="type__bike">Xe côn tay</span>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/type4.jpg" alt="">
                  </a>
                  <span class="type__bike">Xe đạp trần</span>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/type5.jpg" alt="">
                  </a>
                  <span class="type__bike">Xe thể thao</span>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/type6.jpg" alt="">
                  </a>
                  <span class="type__bike">Cruser</span>
              </div>
              <div class="brand-item">
                  <a href="#" class="brand-link">
                      <img src="./assets/img/type7.jpg" alt="">
                  </a>
                  <span class="type__bike">Chopper</span>
              </div>
              <div class="brand-item">
                <a href="#" class="brand-link">
                    <img src="./assets/img/type8.jpg" alt="">
                </a>
                <span class="type__bike">Bobber</span>
              </div>
              <div class="brand-item">
                <a href="#" class="brand-link">
                    <img src="./assets/img/type9.jpg" alt="">
                </a>
                <span class="type__bike">Drag</span>
              </div>
              <div class="brand-item">
                <a href="#" class="brand-link">
                    <img src="./assets/img/type10.jpg" alt="">
                </a>
                <span class="type__bike">Touring</span>
              </div>
            </div>
          </div>
          

        </div>
        
        

        <div class="motor__market">
          <div class="box__title">
            <span>
              <h2 class="motor__market--title">Chợ xe máy</h2>
            </span>
          </div>

          <!-- List bike -->
          <div class="motor__list">
            <a href="#" class="bike__link">
              <div class="box__bike--item">
                <div class="box__bike-img">
                  <img src="./assets/img/xe1.png" alt="#" />
                  <h5 class="box__bike--name">
                    HONDA Airblade 110 Fi 2013
                  </h5>
                  <span class="box__sub--title">Mới</span>
                </div>
                <div class="box__bike--price">
                  <span class="box__bike--price-old">39.200.000đ</span>
                  <span class="box__bike--price-current">33.900.000đ</span>
                </div>
                <div class="box__bike--origin">
                  <span class="box__bike--origin-text">Hà Nội</span>
                </div>
                <div class="box__bike--favourite">
                  <i class="fa-regular fa-heart"></i>
                </div>
                <div class="box__bike--sale-off">
                  <span class="box__bike--sale-off-percent">10%</span>
                  <span class="box__bike--sale-off-label">Giảm</span>
                </div>
              </div>
            </a>
            <a href="#" class="bike__link">
              <div class="box__bike--item">
                <div class="box__bike-img">
                  <img src="./assets/img/xe1.png" alt="#" />
                  <h5 class="box__bike--name">
                    HONDA Airblade 110 Fi 2013 
                  </h5>
                  <span class="box__sub--title">Mới</span>
                </div>
                <div class="box__bike--price">
                  <span class="box__bike--price-old">39.200.000đ</span>
                  <span class="box__bike--price-current">33.900.000đ</span>
                </div>
                <div class="box__bike--origin">
                  <span class="box__bike--origin-text">Hà Nội</span>
                </div>
                <div class="box__bike--favourite">
                  <i class="fa-regular fa-heart"></i>
                </div>
                <div class="box__bike--sale-off">
                  <span class="box__bike--sale-off-percent">10%</span>
                  <span class="box__bike--sale-off-label">Giảm</span>
                </div>
              </div>
            </a>
            <a href="Chi%20tiet%20san%20pham.jsp" class="bike__link">
              <div class="box__bike--item">
                <div class="box__bike-img">
                  <img src="./assets/img/xe1.png" alt="#" />
                  <h5 class="box__bike--name">
                    HONDA Airblade 110 Fi 2013
                  </h5>
                  <span class="box__sub--title">Mới</span>
                </div>
                <div class="box__bike--price">
                  <span class="box__bike--price-old">39.200.000đ</span>
                  <span class="box__bike--price-current">33.900.000đ</span>
                </div>
                <div class="box__bike--origin">
                  <span class="box__bike--origin-text">Đống Đa, Hà Nội</span>
                </div>
                <div class="box__bike--favourite">
                  <i class="fa-regular fa-heart"></i>
                </div>
                <div class="box__bike--sale-off">
                  <span class="box__bike--sale-off-percent">13%</span>
                  <span class="box__bike--sale-off-label">Giảm</span>
                </div>
              </div>
            </a>
            <a href="#" class="bike__link">
              <div class="box__bike--item">
                <div class="box__bike-img">
                  <img src="./assets/img/cup50.png" alt="#" />
                  <h5 class="box__bike--name">
                    Super cup C125 2021
                  </h5>
                  <span class="box__sub--title">Mới</span>
                </div>
                <div class="box__bike--price">
                  <span class="box__bike--price-old">86.292.000đ</span>
                  <span class="box__bike--price-current">78.900.000đ</span>
                </div>
                <div class="box__bike--origin">
                  <span class="box__bike--origin-text">Quận 5, Hồ Chí Minh</span>
                </div>
                <div class="box__bike--favourite">
                  <i class="fa-regular fa-heart"></i>
                </div>
                <div class="box__bike--sale-off">
                  <span class="box__bike--sale-off-percent">15%</span>
                  <span class="box__bike--sale-off-label">Giảm</span>
                </div>
              </div>
            </a>
            <a href="#" class="bike__link">
              <div class="box__bike--item">
                <div class="box__bike-img">
                  <img src="./assets/img/vario.png" alt="#" />
                  <h5 class="box__bike--name">
                    Varior 160 2021
                  </h5>
                  <span class="box__sub--title">Mới</span>
                </div>
                <div class="box__bike--price">
                  <span class="box__bike--price-old">51.990.000đ</span>
                  <span class="box__bike--price-current">45.900.000đ</span>
                </div>
                <div class="box__bike--origin">
                  <span class="box__bike--origin-text">Cẩm Lệ, Đà Nẵng</span>
                </div>
                <div class="box__bike--favourite">
                  <i class="fa-regular fa-heart"></i>
                </div>
                <div class="box__bike--sale-off">
                  <span class="box__bike--sale-off-percent">8%</span>
                  <span class="box__bike--sale-off-label">Giảm</span>
                </div>
              </div>
            </a>
            <a href="#" class="bike__link">
              <div class="box__bike--item">
                <div class="box__bike-img">
                  <img src="./assets/img/air_blade160.png" alt="#" />
                  <h5 class="box__bike--name">
                    Air Blade 160 2021
                  </h5>
                  <span class="box__sub--title">Mới</span>
                </div>
                <div class="box__bike--price">
                  <span class="box__bike--price-old">42.012.000đ</span>
                  <span class="box__bike--price-current">35.990.000đ</span>
                </div>
                <div class="box__bike--origin">
                  <span class="box__bike--origin-text">Ba Đình, Hà Nội</span>
                </div>
                <div class="box__bike--favourite">
                  <i class="fa-regular fa-heart"></i>
                </div>
                <div class="box__bike--sale-off">
                  <span class="box__bike--sale-off-percent">12%</span>
                  <span class="box__bike--sale-off-label">Giảm</span>
                </div>
              </div>
            </a>
            <a href="#" class="bike__link">
              <div class="box__bike--item">
                <div class="box__bike-img">
                  <img src="./assets/img/lead_abs.png" alt="#" />
                  <h5 class="box__bike--name">
                    Lead 125 ABS 2022
                  </h5>
                  <span class="box__sub--title">Cũ</span>
                </div>
                <div class="box__bike--price">
                  <span class="box__bike--price-old">39.590.000đ</span>
                  <span class="box__bike--price-current">30.900.000đ</span>
                </div>
                <div class="box__bike--origin">
                  <span class="box__bike--origin-text">Thủ Đức, Hồ Chí Minh</span>
                </div>
                <div class="box__bike--favourite">
                  <i class="fa-regular fa-heart"></i>
                </div>
                <div class="box__bike--sale-off">
                  <span class="box__bike--sale-off-percent">10%</span>
                  <span class="box__bike--sale-off-label">Giảm</span>
                </div>
              </div>
            </a>
            <a href="#" class="bike__link">
              <div class="box__bike--item">
                <div class="box__bike-img">
                  <img src="./assets/img/winnerX.jpg" alt="#" />
                  <h5 class="box__bike--name">
                    Winner X 150 2022
                  </h5>
                  <span class="box__sub--title">Cũ</span>
                </div>
                <div class="box__bike--price">
                  <span class="box__bike--price-old">46.799.000đ</span>
                  <span class="box__bike--price-current">42.599.000đ</span>
                </div>
                <div class="box__bike--origin">
                  <span class="box__bike--origin-text">Hoàn Kiếm, Hà Nội</span>
                </div>
                <div class="box__bike--favourite">
                  <i class="fa-regular fa-heart"></i>
                </div>
                <div class="box__bike--sale-off">
                  <span class="box__bike--sale-off-percent">6%</span>
                  <span class="box__bike--sale-off-label">Giảm</span>
                </div>
              </div>
            </a>
            <a href="#" class="bike__link">
              <div class="box__bike--item">
                <div class="box__bike-img">
                  <img src="./assets/img/waveRSX.png" alt="#" />
                  <h5 class="box__bike--name">
                    Wave RSX 110 2022
                  </h5>
                  <span class="box__sub--title">Mới</span>
                </div>
                <div class="box__bike--price">
                  <span class="box__bike--price-old">22.200.000đ</span>
                  <span class="box__bike--price-current">17.900.000đ</span>
                </div>
                <div class="box__bike--origin">
                  <span class="box__bike--origin-text">Bình Thạnh, Hồ Chí Minh</span>
                </div>
                <div class="box__bike--favourite">
                  <i class="fa-regular fa-heart"></i>
                </div>
                <div class="box__bike--sale-off">
                  <span class="box__bike--sale-off-percent">7%</span>
                  <span class="box__bike--sale-off-label">Giảm</span>
                </div>
              </div>
            </a>

            <div class="motor__list--arrow">
              <button class="arrow-left" onclick="sliderToLeft()">
                <i class="fa-solid fa-chevron-left"></i>
              </button>
              <button class="arrow-right" onclick="sliderToRight()">
                <i class="fa-solid fa-chevron-right"></i>
              </button>
            </div>
          </div>

          <!-- Detail bike -->
          <div class="motor__detail-list">
            <div class="title-second">
              <h3 class="title-second-name">Xe mới đăng</h3>
            </div>
            <div class="grid-2-8" style="padding-bottom: 10px;">
              <div class="checkbox__category">
                <div id="checkboxes">
                  <h4>Hãng xe</h4>
                  <label><input type="checkbox" value="honda" onclick="filterimg()"> HONDA</label>
                  <label><input type="checkbox" value="ducati" onclick="filterimg()"> DUCATI</label>
                  <label><input type="checkbox" value="sym" onclick="filterimg()"> SYM</label>
                  <label><input type="checkbox" value="piaggio" onclick="filterimg()"> PIAGGIO</label>
                </div>
                <div id="checkboxes1">
                  <h4>Màu sắc</h4>
                  <label><input type="checkbox" value="den" onclick="filterimg()"> ĐEN</label>
                  <label><input type="checkbox" value="trang" onclick="filterimg()"> TRẮNG</label>
                  <label><input type="checkbox" value="xam" onclick="filterimg()"> XÁM</label>
                </div>
              </div>
              <div class="list-bike">
                <div class="grid__row" style="padding: 0 40px;">
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="Chi%20tiet%20san%20pham.jsp" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt1.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave 110 HQTrắng - 2008</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt2.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Ducati 848 Đen - 2013</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Bình Thạnh, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="sym, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt3.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">SYM Angela 50cc 2016 màu đỏ trắng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">4 tháng trước</span>
                        </div>
                        <address class="address">Quận 7, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt4.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Vespa LX 125 Đen - 2015</h3>
                        <span class="bike__price">8.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt5.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Cub 50cc Vàng Trắng - 2020</h3>
                        <span class="bike__price">7.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt6.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi 2013 màu đen vàng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">7 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt7.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave Alpha 110 hqld,  màu trắng</h3>
                        <span class="bike__price">5.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">8 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="piaggio, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt8.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Liberty 3V i.e 125 2015 màu trắng</h3>
                        <span class="bike__price">19.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">9 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hà Nội</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt9.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi Trắng Đỏ - 2013</h3>
                        <span class="bike__price">10.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">10 tháng trước</span>
                        </div>
                        <address class="address">Quận 11, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, xam" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt10.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Scrambler 1100 Sport 2021 Xám Mờ</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">11 tháng trước</span>
                        </div>
                        <address class="address">Thủ Đức, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt11.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Vision 110 2013 màu đen đỏ</h3>
                        <span class="bike__price">15.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt1.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave 110 HQTrắng - 2008</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt2.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Ducati 848 Đen - 2013</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Bình Thạnh, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="sym, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt3.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">SYM Angela 50cc 2016 màu đỏ trắng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">4 tháng trước</span>
                        </div>
                        <address class="address">Quận 7, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt4.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Vespa LX 125 Đen - 2015</h3>
                        <span class="bike__price">8.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt5.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Cub 50cc Vàng Trắng - 2020</h3>
                        <span class="bike__price">7.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt6.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi 2013 màu đen vàng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">7 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt7.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave Alpha 110 hqld,  màu trắng</h3>
                        <span class="bike__price">5.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">8 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="piaggio, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt8.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Liberty 3V i.e 125 2015 màu trắng</h3>
                        <span class="bike__price">19.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">9 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hà Nội</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt9.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi Trắng Đỏ - 2013</h3>
                        <span class="bike__price">10.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">10 tháng trước</span>
                        </div>
                        <address class="address">Quận 11, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, xam" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt10.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Scrambler 1100 Sport 2021 Xám Mờ</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">11 tháng trước</span>
                        </div>
                        <address class="address">Thủ Đức, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt11.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Vision 110 2013 màu đen đỏ</h3>
                        <span class="bike__price">15.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt1.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave 110 HQTrắng - 2008</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt2.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Ducati 848 Đen - 2013</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Bình Thạnh, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="sym, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt3.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">SYM Angela 50cc 2016 màu đỏ trắng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">4 tháng trước</span>
                        </div>
                        <address class="address">Quận 7, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt4.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Vespa LX 125 Đen - 2015</h3>
                        <span class="bike__price">8.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt1.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave 110 HQTrắng - 2008</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt2.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Ducati 848 Đen - 2013</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Bình Thạnh, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="sym, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt3.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">SYM Angela 50cc 2016 màu đỏ trắng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">4 tháng trước</span>
                        </div>
                        <address class="address">Quận 7, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt4.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Vespa LX 125 Đen - 2015</h3>
                        <span class="bike__price">8.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt5.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Cub 50cc Vàng Trắng - 2020</h3>
                        <span class="bike__price">7.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt6.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi 2013 màu đen vàng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">7 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt7.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave Alpha 110 hqld,  màu trắng</h3>
                        <span class="bike__price">5.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">8 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="piaggio, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt8.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Liberty 3V i.e 125 2015 màu trắng</h3>
                        <span class="bike__price">19.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">9 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hà Nội</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt9.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi Trắng Đỏ - 2013</h3>
                        <span class="bike__price">10.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">10 tháng trước</span>
                        </div>
                        <address class="address">Quận 11, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, xam" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt10.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Scrambler 1100 Sport 2021 Xám Mờ</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">11 tháng trước</span>
                        </div>
                        <address class="address">Thủ Đức, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt11.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Vision 110 2013 màu đen đỏ</h3>
                        <span class="bike__price">15.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt1.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave 110 HQTrắng - 2008</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt2.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Ducati 848 Đen - 2013</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Bình Thạnh, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="sym, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt3.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">SYM Angela 50cc 2016 màu đỏ trắng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">4 tháng trước</span>
                        </div>
                        <address class="address">Quận 7, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt4.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Vespa LX 125 Đen - 2015</h3>
                        <span class="bike__price">8.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt5.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Cub 50cc Vàng Trắng - 2020</h3>
                        <span class="bike__price">7.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt6.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi 2013 màu đen vàng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">7 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt7.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave Alpha 110 hqld,  màu trắng</h3>
                        <span class="bike__price">5.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">8 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="piaggio, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt8.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Liberty 3V i.e 125 2015 màu trắng</h3>
                        <span class="bike__price">19.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">9 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hà Nội</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt9.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi Trắng Đỏ - 2013</h3>
                        <span class="bike__price">10.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">10 tháng trước</span>
                        </div>
                        <address class="address">Quận 11, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, xam" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt10.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Scrambler 1100 Sport 2021 Xám Mờ</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">11 tháng trước</span>
                        </div>
                        <address class="address">Thủ Đức, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt11.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Vision 110 2013 màu đen đỏ</h3>
                        <span class="bike__price">15.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt1.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave 110 HQTrắng - 2008</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt2.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Ducati 848 Đen - 2013</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Bình Thạnh, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="sym, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt3.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">SYM Angela 50cc 2016 màu đỏ trắng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">4 tháng trước</span>
                        </div>
                        <address class="address">Quận 7, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt4.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Vespa LX 125 Đen - 2015</h3>
                        <span class="bike__price">8.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt1.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave 110 HQTrắng - 2008</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt2.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Ducati 848 Đen - 2013</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Bình Thạnh, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="sym, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt3.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">SYM Angela 50cc 2016 màu đỏ trắng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">4 tháng trước</span>
                        </div>
                        <address class="address">Quận 7, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt4.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Vespa LX 125 Đen - 2015</h3>
                        <span class="bike__price">8.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt5.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Cub 50cc Vàng Trắng - 2020</h3>
                        <span class="bike__price">7.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt6.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi 2013 màu đen vàng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">7 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt7.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave Alpha 110 hqld,  màu trắng</h3>
                        <span class="bike__price">5.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">8 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="piaggio, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt8.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Liberty 3V i.e 125 2015 màu trắng</h3>
                        <span class="bike__price">19.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">9 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hà Nội</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt9.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi Trắng Đỏ - 2013</h3>
                        <span class="bike__price">10.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">10 tháng trước</span>
                        </div>
                        <address class="address">Quận 11, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, xam" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt10.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Scrambler 1100 Sport 2021 Xám Mờ</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">11 tháng trước</span>
                        </div>
                        <address class="address">Thủ Đức, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt11.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Vision 110 2013 màu đen đỏ</h3>
                        <span class="bike__price">15.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt1.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave 110 HQTrắng - 2008</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt2.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Ducati 848 Đen - 2013</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Bình Thạnh, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="sym, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt3.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">SYM Angela 50cc 2016 màu đỏ trắng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">4 tháng trước</span>
                        </div>
                        <address class="address">Quận 7, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt4.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Vespa LX 125 Đen - 2015</h3>
                        <span class="bike__price">8.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt5.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Cub 50cc Vàng Trắng - 2020</h3>
                        <span class="bike__price">7.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt6.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi 2013 màu đen vàng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">7 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt7.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave Alpha 110 hqld,  màu trắng</h3>
                        <span class="bike__price">5.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">8 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="piaggio, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt8.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Liberty 3V i.e 125 2015 màu trắng</h3>
                        <span class="bike__price">19.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">9 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hà Nội</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt9.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi Trắng Đỏ - 2013</h3>
                        <span class="bike__price">10.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">10 tháng trước</span>
                        </div>
                        <address class="address">Quận 11, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, xam" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt10.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Scrambler 1100 Sport 2021 Xám Mờ</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">11 tháng trước</span>
                        </div>
                        <address class="address">Thủ Đức, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt11.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Vision 110 2013 màu đen đỏ</h3>
                        <span class="bike__price">15.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt1.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave 110 HQTrắng - 2008</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt2.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Ducati 848 Đen - 2013</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Bình Thạnh, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="sym, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt3.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">SYM Angela 50cc 2016 màu đỏ trắng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">4 tháng trước</span>
                        </div>
                        <address class="address">Quận 7, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt4.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Vespa LX 125 Đen - 2015</h3>
                        <span class="bike__price">8.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt5.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Cub 50cc Vàng Trắng - 2020</h3>
                        <span class="bike__price">7.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">5 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt6.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi 2013 màu đen vàng</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">7 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt7.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Wave Alpha 110 hqld,  màu trắng</h3>
                        <span class="bike__price">5.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">8 tháng trước</span>
                        </div>
                        <address class="address">Bình Tân, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="piaggio, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt8.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Liberty 3V i.e 125 2015 màu trắng</h3>
                        <span class="bike__price">19.500.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">9 tháng trước</span>
                        </div>
                        <address class="address">Cầu Giấy, Hà Nội</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="honda, trang" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt9.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Airblade 110 Fi Trắng Đỏ - 2013</h3>
                        <span class="bike__price">10.500.00đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">10 tháng trước</span>
                        </div>
                        <address class="address">Quận 11, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="ducati, xam" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt10.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">DUCATI Scrambler 1100 Sport 2021 Xám Mờ</h3>
                        <span class="bike__price">Liên hệ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">11 tháng trước</span>
                        </div>
                        <address class="address">Thủ Đức, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2" data-attributes="honda, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt11.jpeg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">HONDA Vision 110 2013 màu đen đỏ</h3>
                        <span class="bike__price">15.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">1 tháng trước</span>
                        </div>
                        <address class="address">Tân Bình, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  <div class="grid__column-2"  data-attributes="piaggio, den" style="padding: 10px;">
                    <a href="#" class="bike--item">
                      <div class="bike__img zoom-img">
                        <img src="./assets/img/dt12.jpg" alt="#" />
                      </div>
                      <div class="bike__info">
                        <h3 class="bike__name">PIAGGIO Liberty 125 i.e Đen - 2015</h3>
                        <span class="bike__price">6.800.000đ</span>
                        <div class="source">
                          <span class="condition">Xe cũ</span>
                          <span class="time">11 tháng trước</span>
                        </div>
                        <address class="address">Gò Vấp, Hồ Chí Minh</address>
                        <button class="motor__addToCard--btn">Thêm vào giỏ</button>
                      </div>
                    </a>
                  </div>
                  
                </div>
              </div>
            </div>
          </div>

          <!-- pagination -->
          <div class="motor__pagination">
            <button class="pagination__btn btn--left">
              <i class="fa-solid fa-chevron-left"></i>
            </button>
            <div class="pagination">
              <ul>
                <li class="pagination__link pagination__link--active" value="1">1</li>
                <li class="pagination__link" value="2">2</li>
                <li class="pagination__link" value="3">3</li>
                <li class="pagination__link" value="4">4</li>
                <li class="pagination__link" value="5">5</li>
                <li class="pagination__link" value="6">6 </li>
              </ul>
            </div>
            <button class="pagination__btn btn--right" >
              <i class="fa-solid fa-chevron-right"></i>
            </button>
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
                  <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Bản quyền</a></li>
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

    <script src="./assets/js/product.js"></script>
    <script src="./assets/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="./assets/bootstrap/js/popper.min.js"></script>
  </body>
</html>
