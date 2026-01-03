<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet"/>--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"--%>
<%--          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="--%>
<%--          crossorigin="anonymous" referrerpolicy="no-referrer"/>--%>
<%--    <link rel="preconnect" href="https://fonts.googleapis.com">--%>
<%--    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>--%>
<%--    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">--%>
<%--    <!-- <link rel="stylesheet" href="./assets/css/admin.css"> -->--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/product_list.css">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/sidebar.css">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/base.css">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/header.css">--%>
<%--    <title>Admin</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<section class="admin">--%>
<%--    <div class="row__grid">--%>
<%--        <jsp:include page="/Admin/sidebar.jsp"/>--%>

<%--        <div class="admin__content">--%>
<%--            <jsp:include page="/Admin/header.jsp"/>--%>

<%--            <c:set var="canWritetProdcut" value="false" />--%>
<%--            <c:set var="canDeletetProduct" value="false" />--%>

<%--            <c:forEach var="p" items="${sessionScope.permissions}">--%>
<%--                <c:if test="${p.resource eq 'product' and p.action eq 'write'}">--%>
<%--                    <c:set var="canWritetProdcut" value="true" />--%>
<%--                </c:if>--%>
<%--                <c:if test="${p.resource eq 'product' and p.action eq 'delete'}">--%>
<%--                    <c:set var="canDeletetProduct" value="true" />--%>
<%--                </c:if>--%>

<%--            </c:forEach>--%>
<%--            <div class="admin-content-main">--%>
<%--                <div class="admin-content-main-title">--%>
<%--                    <h1>Danh sách sản phẩm</h1>--%>
<%--                </div>--%>
<%--&lt;%&ndash;                <div class="admin-content-main-container">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <div class="admin-content-main-header">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="admin-content-main-search">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label style="font-size: 16px">Tìm kiếm</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <input type="text" id="searchInput" placeholder="Tên sản phẩm" class="search-input">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="admin-content-main-filter">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label style="font-size: 16px">Loại sản phẩm</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <select class="filter-select" id="typeFilter">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <option value="0" >Tất cả</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <c:forEach var="bt" items="${bt}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <option value="${bt.id}">${bt.type}</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </select>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <div class="admin-content-main-header">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="admin-content-main-search">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label style="font-size: 16px">Tìm kiếm</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <input type="text" id="searchInput" placeholder="Tên sản phẩm" class="search-input">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="admin-content-main-filter">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label style="font-size: 16px">Loại sản phẩm</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <select class="filter-select" id="typeFilter">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <option value="0" >Tất cả</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <c:forEach var="bt" items="${bt}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <option value="${bt.id}">${bt.type}</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </select>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <div class="admin-content-main-header">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="admin-content-main-search">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label style="font-size: 16px">Tìm kiếm</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <input type="text" id="searchInput" placeholder="Tên sản phẩm" class="search-input">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="admin-content-main-filter">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label style="font-size: 16px">Loại sản phẩm</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <select class="filter-select" id="typeFilter">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <option value="0" >Tất cả</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <c:forEach var="bt" items="${bt}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <option value="${bt.id}">${bt.type}</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </select>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>

<%--                    <div class="admin-content-main-header">--%>
<%--                        <div class="admin-content-main-search">--%>
<%--                            <label style="font-size: 16px">Tìm kiếm</label>--%>
<%--                            <input type="text" id="searchInput" placeholder="Tên sản phẩm" class="search-input">--%>
<%--                        </div>--%>
<%--                        <div class="admin-content-main-filter">--%>
<%--                            <label style="font-size: 16px">Loại sản phẩm</label>--%>
<%--                            <select class="filter-select" id="typeFilter">--%>
<%--                                <option value="0" >Tất cả</option>--%>
<%--                                <c:forEach var="bt" items="${bt}">--%>
<%--                                    <option value="${bt.id}">${bt.type}</option>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
<%--                        </div>--%>

<%--                    </div>--%>

<%--                    <table>--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th>ID</th>--%>
<%--                            <th>Ảnh</th>--%>
<%--                            <th>Tên sản phẩm</th>--%>
<%--                            <th>Giá bán</th>--%>
<%--                            <th>Số lượng</th>--%>
<%--                            <th>Tuỳ chỉnh</th>--%>
<%--                        </tr>--%>
<%--                        </thead>--%>
<%--                        <tbody id="productTableBody">--%>
<%--                        <c:forEach var="p" items="${products}">--%>
<%--                            <tr>--%>
<%--                                    &lt;%&ndash;<%= request.getContextPath() %>&ndash;%&gt;--%>
<%--                                <td>${p.id}</td>--%>
<%--                                <td class="img__item"><img src="${p.img.values().iterator().next()}" alt="${p.name}" style="height: 100px; width: 200px"></td>--%>
<%--                                <td>${p.name}</td>--%>
<%--                                <td>--%>
<%--                                    <f:setLocale value="vi_VN"/>--%>
<%--                                    <f:formatNumber value="${p.price}" type="currency"/>--%>
<%--                                </td>--%>
<%--                                <td>${p.quantity}</td>--%>
<%--                                <td>--%>
<%--                                    <c:if test="${canWritetProdcut}">--%>
<%--                                    <a href="update-product?id=${p.id}" class="btn-edit">Sửa</a>--%>
<%--                                    </c:if>--%>
<%--                                    <c:if test="${canDeletetProduct}">--%>
<%--                                    <a href="delete-product?id=${p.id}" class="btn-delete"--%>
<%--                                       onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">Xóa</a>--%>
<%--                                    </c:if>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                        </c:forEach>--%>
<%--                        </tbody>--%>
<%--                    </table>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<%--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>


<%--<script src="${pageContext.request.contextPath}/Admin/assets/js/filterProduct.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/Admin/assets/js/searchProductAjax.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/Admin/assets/js/product_list.js"></script>--%>
<%--<script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>--%>

<%--</body>--%>
<%--</html>--%>

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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/header.css">
    <title>Admin</title>
</head>
<body>
<section class="admin">
    <div class="row__grid">
        <jsp:include page="/Admin/sidebar.jsp"/>

        <div class="admin__content">
            <jsp:include page="/Admin/header.jsp"/>

            <c:set var="canWritetProdcut" value="false" />
            <c:set var="canDeletetProduct" value="false" />

            <c:forEach var="p" items="${sessionScope.permissions}">
                <c:if test="${p.resource eq 'product' and p.action eq 'write'}">
                    <c:set var="canWritetProdcut" value="true" />
                </c:if>
                <c:if test="${p.resource eq 'product' and p.action eq 'delete'}">
                    <c:set var="canDeletetProduct" value="true" />
                </c:if>

            </c:forEach>

            <!-- Input ẩn để truyền quyền cho JavaScript -->
            <input type="hidden" id="canWriteProduct" value="${canWriteProduct}">
            <input type="hidden" id="canDeleteProduct" value="${canDeleteProduct}">

            <div class="admin-content-main">
                <div class="admin-content-main-title">
                    <h1>Danh sách sản phẩm</h1>
                </div>
                <div class="admin-content-main-container">
                    <div class="admin-content-main-header">
                        <div class="admin-content-main-search">
                            <label style="font-size: 16px">Tìm kiếm</label>
                            <input type="text" id="searchInput" placeholder="Tên sản phẩm" class="search-input">
                        </div>
                        <div class="admin-content-main-filter">
                            <label style="font-size: 16px">Loại sản phẩm</label>
                            <select class="filter-select" id="typeFilter">
                                <option value="0" >Tất cả</option>
                                <c:forEach var="bt" items="${bt}">
                                    <option value="${bt.id}">${bt.type}</option>
                                </c:forEach>
                            </select>
                        </div>
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
                        <c:forEach var="p" items="${products}">
                            <tr>
                                <td>${p.id}</td>
                                <td class="img__item"><img src="${p.img.values().iterator().next()}" alt="${p.name}" style="height: 75px; width: 115px"></td>
                                <td>${p.name}</td>
                                <td>
                                    <f:setLocale value="vi_VN"/>
                                    <f:formatNumber value="${p.price}" type="currency"/>
                                </td>
                                <td>${p.quantity}</td>
                                <td>
                                    <c:if test="${canWritetProdcut}">
                                        <a href="update-product?id=${p.id}" class="btn-edit">Sửa</a>
                                    </c:if>
                                    <c:if test="${canDeletetProduct}">
                                        <a href="delete-product?id=${p.id}" class="btn-delete"
                                           onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">Xóa</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<script src="${pageContext.request.contextPath}/Admin/assets/js/filterProduct.js"></script>
<script src="${pageContext.request.contextPath}/Admin/assets/js/searchProductAjax.js"></script>
<script src="${pageContext.request.contextPath}/Admin/assets/js/product_list.js"></script>
<script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>

</body>
</html>