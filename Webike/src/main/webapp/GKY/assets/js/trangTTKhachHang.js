
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
    const changeAvatarLink = document.getElementById("change-avatar");
    const changeEmailLink = document.getElementById("change-email");
    const showProfileLink = document.getElementById("show-profile");
    const changePasswordLink = document.getElementById("change-password");
    const enable2FALink = document.getElementById("enable-2fa");


    const changeAvatarForm = document.querySelector(".change-avatar-form");
    const changeEmailForm = document.getElementById("change-email-form");
    const profileForm = document.getElementById("profile-form");
    const changePasswordForm = document.getElementById("change-password-form");
    const enable2FAForm = document.getElementById("enable-2fa-form");


    const menuLinks = document.querySelectorAll(".sidebar-menu li a");

    menuLinks.forEach(link => {
        link.addEventListener("click", function (e) {
            e.preventDefault();

            // Ẩn tất cả các form
            profileForm.style.display = "none";
            changePasswordForm.style.display = "none";
            changeAvatarForm.style.display = "none";
            if (changeEmailForm) changeEmailForm.style.display = "none";

            // Reset active
            menuLinks.forEach(link => link.classList.remove("active"));
            this.classList.add("active");

            const targetId = this.id;
            if (targetId === "show-profile") {
                profileForm.style.display = "block";
            } else if (targetId === "change-password") {
                changePasswordForm.style.display = "block";
            } else if (targetId === "change-avatar") {
                changeAvatarForm.style.display = "block";
            } else if (targetId === "change-email") {
                if (changeEmailForm) changeEmailForm.style.display = "block";
            }else if (targetId === "enable-2fa") {
                if (enable2FAForm) enable2FAForm.style.display = "block";
            }
        });
    });
});

