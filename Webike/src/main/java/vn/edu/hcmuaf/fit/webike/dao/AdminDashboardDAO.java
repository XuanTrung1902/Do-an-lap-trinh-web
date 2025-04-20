package vn.edu.hcmuaf.fit.webike.dao;
import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;

import java.util.List;
import java.util.Map;

public class AdminDashboardDAO {
    
    // Lấy số khách hàng mới (giả sử trong 30 ngày gần nhất)
    public int getNewCustomers() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "SELECT COUNT(*) FROM accounts WHERE created >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)";
        return jdbi.withHandle(handle -> handle.createQuery(sql).mapTo(Integer.class).one());
    }

    // Lấy danh sách khách hàng gần đây (3 khách hàng mới nhất)
    public List<Map<String, Object>> getRecentCustomers() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
            SELECT name, image 
            FROM accounts 
            ORDER BY created DESC 
            LIMIT 3
        """;
        return jdbi.withHandle(handle -> handle.createQuery(sql).mapToMap().list());
    }

    // Lấy số đơn hàng mới trong ngày hiện tại
    public int getNewOrdersToday() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
            SELECT COUNT(*) 
            FROM orders 
            WHERE DATE(appointment) = CURDATE()
        """;
        return jdbi.withHandle(handle -> handle.createQuery(sql).mapTo(Integer.class).one());
    }

    // Lấy doanh thu hôm nay (tổng tiền từ các đơn hàng đã thanh toán trong ngày)
    public double getTodayRevenue() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
            SELECT COALESCE(SUM(deposit + remain), 0) AS revenue
            FROM orders
            WHERE DATE(payDate) = CURDATE()
            AND status = 'Đã thanh toán'
        """;
        return jdbi.withHandle(handle -> handle.createQuery(sql).mapTo(Double.class).one());
    }

    // Lấy dữ liệu doanh thu theo tháng (tổng deposit + remain)
    public List<Map<String, Object>> getMonthlyRevenue() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
            SELECT DATE_FORMAT(payDate, '%Y-%m') AS month, COALESCE(SUM(deposit + remain), 0) AS revenue
            FROM orders
            WHERE status = 'Đã thanh toán'
            GROUP BY DATE_FORMAT(payDate, '%Y-%m')
            ORDER BY month ASC
            LIMIT 7
        """;
        return jdbi.withHandle(handle -> handle.createQuery(sql).mapToMap().list());
    }

    // Lấy dữ liệu đơn hàng theo tháng
    public List<Map<String, Object>> getMonthlyOrders() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
            SELECT DATE_FORMAT(appointment, '%Y-%m') AS month, COUNT(*) AS orderCount
            FROM orders
            GROUP BY DATE_FORMAT(appointment, '%Y-%m')
            ORDER BY month ASC
            LIMIT 7
        """;
        return jdbi.withHandle(handle -> handle.createQuery(sql).mapToMap().list());
    }
}
