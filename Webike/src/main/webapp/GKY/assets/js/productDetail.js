function changeColor(pid, cid, colorName) {
    fetch('/Webike/changeColor?id=' + encodeURIComponent(pid) + '&cid=' + encodeURIComponent(cid) + '&colorName=' + encodeURIComponent(colorName))
        .then(response => response.text())
        .then(imgURL => {
            document.getElementById('img').src = imgURL;
            document.querySelectorAll('.colorButton.cursor__pointer')
                .forEach(btn => {btn.style.background = 'none';
                });
            document.getElementById(cid+ '-ColorID').style.background = "rgb(147, 157, 163)";
            document.getElementById("productColor").value = cid;
            document.getElementById("colorName").value = colorName;
            document.getElementById("productImg").value = imgURL;
        })
        .catch(error => console.error("Lỗi đổi màu:", error));
}

// AJAX thêm SP và Cart
document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById('addCartForm');
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        const params = new URLSearchParams(new FormData(form)).toString();
        fetch(form.action + '?' + params)
            .then(res => res.json())
            .catch(err => {
                console.error("Thêm vào giỏ hàng ko thành công:", err);
            });
    });
});