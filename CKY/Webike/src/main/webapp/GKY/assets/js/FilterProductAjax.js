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
                brand: selectedBrands,
                page: currentPage,
                limit: itemsPerPage
            },
            traditional: true,
            success: function(response) {
                $(".grid__row").empty();

                response.forEach(function(product) {
                    var productHTML = `
                        <div class="grid__column-2" style="padding: 10px; height: 380px">
                            <a href="products" class="bike--item">
                                <div class="bike__img zoom-img">
                                    <img src="${product.imgUrl}" alt="${product.name}"/>
                                </div>
                                <div class="bike__info">
                                    <h3 class="bike__name" style="display: block; height: 49px;">${product.name}</h3>
                                    <span class="bike__price">${product.price}đ</span>
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
                renderPagination();
            },
            error: function(xhr, status, error) {
                console.log("Có lỗi xảy ra:", error);
            }
        });
    }

    $("input[name='brand']").on("change", function() {
        currentPage = 1; // Reset về trang đầu tiên
        fetchFilteredProducts();
    });

    function renderPagination() {
        $(".pagination ul").empty();
        const totalPages = 5; // Cần lấy tổng số trang từ phản hồi (phát triển sau)

        for (let i = 1; i <= totalPages; i++) {
            const pageItem = `<li class="pagination__link ${i === currentPage ? 'pagination__link--active' : ''}" data-page="${i}">${i}</li>`;
            $(".pagination ul").append(pageItem);
        }

        $(".pagination__link").on("click", function() {
            currentPage = parseInt($(this).data("page"));
            fetchFilteredProducts();
        });
    }
});
