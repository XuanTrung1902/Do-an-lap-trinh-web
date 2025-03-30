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
    <!-- <link rel="stylesheet" href="./assets/css/admin.css"> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/product_list.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/sidebar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/base.css">


    <title>Admin</title>
</head>
<body>
<section class="admin">
    <div class="row__grid">
        <jsp:include page="/Admin/sidebar.jsp"/>

        <div class="admin__content">
            <div class="admin__content-top flex-box">
                <div class="admin__content-top-left">
                    <ul class="flex-box">
                        <li><i class="ri-search-line"></i></li>
                        <li><i class="ri-drag-move-line"></i></li>
                    </ul>
                </div>
                <div class="admin__content-top-right flex-box">
                    <ul class="flex-box">
                        <li><i class="ri-notification-line" number="3"></i></li>
                        <li><i class="ri-message-2-line" number="5"></i></li>
                        <li class="flex-box user__login">
                            <img src="<%= request.getContextPath() %>/${sessionScope.auth.image}" alt="" class="header__navbar--user-img">
                            <p>${sessionScope.auth.name}</p>
                            <i class="ri-arrow-down-s-fill"></i>
                            <ul class="header__navbar--user-menu">
                                <li class="header__navbar--user-menu-item">
                                    <a href="${pageContext.request.contextPath}/Logout">Đăng xuất</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="admin-content-main">
                <div class="admin-content-main-title">
                    <h1>Danh sách sản phẩm</h1>
                </div>
                <div class="admin-content-main-container">
                    <div class="admin-content-main-search">
                        <label style="font-size: 16px">Tìm kiếm</label>
                        <input type="text" id="searchInput" placeholder="Tên sản phẩm" class="search-input">
                    </div>
                    <table>
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Ảnh</th>
                            <th>Tên sản phẩm</th>
                            <th>Giá bán</th>
                            <th>Số lượng</th>
                            <th>Tuỳ chỉnh</th>
                        </tr>
                        </thead>
                        <tbody id="productTableBody">
                        <c:forEach var="p" items="${p}">
                            <tr>
                                    <%--<%= request.getContextPath() %>--%>
                                <td>${p.id}</td>
                                <td class="img__item"><img src="${p.url}" alt="${p.name}"></td>
                                <td>${p.name}</td>
                                <td>
                                    <f:setLocale value="vi_VN"/>
                                    <f:formatNumber value="${p.price}" type="currency"/>
                                </td>
                                <td>${p.quantity}</td>
                                <td>
                                    <a href="update-product?id=${p.id}" class="btn-edit">Sửa</a>
                                    <a href="delete-product?id=${p.id}" class="btn-delete"
                                       onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">Xóa</a>
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

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<script src="${pageContext.request.contextPath}/Admin/assets/js/searchProductAjax.js"></script>
<script src="${pageContext.request.contextPath}/Admin/assets/js/product_list.js"></script>
</body>
</html>