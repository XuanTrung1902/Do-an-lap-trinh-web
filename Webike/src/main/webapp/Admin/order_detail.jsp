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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/order_detail.css">
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
                    <h1>Chi tiết đơn hàng</h1>
                </div>
                <div class="admin-content-main-container">
                    <table>
                        <thead>
                        <tr>
                            <th>Ảnh</th>
                            <th>Tên sản phẩm</th>
                            <th>Hãng xe</th>
                            <th>Số lượng</th>
                            <th>Giá thành</th>
                            <th>Thành tiền</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${ls}">
                            <tr>
                                <td><img src="${i.img}" alt=""></td>
                                <td>${i.name}</td>
                                <td>${i.brand}</td>
                                <td>${i.quantity}</td>
                                <td>
                                    <f:setLocale value="vi_VN"/>
                                    <f:formatNumber value="${i.price}" type="currency"/>
                                </td>
                                <td>
                                    <f:setLocale value="vi_VN"/>
                                    <f:formatNumber value="${i.price * i.quantity}" type="currency"/>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="${pageContext.request.contextPath}/Admin/assets/js/product_list.js"></script>
<script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>

</body>
</html>