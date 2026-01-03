function changeColor(pid, cid, colorName) {
    fetch('/changeColor?id=' + encodeURIComponent(pid) + '&cid=' + encodeURIComponent(cid) + '&colorName=' + encodeURIComponent(colorName))
        .then(response => response.text())
        .then(imgURL => {
            document.getElementById('img').src = imgURL;
            document.querySelectorAll('.colorButton.cursor__pointer')
                .forEach(btn => {btn.style.background = 'none';
                });
            document.getElementById(cid+ '-ColorID').style.background = "rgb(147, 157, 163)";

            // add cart form
            document.getElementById("productColor").value = cid;
            document.getElementById("colorName").value = colorName;
            document.getElementById("productImg").value = imgURL;

            // direct buy form
            document.getElementById("directBuyColor").value = cid;
            document.getElementById("directBuyImg").value = imgURL;


        })
        .catch(error => console.error("Lỗi đổi màu:", error));
}

// AJAX thêm SP và Cart
document.addEventListener("DOMContentLoaded", function () {
    // lấy gtri cid từ URL (khi vào trang productDetail, màu sắc mặc định được chọn là màu của cid)
    const cid = new URLSearchParams(window.location.search).get('cid');
    document.getElementById(cid + '-ColorID').style.background = "rgb(147, 157, 163)";

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