$(document).ready(function() {
    let currentPage = 1;
    const itemsPerPage = 10;

    // Hàm lấy danh sách sản phẩm theo bộ lọc hoặc tất cả sản phẩm
    function fetchFilteredProducts() {
        var selectedBrands = [];
        $("input[name='brand']:checked").each(function() {
            selectedBrands.push($(this).val());
        });
        // console.log("Selected Brands:", selectedBrands);

        $.ajax({
            url: "/Webike/filter",
            type: "POST",
            data: {
                brand: selectedBrands,
                page: currentPage,
                limit: itemsPerPage
            },
            traditional: true,
            success: function(response) {
                // Xóa danh sách sản phẩm hiện tại
                $("#product-grid").empty();

                // Kiểm tra nếu không có sản phẩm
                if (!response.products || response.products.length === 0) {
                    $("#product-grid").append('<p>Không có sản phẩm nào phù hợp.</p>');
                    renderPagination(0); // Không có trang
                    return;
                }

                // console.log("Response:", response);

                // Hiển thị danh sách sản phẩm
                response.products.forEach(function(product) {
                    var colorHTML = "";
                    // Duyệt qua các cặp color-url trong img
                    for (var colorKey in product.img) {
                        var imgUrl = product.img[colorKey];
                        var colorId = colorKey; // Sử dụng colorKey làm colorID (đã serialize trong FilterProduct.java)
                        colorHTML += `
                            <a href="productDetail?id=${product.id}&cid=${colorId}"
                               onclick="checkLoginForProduct(event, ${product.id})" class="bike--item">
                                <div class="bike__img zoom-img">
                                    <img src="${imgUrl}" alt="${product.name}"/>
                                </div>
                        `;
                    }

                    var productHTML = `
                        <div class="grid__column-2" style="padding: 10px; height: 380px" data-attributes="${product.brand || ''}">
                            ${colorHTML}
                            <div class="bike__info">
                                <h3 class="bike__name" style="display: block; height: 49px;">${product.name}</h3>
                                <div class="d-flex justify-content-between">
                                    <span class="bike__price">${new Intl.NumberFormat('vi-VN').format(product.price)}₫</span>
                                    ${product.discount > 0 ? `<span class="text-danger" style="text-align: center; display: flex; font-size: 1.3rem;">-${product.discount}%</span>` : ''}
                                </div>
                                <div class="source">
                                    <span class="condition">${product.version}</span>
                                    <span class="time">${product.launch}</span>
                                </div>
                                <address class="address">${product.status}</address>
                            </div>
                            </a>
                        </div>
                    `;
                    $("#product-grid").append(productHTML);
                });

                // Cập nhật phân trang
                renderPagination(response.totalPages);
            },
            error: function(xhr, status, error) {
                console.error("AJAX Error:", error);
                console.error("Status:", status);
                console.error("Response:", xhr.responseText);
                $("#product-grid").empty();
                $("#product-grid").append('<p>Có lỗi xảy ra khi tải sản phẩm. Vui lòng thử lại.</p>');
                renderPagination(0);
            }
        });
    }

    // Hàm render phân trang
    function renderPagination(totalPages) {
        $(".pagination ul").empty();

        if (totalPages === 0) {
            $(".pagination ul").append('<li class="pagination__link pagination__link--disabled">1</li>');
            const leftButton = document.querySelector(".btn--left");
            const rightButton = document.querySelector(".btn--right");
            if (leftButton) leftButton.disabled = true;
            if (rightButton) rightButton.disabled = true;
            return;
        }

        const maxPagesBeforeCurrent = 2;
        const maxPagesAfterCurrent = 2;

        let startPage = Math.max(2, currentPage - maxPagesBeforeCurrent);
        let endPage = Math.min(totalPages - 1, currentPage + maxPagesAfterCurrent);

        const maxVisiblePages = maxPagesBeforeCurrent + maxPagesAfterCurrent + 1;
        if (endPage - startPage + 1 < maxVisiblePages) {
            if (currentPage <= totalPages / 2) {
                endPage = Math.min(totalPages - 1, startPage + maxVisiblePages - 1);
            } else {
                startPage = Math.max(2, endPage - maxVisiblePages + 1);
            }
        }

        const pageItem1 = `<li class="pagination__link ${1 === currentPage ? 'pagination__link--active' : ''}" data-page="1">1</li>`;
        $(".pagination ul").append(pageItem1);

        if (startPage > 2) {
            $(".pagination ul").append('<li class="pagination__ellipsis">...</li>');
        }

        for (let i = startPage; i <= endPage; i++) {
            const pageItem = `<li class="pagination__link ${i === currentPage ? 'pagination__link--active' : ''}" data-page="${i}">${i}</li>`;
            $(".pagination ul").append(pageItem);
        }

        if (endPage < totalPages - 1) {
            $(".pagination ul").append('<li class="pagination__ellipsis">...</li>');
        }

        if (totalPages > 1) {
            const pageItemLast = `<li class="pagination__link ${totalPages === currentPage ? 'pagination__link--active' : ''}" data-page="${totalPages}">${totalPages}</li>`;
            $(".pagination ul").append(pageItemLast);
        }

        $(".pagination__link").off("click").on("click", function() {
            currentPage = parseInt($(this).data("page"));
            fetchFilteredProducts();
        });

        const leftButton = document.querySelector(".btn--left");
        const rightButton = document.querySelector(".btn--right");

        if (leftButton) {
            leftButton.disabled = currentPage === 1;
            leftButton.onclick = function() {
                if (currentPage > 1) {
                    currentPage--;
                    fetchFilteredProducts();
                }
            };
        }

        if (rightButton) {
            rightButton.disabled = currentPage === totalPages;
            rightButton.onclick = function() {
                if (currentPage < totalPages) {
                    currentPage++;
                    fetchFilteredProducts();
                }
            };
        }
    }

    // Xử lý sự kiện khi thay đổi checkbox
    $("input[name='brand']").on("change", function() {
        currentPage = 1; // Reset về trang 1 khi thay đổi bộ lọc
        fetchFilteredProducts();
    });

    // Tải tất cả sản phẩm khi trang được load lần đầu
    fetchFilteredProducts();
});