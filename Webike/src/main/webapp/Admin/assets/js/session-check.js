if (!sessionStorage.getItem("loggedOut")) {
    setInterval(() => {
        console.log("⏱️ Đang kiểm tra force logout...");
        fetch('/Webike/checkForceLogout')
            .then(res => {
                if (!res.ok) throw new Error("HTTP " + res.status);
                return res.json();
            })
            .then(data => {
                console.log("🔄 Kết quả từ server:", data);
                if (data.forceLogout) {
                    alert("Bạn đã bị đăng xuất do thay đổi quyền. Vui lòng đăng nhập lại.");
                    window.location.href = '/Webike/Logout'; // đừng quên thêm context path ở đây nữa
                }
            })
            .catch(err => {
                console.error("❌ Lỗi khi gọi checkForceLogout:", err);
            });
    }, 20000);
}