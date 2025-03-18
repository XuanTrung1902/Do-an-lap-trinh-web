function sendRequest() {
    const name = document.getElementById("nameInput").value;
    if (!name) {
        alert("Vui lòng nhập tên!");
        return;
    }

    fetch(`/Webike/hello`, {  // Dùng template literal để đảm bảo định dạng đúng
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `name=${encodeURIComponent(name)}` // Dùng template literal thay vì chuỗi cộng
    })
        .then(response => response.text())  // Phản hồi là text
        .then(data => {
            document.getElementById("responseText").textContent = `${data}`; // Dùng `` thay vì +
        })
        .catch(error => console.error(`Lỗi: ${error}`));
}
