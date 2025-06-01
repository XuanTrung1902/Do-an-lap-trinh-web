<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/order_edit.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/sidebar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/header.css">
    <title>Admin</title>
</head>
<body>
<section class="admin">
    <div class="row__grid">
        <jsp:include page="/Admin/sidebar.jsp"/>

        <div class="admin__content">
            <jsp:include page="/Admin/header.jsp"/>

            <div class="admin-content-main">
                <div class="admin-content-main-title">
                    <h1>Chỉnh sửa đơn hàng</h1>
                </div>
                <div class="admin-content-main-container">
                    <form action="order-edit" method="post" class="order-edit-form">
                        <input type="hidden" name="oid" value="${order.id}">
                        <div class="form-group">
                            <label for="username">Tên người dùng</label>
                            <input type="text" value="${username}" id="username" name="username">
                        </div>
                        <div class="form-group">
                            <label for="customer-phoneNum">Số điện thoại liên lạc</label>
                            <input type="tel" value="${order.phoneNum}" id="customer-phoneNum" name="phoneNum">
                        </div>
                        <div class="form-group">
                            <label for="customer-address">Địa chỉ</label>
                            <input type="text" value="${order.address}" id="customer-address" name="address">
                        </div>
                        <f:setLocale value="vi_VN" />
                        <f:formatNumber value="${order.deposit}" type="currency" var="formattedDeposit"/>
                        <div class="form-group">
                            <label for="order-deposit">Số tiền đã cọc</label>
                            <input type="text" readonly value="${formattedDeposit}" id="order-deposit">
                        </div>
                        <f:setLocale value="vi_VN" />
                        <f:formatNumber value="${order.remain}" type="currency" var="formattedRemain" />
                        <div class="form-group">
                            <label for="order-remain">Số cần thanh toán tiếp</label>
                            <input type="text" readonly value="${formattedRemain}" id="order-remain">
                        </div>
                        <div class="form-group">
                            <label for="order-status">Trạng thái</label>
                            <select id="order-status" name="status">
                                <c:forEach var="s" items="${status}">
                                    <c:choose>
                                        <c:when test="${order.status.equalsIgnoreCase(s.valueString)}">
                                            <option selected value="${s.valueString}">${s.valueString}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${s.valueString}">${s.valueString}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="order-date">Ngày hẹn làm giấy tờ</label>
                            <input type="date" id="order-date" name="appointment" value="${order.appointment}">
                        </div>
                        <div class="form-group">
                            <label for="order-date">Ngày đặt cọc</label>
                            <input type="text" readonly id="deposit-date" name="depositDate" value="${order.depositDate}">
                        </div>
                        <div class="form-group">
                            <label for="order-date">Ngày thanh toán</label>
                            <input type="datetime-local" id="pay-date" name="payDate" value="${order.payDate}">
                        </div>
                        <div class="form-group">
                            <label for="order-status">Chi nhánh</label>
                            <select id="branch" name="branch">
                                <c:forEach var="s" items="${shops}">
                                    <c:choose>
                                        <c:when test="${s.id == branch}">
                                            <option selected value="${s.id}">${s.name}/ ${s.address}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${s.id}">${s.name}/ ${s.address}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="save-button">Lưu</button>
                            <button type="reset" class="cancel-button">Hủy</button>
                        </div>
                    </form>
                    <div class="orderItem cotainer mt-5">
                        <div class="mb-3 " style="font-size: 20px">
                            <strong>Danh sách sản phẩm trong đơn</strong>
                        </div>
                        <c:forEach var="i" items="${itemList}">
                            <div class="d-flex flex-column flex-md-row justify-content-between align-items-start">
                                <div class="me-3">
                                    <h5 class="card-title" style="padding: 5px 0; font-size: 15px;">
                                        Tên: ${i.name}
                                    </h5>
                                    <p class="card-text " style="font-size: 15px;">
                                        Số lượng: ${i.quantity}
                                    </p>
                                    <div class="d-flex flex-column flex-md-row justify-content-between align-items-center">
                                        <label for="colorOption_${i.productID}" class="form-label" style="font-size: 15px; margin-right: 5px;">
                                            Màu
                                        </label>
                                        <select id="colorOption_${i.productID}" name="color" class="form-select" style="font-size: 15px">
                                            <c:forEach var="c" items="${colorMap[i.productID]}">
                                                <option value="${c.id}">${c.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="text-end mt-3 mt-md-0">
                                    <f:setLocale value="vi_VN" />
                                    <p class="text-muted" style="font-size: 15px;">
                                        Giá: <f:formatNumber value="${i.price * i.quantity}" type="currency" var="formattedDeposit"/>
                                            ${formattedDeposit}
                                    </p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="${pageContext.request.contextPath}/Admin/assets/js/sidebar.js"></script>
<script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>

</body>
</html>