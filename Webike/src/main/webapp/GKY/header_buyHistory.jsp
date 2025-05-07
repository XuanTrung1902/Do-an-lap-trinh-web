<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="order-tabs">
    <ul class="tabs-list d-flex">
        <li class="tab-item tab-item--active"><a class="tab-item__link" href="#">Tất cả</a></li>
        <li class="tab-item"><a href="#" class="tab-item__link">Chờ thanh toán</a></li>
        <li class="tab-item"><a href="#" class="tab-item__link">Vận chuyển</a></li>
        <li class="tab-item"><a href="#" class="tab-item__link">Chờ giao hàng</a></li>
        <li class="tab-item"><a href="#" class="tab-item__link">Hoàn thành</a></li>
        <li class="tab-item"><a href="#" class="tab-item__link">Đã hủy</a></li>
        <li class="tab-item"><a href="#" class="tab-item__link">Trả hàng/Hoàn tiền</a></li>
    </ul>
    <div class="search-bar">
        <span class="search-label">Tìm kiếm:</span>
        <input type="text" placeholder="Bạn có thể tìm kiếm theo tên Shop, ID đơn hàng hoặc Tên Sản phẩm" class="search-input">
    </div>
</div>