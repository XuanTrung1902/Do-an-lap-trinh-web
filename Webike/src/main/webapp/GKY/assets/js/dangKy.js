// function sendOtp() {
//     // const email = document.querySelector('input[name="email"]').value;
//     const email = document.getElementById('email').value;
//     console.log(email)
//     if (email) {
//         fetch('<%= request.getContextPath()%>/OTP?email='+email, {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/x-www-form-urlencoded'
//             },
//             body: `email=${email}`
//         }).then(response => response.text()).then(data => {
//             alert(data);
//         }).catch(error => {
//             console.log(error)
//             console.error('Error:', error);
//         });
//     } else {
//         alert('Vui lòng nhập email.');
//     }
// }
document.addEventListener("DOMContentLoaded", function () {
    const submitBtn = document.querySelector(".submit_btn");
    if (submitBtn) {
        submitBtn.addEventListener("click", function (event) {
            event.preventDefault();

            // Lấy giá trị từ các input
            const hoTen = document.querySelector(".input_field input[name='fullname']").value;
            const dienThoai = document.querySelector(".input_field input[name='phone']").value;
            const matKhau = document.querySelector(".input_field input[name='password']").value;
            const nhapLaiMatKhau = document.querySelector(".input_field input[name='confirm_password']").value;
            const acceptPolicy = document.querySelector(".checkbox input[type='checkbox']").checked;

            // Lấy giá trị ngày sinh từ dropdown
            const daySelect = document.getElementById("day-select");
            const monthSelect = document.getElementById("month-select");
            const yearSelect = document.getElementById("year-select");

            if (daySelect && monthSelect && yearSelect) {
                const ngaySinh = `${yearSelect.value}-${monthSelect.value.padStart(2, "0")}-${daySelect.value.padStart(2, "0")}`;

                if (hoTen && dienThoai && matKhau && nhapLaiMatKhau && acceptPolicy) {
                    if (matKhau !== nhapLaiMatKhau) {
                        alert("Mật khẩu và Nhập lại mật khẩu không khớp!");
                    } else {
                        alert(`Chào ${hoTen}, bạn đã đăng ký thành công! Ngày sinh: ${ngaySinh}`);
                        // Gửi form đăng ký
                        document.querySelector(".form_center").submit();
                    }
                } else {
                    alert("Vui lòng điền đầy đủ thông tin và chấp nhận chính sách của chúng tôi");
                }
            } else {
                alert("Vui lòng chọn ngày sinh hợp lệ");
            }
        });
    }

    // Thêm các tùy chọn ngày, tháng, năm vào dropdown
    const daySelect = document.getElementById("day-select");
    const monthSelect = document.getElementById("month-select");
    const yearSelect = document.getElementById("year-select");

    if (daySelect && monthSelect && yearSelect) {
        for (let i = 1; i <= 31; i++) {
            const option = document.createElement("option");
            option.value = i;
            option.textContent = i;
            daySelect.appendChild(option);
        }

        for (let i = 1; i <= 12; i++) {
            const option = document.createElement("option");
            option.value = i;
            option.textContent = `Tháng ${i}`;
            monthSelect.appendChild(option);
        }

        const currentYear = new Date().getFullYear();
        for (let i = currentYear; i >= 1900; i--) {
            const option = document.createElement("option");
            option.value = i;
            option.textContent = i;
            yearSelect.appendChild(option);
        }
    }
});

document.addEventListener("DOMContentLoaded", () => {
    const daySelect = document.getElementById("day-select");
    const monthSelect = document.getElementById("month-select");
    const yearSelect = document.getElementById("year-select");

    // Thêm ngày
    for (let i = 1; i <= 31; i++) {
        const option = document.createElement("option");
        option.value = i;
        option.textContent = i;
        daySelect.appendChild(option);
    }

    // Thêm tháng
    for (let i = 1; i <= 12; i++) {
        const option = document.createElement("option");
        option.value = i;
        option.textContent = `Tháng ${i}`;
        monthSelect.appendChild(option);
    }

    // Thêm năm (1900 - hiện tại)
    const currentYear = new Date().getFullYear();
    for (let i = currentYear; i >= 1900; i--) {
        const option = document.createElement("option");
        option.value = i;
        option.textContent = i;
        yearSelect.appendChild(option);
    }
});
