
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
    console.log(dob); // Log giá trị DOB ra console
    const [year, month, day] = dob.split('-');
    populateDays(parseInt(day));
    populateMonths(parseInt(month));
    populateYears(parseInt(year));
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
