// const $ = document.querySelector.bind(document);
// const $$ = document.querySelectorAll.bind(document);
//
// //
// const menuLi = $$('.admin__sidebar--content ul > li > a');
// const subMenu = $$('.sub-menu');
// menuLi.forEach((item, index) => {
//     item.onclick = function(e) {
//         e.preventDefault();
//         // menuLi[index].parentNode.querySelector('ul').classList.toggle('active');
//         for (let i = 0; i < subMenu.length; i++) {
//             subMenu[i].setAttribute('style',`height: 0px`);
//         }
//         const subMenuHeight = menuLi[index].parentNode.querySelector('ul .sub-menu-items').offsetHeight;
//         menuLi[index].parentNode.querySelector('ul').setAttribute('style',`height: ${subMenuHeight}px`);
//     }
// });
//
// // loading animation for table rows
// const adminContentMainContainer = $('.admin-content-main-container');
// const tableRows = $$('.admin-content-main-container table tbody tr');
//
// window.addEventListener('load', () => {
//     adminContentMainContainer.classList.add('fade-in');
//     tableRows.forEach((row, index) => {
//         setTimeout(() => {
//             row.classList.add('slide-in');
//         }, index * 100); // Delay each row animation
//     });
// });
//
// // Add hover effect to table rows
// tableRows.forEach(row => {
//     row.addEventListener('mouseover', () => {
//         row.classList.add('hovered');
//     });
//     row.addEventListener('mouseout', () => {
//         row.classList.remove('hovered');
//     });
// });
//
// // Filtering functionality
// const filterDropdown = $('#order-status-filter');
// const searchInput = $('#searchInput');
//
// function filterOrders() {
//     const filterValue = filterDropdown.value.toLowerCase();
//     const searchValue = searchInput.value.toLowerCase();
//
//     tableRows.forEach(row => {
//         const statusCell = row.querySelector('.coform-order');
//         const nameCell = row.querySelector('td:nth-child(2)').textContent.toLowerCase();
//
//         const matchesStatus = filterValue === 'all' || statusCell.classList.contains(filterValue);
//         const matchesName = nameCell.includes(searchValue);
//
//         if (matchesStatus && matchesName) {
//             row.style.display = '';
//         } else {
//             row.style.display = 'none';
//         }
//     });
// }
//
// filterDropdown.addEventListener('change', filterOrders);
// searchInput.addEventListener('input', filterOrders);

const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

// Hàm loại bỏ dấu tiếng Việt và chuẩn hóa chuỗi
function removeVietnameseDiacritics(str) {
    return str
        .normalize('NFD') // Tách dấu ra khỏi ký tự
        .replace(/[\u0300-\u036f]/g, '') // Xóa các dấu
        .replace(/đ/g, 'd') // Thay 'đ' bằng 'd'
        .replace(/Đ/g, 'D') // Thay 'Đ' bằng 'D'
        .toLowerCase(); // Chuyển về chữ thường
}

// Sidebar menu toggle functionality
const menuLi = $$('.admin__sidebar--content ul > li > a');
const subMenu = $$('.sub-menu');
menuLi.forEach((item, index) => {
    item.onclick = function(e) {
        e.preventDefault();
        for (let i = 0; i < subMenu.length; i++) {
            subMenu[i].setAttribute('style', `height: 0px`);
        }
        const subMenuHeight = menuLi[index].parentNode.querySelector('ul .sub-menu-items').offsetHeight;
        menuLi[index].parentNode.querySelector('ul').setAttribute('style', `height: ${subMenuHeight}px`);
    };
});

// Loading animation for table rows
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
const searchInput = $('#searchInput');
const searchButton = $('.search-button');

function filterOrders() {
    const filterValue = filterDropdown.value.toLowerCase();
    const searchValue = removeVietnameseDiacritics(searchInput.value.trim());

    tableRows.forEach(row => {
        // Lấy tên (cột thứ 2) và trạng thái (cột thứ 8)
        const nameCell = removeVietnameseDiacritics(row.querySelector('td:nth-child(2)').textContent);
        const statusCell = removeVietnameseDiacritics(row.querySelector('td:nth-child(8)').textContent);

        // Kiểm tra trạng thái
        let matchesStatus = true;
        if (filterValue !== 'all') {
            if (filterValue === 'success' && statusCell !== 'da thanh toan') matchesStatus = false;
            if (filterValue === 'warning' && statusCell !== 'da coc') matchesStatus = false;
            if (filterValue === 'pending' && statusCell !== 'da giao') matchesStatus = false;
            if (filterValue === 'cancel' && statusCell !== 'da huy') matchesStatus = false;
        }

        // Kiểm tra tên
        const matchesName = nameCell.includes(searchValue);

        // Hiển thị hoặc ẩn dòng dựa trên cả hai bộ lọc
        if (matchesStatus && matchesName) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
}

filterDropdown.addEventListener('change', filterOrders);
searchInput.addEventListener('input', filterOrders);
searchButton.addEventListener('click', filterOrders);