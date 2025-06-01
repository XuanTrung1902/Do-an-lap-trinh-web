<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
<%--    <link rel="stylesheet" href="https://cdn.datatables.net/2.1.8/css/dataTables.dataTables.css">--%>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/stockItem.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/sidebar.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/base.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/header.css">
    <title>Chi tiết sản phẩm trong kho</title>
</head>
<body>
    <section class="admin">
        <div class="row__grid">
            <jsp:include page="/Admin/sidebar.jsp"/>

            <div class="admin__content">
                <jsp:include page="/Admin/header.jsp"/>

                <div class="admin-content-main">
                    <div class="admin-content-main-title">
                        <button>
                            <a href="stock-batch-list?stockID=${stockID}">
                                <i class="ri-arrow-left-line"></i>
                            </a>
                        </button>
                        <h1>Chi tiết sản phẩm</h1>
                    </div>
                    <div class="admin-content-main-container">
                        <table id="stockItem" style="background-color: white; font-size: 1.6rem;" >
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Hình ảnh</th>
                                <th>Sản phẩm</th>
                                <th>Màu sắc</th>
                                <th>Trạng thái</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach  var="x" items="${ls}">
                                    <tr>
                                        <td>${x.id}</td>
                                        <td>
                                            <img src="${pageContext.request.contextPath}/${x.imagePath}" alt="Ảnh" style="width: 100px; height: 60px" />
                                        </td>
                                        <td>${x.product.name}</td>
                                        <td>${x.color.name}</td>
                                        <td>${x.status}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="<%= request.getContextPath()%>/Admin/assets/js/admin.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<%--    <script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>--%>
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#stockItem').DataTable({
                pageLength: 5,
                lengthChange: false,
                language: {
                    url: '//cdn.datatables.net/plug-ins/1.13.6/i18n/vi.json'
                }
            });
        });
    </script>
</body>
</html>
