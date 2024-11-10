
document.addEventListener("DOMContentLoaded", function () {
    document.querySelector(".submit_btn").addEventListener("click", function (event) {
        event.preventDefault();

        const ho = document.querySelector(".input_name input:nth-child(1)").value;
        const tenDem = document.querySelector(".input_name input:nth-child(2)").value;
        const dienThoai = document.querySelector(".input_information input[type='tel']").value;
        const email = document.querySelector(".input_information input[type='email']").value;
        const matKhau = document.querySelector(".input_information input[type='password']").value;
        const acceptPolicy = document.querySelector(".checkbox input[type='checkbox']").checked;

        if (ho && tenDem && dienThoai && email && matKhau && acceptPolicy) {
            alert(`Chào ${ho} ${tenDem}, bạn đã đăng ký thành công!`);
        } else {
            alert("Vui lòng điền đầy đủ thông tin và chấp nhận chính sách của chúng tôi");
        }
    });
});