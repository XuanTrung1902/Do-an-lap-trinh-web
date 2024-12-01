document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".form-container form");
    const usernameInput = document.getElementById("username");
    const emailInput = document.getElementById("email");
    const captchaInput = document.getElementById("captcha");

    const correctCaptcha = "1264";

    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const username = usernameInput.value.trim();
        const email = emailInput.value.trim();
        const captcha = captchaInput.value.trim();

        if (username && email && captcha) {
            if (captcha === correctCaptcha) {
                alert("Mật khẩu mới đã được gửi về email của bạn.");
            } else {
                alert("Mã captcha không chính xác. Vui lòng thử lại.");
            }
        } else {
            alert("Vui lòng điền đầy đủ thông tin.");
        }
    });
});
