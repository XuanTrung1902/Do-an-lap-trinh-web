$(document).ready(function() {
    let currentPage = 1;
    const itemsPerPage = 10;

    function fetchFilteredProducts() {
        var selectedBrands = [];
        $("input[name='brand']:checked").each(function() {
            selectedBrands.push($(this).val());
        });

        $.ajax({
            url: "/Webike/filter",
            type: "POST",
            data: {
                brand: selectedBrands.length > 0 ? selectedBrands : null,
                page: currentPage,
                limit: itemsPerPage
            },
            traditional: true,
            success: function(response) {
                $(".grid__row").empty();

                response.products.forEach(function(product) {
                    var productHTML = `
                        <div class="grid__column-2" style="padding: 10px; height: 380px" data-attributes="${product.brand || ''}">
                            <a href="productDetail?id=${product.id}" class="bike--item">
                                <div class="bike__img zoom-img">
                                    <img src="${product.imgUrl}" alt="${product.name}"/>
                                </div>
                                <div class="bike__info">
                                    <h3 class="bike__name" style="display: block; height: 49px;">${product.name}</h3>
                                    <span class="bike__price">${new Intl.NumberFormat().format(product.price)}₫</span>
                                    <div class="source">
                                        <span class="condition">${product.version}</span>
                                        <span class="time">${product.launch}</span>
                                    </div>
                                    <address class="address">${product.status}</address>
                                </div>
                            </a>
                        </div>
                    `;
                    $(".grid__row").append(productHTML);
                });

                console.log(response);
                renderPagination(response.totalPages);
                // Bỏ applyPagination để tránh xung đột
                // applyPagination();
            },
            error: function(xhr, status, error) {
                console.error("AJAX Error:", error);
                console.error("Status:", status);
                console.error("Response:", xhr.responseText);
            }
        });
    }

    function fetchAllProducts() {
        $.ajax({
            url: "/Webike/filter",
            type: "POST",
            data: {
                page: currentPage,
                limit: itemsPerPage
            },
            success: function(response) {
                $(".grid__row").empty();

                response.products.forEach(function(product) {
                    var productHTML = `
                        <div class="grid__column-2" style="padding: 10px; height: 380px" data-attributes="${product.brand || ''}">
                            <a href="productDetail?id=${product.id}" class="bike--item">
                                <div class="bike__img zoom-img">
                                    <img src="${product.imgUrl}" alt="${product.name}"/>
                                </div>
                                <div class="bike__info">
                                    <h3 class="bike__name" style="display: block; height: 49px;">${product.name}</h3>
                                    <span class="bike__price">${new Intl.NumberFormat().format(product.price)}₫</span>
                                    <div class="source">
                                        <span class="condition">${product.version}</span>
                                        <span class="time">${product.launch}</span>
                                    </div>
                                    <address class="address">${product.status}</address>
                                </div>
                            </a>
                        </div>
                    `;
                    $(".grid__row").append(productHTML);
                });

                console.log(response);
                renderPagination(response.totalPages);
                // Bỏ applyPagination để tránh xung đột
                // applyPagination();
            },
            error: function(xhr, status, error) {
                console.log("Có lỗi xảy ra:", error);
            }
        });
    }

    function renderPagination(totalPages) {
        $(".pagination ul").empty();

        for (let i = 1; i <= totalPages; i++) {
            const pageItem = `<li class="pagination__link ${i === currentPage ? 'pagination__link--active' : ''}" data-page="${i}">${i}</li>`;
            $(".pagination ul").append(pageItem);
        }

        $(".pagination__link").off("click").on("click", function() {
            currentPage = parseInt($(this).data("page"));
            var selectedBrands = [];
            $("input[name='brand']:checked").each(function() {
                selectedBrands.push($(this).val());
            });

            if (selectedBrands.length === 0) {
                fetchAllProducts();
            } else {
                fetchFilteredProducts();
            }
        });

        const leftButton = document.querySelector(".btn--left");
        const rightButton = document.querySelector(".btn--right");

        if (leftButton) {
            leftButton.onclick = function() {
                if (currentPage > 1) {
                    currentPage--;
                    var selectedBrands = [];
                    $("input[name='brand']:checked").each(function() {
                        selectedBrands.push($(this).val());
                    });

                    if (selectedBrands.length === 0) {
                        fetchAllProducts();
                    } else {
                        fetchFilteredProducts();
                    }
                }
            };
        }

        if (rightButton) {
            rightButton.onclick = function() {
                if (currentPage < totalPages) {
                    currentPage++;
                    var selectedBrands = [];
                    $("input[name='brand']:checked").each(function() {
                        selectedBrands.push($(this).val());
                    });

                    if (selectedBrands.length === 0) {
                        fetchAllProducts();
                    } else {
                        fetchFilteredProducts();
                    }
                }
            };
        }
    }

    $("input[name='brand']").on("change", function() {
        currentPage = 1;
        var selectedBrands = [];
        $("input[name='brand']:checked").each(function() {
            selectedBrands.push($(this).val());
        });

        if (selectedBrands.length === 0) {
            fetchAllProducts();
        } else {
            fetchFilteredProducts();
        }
    });

    fetchAllProducts();
});

///////////////////////
///// Search Product ////
///////////////////////

$(document).ready(function () {
    $('#search-input').on('keyup', function () {
        let keyword = $(this).val();
        console.log(keyword);
        $.ajax({
            url: '/Webike/search',
            method: 'GET',
            data: { keyword: keyword },
            success: function (response) {
                // console.log('Response:', response);
                let productGrid = $('#product-grid');
                productGrid.empty(); // Xóa kết quả cũ

                if (response.length > 0) {
                    response.forEach(product => {
                        let productHTML = `
                            <div class="grid__column-2" style="padding: 10px; height: 380px">
                                <a href="productDetail?id=${product.id}" class="bike--item">
                                    <div class="bike__img zoom-img">
                                        <img src="${product.imgurl}" alt="${product.name}" />
                                    </div>
                                    <div class="bike__info">
                                        <h3 class="bike__name">${product.name}</h3>
                                        <span class="bike__price">${new Intl.NumberFormat().format(product.price)}₫</span>
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
                } else {
                    productGrid.append('<p>Không tìm thấy sản phẩm nào.</p>');
                }
            },
            error: function (xhr, status, error) {
                console.error('Error status:', xhr.status); // Kiểm tra HTTP status code
                console.error('AJAX Error:', error);
                // console.error('Status:', status);
                // console.error('Response:', xhr.responseText);
            }
        });
    });
});


//////////////////////////////////////////////////////////////
/////////////////////// gợi ý tìm kiếm ///////////////////////
//////////////////////////////////////////////////////////////
$(document).ready(function () {
    let typingTimer;
    const doneTypingInterval = 300; // Thời gian chờ (ms) trước khi gọi API

    // Lắng nghe sự kiện khi người dùng nhập vào ô tìm kiếm
    $('.header__search--input').on('keyup', function () {
        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            let keyword = $(this).val().trim();

            // Nếu từ khóa rỗng, ẩn danh sách gợi ý
            if (keyword === '') {
                $('.search-suggestions').hide();
                return;
            }

            // Gọi API để lấy danh sách gợi ý
            $.ajax({
                url: '/Webike/search',
                method: 'GET',
                data: { keyword: keyword },
                success: function (response) {
                    let suggestionList = $('#suggestion-list');
                    suggestionList.empty(); // Xóa danh sách gợi ý cũ

                    if (response.length > 0) {
                        // Duyệt qua danh sách sản phẩm trả về và hiển thị gợi ý
                        response.forEach(product => {
                            let suggestionItem = `
                                <li data-id="${product.id}">
                                <div>
                                    <img src="${product.imgurl}" alt="${product.name}"/>
                                    <span><strong>${product.name}</strong></span>
                                </div>
                                    <span>${new Intl.NumberFormat().format(product.price)}₫</span>
                                </li>`;
                            suggestionList.append(suggestionItem);
                        });

                        // Hiển thị danh sách gợi ý
                        $('.search-suggestions').show();
                    } else {
                        // Nếu không có kết quả, hiển thị thông báo
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

    // Xử lý khi người dùng nhấp vào một gợi ý
    $(document).on('click', '#suggestion-list li', function () {
        let productId = $(this).data('id');
        if (productId) {
            // Chuyển hướng đến trang chi tiết sản phẩm
            window.location.href = `productDetail?id=${productId}`;
        }
        $('.search-suggestions').hide(); // Ẩn danh sách gợi ý sau khi chọn
    });

    // Ẩn danh sách gợi ý khi người dùng nhấp ra ngoài
    $(document).on('click', function (e) {
        if (!$(e.target).closest('.header__search').length) {
            $('.search-suggestions').hide();
        }
    });

    // Xử lý khi nhấn nút tìm kiếm
    $('.header__search--btn').on('click', function () {
        let keyword = $('.header__search--input').val().trim();
        if (keyword) {
            // Chuyển hướng đến trang kết quả tìm kiếm
            window.location.href = `/Webike/list-products?keyword=${encodeURIComponent(keyword)}`;
        }
    });
});



