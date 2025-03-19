<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<%--<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WeBike</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/homepage.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/bootstrap/css/bootstrap.css">

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


<%--                            <c:set var="u" value="${empty sessionScope.auth ? 0 : sessionScope.auth}"/>--%>


                            <c:set var="u" value="${empty sessionScope.auth ? null : sessionScope.auth}"/>
                            <li class="header__navbar--item header__navbar--user">
                                <img src="${u.image}" alt="" class="header__navbar--user-img">
                                <span class="header__navbar--user-name">${u.name}</span>

                                <ul class="header__navbar--user-menu">
                                    <li class="header__navbar--user-menu-item">
                                        <a href="${pageContext.request.contextPath}/Profile"><i class="fa-solid fa-user m-r-8"></i>Thông tin cá
                                            nhân</a>
                                    </li>
                                    <li class="header__navbar--user-menu-item">
                                        <a href="buy-history"><i class="fa-solid fa-shopping-cart m-r-8"></i>Lịch sử mua hàng</a>
                                    </li>
                                    <li class="header__navbar--user-menu-item">
                                        <a href="Logout"><i class="fa-solid fa-sign-out m-r-8"></i>Đăng xuất</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                    <div class="header__navbar--bot">
                        <div class="header__search">
                            <input type="text" id="search-input" class="header__search--input" placeholder="Nhập từ khoá tìm kiếm"/>
                            <div class="header__search-select">
                                <span class="header__search-select-label">Tìm xe</span>
                                <i class="header__search-select-icon"></i>

                            </div>
                            <button class="header__search--btn">
                                <i class="header__search--btn-icon fa-solid fa-search"></i>
                            </button>
                        </div>

                        <div class="header__cart" style="width: fit-content">
                            <a href="show-cart" class="header__cart-link">
                                <i class="header__cart-icon ti-shopping-cart"></i>
                                <c:set var="xxx" value="${empty sessionScope.cart.cartLength ? 0 : sessionScope.cart.cartLength}"></c:set>
                                <span class="header__cart--text">Giỏ Hàng (${xxx}) </span>                             </a>
                        </div>
                    </div>
                </nav>
            </div>
        </header>

    <div class="container" style="padding: 0;">
        <!-- Slider -->
<%--        <a href="Chi%20tiet%20san%20pham.jsp">--%>
<%--            <div class="slider">--%>
<%--                <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">--%>
<%--                    <div class="carousel-indicators bg__control ">--%>
<%--                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0"--%>
<%--                                class="active" aria-current="true" aria-label="Slide 1"></button>--%>
<%--                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"--%>
<%--                                aria-label="Slide 2"></button>--%>
<%--                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"--%>
<%--                                aria-label="Slide 3"></button>--%>
<%--                    </div>--%>
<%--                    <div class="carousel-inner">--%>
<%--                        <c:forEach var="x" items="${get3}">--%>
<%--                        <div class="carousel-item ">--%>
<%--                            <img src="${x.imgurl}" class="d-block w-100 slider_img" alt="">--%>
<%--                            <div class="carousel-caption d-none d-md-block">--%>
<%--&lt;%&ndash;                                <h5>${x.name}</h5>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <p>${x.des}</p>&ndash;%&gt;--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        </c:forEach>--%>
<%--&lt;%&ndash;                        <div class="carousel-item">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <img src="GKY/assets/img/xe2.jpg" class="d-block w-100 slider_img" alt="">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <div class="carousel-caption d-none d-md-block">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <h5>Winner X 2024</h5>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <p>Khẳng định chất riêng biệt hướng tới hình ảnh một mẫu siêu mô tô</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="carousel-item">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <img src="GKY/assets/img/xe3.jpg" class="d-block w-100 slider_img " alt="">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <div class="carousel-caption d-none d-md-block">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <h5>Vespa Sprint S125</h5>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <p>Cho những tâm hồn bản lĩnh, khát khao và cá tính</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--                    </div>--%>
<%--                    <button class="carousel-control-prev bg__control " type="button"--%>
<%--                            data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">--%>
<%--                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
<%--                        <span class="visually-hidden">Previous</span>--%>
<%--                    </button>--%>
<%--                    <button class="carousel-control-next bg__control" type="button"--%>
<%--                            data-bs-target="#carouselExampleCaptions" data-bs-slide="next">--%>
<%--                        <span class="carousel-control-next-icon" aria-hidden="true"></span>--%>
<%--                        <span class="visually-hidden">Next</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </a>--%>
        <!-- Motorbike Category -->
        <%--            <div id="motorSelectionCategory">--%>
        <%--               <div class="motorbike__row">--%>
        <%--                    <c:forEach var="b" items="${bikeTypes}">--%>
        <%--                    <div class="motorbike-item">--%>
        <%--                        <a href="product.jsp" class="motorbike-item-link">--%>
        <%--                            <div class="motorbike__content">--%>
        <%--                                <div class="motorbike__thumb">--%>
        <%--                                    <img class="motorbike-item-img" src="${b.img}" alt="xe">--%>
        <%--                                </div>--%>
        <%--                                <div class="motorbike__body">--%>
        <%--                                    <h3 class="motorbike__title">${b.type}</h3>--%>
        <%--                                    <div class="motorbike__body--bf">--%>
        <%--                                        <div class="motorbike__body-icon"></div>--%>
        <%--                                    </div>--%>
        <%--                                </div>--%>
        <%--                            </div>--%>
        <%--                        </a>--%>
        <%--                    </div>--%>
        <%--                    </c:forEach>--%>

        <%--                    <div class="motorbike-item">--%>
        <%--                        <a href="products" class="motorbike-item-link motorbike__title d-block ">--%>
        <%--                           <span class="motorbike__body-see-all">--%>
        <%--                                <i class="motorbike__body-see-all-icon fa-solid fa-plus"></i>--%>
        <%--                                 Xem tất cả--%>
        <%--                           </span>--%>
        <%--                        </a>--%>
        <%--                    </div>--%>
        <%--               </div>--%>
        <%--            </div>--%>

        <div class="bike-introduce">
            <div class="bike-banner">
                <div class="banner-img">
                    <img src="GKY/assets/img/indroduce.jpg" alt="">
                    <div class="bike-intro__main">
                        <div class="bike__header">
                            <p>Webike Việt Nam</p>
                        </div>
                        <div class="bike__description">
                            <p>Webike Việt Nam là cửa hàng trực tuyến hàng đầu chuyên cung cấp các loại xe máy và phụ
                                kiện chất lượng cao. Chúng tôi cam kết mang đến cho khách hàng những sản phẩm tốt nhất
                                với giá cả hợp lý và dịch vụ chăm sóc khách hàng tận tâm.</p>
                        </div>
                        <div class="bike__button">
                            <a href="list-products" class="bike__button--link">
                                <button class="btn-container">
                                    <span class="btn-container--text">Xem thêm</span>
                                    <span class="btn-container--icon">
                                            <i class="fa-solid fa-arrow-right"></i>
                                        </span>
                                </button>
                            </a>
                        </div>
                    </div>
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

                <c:forEach var="br" items="${brands}">
                    <div class="brand-item">
                        <a href="#" class="brand-link">
                            <img src="${br}" alt="" style="object-fit: contain">
                        </a>
                    </div>
                </c:forEach>

            </div>
        </div>

        <!-- dealer -->
        <div class="dealer">
            <div class="dealer__heading">
                <h3 class="dealer__heading--title">Chi nhánh</h3>
            </div>
            <div class="dealer__list">
                <div class="dealer__list--row">
                    <c:forEach var="s" items="${shops}">
                        <a href="#" class="dealer__list--item">
                            <div class="dealer__list--img">
                                <img src="GKY/assets/img/banner.jpg" alt="#">
                                <span class="dealer__list--name">${s.name}</span>
                            </div>
                            <div class="dealer__list--description">
                                <p>Địa chỉ: ${s.address}</p>
                            </div>
                        </a>
                    </c:forEach>
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

    <script src="${pageContext.request.contextPath}/GKY/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/GKY/assets/bootstrap/js/popper.min.js"></script>
</body>
</html>
