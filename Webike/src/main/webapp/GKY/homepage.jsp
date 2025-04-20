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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/homepage.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/bootstrap/css/bootstrap.css">
    <!-- Toastify CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css"/>

</head>
<body>
    <div class="app">
    <jsp:include page="/GKY/header.jsp" />

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

    <jsp:include page="/GKY/footer.jsp" />
</div>

    <script src="${pageContext.request.contextPath}/GKY/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/GKY/assets/bootstrap/js/popper.min.js"></script>

    <!-- Toastify JS -->
    <script src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
    <script>
        function showToast(message, type = 'error') {
            Toastify({
                text: message,
                duration: 3000,
                close: true,
                gravity: "top", // Hiển thị ở trên cùng
                position: "right", // Hiển thị ở bên phải
                backgroundColor: type === 'error' ? "#e74c3c" : "#2ecc71",
                stopOnFocus: true,
            }).showToast();
        }
    </script>
</body>
</html>
