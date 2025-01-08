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



