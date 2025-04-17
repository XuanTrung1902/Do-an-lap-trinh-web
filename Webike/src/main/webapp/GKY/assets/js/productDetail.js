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

function changeBikeColor(id) {
    fetch(`/Webike/remove-cart`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({id: itemId})
    })
        .then(response => response.json())
        .then(data => {
            if (data.isSuccess) {
                return fetch(`/Webike/show-cart`);
            }
        })
        .then(response => response.text())
        .then(html => {
            document.getElementById("main").innerHTML = html;
        })
        .catch(error => console.error(`Lỗi: ${error}`));
}

