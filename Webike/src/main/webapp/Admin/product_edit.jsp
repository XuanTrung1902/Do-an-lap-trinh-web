<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/sidebar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/assets/css/detail.css">

    <title>Admin</title>
</head>
<body>
<c:set var="u" value="${empty sessionScope.auth ? 0 : sessionScope.auth}"/>
    <section class="admin">
        <div class="row__grid">
            <jsp:include page="/Admin/sidebar.jsp"/>
    
            <div class="admin__content">
                <div class="admin__content-top flex-box">
                    <div class="admin__content-top-left">
                        <ul class="flex-box">
                            <li><i class="ri-search-line"></i></li>
                            <li> <i class="ri-drag-move-line"></i></li>
                        </ul>
                    </div>
                    <div class="admin__content-top-right flex-box">
                        <ul class="flex-box">
                            <li><i class="ri-notification-line" number="3"></i></li>
                            <li><i class="ri-message-2-line" number="5"></i></li>
                            <li class="flex-box">
                                <img style="width: 50px;" src="<%= request.getContextPath() %>/${sessionScope.auth.image}" alt="">
                                <p>${sessionScope.auth.name}</p>
                                <i class="ri-arrow-down-s-fill"></i>
                            </li>
                        </ul>
                    </div>
                </div>

            <div class="admin-content-main">
                <div class="admin-content-main-title">
                    <h1>Cập nhật sản phẩm</h1>
                </div>
                <form id="updateForm" class="admin-content-main-container" method="POST" action="update-product"
                      enctype="multipart/form-data">
                    <div class="admin-content-main-container-two-input">
                        <input type="hidden" name="id" value="${product.id}">
                        <input type="text" name="name" placeholder="Tên sản phẩm">
                        <select name="color"
                                style="margin: 0 10px;width: 48%;padding: 10px;font-size: 1.6rem;border: 1px solid #ddd;border-radius: 4px;box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);">
                            <c:forEach var="color" items="${colorList}">
                                <option value="${color.id}">${color.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="admin-content-main-container-two-input">
                        <select name="brand"
                                style="width: 48%;padding: 10px;font-size: 1.6rem;border: 1px solid #ddd;border-radius: 4px;box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);">
                            <c:forEach var="brand" items="${brandList}">
                                <option value="${brand.id}">${brand.name}</option>
                            </c:forEach>
                        </select>
                        <select name="type"
                                style="margin: 0 10px;width: 48%;padding: 10px;font-size: 1.6rem;border: 1px solid #ddd;border-radius: 4px;box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);">
                            <c:forEach var="type" items="${typeList}">
                                <option value="${type.id}">${type.type}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="admin-content-main-container-two-input">
                        <input type="number" name="quantity" placeholder="Số lượng">
                        <input style="margin: 0 10px;" type="number" name="price" placeholder="Giá bán">
                    </div>
                    <div class="admin-content-main-container-two-input">
                        <input type="number" name="duration" placeholder="Số năm bảo hành">
                        <input style="margin: 0 10px;" type="number" name="km" placeholder="Số km bảo hành">
                    </div>
                    <div class="admin-content-main-container-two-input">
                        <input type="text" name="version" placeholder="Phiên bản">
                    </div>
                    <div class="admin-content-main-container-two-input">
                        <input type="date" name="launch" placeholder="Ngày sản xuất">
                        <div class="admin-content-main-container-choose-img">
                            <input type="file" id="file" name="image" style="display: none;">
                            <label for="file">Thêm hình ảnh</label>
                        </div>
                    </div>

                    <div class="admin-content-main-container-description">
                        <textarea name="description" id="editor" cols="30" rows="5" placeholder="Mô tả sản phẩm"
                                  required></textarea>
                    </div>

                    <%-- thong so sp --%>
                    <div>
                        <div class="detail">
                            <h1 style="font-size: 30px;">Thông số chi tiết</h1>
                            <div class="type">
                                <c:forEach var="type" items="${specType}">
                                    <div class="dongco">
                                        <h1 style="text-transform:uppercase ">${type}</h1>
                                        <c:forEach var="tag" items="${tags[type].keySet()}">
                                            <fieldset class="dongco_fieldset">
                                                <legend class="dongco_tilte">${tag}</legend>
                                                <c:forEach var="spec" items="${tags[type][tag]}">
                                                    <div class="loai_option">
                                                        <c:set var="isChecked" value="false"/>
                                                        <c:forEach var="id" items="${listSpecID}">
                                                            <c:if test="${id eq spec.id}">
                                                                <c:set var="isChecked" value="true"/>
                                                            </c:if>
                                                        </c:forEach>
                                                        <input class="loai_input" ${isChecked ? 'checked' : ''}
                                                               id="${spec.id}" type="radio" name="${tag}"
                                                               value="${spec.id}"/>
                                                        <label class="loai_label" for="${spec.id}">${spec.des}</label>
                                                    </div>
                                                </c:forEach>
                                            </fieldset>
                                        </c:forEach>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="selectedValues" id="selectedValues"/>
                    <button type="submit">Cập nhật sản phẩm</button>
                </form>
            </div>
        </div>
    </div>
</section>

<script>
    function getCheckedValues() {
        const checkedValues = [];
        const radios = document.querySelectorAll('input[type="radio"]:checked');
        radios.forEach(radio => {
            checkedValues.push(radio.value);
        });
        return checkedValues;
    }

    // Gọi hàm khi cần (ví dụ khi nhấn nút Submit)
    document.querySelector('button[type="submit"]').addEventListener('click', function (e) {
        e.preventDefault();  // Ngăn hành động mặc định của form
        const values = getCheckedValues();
        document.getElementById('selectedValues').value = JSON.stringify(values);
        document.getElementById('updateForm').submit();
    });
</script>

<script>
    document.querySelector('form').addEventListener('submit', function (event) {
        const quantity = document.querySelector('input[name="quantity"]').value;
        const price = document.querySelector('input[name="price"]').value;

        if (quantity < 0) {
            alert('Số lượng không được âm!');
            event.preventDefault(); // Ngăn không cho form gửi đi
            return;
        }

        if (price < 0) {
            alert('Giá tiền không được âm!');
            event.preventDefault(); // Ngăn không cho form gửi đi
            return;
        }
    });
</script>

<script src="${pageContext.request.contextPath}/Admin/assets/js/sidebar.js"></script>
<script src="https://cdn.ckeditor.com/4.22.1/standard/ckeditor.js"></script>
<script>
    CKEDITOR.replace('editor');
</script>
<script src="<%= request.getContextPath()%>/Admin/assets/js/session-check.js"></script>

</body>
</html>