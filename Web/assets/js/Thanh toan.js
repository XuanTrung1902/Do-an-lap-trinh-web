
// Hàm để hiển thị hoặc ẩn div
function showAddressSection() {
    const option1 = document.getElementById("option1");
    const addressDiv = document.getElementById("address");
    const deposit = document.getElementById("deposit");
    const shipping = document.getElementById("shipping");



    if (option1.checked) {
        addressDiv.style.display = "flex";
        // shipping.style.display = "flex";
        // deposit.style.display = "none";

    } else {
        addressDiv.style.display = "none";
        // deposit.style.display = "flex";
        // shipping.style.display = "none";

    }
}