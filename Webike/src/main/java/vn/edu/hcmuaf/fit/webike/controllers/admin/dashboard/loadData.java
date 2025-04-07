package vn.edu.hcmuaf.fit.webike.controllers.admin.dashboard;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.AdminDashboardDAO;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import com.fasterxml.jackson.databind.ObjectMapper; // Thêm import cho Jackson

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "loadData", value = "/dashboard")
public class loadData extends HttpServlet {
    private AdminDashboardDAO adminDashboaDAO;
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        adminDashboaDAO = new AdminDashboardDAO();
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tổng số sản phẩm
        int totalProducts = productDAO.getAllProducts().size();

        // Đơn hàng mới (đếm số đơn hàng trong ngày hiện tại)
        int newOrders = adminDashboaDAO.getNewOrdersToday();

        // Khách hàng mới (từ bảng accounts)
        int newCustomers = adminDashboaDAO.getNewCustomers();

        // Doanh thu hôm nay (tổng tiền từ các đơn hàng đã thanh toán trong ngày)
        double todayRevenue = adminDashboaDAO.getTodayRevenue();

        // Dữ liệu biểu đồ doanh thu (theo tháng)
        List<Map<String, Object>> revenueData = adminDashboaDAO.getMonthlyRevenue();

        // Dữ liệu biểu đồ đơn hàng (theo tháng)
        List<Map<String, Object>> ordersData = adminDashboaDAO.getMonthlyOrders();

        // Danh sách khách hàng gần đây
        List<Map<String, Object>> recentCustomers = adminDashboaDAO.getRecentCustomers();

        // Chuyển đổi dữ liệu thành JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String revenueDataJson = objectMapper.writeValueAsString(revenueData);
        String ordersDataJson = objectMapper.writeValueAsString(ordersData);

        // Đặt dữ liệu vào request attributes
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("newOrders", newOrders);
        request.setAttribute("newCustomers", newCustomers);
        request.setAttribute("todayRevenue", todayRevenue);
        request.setAttribute("revenueDataJson", revenueDataJson); // Truyền JSON
        request.setAttribute("ordersDataJson", ordersDataJson);   // Truyền JSON
        request.setAttribute("recentCustomers", recentCustomers);

        // Chuyển hướng đến trang admin.jsp
        request.getRequestDispatcher("/Admin/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}