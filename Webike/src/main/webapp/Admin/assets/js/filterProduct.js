$(document).ready(function() {
    $('#typeFilter').change(function() {
        var typeID = $(this).val();
        // console.log("Type ID: " + typeID); // In ra ID loại sản phẩm đã chọn

        $.ajax({
            url: "/Webike/products",
            type: "GET",
            data: { typeID: typeID },
            success: function(data) {
                // Cập nhật bảng sản phẩm bằng cách parse HTML từ response
                $("#productTableBody").html($(data).find("#productTableBody").html());
            },
            error: function(xhr, status, error) {
                alert("Lỗi khi lọc sản phẩm!");
            }
        });
    });
});