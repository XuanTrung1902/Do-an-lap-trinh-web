
// các loại thông số trong thông số kỹ thuật ra chi tiết
function toggleSubOptions(id, element) {
    var text = document.getElementById("text");
    var optionValue = element.getAttribute("value");
    
    var subOptions = document.getElementById(id);
    if (subOptions.style.display === "none" || subOptions.style.display === "") {
        subOptions.style.display = "block";
        // text.textContent = "Text: " + optionValue;
    } else {
        subOptions.style.display = "none";
        // text.textContent = "Text:";
    }
}