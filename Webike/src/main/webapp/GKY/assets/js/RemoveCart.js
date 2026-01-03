function remove(id) {
    fetch(`/remove-cart`, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `id=${encodeURIComponent(id)}`
    })
        .then(response => response.text())
        .then(() => {
            return fetch(`/show-cart`);
        })
        .then(response => response.text())
        .then(data => {
            document.getElementById("main").innerHTML = data;
        })
        .catch(error => console.error(`Lỗi: ${error}`));
}

