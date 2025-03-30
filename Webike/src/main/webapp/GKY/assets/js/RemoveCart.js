function remove(itemId) {
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

