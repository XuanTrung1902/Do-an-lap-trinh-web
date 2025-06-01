package vn.edu.hcmuaf.fit.webike.controllers.admin.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.OrderDAO;
import vn.edu.hcmuaf.fit.webike.models.OrderItem;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderDetail", value = "/order-detail")
public class OrderDetail extends HttpServlet {
    final String LEVEL_INFO = LogService.LEVEL_INFO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oid = Integer.parseInt(request.getParameter("oid"));
        User user = (User) request.getSession().getAttribute("auth");
        OrderDAO dao = new OrderDAO();
        List<OrderItem> ls = dao.getOrderItems(oid);

        request.setAttribute("ls", ls);
        LogService.log(LEVEL_INFO, "Truy cập chi tiết đơn hàng", user.getId()+"", "orderID=" + oid, null);

        request.getRequestDispatcher("Admin/order_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}