<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/base.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/billing.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/font/themify-icons/themify-icons.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css"/>
    <title>Thông tin đơn thanh toán</title>
</head>
<body>
<div class="app">
    <jsp:include page="/GKY/header.jsp"/>

    <div class="billing-container">
        <div class="billing-card">
            <div class="billing-header">
                <h1>Hóa đơn thanh toán</h1>
                <p>Số hoá đơn: <%=request.getParameter("vnp_TxnRef")%></p>
            </div>
            <div class="billing-info">
                <div class="billing-info__item">
                    <span class="billing-info__label">Tiền cọc:</span>
                    <span class="billing-info__value">
                        <f:formatNumber value="${sessionScope.deposit}" pattern="#,##0.###" />đ
                    </span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Tiền trả tiếp:</span>
                    <span class="billing-info__value">
                        <f:formatNumber value="${sessionScope.remain}" pattern="#,##0.###" />đ
                    </span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Ngày cọc:</span>
                    <span class="billing-info__value">${sessionScope.order.depositDate}</span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Ngày hẹn:</span>
                    <span class="billing-info__value"><%=request.getSession().getAttribute("appointment")%></span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Chi nhánh:</span>
                    <span class="billing-info__value">${shopAddress}</span>
                </div>                <div class="billing-info__item">
                    <span class="billing-info__label">Địa chỉ:</span>
                    <span class="billing-info__value"><%=request.getSession().getAttribute("address")%></span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Tên khách hàng:</span>
                    <span class="billing-info__value">${userName}</span>
                </div>
                <div class="billing-info__item">
                    <span class="billing-info__label">Số điện thoai:</span>
                    <span class="billing-info__value">${phoneNum}</span>
                </div>
            </div>
            <div class="order-items">
                <h2>Chi tiết sản phẩm</h2>
                <c:forEach var="o" items="${orderItem}">
                    <div class="order-item">
                        <img src="${o.img}" alt="${o.name}" class="order-item__img">
                        <div class="order-item__details">
                            <div class="order-item__detail">
                                <span class="order-item__label">Tên sản phẩm:</span>
                                <span class="order-item__value">${o.name}</span>
                            </div>
                            <div class="order-item__detail">
                                <span class="order-item__label">Số lượng:</span>
                                <span class="order-item__value">${o.quantity}</span>
                            </div>
                            <div class="order-item__detail">
                                <span class="order-item__label">Màu sản phẩm:</span>
                                <span class="order-item__value">${o.color.name}</span>
                            </div>
                            <div class="order-item__detail">
                                <span class="order-item__label">Giá sản phẩm:</span>
                                <span class="order-item__value">
                                    <f:formatNumber value="${o.price}" pattern="#,##0.###" />đ
                                </span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <%-- Button in hoa don --%>
        <div class="billing-button">
            <button class="print-invoice" data-bs-toggle="modal" data-bs-target="#printModal">In hóa đơn</button>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="printModal" tabindex="-1" aria-labelledby="printModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="printModalLabel">Chọn định dạng in</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="printFormat" id="pngFormat" value="png" checked>
                        <label class="form-check-label" for="pngFormat">PNG</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="printFormat" id="pdfFormat" value="pdf">
                        <label class="form-check-label" for="pdfFormat">PDF</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="button" class="btn btn-primary" id="confirmPrint">Xác nhận</button>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/GKY/footer.jsp"/>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>




</body>
</html>