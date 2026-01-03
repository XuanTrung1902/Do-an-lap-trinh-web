$(document).ready(function () {
    let currentPage = 1;
    const itemsPerPage = 10;

    $('#search-input').on('keyup', function () {
        let keyword = $(this).val().trim();
        fetchSearchProducts(keyword, currentPage);
    });

    function fetchSearchProducts(keyword, page) {
        $.ajax({
            url: '/search',
            method: 'GET',
            data: {
                keyword: keyword,
                page: page,
                limit: itemsPerPage
            },
            success: function (response) {
                let productGrid = $('#product-grid');
                productGrid.empty();

                if (response.products && response.products.length > 0) {
                    response.products.forEach(product => {
                        var colorHTML = "";
                        for (var colorKey in product.img) {
                            var imgUrl = product.img[colorKey];
                            // var colorId = colorKey;
                            var colorId = colorKey.split(',')[0].trim();
                            colorHTML += `
                                <a href="productDetail?id=${product.id}&cid=${colorId}" class="bike--item">
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
                            </div>`;
                        productGrid.append(productHTML);
                    });

                    renderPagination(response.totalPages);
                } else {
                    productGrid.append('<p>Không tìm thấy sản phẩm nào.</p>');
                    renderPagination(0);
                }
            },
            error: function (xhr, status, error) {
                console.error('Error status:', xhr.status);
                console.error('AJAX Error:', error);
                $('#product-grid').empty();
                $('#product-grid').append('<p>Có lỗi xảy ra khi tìm kiếm. Vui lòng thử lại.</p>');
                renderPagination(0);
            }
        });
    }

    function renderPagination(totalPages) {
        $(".pagination ul").empty();

        if (totalPages === 0) {
            $(".pagination ul").append('<li class="pagination__link pagination__link--disabled">1</li>');
            return;
        }

        const maxPagesBeforeCurrent = 2;
        const maxPagesAfterCurrent = 2;

        let startPage = Math.max(1, currentPage - maxPagesBeforeCurrent);
        let endPage = Math.min(totalPages, currentPage + maxPagesAfterCurrent);

        if (startPage > 1) {
            $(".pagination ul").append('<li class="pagination__link" data-page="1">1</li>');
            if (startPage > 2) $(".pagination ul").append('<li class="pagination__ellipsis">...</li>');
        }

        for (let i = startPage; i <= endPage; i++) {
            $(".pagination ul").append(`<li class="pagination__link ${i === currentPage ? 'pagination__link--active' : ''}" data-page="${i}">${i}</li>`);
        }

        if (endPage < totalPages) {
            if (endPage < totalPages - 1) $(".pagination ul").append('<li class="pagination__ellipsis">...</li>');
            $(".pagination ul").append(`<li class="pagination__link ${totalPages === currentPage ? 'pagination__link--active' : ''}" data-page="${totalPages}">${totalPages}</li>`);
        }

        $(".pagination__link").off("click").on("click", function () {
            currentPage = parseInt($(this).data("page"));
            fetchSearchProducts($('#search-input').val().trim(), currentPage);
        });
    }

    // Gợi ý tìm kiếm
    let typingTimer;
    const doneTypingInterval = 300;

    $('.header__search--input').on('keyup', function () {
        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            let keyword = $(this).val().trim();

            if (keyword === '') {
                $('.search-suggestions').hide();
                return;
            }

            $.ajax({
                url: '/search',
                method: 'GET',
                data: { keyword: keyword },
                success: function (response) {
                    console.log("Search response:", response); // Thêm log để kiểm tra dữ liệu
                    let suggestionList = $('#suggestion-list');
                    suggestionList.empty();

                    if (response.products && response.products.length > 0) {
                        response.products.forEach(product => {
                            let colorId = product.img && Object.keys(product.img).length > 0 ? Object.keys(product.img)[0] : '';
                            console.log("Color ID for product", product.id, ":", colorId); // Thêm log để kiểm tra colorId
                            let imgUrl = colorId ? product.img[colorId] : '/Webike/GKY/assets/img/default.png';

                            let suggestionItem = `
                    <li data-id="${product.id}" data-color-id="${colorId}">
                        <div>
                            <img src="${imgUrl}" alt="${product.name}"/>
                            <span><strong>${product.name}</strong></span>
                        </div>
                        <span>${new Intl.NumberFormat('vi-VN').format(product.price)}₫</span>
                    </li>`;
                            suggestionList.append(suggestionItem);
                        });
                        $('.search-suggestions').show();
                    } else {
                        suggestionList.append('<li>Không tìm thấy xe nào.</li>');
                        $('.search-suggestions').show();
                    }
                },
                error: function (xhr, status, error) {
                    console.error('AJAX Error:', error);
                    $('.search-suggestions').hide();
                }
            });
        }, doneTypingInterval);
    });

    // Xử lý khi nhấp vào gợi ý
    $(document).on('click', '#suggestion-list li', function () {
        let productId = $(this).data('id');
        let colorId = $(this).data('color-id');
        console.log("Product ID:", productId, "Color ID:", colorId);
        if (productId) {
            let url = `/productDetail?id=${encodeURIComponent(productId)}`;
            if (colorId) {
                url += `&cid=${encodeURIComponent(colorId)}`;
            } else {
                console.log("No colorId found, using default navigation");
            }
            window.location.href = url; // Chuyển hướng trực tiếp
        }
        $('.search-suggestions').hide();
    });

    $(document).on('click', function (e) {
        if (!$(e.target).closest('.header__search').length) {
            $('.search-suggestions').hide();
        }
    });

    $('.header__search--btn').on('click', function () {
        let keyword = $('.header__search--input').val().trim();
        if (keyword) {
            window.location.href = `/list-products?keyword=${encodeURIComponent(keyword)}`;
        }
    });
});