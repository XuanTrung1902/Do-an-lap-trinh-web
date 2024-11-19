// nut xoa sp khoi gio hang
function deleteProduct(list ,id) {
    const product = document.getElementById(id);
    const listProduct = document.getElementById(list);
    const toastLiveExample = document.getElementById('liveToast');

    product.style.display = "none";
    console.log("Xóa sản phẩm với ID:", listProduct);
    if (product) {
        const toast = bootstrap.Toast.getOrCreateInstance(toastLiveExample);
        // const toast = new bootstrap.Toast(toastLiveExample);
        product.addEventListener('click', () => {
            toast.show()
        })
    }
}

