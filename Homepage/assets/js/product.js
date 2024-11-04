const products = document.querySelectorAll('.box__bike--item');
let counter = 0; 

function left () {
    if(counter == 0 ) {
        counter = products.length/3 - 1;
    } else {
        counter--;
    }
    scroll();
}

function right () {
    if(counter == products.length/3 - 1) {
        counter = 0;
    } else {
        counter++;
    }
    scroll();
}

function scroll() {
    products.forEach(function(item){
        item.style.transform = `translateX(-${counter * 100}%)`;
    })
}