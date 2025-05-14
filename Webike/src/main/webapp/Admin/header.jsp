<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css"/>

<div class="admin__content-top flex-box">
    <div class="admin__content-top-left">
        <ul class="flex-box">
            <li><i class="ri-search-line"></i></li>
            <li><i class="ri-drag-move-line"></i></li>
        </ul>
    </div>
    <div class="admin__content-top-right flex-box">
        <ul class="flex-box">
            <li><i class="ri-notification-line" number="3"></i></li>
            <li><i class="ri-message-2-line" number="5"></i></li>
            <li class="flex-box user__login">
                <img src="<%= request.getContextPath() %>/${sessionScope.auth.image}" alt="" class="header__navbar--user-img">
                <p>${sessionScope.auth.name}</p>
                <i class="ri-arrow-down-s-fill"></i>
                <ul class="header__navbar--user-menu">
                    <li class="header__navbar--user-menu-item">
                        <a href="${pageContext.request.contextPath}/Logout">Đăng xuất</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
