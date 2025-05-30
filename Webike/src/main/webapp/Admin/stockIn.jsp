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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/stockIn.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/sidebar.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/base.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Admin/assets/css/header.css">
    <title>Nhập kho</title>
</head>
<body>
    <section class="admin">
        <div class="row__grid">
            <jsp:include page="/Admin/sidebar.jsp"/>

            <div class="admin__content">
                <jsp:include page="/Admin/header.jsp"/>

                <div class="admin-content-main">
                    <div class="admin-content-main-title">
                        <h1>Nhập kho</h1>
                        <button class="btn_stock-in"> Nhập kho mới </button>

                    </div>
                    <div class="admin-content-main-container">
                        <table id="stockIn" style="background-color: white; font-size: 1.6rem;" >
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nhà cung cấp</th>
                                    <th>Ngày nhập</th>
                                    <th>Ghi chú</th>
                                    <th>Tuỳ chỉnh</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="s" items="${stock}">
                                <tr>
                                    <td>${s.id}</td>
                                    <td>${s.supplier.name}</td>
                                    <td>${s.receiptDate}</td>
                                    <td>${s.note}</td>
                                    <td>
                                        <form action="stock-batch-list" method="get">
                                            <input type="hidden" name="stockID" value="${s.id}">
                                            <button type="submit">Chi tiết</button>
                                        </form>
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

    <!-- Modal Thêm Lô Hàng -->
    <div id="stockInModal" class="modal-overlay" style="display: none;">
        <div class="modal-content slide-in">
            <div class="modal-header">
                <h2>Thêm Lô Hàng</h2>
                <span class="modal-close" onclick="closeStockInModal()">&times;</span>
            </div>

            <div class="modal-body">
                <jsp:include page="/Admin/stockAdd.jsp" />
            </div>
        </div>
    </div>

    <script src="<%= request.getContextPath()%>/Admin/assets/js/admin.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <script>
        const modal = document.getElementById('stockInModal');
        const modalContent = document.querySelector('.modal-content');
        document.querySelector('.btn_stock-in').addEventListener('click', function () {
            modal.style.display = 'flex';
        });

        function closeStockInModal() {
            modal.style.display = 'none';
        }

        window.addEventListener('click', function (event) {
            if (event.target === modal) {
                closeStockInModal();
            }
        });
        document.getElementById('stockInForm').addEventListener('submit', function (e) {
            e.preventDefault();
            alert('Lô hàng đã được thêm!');
            closeStockInModal();
        });
    </script>
    <script>
        $(document).ready(function () {
            $('#stockIn').DataTable({
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
