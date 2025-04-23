// thay doi mau xe dua theo lua chon
function changeBikeColor(id) {
    var imgscr = document.getElementById("img");
    var btnid = document.getElementById(id);
    if (btnid.id == "red") {
        imgscr.src = "assets/img/ducati red.png";
        btnid.style.background = "rgb(147, 157, 163)";
        document.getElementById("black").style.background = "none"
    } else if (btnid.id) {
        imgscr.src = "assets/img/ducati black.png";
        btnid.style.background = "rgb(147, 157, 163)";
        document.getElementById("red").style.background = "none"
    }
}

function changeColor(id) {
    fetch('/Webike/productDetail', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'color=' + encodeURIComponent(id) + '&id=' + encodeURIComponent(productId)
    })
        .then(response => response.json())
        .then(data => {
            if (data.imgUrl) {
                document.getElementById('img').src = data.imgUrl;

                document.querySelectorAll('.colorButton').forEach(btn => {
                    btn.style.background = (btn.id === id) ? "rgb(147, 157, 163)" : "none";
                });

                // Cập nhật hidden input để form gửi đúng ảnh & màu
                document.getElementById("productColor").value = id;
                document.getElementById("productImg").value = data.imgUrl;
                document.getElementById("directBuyColor").value = id;
                document.getElementById("directBuyImg").value = data.imgUrl;
            }
        })
        .catch(error => console.error("Lỗi đổi màu:", error));
}

