document.addEventListener("DOMContentLoaded", function () {
    document.querySelector(".submit_btn").addEventListener("click", function (event) {
        event.preventDefault();

        // Lấy giá trị từ các input
        const hoTen = document.querySelector(".input_field input:nth-child(1)").value;
        const dienThoai = document.querySelector(".input_field:nth-child(2) input").value;
        const matKhau = document.querySelector(".input_field:nth-child(3) input").value;
        const nhapLaiMatKhau = document.querySelector(".input_field:nth-child(4) input").value;
        const acceptPolicy = document.querySelector(".checkbox input[type='checkbox']").checked;

        if (hoTen && dienThoai && matKhau && nhapLaiMatKhau && acceptPolicy) {
            if (matKhau !== nhapLaiMatKhau) {
                alert("Mật khẩu và Nhập lại mật khẩu không khớp!");
            } else {
                alert(`Chào ${hoTen}, bạn đã đăng ký thành công!`);
            }
        } else {
            alert("Vui lòng điền đầy đủ thông tin và chấp nhận chính sách của chúng tôi");
        }
    });

    document.querySelector(".facebook-btn").addEventListener("click", function () {
        alert("Liên kết Facebook thành công!");
    });

    document.querySelector(".google-btn").addEventListener("click", function () {
        alert("Liên kết Google thành công!");
    });
});
