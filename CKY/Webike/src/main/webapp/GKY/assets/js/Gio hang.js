// nut xoa sp khoi gio hang
function deleteProduct(list ,id) {
    const product = document.getElementById(id);
    const listProduct = document.getElementById(list);
    const toastLiveExample = document.getElementById('liveToast');

    product.style.display = "none";
    // console.log("Xóa sản phẩm với ID:", listProduct);
    if (product) {
        const toast = bootstrap.Toast.getOrCreateInstance(toastLiveExample);
        // const toast = new bootstrap.Toast(toastLiveExample);
        product.addEventListener('click', () => {
            toast.show()
        })
    }
}

function cartItemChecked(){
    const cart = document.getElementById('cart')
    const brands = document.getElementsByClassName("brand")
    const items = document.getElementsByClassName("item")
    cart.addEventListener('change', () => {
        const isChecked = cart.checked; 
        for (let i = 0; i < brands.length; i++) {
            brands[i].checked = isChecked; 
        }
        for (let i = 0; i < items.length; i++) {
            items[i].checked = isChecked; 
        }
    });
}
function brandItemChecked(idBrand, idItem){
    const brand = document.getElementById(idBrand)
    const item = document.getElementsByClassName(idItem)
    const isChecked = brand.checked
    for (let i = 0; i < item.length; i++) {
        item[i].checked = isChecked;
    }
}
function increase(idText) {
    const quantity = document.getElementById(idText);
    let currentQuantity = parseInt(quantity.textContent);
    currentQuantity += 1;
    quantity.textContent = currentQuantity;
}

function decrease(idText) {
    const quantity = document.getElementById(idText);
    let currentQuantity = parseInt(quantity.textContent);
    currentQuantity = Math.max(1, currentQuantity - 1);
    quantity.textContent = currentQuantity;
}

