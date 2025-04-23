<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Webike: Chi tiết sản phẩm</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/base.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/homepage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/footer.css">
    <link rel="stylesheet" href=" <%= request.getContextPath()%>/GKY/assets/css/productDetail.css">
    <link rel="stylesheet"
          href="<%= request.getContextPath()%>/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/bootstrap/css/bootstrap.css">
    <script src="<%= request.getContextPath()%>/GKY/assets/js/productDetail.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css"/>
</head>
<body>
<jsp:include page="/GKY/header.jsp"/>

<div class="main">
    <!-- chua hinh anh va thong tin sp: gia, mau... -->
    <div class="info">
        <div class="info__img">
            <div class="img__container">
<%--                <img id="img" src="${p.img.entrySet().iterator().next().getValue()}" alt="anh xe"--%>
<%--                     style="width: 750px; height: 450px;"/>--%>
                <img id="img" src="${img}" alt="anh xe"
                     style="width: 750px; height: 450px;"/>

            </div>
        </div>
        <div class="info__description">
            <div class="name padding--bottom--8"> ${p.name} </div>
            <div class="description">
                <div class="price padding--bottom--8">
                    <span class="infoHeader">Giá: </span>
                    <span class="text--description">
                        <f:setLocale value="vi_VN"/>
                        <f:formatNumber value="${p.price - (p.price * p.discount/100)}" type="currency"/>
                    </span>
                    <c:if test="${p.discount > 0}">
                        <span class="ms-3 text--description" style="text-decoration: line-through;">
                            <f:setLocale value="vi_VN"/>
                            <f:formatNumber value="${p.price}" type="currency"/>
                        </span>
                    </c:if>
                </div>

                <div class="enigne padding--bottom--8">
                    <span class="infoHeader">Phiên bản: </span>
                    <span class="text--description"> ${p.version} </span>
                </div>

                <div class="brand padding--bottom--8">
                    <div class="brand__text">
                        <span class="infoHeader">Nhà sản xuất: </span>
                        <span class="text--type text--description"> ${p.brand} </span>
                    </div>
                </div>

                <div class="enigne padding--bottom--8">
                    <span class="infoHeader">Loại xe: </span>
                    <span class="text--description"> ${p.type} </span>
                </div>

                <div class="color padding--bottom--8">
                    <span class="infoHeader">Màu sắc: </span>
                    <div class="btnCointainer">
                        <c:forEach var="color" items="${p.img.entrySet()}">
                            <div class="colorButton cursor__pointer" id="${color.getKey().getId()}-ColorID"
                                 onclick="changeColor(this.id)">
                                <div class="colorbtn" style="background-color: ${color.getKey().getCode()};"></div>
                                <span class="color--text text--description">${color.getKey().getName()}</span>
                            </div>
                        </c:forEach>
<%--                        <script>--%>
<%--                            var imgColor = {};--%>
<%--                            // truyen gia tri tu servlet vao map cua js--%>
<%--                            <c:forEach var="entry" items="${p.img.entrySet()}">--%>
<%--                            imgColor['${entry.key.name}'] = '${entry.value}';--%>
<%--                            </c:forEach>--%>

<%--                            function changeColor(id) {--%>
<%--                                const imgElement = document.getElementById('img');--%>
<%--                                imgElement.src = imgColor[id];--%>
<%--                                const allBtns = document.querySelectorAll('.colorButton');--%>
<%--                                allBtns.forEach(function (btn) {--%>
<%--                                    if (btn.id !== id.toString()) {--%>
<%--                                        btn.style.background = "none";--%>
<%--                                    } else {--%>
<%--                                        btn.style.background = "rgb(147, 157, 163)";--%>
<%--                                    }--%>
<%--                                });--%>
<%--                                const color = document.getElementById("productColor");--%>
<%--                                const img = document.getElementById("productImg");--%>

<%--                                const directBuyColor = document.getElementById("directBuyColor");--%>
<%--                                const directBuyImg = document.getElementById('directBuyImg');--%>

<%--                                color.value = id;--%>
<%--                                img.value = imgColor[id];--%>
<%--                                directBuyColor.value = id;--%>
<%--                                directBuyImg.value = imgColor[id];--%>
<%--                            }--%>

<%--                            window.onload = function () {--%>
<%--                                const firstButton = document.querySelector('.colorButton');--%>
<%--                                if (firstButton) {--%>
<%--                                    changeColor(firstButton.id);--%>
<%--                                }--%>
<%--                            }--%>
<%--                        </script>--%>
                    </div>
                </div>

                <div class="remain padding--bottom--8">
                    <span class="infoHeader">Số lượng còn lại: </span>
                    <span class="text--description"> ${p.quantity} </span>
                </div>

            </div>
            <div class="container--button d-flex">
                <form action="direct-buy" method="POST">
                    <input type="hidden" id="directBuy" name="method" value="direct">
                    <input type="hidden" name="id" value="${p.id}">
                    <input type="hidden" id="directBuyColor" name="color" value="">
                    <input type="hidden" id="directBuyImg" name="img" value="">
                    <button type="submit" class="buy">Mua ngay</button>
                </form>

                <form action="add-cart?id=${p.id}" method="GET">
                    <input type="hidden" name="id" id="id" value="${p.id}">
                    <input type="hidden" name="color" id="productColor" value="">
                    <input type="hidden" name="img" id="productImg" value="">
                    <button type="submit" class="addToCart">Thêm vào giỏ hàng</button>
                </form>
            </div>
        </div>
    </div>

    <!-- tinh nang noi bat -->
    <div class="features mt-5 mb-5">
        <h1 class="features--header mb-5">TÍNH NĂNG NỔI BẬT</h1>
        <div class="img-warp ">
            <p class="img-background">
                <img src="img/background/street background.jpg" alt="anh nen">
                <span class="img-text"> ${p.name} </span>
            </p>
            <p class="img-bike">
                <img src=" ${p.img.entrySet().iterator().next().getValue()} " alt="anh xe">
            </p>
        </div>
        <p class="des mb-3">
            ${p.des}
        </p>
    </div>
    <ul class="features-item d-flex p-0 m-0 ">
        <c:forEach var="f" items="${f}">
            <li class="fItem shadow">
                <img class="img-bound" src="${f.img}" alt="">
                <div class="m-4 mt-3 p-2 mb-0 pb-0 mb-0 pb-0">
                    <h2 class="fs-2">${f.tag}</h2>
                    <p class="fs-4">${f.des}</p>
                </div>
            </li>
        </c:forEach>
    </ul>

    <!-- thông số kỹ thuật của sản phẩm: phân khối, khung xe... -->
    <div class="detail container mt-5 d-flex flex-column justify-content-between align-items-center">
        <h1 class="detail--header">THÔNG SỐ KỸ THUẬT</h1>
        <div class="accordion">
            <!-- thong so ky thuat -->
            <c:forEach var="type" items="${specType}" varStatus="status">
                <%-- varstatus dung de theo doi trang thai lap foreach trong jstl --%>
                <%-- index de lay ra index cua phan tu trong loop --%>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOpen${status.index}">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#open${status.index}" aria-expanded="false"
                                aria-controls="open${status.index}">
                            <span class="accordionItem__Header"> ${type} </span>
                        </button>
                    </h2>
                    <div id="open${status.index}" class="accordion-collapse collapse"
                         aria-labelledby="headingOpen${status.index}">
                        <div class="accordion-body p-0">
                            <ul class="list-group item--container">
                                <c:forEach var="s" items="${specMap[type]}">
                                    <li class="list-group-item d-flex">
                                        <h4 class="item--header">${s.tag}</h4>
                                        <small class="lead text-muted item--detail">
                                                ${s.des}
                                        </small>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <!-- bao hanh -->
            <div class="accordion-item">
                <h2 class="accordion-header" id="headingOpen${specType.size()+1}">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                            data-bs-target="#open${specType.size()+1}" aria-expanded="false"
                            aria-controls="open${specType.size()+1}">
                        <span class="accordionItem__Header"> Chính sách bảo hành </span>
                    </button>
                </h2>
                <div id="open${specType.size()+1}" class="accordion-collapse collapse"
                     aria-labelledby="headingOpen${specType.size()+1}">
                    <div class="accordion-body p-0">
                        <ul class="list-group item--container">
                            <c:forEach var="w" items="${warranties}">
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">thời gian bảo hành</h4>
                                    <small class="lead text-muted item--detail">
                                            ${w.km} km/ ${w.duration} năm (Tùy điều kiện nào đến trước)
                                    </small>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%-- cac sp khac --%>
    <%--    <div class="container d-flex flex-column justify-content-between align-items-center" style="width: 90%;">--%>
    <%--        <h1 class="">CÓ THỂ BẠN QUAN TÂM</h1>--%>
    <%--        <div class="container--card row">--%>
    <%--            <a href="#" class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">--%>
    <%--                <img src="assets/img/future blue.png" class="card-img-top img__modi" alt="???">--%>
    <%--                <div class="card--body">--%>
    <%--                    <h3 class="card-title">--%>
    <%--                        <span class="uppercase padding__5px__8px text__white">honda future</span>--%>
    <%--                    </h3>--%>
    <%--                    <span class="card-text padding__5px__8px text__white">85.050.000 vnd</span>--%>
    <%--                </div>--%>
    <%--            </a>--%>
    <%--            <a href="#" class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">--%>
    <%--                <img src="assets/img/honda harley.png" class="card-img-top img__modi" alt="???">--%>
    <%--                <div class="card--body">--%>
    <%--                    <h3 class="card-title">--%>
    <%--                        <span class="uppercase padding__5px__8px text__white">honda harley</span>--%>
    <%--                    </h3>--%>
    <%--                    <span class="card-text padding__5px__8px text__white">374.000.000 vnd</span>--%>
    <%--                </div>--%>
    <%--            </a>--%>
    <%--            <a href="#" class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">--%>
    <%--                <img src="assets/img/kawasaki black harley.png" class="card-img-top img__modi" alt="???">--%>
    <%--                <div class="card--body">--%>
    <%--                    <h3 class="card-title">--%>
    <%--                        <span class="uppercase padding__5px__8px text__white">kawasaki sora</span>--%>
    <%--                    </h3>--%>
    <%--                    <span class="card-text padding__5px__8px text__white">1.069.000.000 vnd</span>--%>
    <%--                </div>--%>
    <%--            </a>--%>
    <%--            <a href="#" class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">--%>
    <%--                <img src="assets/img/kawasaki green 1.png" class="card-img-top img__modi" alt="???">--%>
    <%--                <div class="card--body">--%>
    <%--                    <h3 class="card-title">--%>
    <%--                        <span class="uppercase padding__5px__8px text__white">kawasaki ninjas</span>--%>
    <%--                    </h3>--%>
    <%--                    <span class="card-text padding__5px__8px text__white">3.111.000.000 vnd</span>--%>
    <%--                </div>--%>
    <%--            </a>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <%--  cmt  --%>
    <div class="m-5" style="border: 3px solid #000; width: 80%;"></div>
    <div class="commentSection d-flex flex-column align-items-center ">
        <h1 class="text-center">BÌNH LUẬN</h1>
        <div class="comment_container d-flex flex-column align-items-center gap-2">
            <c:choose>
            <c:when test="${not empty c}">
            <c:forEach var="c" items="${c}">
            <div class="p-3 d-flex align-items-center justify-content-center gap-4" style="width: 1500px">
                <div class="user-avt d-flex flex-row">
                    <img id="" class="user_avt" src="${c.avt}" alt="user avt">
                </div>
                <div class="comment_content d-flex flex-column align-items-center">
                    <div class="d-flex align-items-center" style="width: 100%;">
                        <h3 class="username text-start">@${c.username}</h3>
                        <h3 class="ms-5" style="font-weight: 400;">${c.created}</h3>
                        <h3>Phân loại: ${c.color}</h3>
                    </div>
                    <h4 class="cmt">
                            ${c.content}
                    </h4>
                </div>
                <div class="option cursor__pointer">
                    <i class="fa-solid fa-ellipsis-vertical"></i>
                </div>
            </div>
        </div>
        </c:forEach>
        </c:when>
        <c:otherwise>
            <div>Chưa có bình luận nào</div>
        </c:otherwise>
        </c:choose>
    </div>
    <!-- footer -->
    <jsp:include page="/GKY/footer.jsp" />

</div>
<script src="assets/js/productDetail.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
<!-- footer -->
<jsp:include page="/GKY/footer.jsp"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/</body>
</html>