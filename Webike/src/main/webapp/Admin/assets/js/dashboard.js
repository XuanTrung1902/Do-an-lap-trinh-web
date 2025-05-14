// Xử lý animation cho dashboard items
document.addEventListener('DOMContentLoaded', function() {
    const dashboardItems = document.querySelectorAll('.dashboard__item');
    dashboardItems.forEach((item, index) => {
        setTimeout(() => {
            item.style.opacity = 1;
            item.style.transform = 'translateY(0)';
        }, index * 100);
    });

    // Sử dụng biến toàn cục thay vì parse trực tiếp
    const revenueData = window.revenueData;
    const ordersData = window.ordersData;

    // console.log('Revenue Data:', revenueData);
    // console.log('Orders Data:', ordersData);

    // Sắp xếp dữ liệu theo thời gian
    revenueData.sort((a, b) => new Date(a.month) - new Date(b.month));
    ordersData.sort((a, b) => new Date(a.month) - new Date(b.month));

    const revenueLabels = revenueData.map(item => item.month);
    const revenueValues = revenueData.map(item => item.revenue);
    const ordersLabels = ordersData.map(item => item.month);
    const ordersValues = ordersData.map(item => item.ordercount);

    const revenueCtx = document.getElementById('revenueChart').getContext('2d');
    const ordersCtx = document.getElementById('ordersChart').getContext('2d');

    const revenueChart = new Chart(revenueCtx, {
        type: 'line',
        data: {
            labels: revenueLabels, // Chỉ hiển thị các tháng có dữ liệu
            datasets: [{
                label: 'Doanh thu',
                data: revenueValues,
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
            labels: revenueLabels, // Chỉ hiển thị các tháng có dữ liệu
            labels: ordersLabels,
            datasets: [{
                label: 'Đơn hàng',
                data: ordersValues,
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