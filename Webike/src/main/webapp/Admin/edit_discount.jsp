<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/admin.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/sidebar.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/base.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/header.css">
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
                        <h1>Chỉnh sửa giảm giá</h1>
                    </div>
                    <form class="admin-content-main-container" action="<%= request.getContextPath() %>/updateDiscount" method="post">
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger" role="alert">
                                    ${error}
                            </div>
                        </c:if>
                        <input type="hidden" name="id" value="${discount.id}">
                        <div class="admin-content-main-container-two-input">
                            <input type="text" name="productID" placeholder="Mã sản phẩm" value="${discount.productID}" required>
                            <input type="text" name="amount" placeholder="% giảm giá" value="${discount.amount}" required>
                        </div>
                        <div class="admin-content-main-container-two-input">
                            <input type="date" name="start" placeholder="Ngày bắt đầu" value="${discount.start}" required>
                            <input type="date" name="end" placeholder="Ngày kết thúc" value="${discount.end}" required>
                        </div>
                        <button type="submit">Cập nhật giảm giá</button>
                    </form>
                </div>



            </div>
        </div>
    </section>

    <script src="/<%= request.getContextPath() %>/Admin/assets/js/product_add.js"></script>
    <script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>

</body>
</html>