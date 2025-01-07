<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/base.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/homepage.css">
    <link rel="stylesheet"
          href="<%= request.getContextPath()%>/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/bootstrap/css/bootstrap.css">

    <link rel="stylesheet" href="<%= request.getContextPath()%>/GKY/assets/css/cart.css">
</head>
<title>Giỏ hàng</title>
</head>

<body>
<div class="main">
    <div class="header d-flex align-items-center">
        <a href="homepage.jsp">
            <img class="logo-img" src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827"
                 alt="Webike VN"></a>
        <div class="separator"></div>
        <h1 class="header__text">Giỏ hàng</h1>
    </div>
    <div class="head__line"></div>
    <div class="product m-5 p-5 mb-0 pb-0 d-flex flex-column">
        <div class="head row p-5 ms-5 me-5 mb-5 pt-4 pb-4 border shadow-sm rounded">
            <div class="col-6 d-flex align-items-center gap-3">
                <input type="checkbox" id="cart">
                <label class="text " for="cart">Sản phẩm</label>
            </div>
            <!-- <div class="col">
                <div class="text text-center">Đơn giá</div>
            </div> -->
            <div class="col-2">
                <div class="text text-center">Số lượng</div>
            </div>
            <div class="col">
                <div class="text text-center">Giá tiền</div>
            </div>
            <div class="col">
                <div class="text text-center">Thao tác</div>
            </div>
        </div>


        <ul class="list-product" style="padding: 0px; margin: 0px; list-style-type: none;">
            <c:forEach var="p" items="${sessionScope.cart.list}">
                <li id="list2" class="products mb-5" style="padding: 0px; margin: 0px;">
                    <div id="" class="item row p-5 ms-5 me-5 border">
                        <div id="${p.id}" class="item col-6 d-flex align-items-center gap-4">
                            <input type="checkbox" value="${p.id}" class="item check">
                            <img class="img-modi" src="${p.img.entrySet().iterator().next().getValue()}" alt="">
                            <span class="pName text-1 text-break">${p.name} (${p.img.entrySet().iterator().next().getKey()})</span>
                        </div>
                        <div class="item col-2 d-flex align-items-center justify-content-center gap-3">
                            <!-- Ô này để cái button tăng giảm số lượng -->
                            <div class="number d-flex align-items-center">
                                <button class="button-modi">
                                    <i class="fa-solid fa-minus"></i>
                                </button>
                                <div class="quantity text-1">${p.quantity}</div>
                                <button class="button-modi">
                                    <i class="fa-solid fa-plus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="item col d-flex align-items-center">
                            <span class=" text-1 text-center full-width productPrice">
                                <!-- Giá tiền -->
                                <f:setLocale value="vi_VN"/>
                                <f:formatNumber value="${p.price * p.quantity}" type="currency"/>
                            </span>
                        </div>
                        <form action="remove-cart?id=${p.id}" method="GET">
                            <input type="hidden" name="id" id="id" value="${p.id}">
                            <button type="submit" class="item col d-flex align-items-center gap-3">
                            <span class="text-1 text-center text-danger full-width">
                                Xóa
                            </span>
                            </button>
                        </form>
                    </div>
                </li>
            </c:forEach>
            <script>
                function totalPrice() {
                    const checkboxes = document.querySelectorAll('.check input[type="checkbox"]:checked');
                    let totalPrice = 0;
                    checkboxes.forEach((checkbox) => {
                        const parentRow = checkbox.closest('.item');
                        const price = parseInt(parentRow.querySelector('.productPrice').textContent, 10);
                        totalPrice += price;
                    });
                    document.getElementById('total-price').textContent = totalPrice;
                }
                document.querySelectorAll('.item input[type="checkbox"]').forEach((checkbox) => {
                    checkbox.addEventListener('change', totalPrice);
                });
            </script>


            <div class="buy-section shadow rounded d-flex align-items-center pe-5 m-5 mb-0 pt-4 pb-4">
                <div class="d-flex gap-3">
                    <h2 class="fs-1 fw-normal">Tổng thanh toán ( sản phẩm):</h2>
                    <h2 id="total-price" class="fs-1 fw-bold price">
                        0
                    </h2>
                    <script>
                        function formatCurrency(value) {
                            return new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(value);
                        }

                        const total = document.getElementById('total-price');
                        const value = parseInt(total.textContent, 10); // 10 la he thap phan
                        total.textContent = formatCurrency(value);
                    </script>
                </div>
                <a href="" class="ms-auto me-5">
                    <button class=" buybtn">
                        <span class="buybtn-text">Mua hàng</span>
                    </button>
                </a>
            </div>

        </ul>
    </div>
</div>

<!-- noti -->
<div class="toast-container position-fixed bottom-0 end-0 p-3">
    <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-body p-5 pt-3 pb-3 d-flex align-items-center justify-content-between">
            <span class="toast-text">Đã xóa sản phẩm khỏi giỏ hàng.</span>
            <button type="button" class="btn-close custom-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    </div>
</div>

<script src="<%= request.getContextPath()%>/GKY/assets/js/Gio hang.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    cartItemChecked();
</script>
</body>
</html>