<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 02/04/02025
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin đơn thanh toán</title>
</head>
<body>
    <div>ID đơn hàng: </div>
    <div><%=request.getSession().getAttribute("oid")%></div>
    <div>Tiền cọc: </div>
    <div><%=request.getSession().getAttribute("deposit")%></div>
    <div>Tiền trả tiếp: </div>
    <div><%=request.getSession().getAttribute("remain")%></div>
    <div>Ngày hẹn: </div>
    <div><%=request.getSession().getAttribute("appointment")%></div>
    <div>Địa chỉ: </div>
    <div><%=request.getSession().getAttribute("address")%></div>
    <div>Account ID: </div>
    <div><%=request.getSession().getAttribute("accountID")%></div>
    <div>Shop ID: </div>
    <div><%=request.getSession().getAttribute("shopID")%></div>
    <div>Response code: </div>
    <div><%=request.getSession().getAttribute("vnp_ResponseCode")%></div>
</body>
</html>
