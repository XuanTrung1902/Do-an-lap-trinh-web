function updateCart(id, quantity) {
    fetch('/Webike/update-cart', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: `id=${id}&quantity=${quantity}`
    })
        .then(response => response.text())
        .then(() => {
            return fetch('/Webike/show-cart'); // Gửi yêu cầu lấy dữ liệu mới của giỏ hàng
        })
        .then(response => response.text())
        .then(data => {
            document.getElementById("main").innerHTML = data; // Cập nhật lại giỏ hàng
        })
        .catch(error => console.error('Lỗi:', error));
}
