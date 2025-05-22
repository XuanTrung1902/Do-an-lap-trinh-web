<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="x" items="${ls}">
    <div>
        <p>ID: ${x.id}</p>
        <p>Sản phẩm (có thể lấy ra các thuộc tính khác của sản phẩm): ${x.product.id}</p>
        <p>Màu: ${x.color}</p>
        <p>Trạng thái: ${x.status}</p>
    </div>
    <span>++++++++++++++++++++++++++++++++++++</span>
</c:forEach>
</body>
</html>
