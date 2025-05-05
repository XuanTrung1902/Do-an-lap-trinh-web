<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css"/>

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

                    <c:choose>
                        <c:when test="${empty sessionScope.auth}">
                            <!-- Người dùng chưa đăng nhập -->
                            <li class="header__navbar--item header__navbar--separate">
                                <a href="${pageContext.request.contextPath}/Login"><i class="fa-solid fa-user m-r-8"></i>Đăng nhập</a>
                            </li>
                            <li class="header__navbar--item">
                                <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <!-- Người dùng đã đăng nhập -->
                            <li class="header__navbar--item header__navbar--user">
                                <img src="${sessionScope.auth.image}" alt="" class="header__navbar--user-img">
                                <span class="header__navbar--user-name">${sessionScope.auth.name}</span>
                                <ul class="header__navbar--user-menu">
                                    <li class="header__navbar--user-menu-item">
                                        <a href="${pageContext.request.contextPath}/Profile"><i class="fa-solid fa-user m-r-8"></i>Thông tin cá nhân</a>
                                    </li>
                                    <li class="header__navbar--user-menu-item">
                                        <a href="buy-history"><i class="fa-solid fa-shopping-cart m-r-8"></i>Lịch sử mua hàng</a>
                                    </li>
                                    <li class="header__navbar--user-menu-item">
                                        <a href="Logout"><i class="fa-solid fa-sign-out m-r-8"></i>Đăng xuất</a>
                                    </li>
                                </ul>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>

            <div class="header__navbar--bot">
                <div onclick="checkLoginForSearch(event)" class="header__search">
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
                    <a href="show-cart" onclick="checkLoginForCart(event)" class="header__cart-link">
                        <i class="header__cart-icon ti-shopping-cart"></i>
                        <c:set var="cartSize" value="${empty sessionScope.cart.cartLength ? 0 : sessionScope.cart.cartLength}"></c:set>
                        <span class="header__cart--text">Giỏ Hàng (${cartSize}) </span>
                    </a>
                </div>
            </div>
        </nav>
    </div>
</header>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
<script>
    function checkLoginForSearch(event) {
        <c:if test="${empty sessionScope.auth}">
        event.preventDefault();
        showToast("Bạn cần phải đăng nhập trước!");
        return false;
        </c:if>
        return true;
    }

    function checkLoginForCart(event) {
        <c:if test="${empty sessionScope.auth}">
        event.preventDefault();
        showToast("Bạn cần phải đăng nhập trước!");
        return false;
        </c:if>
        window.location.href = "${pageContext.request.contextPath}/show-cart"; // Chuyển đến trang giỏ hàng nếu đã đăng nhập
        return true;
    }

    function showToast(message) {
        Toastify({
            text: message,
            duration: 3000,
            close: true,
            gravity: "top",
            position: "right",
            backgroundColor: "#e74c3c",
            stopOnFocus: true,
        }).showToast();
    }
</script>
<script src="${pageContext.request.contextPath}/GKY/assets/js/FilterProductAjax.js"></script>
