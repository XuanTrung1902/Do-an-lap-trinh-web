package vn.edu.hcmuaf.fit.webike.controllers.admin.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.OrderDAO;
import vn.edu.hcmuaf.fit.webike.models.Order;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderList", value = "/order-list")
public class OrderList extends HttpServlet {
    final String LEVEL_INFO = LogService.LEVEL_INFO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        OrderDAO dao = new OrderDAO();
        List<Order> orders = dao.getOrders();
        LogService.log(LEVEL_INFO, "Xem danh sách đơn hàng", user.getId()+"", "", "");
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("Admin/order_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}