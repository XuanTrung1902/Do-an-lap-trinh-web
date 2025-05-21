<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach var="s" items="${stock}">
    <p>ID: ${s.id}</p>
    <p>Nhà cung cấp: ${s.supplier}</p>
    <p>Ngày nhập: ${s.receiptDate}</p>
    <p>Ghi chú: ${s.note}</p>
    <c:forEach var="b" items="${s.batches}">
        <div>
        <p>Lô hàng: ${b.batch}</p>
        <p>Sản phẩm: ${b.productID}</p>
        <p>Số lượng: ${b.quantity}</p>
        <p>Đơn giá: ${b.unitPrice}</p>
        <p>Tổng giá: ${b.totalPrice}</p>
        </div>
        <span>++++++++++++++++++++++++++++++++++++</span>
    </c:forEach>
    <span>-------------------------------------------------</span>
</c:forEach>

</body>
</html>
