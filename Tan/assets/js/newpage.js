document.querySelector('.header__navbar-news > a').addEventListener('click', function (e) {
    e.preventDefault();
    const dropdown = document.querySelector('.news-dropdown');
    dropdown.style.display = dropdown.style.display === 'block' ? 'none' : 'block';
});

let currentPage = 1;
const totalPages = 3;

function setPage(page) {
    if (page < 1 || page > 3) return;
    currentPage = page;
    updatePagination();
}

function changePage(step) {
    if (currentPage === 3 && step === 1) return;
    if (currentPage === 1 && step === -1) return;
    setPage(currentPage + step);
}

function updatePagination() {

    document.querySelectorAll('.pagination .page-number').forEach(page => {
        page.classList.remove('active');
        if (parseInt(page.textContent) === currentPage) {
            page.classList.add('active');
        }
    });


    document.querySelector('.prev').disabled = currentPage === 1;
    document.querySelector('.next').disabled = currentPage === 3;
}


updatePagination();
