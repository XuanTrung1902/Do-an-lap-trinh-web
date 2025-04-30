// slider for product
const products = document.querySelectorAll(".box__bike--item");
let counter = 0;

function sliderToLeft() {
    if (counter == 0) {
        counter = products.length / 3 - 1;
    } else {
        counter--;
    }
    scroll();
}

function sliderToRight() {
    if (counter == products.length / 3 - 1) {
        counter = 0;
    } else {
        counter++;
    }
    scroll();
}

function scroll() {
    products.forEach(function (item) {
        item.style.transform = `translateX(-${counter * 100}%)`;
    });
}

// Lọc sp theo hãng
function sort() {
    // Lấy tất cả các checkbox được chọn
    const checkedBrands = Array.from(
        document.querySelectorAll('input.filter-checkbox[name="brand"]:checked'))
        .map(brands => brands.value);

    const formBody = checkedBrands.map(brands => `brands=${encodeURIComponent(brands)}`).join('&');

    fetch('/Webike/list-products', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: formBody
    })
        .then(response => response.text())
        .then(data => {
            document.getElementById("app").innerHTML = data;
        })
        .catch(error => console.error('Lỗi:', error));
}
