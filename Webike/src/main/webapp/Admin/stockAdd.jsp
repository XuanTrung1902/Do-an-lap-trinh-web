<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<form action="stock-add" method="post" enctype="multipart/form-data" class="modal-form">

    <div class="form-group">
        <label for="supplier">Nhà cung cấp:</label>
        <select name="supplierID" id="supplier">
            <c:forEach var="s" items="${suppliers}">
                <option id="${s.id}" value="${s.id}">${s.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label for="employeeID">Mã nhân viên:</label>
        <input type="text" name="employeeID" id="employeeID" required>
    </div>

    <div class="form-group">
        <label for="receiptDate">Ngày nhập:</label>
        <input type="date" name="receiptDate" id="receiptDate" required>
    </div>

    <div class="form-group">
        <label for="note">Ghi chú:</label>
        <input type="text" name="note" id="note">
    </div>

    <div class="form-group">
        <label for="filePart">Tệp đính kèm:</label>
        <input type="file" name="filePart" id="filePart">
    </div>

    <button type="submit" class="btn-submit">Thêm</button>
</form>
<%--<form action="stock-add" method="post" enctype="multipart/form-data">--%>
<%--    <select name="supplierID">--%>
<%--        <c:forEach var="s" items="${suppliers}">--%>
<%--            <option id="${s.id}" value="${s.id}" >--%>
<%--                    ${s.name}--%>
<%--            </option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <input type="text" name="employeeID">--%>
<%--    <input type="date" name="receiptDate">--%>
<%--    <input type="text" name="note">--%>
<%--    <input type="file" name="filePart">--%>
<%--    <button type="submit">Thêm</button>--%>
<%--</form>--%>

