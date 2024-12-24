<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Quên Mật Khẩu</title>
    <base href="${pageContext.request.contextPath}/GKY/assets/">
    <link rel="stylesheet" href="css/quenMatKhau.css">
<%--    <script>--%>
<%--        document.addEventListener("DOMContentLoaded", function () {--%>
<%--            const phoneInput = document.querySelector("input[name='phone']");--%>
<%--            const phoneError = document.getElementById("phone-error");--%>

<%--            phoneInput.addEventListener("blur", function () {--%>
<%--                const phoneNum = phoneInput.value;--%>
<%--                if (phoneNum) {--%>
<%--                    fetch(`${window.location.origin}/CheckPhone`, {--%>
<%--                        method: 'POST',--%>
<%--                        headers: {--%>
<%--                            'Content-Type': 'application/json'--%>
<%--                        },--%>
<%--                        body: JSON.stringify({ phone: phoneNum })--%>
<%--                    })--%>
<%--                        .then(response => response.json())--%>
<%--                        .then(data => {--%>
<%--                            if (data.exists) {--%>
<%--                                phoneError.style.display = "block";--%>
<%--                            } else {--%>
<%--                                phoneError.style.display = "none";--%>
<%--                            }--%>
<%--                        })--%>
<%--                        .catch(error => {--%>
<%--                            console.error('Error:', error);--%>
<%--                            alert("Có lỗi xảy ra. Vui lòng thử lại sau.");--%>
<%--                        });--%>
<%--                }--%>
<%--            });--%>

<%--            const form = document.querySelector("form");--%>
<%--            form.addEventListener("submit", function (event) {--%>
<%--                event.preventDefault();--%>

<%--                const phone = document.getElementById("phone").value;--%>
<%--                const password = document.getElementById("password").value;--%>
<%--                const confirmPassword = document.getElementById("confirm_password").value;--%>

<%--                fetch(`${window.location.origin}/Dangky`, {--%>
<%--                    method: 'POST',--%>
<%--                    headers: {--%>
<%--                        'Content-Type': 'application/x-www-form-urlencoded'--%>
<%--                    },--%>
<%--                    body: new URLSearchParams({--%>
<%--                        phone: phone,--%>
<%--                        password: password,--%>
<%--                        confirm_password: confirmPassword--%>
<%--                    })--%>
<%--                })--%>
<%--                    .then(response => response.json())--%>
<%--                    .then(data => {--%>
<%--                        if (data.success) {--%>
<%--                            alert(`Chào ${data.name}, bạn đã đăng ký thành công!`);--%>
<%--                            window.location.href = `${window.location.origin}/Dangnhap`;--%>
<%--                        } else {--%>
<%--                            alert(data.message);--%>
<%--                        }--%>
<%--                    })--%>
<%--                    .catch(error => {--%>
<%--                        console.error('Error:', error);--%>
<%--                        alert("Có lỗi xảy ra. Vui lòng thử lại sau.");--%>
<%--                    });--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const phoneInput = document.getElementById("phone");
            const phoneError = document.getElementById("phone-error");

            phoneInput.addEventListener("blur", function () {
                const phoneNum = phoneInput.value;
                if (phoneNum) {
                    fetch(`${window.location.origin}/CheckPhone`, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({ phone: phoneNum })
                    })
                        .then(response => response.json())
                        .then(data => {
                            if (!data.exists) {
                                phoneError.style.display = "block";
                            } else {
                                phoneError.style.display = "none";
                            }
                        })
                        .catch(error => {
                            console.error('Error:', error);
                            alert("Có lỗi xảy ra. Vui lòng thử lại sau.");
                        });
                }
            });

            const form = document.querySelector("form");
            form.addEventListener("submit", function (event) {
                const phoneNum = phoneInput.value;
                if (phoneError.style.display === "block") {
                    event.preventDefault();
                    alert("Số điện thoại không tồn tại!");
                }
            });
        });
    </script>

</head>
<body>

<div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
    <h1>
        <a href="#">
            <img src="img/logo.png" alt="Webike VN" class="logo" /></a>
    </h1>
</div>

<div class="form-container">
    <h2>Quên mật khẩu?</h2>
    <form action="${pageContext.request.contextPath}/QuenMatKhau" method="post" onsubmit="return validateForm()">
        <label for="phone">SDT:</label>
        <input type="tel" id="phone" name="phone" required>
        <span id="phone-error" style="color: red; display: none;">Số điện thoại không tồn tại!</span>

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required>

        <label for="confirm_password">Nhập lại mật khẩu:</label>
        <input type="password" id="confirm_password" name="confirm_password" required>

        <button type="submit">Gửi</button>
    </form>
</div>
<%--<script src="js/quenMatKhau.js"></script>--%>
</body>
</html>
