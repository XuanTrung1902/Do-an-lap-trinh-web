// hiện ra các loại thông số trong thông số kỹ thuật ra chi tiết
function toggleSubOptions(id, element) {
    var subOptions = document.getElementById(id);
    if (subOptions.style.display === "none" || subOptions.style.display === "") {
        subOptions.style.display = "block";
    } else {
        subOptions.style.display = "none";
    }
}