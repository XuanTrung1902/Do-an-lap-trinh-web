
// Hàm để hiển thị hoặc ẩn div
function showAddressSection() {
    const option1 = document.getElementById("option1");
    const addressDiv = document.getElementById("address");
    const deposit = document.getElementById("deposit");
    const shipping = document.getElementById("shipping");
    const shop = document.getElementById("shop-address");

    if (option1.checked) {
        addressDiv.style.display = "flex";
        shipping.style.display = "block";
        deposit.style.display = "none";
        shop.style.display = "none";
    } else {
        addressDiv.style.display = "none";
        deposit.style.display = "block";
        shipping.style.display = "none";
        shop.style.display = "block";
    }
}