// $(document).ready(function() {
//     // Lấy tất cả các input checkbox bên trong class 'filter'
//     $(".filter input[type='checkbox']").each(function() {
//         // Thêm sự kiện 'change' cho từng checkbox
//         $(this).on("change", function() {
//            $("")
//         });
//     });
// }

// var checkboxes = document.querySelectorAll("input[name='brand']");
//
// // Thêm sự kiện 'change' cho từng checkbox
// checkboxes.forEach(function(checkbox) {
//     checkbox.addEventListener("change", function() {
//         var checkedBrands = [];
//
//         // Lặp qua tất cả các checkbox có name='brand' và lấy những checkbox được chọn
//         checkboxes.forEach(function(checkbox) {
//             if (checkbox.checked) {
//                 checkedBrands.push(checkbox.value); // Thêm giá trị của checkbox vào mảng
//             }
//         });
//
//         // Tạo đối tượng XMLHttpRequest
//         var xhr = new XMLHttpRequest();
//
//         xhr.open("POST", "/Webike/filter", true);
//
//         // Định nghĩa hành động khi nhận được phản hồi từ server
//         xhr.onload = function() {
//             if (xhr.status === 200) {
//                console.log("thanh cong")
//             } else {
//                 console.log("that bai")
//             }
//         };
//
//         // Định nghĩa hành động khi có lỗi xảy ra trong quá trình gửi yêu cầu
//         xhr.onerror = function() {
//             console.log("that bai")
//         };
//         var data = "";
//         checkedBrands.forEach(function(brand) {
//             data += "brand=" + encodeURIComponent(brand) + "&";
//         });
//
//         // Loại bỏ dấu '&' thừa ở cuối chuỗi
//         data = data.slice(0, -1);
//
//         // Gửi dữ liệu
//         xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//         xhr.send(data);
//     });
// });

$(document).ready(function() {
    $("input[name='brand']").on("change", function() {
        var selectedBrands = [];
        $("input[name='brand']:checked").each(function() {
            selectedBrands.push($(this).val());
        });

        // Gửi dữ liệu qua AJAX
        $.ajax({
            url: "/Webike/filter",
            type: "POST",
            data: {
                brand: selectedBrands
            },
            traditional: true,
            success: function(response) {
                // Xóa danh sách sản phẩm hiện tại
                $(".grid__row").empty();

                // Thêm sản phẩm mới từ phản hồi
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
            },
            error: function(xhr, status, error) {
                console.log("Có lỗi xảy ra:", error);
            }
        });
    });
});


