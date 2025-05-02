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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/product.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/font/themify-icons/themify-icons.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css"/>
    <script> var isLoggedIn = ${not empty sessionScope.auth}; </script>
</head>
<body>
<div class="app">
    <jsp:include page="/GKY/header.jsp" />

    <div class="container" style="padding: 0">
        <div class="banner" style=" --height: 200px; --width: 10%; --quantity: 10;">`
            <div class="list-banner">
                <div class="banner-item" style="--position: 1"><img src="GKY/assets/img/product1.png" alt=""></div>
                <div class="banner-item" style="--position: 2"><img src="GKY/assets/img/product2.png" alt=""></div>
                <div class="banner-item" style="--position: 3"><img src="GKY/assets/img/product3.png" alt=""></div>
                <div class="banner-item" style="--position: 4"><img src="GKY/assets/img/product4.png" alt=""></div>
                <div class="banner-item" style="--position: 5"><img src="GKY/assets/img/product5.png" alt=""></div>
                <div class="banner-item" style="--position: 6"><img src="GKY/assets/img/product1.png" alt=""></div>
                <div class="banner-item" style="--position: 7"><img src="GKY/assets/img/product2.png" alt=""></div>
                <div class="banner-item" style="--position: 8"><img src="GKY/assets/img/product3.png" alt=""></div>
                <div class="banner-item" style="--position: 9"><img src="GKY/assets/img/product4.png" alt=""></div>
                <div class="banner-item" style="--position: 10"><img src="GKY/assets/img/product5.png" alt=""></div>
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
                <c:forEach var="p2" items="${products2}">
                    <a href="#" onclick="checkLoginForProducts(event, ${p2.id})" class="bike__link" >
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
                    <div>
                        <h3 class="title-second-name">Lọc sản phẩm</h3>
                    </div>
                        <div class="title__animation">
                            <span class="title__text" style="--color : #0077b6; --delay: 0s">W</span>
                            <span class="title__text" style="--color : #0096c7; --delay: 0.5s">E</span>
                            <span class="title__text" style="--color : #09b2d5; --delay: 1s">B</span>
                            <span class="title__text" style="--color : #089bbb; --delay: 1.5s">I</span>
                            <span class="title__text" style="--color : #90be6d; --delay: 2s">K</span>
                            <span class="title__text" style="--color : #bc6c25; --delay: 2.5s">E</span>
                            <span>&nbsp;</span>
                            <span class="title__text" style="--color : #ef476f; --delay: 3s">L</span>
                            <span class="title__text" style="--color : #f94144; --delay: 3.5s">O</span>
                            <span class="title__text" style="--color : #f3722c; --delay: 4s">V</span>
                            <span class="title__text" style="--color : #f8961e; --delay: 4.5s">E</span>
                            <span>&nbsp;</span>
                            <span class="title__text" style="--color : #f9844a; --delay: 5s">M</span>
                            <span class="title__text" style="--color : #f9c74f; --delay: 5.5s">O</span>
                            <span class="title__text" style="--color : #90be6d; --delay: 6s">T</span>
                            <span class="title__text" style="--color : #43aa8b; --delay: 6.5s">O</span>
                            <span class="title__text" style="--color : #577590; --delay: 7s">R</span>
                            <span class="title__text" style="--color : #4d908e; --delay: 7.5s">C</span>
                            <span class="title__text" style="--color : #277da1; --delay: 8s">Y</span>
                            <span class="title__text" style="--color : #0077b6; --delay: 8.5s">C</span>
                            <span class="title__text" style="--color : #0096c7; --delay: 9s">L</span>
                            <span class="title__text" style="--color : #00b4d8; --delay: 9.5s">E</span>
                            <span>&nbsp;</span>
                            <span class="title__text" style="--color : #264653; --delay: 10s">A</span>
                            <span class="title__text" style="--color : #2a9d8f; --delay: 10.5s">N</span>
                            <span class="title__text" style="--color : #e9c46a; --delay: 11s">D</span>
                            <span>&nbsp;</span>
                            <span class="title__text" style="--color : #f4a261; --delay: 11.5s">R</span>
                            <span class="title__text" style="--color : #e76f51; --delay: 12s">I</span>
                            <span class="title__text" style="--color : #d62828; --delay: 12.5s">D</span>
                            <span class="title__text" style="--color : #9d0208; --delay: 13s">E</span>
                            <span class="title__text" style="--color : #6a040f; --delay: 13.5s">R</span>
                            <span class="title__text" style="--color : #370617; --delay: 14s">S</span>
                        </div>
                </div>
                <div class="grid-2-8" style="padding-bottom: 10px;">
                    <div class="checkbox__category">
                        <div id="checkboxes">
                            <h4 class="filter">Hãng xe</h4>
                            <c:forEach var="ab" items="${allBrand}">
                                <label><input type="checkbox" class="filter-checkbox" name="brand" value="${ab.name}"> ${ab.name}</label>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="list-bike">
                        <div id="product-grid" onclick="checkLoginForProducts(event)"  class="grid__row" style="padding: 0 40px;">
                            <c:forEach var="p" items="${products}">
                                <div id="SP${p.id}" class="grid__column-2" data-attributes="honda, trang" style="padding: 10px; height: 380px">
                                    <a href="#" onclick="checkLoginForProduct(event, ${p.id})" class="bike--item">
                                        <div class="bike__img zoom-img">
                                            <img src="${p['imgurl']}" alt="${p.name}"/>
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

    <jsp:include page="/GKY/footer.jsp" />
</div>



<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/GKY/assets/js/product.js"></script>
<script src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
<script>
    function checkLoginForProducts(event) {
        <c:if test="${empty sessionScope.auth}">
        event.preventDefault();
        showToast("Bạn cần phải đăng nhập trước!");
        return false;
        </c:if>
        window.location.href = "${pageContext.request.contextPath}/list-products";
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
<%-- comment lại thì chạy được, mà mở ra thì lại lỗi ?  --%>
<script src="${pageContext.request.contextPath}/GKY/assets/js/FilterProductAjax.js"></script>
<script src="${pageContext.request.contextPath}/GKY/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/GKY/assets/bootstrap/js/popper.min.js"></script>


</body>
</html>
