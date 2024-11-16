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

document.addEventListener('DOMContentLoaded', function() {
    const dashboardItems = document.querySelectorAll('.dashboard__item');
    dashboardItems.forEach((item, index) => {
        setTimeout(() => {
            item.style.opacity = 1;
            item.style.transform = 'translateY(0)';
        }, index * 100);
    });
});

document.addEventListener('DOMContentLoaded', function() {
    const dashboardItems = document.querySelectorAll('.dashboard__item');
    dashboardItems.forEach((item, index) => {
        setTimeout(() => {
            item.style.opacity = 1;
            item.style.transform = 'translateY(0)';
        }, index * 100);
    });

    const revenueCtx = document.getElementById('revenueChart').getContext('2d');
    const ordersCtx = document.getElementById('ordersChart').getContext('2d');

    const revenueChart = new Chart(revenueCtx, {
        type: 'line',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
            datasets: [{
                label: 'Doanh thu',
                data: [12000, 15000, 18000, 20000, 22000, 25000, 30000],
                backgroundColor: 'rgba(238, 77, 45, 0.2)',
                borderColor: 'rgba(238, 77, 45, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    const ordersChart = new Chart(ordersCtx, {
        type: 'bar',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
            datasets: [{
                label: 'Đơn hàng',
                data: [30, 50, 40, 60, 70, 80, 90],
                backgroundColor: 'rgba(238, 77, 45, 0.2)',
                borderColor: 'rgba(238, 77, 45, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});
