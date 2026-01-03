<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="order-tabs">
<%--    <ul class="tabs-list d-flex">--%>
<%--        <li class="tab-item tab-item--active"><a class="tab-item__link" href="${pageContext.request.contextPath}/buy-history">Tất cả</a></li>--%>
<%--        <li class="tab-item"><a href="${pageContext.request.contextPath}/deposited" class="tab-item__link">Đã cọc</a></li>--%>
<%--        <li class="tab-item"><a href="${pageContext.request.contextPath}/paid" class="tab-item__link">Đã thanh toán</a></li>--%>
<%--        <li class="tab-item"><a href="${pageContext.request.contextPath}/preparing" class="tab-item__link">Đang chuẩn bị hàng</a></li>--%>
<%--        <li class="tab-item"><a href="${pageContext.request.contextPath}/delivering" class="tab-item__link">Đang giao</a></li>--%>
<%--        <li class="tab-item"><a href="${pageContext.request.contextPath}/delivered" class="tab-item__link">Đã giao</a></li>--%>
<%--        <li class="tab-item"><a href="${pageContext.request.contextPath}/canceled" class="tab-item__link">Đã hủy</a></li>--%>
<%--    </ul>--%>
    <ul class="tabs-list d-flex">
        <li class="tab-item ${status eq 'Tất cả' ? 'tab-item--active' : ''}">
            <a class="tab-item__link" href="${pageContext.request.contextPath}/buy-history">Tất cả</a>
        </li>
        <li class="tab-item ${status eq 'Đã cọc' ? 'tab-item--active' : ''}">
            <a class="tab-item__link" href="${pageContext.request.contextPath}/deposited">Đã cọc</a>
        </li>
<%--        <li class="tab-item ${status eq 'Đã thanh toán' ? 'tab-item--active' : ''}">--%>
<%--            <a class="tab-item__link" href="${pageContext.request.contextPath}/paid">Đã thanh toán</a>--%>
<%--        </li>--%>
        <li class="tab-item ${status eq 'Đang chuẩn bị hàng' ? 'tab-item--active' : ''}">
            <a class="tab-item__link" href="${pageContext.request.contextPath}/preparing">Đang chuẩn bị hàng</a>
        </li>
        <li class="tab-item ${status eq 'Đang giao' ? 'tab-item--active' : ''}">
            <a class="tab-item__link" href="${pageContext.request.contextPath}/delivering">Đang giao</a>
        </li>
        <li class="tab-item ${status eq 'Đã giao' ? 'tab-item--active' : ''}">
            <a class="tab-item__link" href="${pageContext.request.contextPath}/delivered">Đã giao</a>
        </li>
        <li class="tab-item ${status eq 'Đã hủy' ? 'tab-item--active' : ''}">
            <a class="tab-item__link" href="${pageContext.request.contextPath}/canceled">Đã hủy</a>
        </li>
    </ul>
</div>