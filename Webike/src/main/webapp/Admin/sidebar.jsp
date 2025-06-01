<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="admin__sidebar" style="height: 120vh;">
    <div class="admin__sidebar--top">
        <img src="Admin/assets/images/logo.png" alt="">
    </div>
    <c:set var="showUserList" value="false" />
    <c:set var="showOrderlist" value="false" />
    <c:set var="showProductlist" value="false" />
    <c:set var="showDiscountlist" value="false" />
    <c:set var="canWritetDiscount" value="false" />
    <c:set var="canWritetProduct" value="false" />

    <c:forEach var="p" items="${sessionScope.permissions}">
        <c:if test="${p.resource eq 'userlist' and p.action eq 'read'}">
            <c:set var="showUserList" value="true" />
        </c:if>

        <c:if test="${p.resource eq 'product' and p.action eq 'read'}">
            <c:set var="showProductlist" value="true" />
        </c:if>

        <c:if test="${p.resource eq 'order' and p.action eq 'read'}">
            <c:set var="showOrderlist" value="true" />
        </c:if>

        <c:if test="${p.resource eq 'discount' and p.action eq 'read'}">
            <c:set var="showDiscountlist" value="true" />
        </c:if>
        <c:if test="${p.resource eq 'discount' and p.action eq 'write'}">
            <c:set var="canWritetDiscount" value="true" />
        </c:if>
        <c:if test="${p.resource eq 'product' and p.action eq 'write'}">
            <c:set var="canWritetProduct" value="true" />
        </c:if>
    </c:forEach>


    <div class="admin__sidebar--content">
        <ul>
            <li><a href="#">
                <i class="ri-dashboard-line"></i>
                Dashboard
                <i></i>
            </a>
                <ul class="sub-menu">
                    <div class="sub-menu-items">
                        <li><a href="${pageContext.request.contextPath}/dashboard">
                            <i class="ri-arrow-right-s-fill"></i>
                            Tổng quan
                        </a>
                        </li>
                    </div>
                </ul>
            </li>
            <c:if test="${showUserList}">
            <li>
                <a href="">
                    <i class="ri-file-list-line"></i>
                    Người dùng
                    <i class="ri-add-box-line"></i>
                </a>
                <ul class="sub-menu">
                    <div class="sub-menu-items">
                        <li>
                            <a href="${pageContext.request.contextPath}/userList">
                            <i class="ri-arrow-right-s-fill"></i>
                            Danh sách
                            </a>
                        </li>
                    </div>
                </ul>
            </li>
            </c:if>
            <c:if test="${showOrderlist}">
            <li>
                <a href="">
                    <i class="ri-file-list-line"></i>
                    Đơn hàng
                    <i class="ri-add-box-line"></i>
                </a>
                <ul class="sub-menu">
                    <div class="sub-menu-items">
                        <li>
                            <a href="order-list">
                            <i class="ri-arrow-right-s-fill"></i>
                            Danh sách
                        </a>
                        </li>
                        <%--                                    <li>--%>
                        <%--                                        <a href="order_edit.jsp">--%>
                        <%--                                            <i class="ri-arrow-right-s-fill"></i>--%>
                        <%--                                            Sửa    --%>
                        <%--                                         </a>--%>
                        <%--                                    </li>--%>
                    </div>
                </ul>
            </li>
            </c:if>
            <c:if test="${showProductlist}">
            <li>
                <a href="#">
                    <i class="ri-file-list-line"></i>
                    Sản phẩm
                    <i class="ri-add-box-line"></i>
                </a>
                <ul class="sub-menu">
                    <div class="sub-menu-items">
                        <li>
                            <a href="products">
                                <i class="ri-arrow-right-s-fill"></i>
                                Danh sách
                            </a>
                        </li>
                        <li>
                            <c:if test="${canWritetProduct}">
                                        <a href="add-product">
                                        <i class="ri-arrow-right-s-fill"></i>
                                        Thêm
                                    </a>
                            </c:if>
                        </li>
                        <li>
                            <a href="stock-in-list">
                                <i class="ri-arrow-right-s-fill"></i>
                                Nhập kho
                            </a>
                        </li>
                    </div>
                </ul>
            </li>
            </c:if>
            <c:if test="${showDiscountlist}">
            <li>
                <a href="#">
                    <i class="ri-file-list-line"></i>
                    Giảm giá
                    <i class="ri-add-box-line"></i>
                </a>
                <ul class="sub-menu">
                    <div class="sub-menu-items">
                        <li>
                            <a href="discountList">
                            <i class="ri-arrow-right-s-fill"></i>
                            Danh sách
                        </a>
                        </li>
                        <li>
                            <c:if test="${canWritetDiscount}">
                            <a href="addDiscount">
                            <i class="ri-arrow-right-s-fill"></i>
                            Thêm
                        </a>
                            </c:if>
                        </li>
                    </div>
                </ul>
            </li>
            </c:if>
            <li>
                <a href="#">
                    <i class="ri-file-list-line"></i>
                    Nhật ký hệ thống
                    <i class="ri-add-box-line"></i>
                </a>
                <ul class="sub-menu">
                    <div class="sub-menu-items">
                        <li>
                            <a href="${pageContext.request.contextPath}/logList">
                                <i class="ri-arrow-right-s-fill"></i>
                                Danh sách
                            </a>
                        </li>
                    </div>
                </ul>
            </li>

        </ul>
    </div>
</div>
