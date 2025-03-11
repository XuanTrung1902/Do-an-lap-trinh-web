
let currentPage = 1;
const totalPages = document.querySelectorAll('.news-left').length;

function showPage(page) {
    if (page < 1 || page > totalPages) return;

    document.querySelectorAll('.news-left').forEach(group => {
        group.style.display = 'none';
    });


    const currentGroup = document.querySelector(`.news-left[data-page="${page}"]`);
    if (currentGroup) {
        currentGroup.style.display = 'flex';
    }


    updatePagination();
}


function updatePagination() {
    document.querySelectorAll('.pagination .page-number').forEach(pageElement => {
        pageElement.classList.remove('active');
        if (parseInt(pageElement.textContent) === currentPage) {
            pageElement.classList.add('active');
        }
    });


    document.querySelector('.prev').disabled = currentPage === 1;
    document.querySelector('.next').disabled = currentPage === totalPages;
}


function setPage(page) {
    if (page < 1 || page > totalPages) return;
    currentPage = page;
    showPage(currentPage);
}


function changePage(step) {
    const newPage = currentPage + step;
    if (newPage >= 1 && newPage <= totalPages) {
        setPage(newPage);
    }
}


document.addEventListener('DOMContentLoaded', () => {
    showPage(currentPage);
});
