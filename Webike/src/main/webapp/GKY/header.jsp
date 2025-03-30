<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

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
                    <c:set var="u" value="${empty sessionScope.auth ? 0 : sessionScope.auth}"/>
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
                    <div class="search-suggestions">
                        <ul id="suggestion-list" ></ul>
                    </div>
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

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/GKY/assets/js/FilterProductAjax.js"></script>
