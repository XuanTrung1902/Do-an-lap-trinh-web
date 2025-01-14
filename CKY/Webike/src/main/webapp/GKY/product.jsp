<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Chợ xe máy</title>
    <title>WeBike</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/base.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/product.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/font/themify-icons/themify-icons.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/bootstrap/css/bootstrap.css"/>
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
                            <a href="homepage">Trang chủ</a>
                        </li>
                        <li class="header__navbar--item">
                            <a href="list-products">Chợ xe máy</a>
                        </li>
<%--                        <li class="header__navbar--item">--%>
<%--                            <a href="news.jsp">Tin tức</a>--%>
<%--                        </li>--%>
                        <!-- <li class="header__navbar--item">
                          <a href="#">Đại lí</a>
                        </li> -->
<%--                        <li class="header__navbar--item">--%>
<%--                            <a href="contact.jsp">Liên hệ</a>--%>
<%--                        </li>--%>
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
                            <img src="GKY/assets/img/avt1.jpg" alt="" class="header__navbar--user-img">
                            <span class="header__navbar--user-name">Trí Đức</span>

                            <ul class="header__navbar--user-menu">
                                <li class="header__navbar--user-menu-item">
                                    <a href="trangTTKhachHang.jsp"><i class="fa-solid fa-user m-r-8"></i>Thông tin cá
                                        nhân</a>
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
                        <a href="Gio hang.jsp" class="header__cart-link">
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
            <img src="GKY/assets/img/banner.jpg" alt="">
        </div>


        <div class="motor__market">
            <div class="box__title">
            <span>
              <h2 class="motor__market--title">Chợ xe máy</h2>
            </span>
            </div>

            <!-- List bike -->
            <div class="motor__list">

                <c:forEach var="p2" items="${products2}">
                    <a href="productDetail?id=${p2.id}" class="bike__link">
                        <div class="box__bike--item">
                            <div class="box__bike-img">
                                <img src="${p2['imgurl']}" alt="#"/>
                                <h5 class="box__bike--name">
                                        ${p2['name']}
                                </h5>
<%--                                <span class="box__sub--title">${p2['status']}</span>--%>
                            </div>
                            <div class="box__bike--price">
                                <span class="box__bike--price-old"><f:formatNumber value="${p2.price}" pattern="#,##0.###"/>đ</span>
                                <span class="box__bike--price-current">
                       <f:formatNumber value="${ p2.price - (p2.price * p2.discount / 100)}" pattern="#,##0.###"/>đ
                  </span>
                            </div>
<%--                            <div class="box__bike--origin">--%>
<%--                                <span class="box__bike--origin-text">Hà Nội</span>--%>
<%--                            </div>--%>
                            <div class="box__bike--favourite">
                                <i class="fa-regular fa-heart"></i>
                            </div>
                            <div class="box__bike--sale-off">
                                <span class="box__bike--sale-off-percent">${p2.discount}%</span>
                                <span class="box__bike--sale-off-label">Giảm</span>
                            </div>
                        </div>
                    </a>
                </c:forEach>

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
                    <h3 class="title-second-name">Lọc sản phẩm</h3>
                </div>

                <div class="grid-2-8" style="padding-bottom: 10px;">
                    <div class="checkbox__category">
                        <div id="checkboxes">
                            <h4>Hãng xe</h4>
                            <label><input type="checkbox" value="HONDA"> HONDA</label>
                            <label><input type="checkbox" value="DUCATI"> DUCATI</label>
                            <label><input type="checkbox" value="SYM"> SYM</label>
                            <label><input type="checkbox" value="PIAGGIO"> PIAGGIO</label>
                        </div>
                        <div id="checkboxes1">
                            <h4>Màu sắc</h4>
                            <label><input type="checkbox" value="ĐEN"> ĐEN</label>
                            <label><input type="checkbox" value="TRẮNG"> TRẮNG</label>
                            <label><input type="checkbox" value="XÁM"> XÁM</label>
                        </div>
                    </div>

                    <div class="list-bike">
                        <div class="grid__row" style="padding: 0 40px;">
                            <c:forEach var="p" items="${products}">
                                <div id="SP${p.id}" class="grid__column-2" data-attributes="honda, trang" style="padding: 10px; height: 380px">
                                    <a href="productDetail?id=${p.id}" class="bike--item">
                                        <div class="bike__img zoom-img">
                                            <img src="${p['imgurl']}" alt="${p.name}"/>
<%--                                            <c:set var="color" value="${p.img.entrySet().iterator().next().getKey()}" />--%>
<%--                                            <c:set var="img" value="${p.img.get(color)}" />--%>
<%--                                            <img src="${img}" alt="${p.name}"/>--%>
                                        </div>
                                        <div class="bike__info">
                                            <h3 class="bike__name" style="display: block; height: 49px;" >${p.name}</h3>
                                            <div class="d-flex justify-content-between">

                                            <span class="bike__price">
                                                <f:formatNumber value="${p['price']}" pattern="#,##0.###"/>đ
                                            </span>
                                                <c:if test="${p.discount > 0.0}">
                                                    <span class="text-danger" style="text-align: center;display: flex;font-size: 1.3rem;">-${p.discount}%</span>
                                                </c:if>
                                            </div>
                                            <div class="source">
                                                <span class="condition">${p.version}</span>
                                                <span class="time">${p.launch}</span>
                                            </div>
                                            <address class="address">${p.status}</address>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>

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
                        <li class="pagination__link" value="6">6</li>
                    </ul>
                </div>
                <button class="pagination__btn btn--right">
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
                                <img class="footer__banking" src="GKY/assets/img/bankcard1.png" alt="">
                                <img class="footer__banking" src="GKY/assets/img/bankcard2.png" alt="">
                                <img class="footer__banking" src="GKY/assets/img/bankcard3.png" alt="">
                                <img class="footer__banking" src="GKY/assets/img/bankcard4.png" alt="">
                                <img class="footer__banking" src="GKY/assets/img/bankcard5.png" alt="">
                                <img class="footer__banking" src="GKY/assets/img/bankcard6.png" alt="">
                            </div>
                            <div class="footer__rectangle">
                                <img src="GKY/assets/img/Rectangle.png" alt="">
                            </div>
                        </form>
                    </div>
                </div>

                <div class="d-flex flex-column flex-sm-row justify-content-between py-4 my-4 border-top">
                    <p>&copy; 2024 Company, Inc. All rights reserved.</p>
                    <ul class="list-unstyled d-flex">
                        <li class="ms-3"><a class="link-body-emphasis" href="#">
                            <svg class="bi" width="24" height="24">
                                <use xlink:href="#twitter"/>
                            </svg>
                        </a></li>
                        <li class="ms-3"><a class="link-body-emphasis" href="#">
                            <svg class="bi" width="24" height="24">
                                <use xlink:href="#instagram"/>
                            </svg>
                        </a></li>
                        <li class="ms-3"><a class="link-body-emphasis" href="#">
                            <svg class="bi" width="24" height="24">
                                <use xlink:href="#facebook"/>
                            </svg>
                        </a></li>
                    </ul>
                </div>
            </footer>
        </div>
    </footer>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
    $(document).ready(function () {
        console.log('jQuery loaded');
    });
</script>
<script src="${pageContext.request.contextPath}/GKY/assets/js/product.js"></script>
<script src="${pageContext.request.contextPath}/GKY/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/GKY/assets/bootstrap/js/popper.min.js"></script>


</body>
</html>
