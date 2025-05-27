<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="stock-add" method="post" enctype="multipart/form-data">
    <select name="supplierID">
        <c:forEach var="s" items="${suppliers}">
            <option id="${s.id}" value="${s.id}" >
                    ${s.name}
            </option>
        </c:forEach>
    </select>
    <input type="text" name="employeeID">
    <input type="date" name="receiptDate">
    <input type="text" name="note">
    <input type="file" name="filePart">
    <button type="submit">Thêm</button>
</form>
</body>
</html>
