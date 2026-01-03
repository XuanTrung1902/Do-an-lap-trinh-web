// $(document).ready(function() {
//     $('#typeFilter').change(function() {
//         var typeID = $(this).val();
//         // console.log("Type ID: " + typeID); // In ra ID loại sản phẩm đã chọn
//
//         $.ajax({
//             url: "${pageContext.request.contextPath}/products",
//             type: "GET",
//             data: { typeID: typeID },
//             success: function(data) {
//                 // Cập nhật bảng sản phẩm bằng cách parse HTML từ response
//                 $("#productTableBody").html($(data).find("#productTableBody").html());
//             },
//             error: function(xhr, status, error) {
//                 alert("Lỗi khi lọc sản phẩm!");
//             }
//         });
//     });
// });
// ${$('#canWriteProduct').val() === 'true' ? `<a href="update-product?id=${product.id}" class="btn-edit">Sửa</a>` : ''}
// ${$('#canDeleteProduct').val() === 'true' ? `<a href="delete-product?id=${product.id}" class="btn-delete" onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">Xóa</a>` : ''}

$(document).ready(function() {
    $('#typeFilter').change(function() {
        var typeID = $(this).val();
        $.ajax({
            url: "/products/filter",
            type: "GET",
            data: { typeID: typeID },
            dataType: "json",
            success: function(products) {
                $("#productTableBody").empty();

                products.forEach(function(product) {
                    var firstImage = product.img ? Object.values(product.img)[0] : ''; // Lấy URL ảnh đầu tiên
                    var row = `
                        <tr>
                            <td>${product.id}</td>
                            <td class="img__item"><img src="${firstImage}" alt="${product.name}" style="height: 75px; width: 115px"></td>
                            <td>${product.name}</td>
                            <td>${new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(product.price)}</td>
                            <td>${product.quantity}</td>
                            <td>
                                <a href="update-product?id=${product.id}" class="btn-edit">Sửa</a>
                                <a href="delete-product?id=${product.id}" class="btn-delete" onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">Xóa</a>
                            </td>
                        </tr>`;
                    $("#productTableBody").append(row);
                });
            },
            error: function(xhr, status, error) {
                alert("Lỗi khi lọc sản phẩm: " + error);
            }
        });
    });
});