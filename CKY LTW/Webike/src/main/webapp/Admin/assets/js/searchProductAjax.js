$(document).ready(function () {
    $('#searchInput').on('keyup', function () {
        let keyword = $(this).val();
        console.log(keyword);
        $.ajax({
            url: '/Webike/search_by_name',
            type: 'POST',
            data: { keyword: keyword },
            success: function (response) {
                $('#productTableBody').empty();

                response.forEach(product => {
                    let row = `
                        <tr>
                            <td>${product.id}</td>
                            <td class="img__item"><img src="${product.imgurl}" alt="${product.name}"></td>
                            <td>${product.name}</td>
                            <td>${new Intl.NumberFormat().format(product.price)}₫</td>
                            <td>${product.launch}</td>
                            <td>
                                <a href="update-product?id=${product.id}" class="btn-edit">Sửa</a>
                                <a href="delete-product?id=${product.id}" class="btn-delete" onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">Xóa</a>
                            </td>
                        </tr>`;
                    $('#productTableBody').append(row);
                });
            },
            error: function () {
                console.error('Không thể tìm kiếm sản phẩm.');
            }
        });
    });
});
