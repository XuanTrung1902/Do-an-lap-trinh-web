<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/homepage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/buyHistory.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/header_buyHistory.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/bootstrap/css/bootstrap.css">
    <title>Webike: lịch sử mua hàng</title>
</head>
<body>
<!-- chua toan bo noi dung trang -->
<div class="main">
    <div class="header d-flex align-items-center">
        <a href="list-products">
            <img class="logo-img" src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827"
                 alt="Webike VN">
        </a>
        <div class="separator"></div>
        <h1 class="header__text">Lịch sử mua hàng</h1>
    </div>

    <div class="head__line"></div>

    <div class="order-container container">
        <jsp:include page="/GKY/header_buyHistory.jsp" />

        <c:forEach var="oi" items="${ls}">
            <div class="order-item d-flex align-items-center">
                <img src="${oi.img}" alt="Product Image" class="product-image">
                <div>ID: ${oi.id}</div>
                <div class="product-details">
                    <div class="product-name">${oi.name}</div>
                    <div class="product-meta">Phân loại hàng: ${oi.color.name} x ${oi.quantity}</div>
                    <div class="product-status">${oi.status}</div>
                    <div class="product-price">Tổng số tiền:
                        <f:setLocale value="vi_VN"/>
                        <f:formatNumber value="${oi.price}" type="currency"/>
                    </div>
                    <div class="product-actions">
                        <form action="buy-history" method="post" id="comment${oi.productID}" style="display: flex;align-items: center">
                            <input type="hidden" name="productID" value="${oi.productID}">
                            <c:if test="${oi.status == 'Đã thanh toán'}">
                                <c:if test="${oi.commented == 0}">
                                    <textarea name="comment" class="resize" form="comment${oi.productID}" rows="3"
                                              cols="50" placeholder="Nhập đánh giá của bạn!"
                                              style="height: 37px; margin-right: 10px"></textarea>
                                    <input type="hidden" name="color" value="${oi.color.name}">
                                    <input type="hidden" name="orderItemID" value="${oi.id}">
                                    <button type="submit" class="view-details">Đánh Giá</button>
                                </c:if>
                            </c:if>
                        </form>
                        <form action="productDetail" method="get">
                            <input type="hidden" name="id" value="${oi.productID}">
                            <input type="hidden" name="cid" value="${oi.color.id}">
                            <button type="submit" class="buy-again">Mua Lần Nữa</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
        <c:if test="${totalPages > 1}">
            <div class="pagination d-flex justify-content-center mt-4 mb-4">
                <c:if test="${currentPage > 1}">
                    <a href="buy-history?page=${currentPage - 1}" class="page__link">Trang trước</a>
                </c:if>
                <c:forEach begin="1" end="${totalPages}" var="i">
                    <c:choose>
                        <c:when test="${i == currentPage}">
                            <span class="page__link active">${i}</span>
                        </c:when>
                        <c:otherwise>
                            <a href="buy-history?page=${i}" class="page__link">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${currentPage < totalPages}">
                    <a href="buy-history?page=${currentPage + 1}" class="page__link">Trang sau</a>
                </c:if>
            </div>
        </c:if>
    </div>


    <jsp:include page="/GKY/footer.jsp"/>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        const tabs = document.querySelectorAll('.tab-item');

        tabs.forEach(tab => {
            tab.addEventListener('click', function() {
                tabs.forEach(t => t.classList.remove('tab-item--active'));
                this.classList.add('tab-item--active');
            });
        });
    });
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/GKY/assets/js/buyHistory.js"></script>
</body>
</html>
