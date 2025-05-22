<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <c:forEach var="b" items="${s.batches}">
            <div>
            <p>Lô hàng: ${b.batch}</p>
            <p>Sản phẩm: ${b.productID}</p>
            <p>Số lượng: ${b.quantity}</p>
            <p>Đơn giá: ${b.unitPrice}</p>
            <p>Tổng giá: ${b.totalPrice}</p>
            </div>
            <form action="stock-item-list" method="get">
                <input type="hidden" name="batchID" value="${b.id}">
                <button type="submit">Chi tiết</button>
            </form>
            <span>++++++++++++++++++++++++++++++++++++</span>
        </c:forEach>
</body>
</html>
