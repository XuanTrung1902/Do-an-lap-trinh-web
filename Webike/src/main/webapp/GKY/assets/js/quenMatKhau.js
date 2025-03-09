
document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const phone = document.getElementById("phone").value;
        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirm_password").value;

        fetch(`${window.location.origin}/QuenMatKhau`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
                phone: phone,
                password: password,
                confirm_password: confirmPassword
            })
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert(`Chào ${data.name}, bạn đã đổi mật khẩu thành công!`);
                    window.location.href = `${window.location.origin}/Dangnhap`;
                } else {
                    alert(data.message);
                }
            })
            .catch(error => {
                console.error('Error:', error);
                    alert("Có lỗi xảy ra. Vui lòng thử lại sau.");
            });
    });
});


