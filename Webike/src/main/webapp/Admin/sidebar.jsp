<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="admin__sidebar" style="height: 120vh;">
    <div class="admin__sidebar--top">
        <img src="Admin/assets/images/logo.png" alt="">
    </div>
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
                        <li><a href="add-product">
                            <i class="ri-arrow-right-s-fill"></i>
                            Thêm
                        </a>
                        </li>
                    </div>
                </ul>
            </li>
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
                        <li><a href="addDiscount">
                            <i class="ri-arrow-right-s-fill"></i>
                            Thêm
                        </a>
                        </li>
                    </div>
                </ul>
            </li>
        </ul>
    </div>
</div>
