const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);


// slider for product
const products = $$('.box__bike--item');
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

// pagination for product
const paginationLink = document.getElementsByClassName('pagination__link');
let currentPage = 1;

function changePage () {
    for(link of paginationLink) {
        link.classList.remove('pagination__link--active');
    }
    event.target.classList.add('pagination__link--active');
    currentPage = event.target.value;
}

function backBtn () {
    if(currentPage == 1) {
        currentPage = paginationLink.length;
    } else {
        currentPage--;
    }
    paginationLink[currentPage - 1].click();
}

function nextBtn () {
    if(currentPage == paginationLink.length) {
        currentPage = 1;
    } else {
        currentPage++;
    }
    paginationLink[currentPage - 1].click();
}

