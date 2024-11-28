
    function populateDays() {
        const daySelect = document.getElementById('day-select');
        for (let day = 1; day <= 31; day++) {
        const option = document.createElement('option');
        option.value = day;
        option.textContent = day;
        daySelect.appendChild(option);
        }
}

    function populateMonths() {
        const monthSelect = document.getElementById('month-select');
        for (let month = 1; month <= 12; month++) {
        const option = document.createElement('option');
        option.value = month;
        option.textContent = month;
        monthSelect.appendChild(option);
        }
}

    function populateYears() {
        const yearSelect = document.getElementById('year-select');
        for (let year = 2025; year >= 1950; year--) {
        const option = document.createElement('option');
        option.value = year;
        option.textContent = year;
        yearSelect.appendChild(option);
        }
}


    window.onload = function () {
    populateDays();
    populateMonths();
    populateYears();
};
    document.addEventListener("DOMContentLoaded", function () {
        const links = document.querySelectorAll(".link-toggle");

        links.forEach((link) => {
            link.addEventListener("click", function (e) {
                e.preventDefault();

                links.forEach((otherLink) => {
                    if (otherLink !== link) {
                        otherLink.classList.remove("active");
                    }
                });

                link.classList.toggle("active");
            });


            document.addEventListener("click", function (event) {
                if (!link.contains(event.target)) {
                    link.classList.remove("active");
                }
            });
        });
    });
    document.addEventListener("DOMContentLoaded", function () {
        // Chọn các phần tử cần thiết
        const changePasswordLink = document.getElementById("change-password");
        const profileForm = document.querySelector(".profile-form");
        const changePasswordForm = document.querySelector(".change-password-form");

        // Sự kiện nhấn vào menu "Đổi mật khẩu"
        changePasswordLink.addEventListener("click", function (e) {
            e.preventDefault();
            profileForm.style.display = "none"; // Ẩn form thông tin cá nhân
            changePasswordForm.style.display = "block"; // Hiển thị form đổi mật khẩu
        });

        // Xử lý logic đổi mật khẩu
        const passwordForm = document.getElementById("password-form");
        passwordForm.addEventListener("submit", function (e) {
            e.preventDefault();

            const currentPassword = document.getElementById("current-password").value;
            const newPassword = document.getElementById("new-password").value;
            const confirmPassword = document.getElementById("confirm-password").value;

            // Kiểm tra các điều kiện mật khẩu
            if (!currentPassword || !newPassword || !confirmPassword) {
                alert("Vui lòng nhập đầy đủ thông tin.");
                return;
            }

            if (newPassword !== confirmPassword) {
                alert("Mật khẩu mới và xác nhận mật khẩu không khớp.");
                return;
            }

            // Xử lý thành công
            alert("Đổi mật khẩu thành công!");

            // Reset form và trở lại profile-form
            passwordForm.reset();
            changePasswordForm.style.display = "none";
            profileForm.style.display = "block";
        });
    });
    document.addEventListener("DOMContentLoaded", function () {
        // Lấy các phần tử cần thao tác
        const profileForm = document.getElementById("profile-form");
        const changePasswordForm = document.getElementById("change-password-form");
        const showProfileLink = document.getElementById("show-profile");
        const changePasswordLink = document.getElementById("change-password");

        // Hàm hiển thị thông tin tài khoản
        function showProfile() {
            profileForm.style.display = "block"; // Hiện thông tin tài khoản
            changePasswordForm.style.display = "none"; // Ẩn đổi mật khẩu
        }

        // Hàm hiển thị đổi mật khẩu
        function showChangePassword() {
            profileForm.style.display = "none"; // Ẩn thông tin tài khoản
            changePasswordForm.style.display = "block"; // Hiện đổi mật khẩu
        }

        // Gắn sự kiện click cho các liên kết
        showProfileLink.addEventListener("click", function (e) {
            e.preventDefault(); // Ngăn chặn hành động mặc định
            showProfile(); // Chuyển sang hiển thị thông tin tài khoản
        });

        changePasswordLink.addEventListener("click", function (e) {
            e.preventDefault(); // Ngăn chặn hành động mặc định
            showChangePassword(); // Chuyển sang hiển thị đổi mật khẩu
        });
    });
    document.addEventListener("DOMContentLoaded", function () {
        // Lấy danh sách tất cả các liên kết trong menu
        const menuLinks = document.querySelectorAll(".sidebar-menu li a");

        // Hàm để xử lý khi nhấn vào một mục
        function handleMenuClick(event) {
            event.preventDefault(); // Ngăn hành động mặc định

            // Loại bỏ lớp 'active' khỏi tất cả các liên kết
            menuLinks.forEach(link => link.classList.remove("active"));

            // Thêm lớp 'active' vào liên kết được nhấn
            this.classList.add("active");

            // Hiển thị hoặc ẩn các nội dung tương ứng
            const targetId = this.id;
            if (targetId === "show-profile") {
                document.getElementById("profile-form").style.display = "block";
                document.getElementById("change-password-form").style.display = "none";
            } else if (targetId === "change-password") {
                document.getElementById("profile-form").style.display = "none";
                document.getElementById("change-password-form").style.display = "block";
            }
        }

        // Gắn sự kiện click cho từng liên kết
        menuLinks.forEach(link => {
            link.addEventListener("click", handleMenuClick);
        });
    });
    document.addEventListener("DOMContentLoaded", function () {
        // Lấy các phần tử cần thao tác
        const profileForm = document.getElementById("profile-form");
        const changePasswordForm = document.getElementById("change-password-form");
        const changePictureForm = document.getElementById("change-picture-form");
        const showProfileLink = document.getElementById("show-profile");
        const changePasswordLink = document.getElementById("change-password");
        const changePictureLink = document.getElementById("change-picture");

        // Hàm hiển thị thông tin tài khoản
        function showProfile() {
            profileForm.style.display = "block"; // Hiện thông tin tài khoản
            changePasswordForm.style.display = "none"; // Ẩn đổi mật khẩu
            changePictureForm.style.display = "none"; // Ẩn đổi ảnh đại diện
        }

        // Hàm hiển thị đổi mật khẩu
        function showChangePassword() {
            profileForm.style.display = "none"; // Ẩn thông tin tài khoản
            changePasswordForm.style.display = "block"; // Hiện đổi mật khẩu
            changePictureForm.style.display = "none"; // Ẩn đổi ảnh đại diện
        }

        // Hàm hiển thị đổi ảnh đại diện
        function showChangePicture() {
            profileForm.style.display = "none"; // Ẩn thông tin tài khoản
            changePasswordForm.style.display = "none"; // Ẩn đổi mật khẩu
            changePictureForm.style.display = "block"; // Hiện đổi ảnh đại diện
        }

        // Gắn sự kiện click cho các liên kết
        showProfileLink.addEventListener("click", function (e) {
            e.preventDefault(); // Ngăn chặn hành động mặc định
            showProfile(); // Chuyển sang hiển thị thông tin tài khoản
        });

        changePasswordLink.addEventListener("click", function (e) {
            e.preventDefault(); // Ngăn chặn hành động mặc định
            showChangePassword(); // Chuyển sang hiển thị đổi mật khẩu
        });

        changePictureLink.addEventListener("click", function (e) {
            e.preventDefault(); // Ngăn chặn hành động mặc định
            showChangePicture(); // Chuyển sang hiển thị đổi ảnh đại diện
        });
    });

    // Đảm bảo các liên kết trong sidebar hiển thị trạng thái 'active'
    document.addEventListener("DOMContentLoaded", function () {
        const menuLinks = document.querySelectorAll(".sidebar-menu li a");

        menuLinks.forEach(link => {
            link.addEventListener("click", function (event) {
                event.preventDefault(); // Ngăn hành động mặc định

                // Loại bỏ lớp 'active' khỏi tất cả các liên kết
                menuLinks.forEach(link => link.classList.remove("active"));

                // Thêm lớp 'active' vào liên kết được nhấn
                this.classList.add("active");
            });
        });
    });
