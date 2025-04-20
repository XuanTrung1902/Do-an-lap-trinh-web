
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Thông tin đơn thanh toán</title>
</head>
<body>
    <div>Hóa đơn thanh toán: </div>
    <div><%=request.getParameter("vnp_TxnRef")%></div>
    <div>Tiền cọc: </div>
    <div><%=request.getSession().getAttribute("deposit")%></div>
    <div>Tiền trả tiếp: </div>
    <div><%=request.getSession().getAttribute("remain")%></div>
    <div>Ngày thanh toán: </div>
    <div><%=request.getSession().getAttribute("payDate")%></div>
    <div>Ngày hẹn: </div>
    <div><%=request.getSession().getAttribute("appointment")%></div>
    <div>Địa chỉ: </div>
    <div><%=request.getSession().getAttribute("address")%></div>
    <div>Account ID: </div>
    <div><%=request.getSession().getAttribute("accountID")%></div>
    <div>Shop ID: </div>
    <div><%=request.getSession().getAttribute("shopID")%></div>

    <c:forEach var="o" items="${orderItem}">
        <img src="${o.img}">
        <div>"Tên sản phẩm:"</div>
        <div>${o.name}</div>
        <div>"Số lượng:"</div>
        <div>${o.quantity}</div>
        <div>"Màu sản phẩm:"</div>
        <div>${o.color}</div>
        <div>"Giá sản phẩm:"</div>
        <div>${o.price}</div>
        <div>----------------------------------</div>
    </c:forEach>

</body>
</html>
