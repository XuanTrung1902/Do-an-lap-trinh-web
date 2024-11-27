const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

// 
const menuLi = $$('.admin__sidebar--content ul > li > a');
const subMenu = $$('.sub-menu');
menuLi.forEach((item, index) => {
    item.onclick = function(e) {
        e.preventDefault();
        // menuLi[index].parentNode.querySelector('ul').classList.toggle('active');
        for (let i = 0; i < subMenu.length; i++) {
            subMenu[i].setAttribute('style',`height: 0px`);
        }
        const subMenuHeight = menuLi[index].parentNode.querySelector('ul .sub-menu-items').offsetHeight;
        menuLi[index].parentNode.querySelector('ul').setAttribute('style',`height: ${subMenuHeight}px`);
    }
});

// loading animation for table rows
const adminContentMainContainer = $('.admin-content-main-container');
const tableRows = $$('.admin-content-main-container table tbody tr');

window.addEventListener('load', () => {
    adminContentMainContainer.classList.add('fade-in');
    tableRows.forEach((row, index) => {
        setTimeout(() => {
            row.classList.add('slide-in');
        }, index * 100); // Delay each row animation
    });
});

// Add hover effect to table rows
tableRows.forEach(row => {
    row.addEventListener('mouseover', () => {
        row.classList.add('hovered');
    });
    row.addEventListener('mouseout', () => {
        row.classList.remove('hovered');
    });
});

// Filtering functionality
const filterDropdown = $('#order-status-filter');
// const tableRows = $$('.admin-content-main-container table tbody tr');

filterDropdown.addEventListener('change', () => {
    const filterValue = filterDropdown.value;
    tableRows.forEach(row => {
        const statusCell = row.querySelector('.coform-order');
        if (filterValue === 'all' || statusCell.classList.contains(filterValue)) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
});