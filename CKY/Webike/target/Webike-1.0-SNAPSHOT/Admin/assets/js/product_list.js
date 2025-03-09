// const $ = document.querySelector.bind(document);
// const $$ = document.querySelectorAll.bind(document);

// 
const menuLi = document.querySelectorAll('.admin__sidebar--content ul > li > a');
const subMenu = document.querySelectorAll('.sub-menu');
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
const adminContentMainContainer = document.querySelector('.admin-content-main-container');
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
// document.querySelector('.search-button').addEventListener('click', function () {
//     const nameFilter = document.querySelector('.search-input[placeholder="Tên sản phẩm"]').value.toLowerCase();
//     const ccFilter = document.querySelector('.search-select').value;
//     const priceFrom = parseInt(document.querySelector('.search-input[placeholder="Giá từ"]').value) || 0;
//     const priceTo = parseInt(document.querySelector('.search-input[placeholder="Giá đến"]').value) || Infinity;
//     const rows = document.querySelectorAll('table tbody tr');
//
//     rows.forEach(row => {
//         const name = row.querySelector('td:nth-child(3)').textContent.toLowerCase();
//         const cc = parseInt(row.querySelector('td:nth-child(4)').textContent);
//         const priceText = row.querySelector('td:nth-child(5)').textContent.replace(/[^\d]/g, ''); // Bỏ dấu
//         const price = parseInt(priceText);
//
//         // Kiểm tra điều kiện lọc
//         const matchName = name.includes(nameFilter);
//         const matchCC = ccFilter === "" || (ccFilter === "150" && cc < 150) || (ccFilter === "200" && cc < 200) || (ccFilter === "250" && cc > 200);
//         const matchPrice = price >= priceFrom && price <= priceTo;
//
//         if (matchName && matchCC && matchPrice) {
//             row.style.display = '';
//         } else {
//             row.style.display = 'none';
//         }
//     });
// });

