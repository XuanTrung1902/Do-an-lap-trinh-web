//
// function populateDays(selectedDay) {
//     const daySelect = document.getElementById('day-select');
//     for (let day = 1; day <= 31; day++) {
//         const option = document.createElement('option');
//         option.value = day;
//         option.textContent = day;
//         if (day == selectedDay) {
//             option.selected = true;
//         }
//         daySelect.appendChild(option);
//     }
// }
//
// function populateMonths(selectedMonth) {
//     const monthSelect = document.getElementById('month-select');
//     for (let month = 1; month <= 12; month++) {
//         const option = document.createElement('option');
//         option.value = month;
//         option.textContent = month;
//         if (month == selectedMonth) {
//             option.selected = true;
//         }
//         monthSelect.appendChild(option);
//     }
// }
//
// function populateYears(selectedYear) {
//     const yearSelect = document.getElementById('year-select');
//     for (let year = 2025; year >= 1950; year--) {
//         const option = document.createElement('option');
//         option.value = year;
//         option.textContent = year;
//         if (year == selectedYear) {
//             option.selected = true;
//         }
//         yearSelect.appendChild(option);
//     }
// }
//
// window.onload = function () {
//     const dob = "${sessionScope.auth.DOB}";
//     const [year, month, day] = dob.split('-');
//     populateDays(day);
//     populateMonths(month);
//     populateYears(year);
// };
//     document.addEventListener("DOMContentLoaded", function () {
//         const links = document.querySelectorAll(".link-toggle");
//
//         links.forEach((link) => {
//             link.addEventListener("click", function (e) {
//                 e.preventDefault();
//
//                 links.forEach((otherLink) => {
//                     if (otherLink !== link) {
//                         otherLink.classList.remove("active");
//                     }
//                 });
//
//                 link.classList.toggle("active");
//             });
//
//
//             document.addEventListener("click", function (event) {
//                 if (!link.contains(event.target)) {
//                     link.classList.remove("active");
//                 }
//             });
//         });
//     });
//     document.addEventListener("DOMContentLoaded", function () {
//         // Chọn các phần tử cần thiết
//         const changePasswordLink = document.getElementById("change-password");
//         const profileForm = document.querySelector(".profile-form");
//         const changePasswordForm = document.querySelector(".change-password-form");
//
//         // Sự kiện nhấn vào menu "Đổi mật khẩu"
//         changePasswordLink.addEventListener("click", function (e) {
//             e.preventDefault();
//             profileForm.style.display = "none"; // Ẩn form thông tin cá nhân
//             changePasswordForm.style.display = "block"; // Hiển thị form đổi mật khẩu
//         });
//
//         // Xử lý logic đổi mật khẩu
//         const passwordForm = document.getElementById("password-form");
//         passwordForm.addEventListener("submit", function (e) {
//             e.preventDefault();
//
//             const currentPassword = document.getElementById("current-password").value;
//             const newPassword = document.getElementById("new-password").value;
//             const confirmPassword = document.getElementById("confirm-password").value;
//
//             // Kiểm tra các điều kiện mật khẩu
//             if (!currentPassword || !newPassword || !confirmPassword) {
//                 alert("Vui lòng nhập đầy đủ thông tin.");
//                 return;
//             }
//
//             if (newPassword !== confirmPassword) {
//                 alert("Mật khẩu mới và xác nhận mật khẩu không khớp.");
//                 return;
//             }
//
//             // Xử lý thành công
//             alert("Đổi mật khẩu thành công!");
//
//             // Reset form và trở lại profile-form
//             passwordForm.reset();
//             changePasswordForm.style.display = "none";
//             profileForm.style.display = "block";
//         });
//     });
//     document.addEventListener("DOMContentLoaded", function () {
//         // Lấy các phần tử cần thao tác
//         const profileForm = document.getElementById("profile-form");
//         const changePasswordForm = document.getElementById("change-password-form");
//         const showProfileLink = document.getElementById("show-profile");
//         const changePasswordLink = document.getElementById("change-password");
//
//         // Hàm hiển thị thông tin tài khoản
//         function showProfile() {
//             profileForm.style.display = "block"; // Hiện thông tin tài khoản
//             changePasswordForm.style.display = "none"; // Ẩn đổi mật khẩu
//         }
//
//         // Hàm hiển thị đổi mật khẩu
//         function showChangePassword() {
//             profileForm.style.display = "none"; // Ẩn thông tin tài khoản
//             changePasswordForm.style.display = "block"; // Hiện đổi mật khẩu
//         }
//
//         // Gắn sự kiện click cho các liên kết
//         showProfileLink.addEventListener("click", function (e) {
//             e.preventDefault(); // Ngăn chặn hành động mặc định
//             showProfile(); // Chuyển sang hiển thị thông tin tài khoản
//         });
//
//         changePasswordLink.addEventListener("click", function (e) {
//             e.preventDefault(); // Ngăn chặn hành động mặc định
//             showChangePassword(); // Chuyển sang hiển thị đổi mật khẩu
//         });
//     });
//     document.addEventListener("DOMContentLoaded", function () {
//         // Lấy danh sách tất cả các liên kết trong menu
//         const menuLinks = document.querySelectorAll(".sidebar-menu li a");
//
//         // Hàm để xử lý khi nhấn vào một mục
//         function handleMenuClick(event) {
//             event.preventDefault(); // Ngăn hành động mặc định
//
//             // Loại bỏ lớp 'active' khỏi tất cả các liên kết
//             menuLinks.forEach(link => link.classList.remove("active"));
//
//             // Thêm lớp 'active' vào liên kết được nhấn
//             this.classList.add("active");
//
//             // Hiển thị hoặc ẩn các nội dung tương ứng
//             const targetId = this.id;
//             if (targetId === "show-profile") {
//                 document.getElementById("profile-form").style.display = "block";
//                 document.getElementById("change-password-form").style.display = "none";
//             } else if (targetId === "change-password") {
//                 document.getElementById("profile-form").style.display = "none";
//                 document.getElementById("change-password-form").style.display = "block";
//             }
//         }
//
//         // Gắn sự kiện click cho từng liên kết
//         menuLinks.forEach(link => {
//             link.addEventListener("click", handleMenuClick);
//         });
//     });
//
function populateDays(selectedDay) {
    const daySelect = document.getElementById('day-select');
    for (let day = 1; day <= 31; day++) {
        const option = document.createElement('option');
        option.value = day;
        option.textContent = day;
        if (day == selectedDay) {
            option.selected = true;
        }
        daySelect.appendChild(option);
    }
}

function populateMonths(selectedMonth) {
    const monthSelect = document.getElementById('month-select');
    for (let month = 1; month <= 12; month++) {
        const option = document.createElement('option');
        option.value = month;
        option.textContent = month;
        if (month == selectedMonth) {
            option.selected = true;
        }
        monthSelect.appendChild(option);
    }
}

function populateYears(selectedYear) {
    const yearSelect = document.getElementById('year-select');
    for (let year = 2025; year >= 1950; year--) {
        const option = document.createElement('option');
        option.value = year;
        option.textContent = year;
        if (year == selectedYear) {
            option.selected = true;
        }
        yearSelect.appendChild(option);
    }
}

window.onload = function () {
    const dob = "${sessionScope.auth.DOB}";
    const [year, month, day] = dob.split('-');
    populateDays(day);
    populateMonths(month);
    populateYears(year);
};

document.addEventListener("DOMContentLoaded", function () {
    const showProfileLink = document.getElementById("show-profile");
    const changePasswordLink = document.getElementById("change-password");
    const profileForm = document.getElementById("profile-form");
    const changePasswordForm = document.getElementById("change-password-form");

    function showProfile() {
        profileForm.style.display = "block";
        changePasswordForm.style.display = "none";
    }

    function showChangePassword() {
        profileForm.style.display = "none";
        changePasswordForm.style.display = "block";
    }

    showProfileLink.addEventListener("click", function (e) {
        e.preventDefault();
        showProfile();
    });

    changePasswordLink.addEventListener("click", function (e) {
        e.preventDefault();
        showChangePassword();
    });

    const passwordForm = document.getElementById("password-form");
    passwordForm.addEventListener("submit", function (e) {
        e.preventDefault();

        const currentPassword = document.getElementById("current-password").value;
        const newPassword = document.getElementById("new-password").value;
        const confirmPassword = document.getElementById("confirm-password").value;

        if (!currentPassword || !newPassword || !confirmPassword) {
            alert("Vui lòng nhập đầy đủ thông tin.");
            return;
        }

        if (newPassword !== confirmPassword) {
            alert("Mật khẩu mới và xác nhận mật khẩu không khớp.");
            return;
        }

        passwordForm.submit();
    });
});
