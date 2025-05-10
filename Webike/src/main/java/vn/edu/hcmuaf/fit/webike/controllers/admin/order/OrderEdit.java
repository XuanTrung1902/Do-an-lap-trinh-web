package vn.edu.hcmuaf.fit.webike.controllers.admin.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.OrderDAO;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.models.Order;
import vn.edu.hcmuaf.fit.webike.models.OrderStatus;
import vn.edu.hcmuaf.fit.webike.models.Shop;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderEdit", value = "/order-edit")
public class OrderEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oid = Integer.parseInt(request.getParameter("oid"));
        OrderDAO dao = new OrderDAO();
        Order o = dao.getOrdersByID(oid);

        PaymentDAO pdao = new PaymentDAO();
        OrderDAO odao = new OrderDAO();
        List<Shop> shops = pdao.getShops();
        int branch = o.getShop().getId();
        List<OrderStatus> status = odao.getOrderStatus();

        request.setAttribute("order", o);
        request.setAttribute("shops", shops);
        request.setAttribute("branch", branch);
        request.setAttribute("status", status);

        request.getRequestDispatcher("Admin/order_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO dao = new OrderDAO();

        int oid = Integer.parseInt(request.getParameter("oid"));
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String appointment = request.getParameter("appointment");
        String payDate = request.getParameter("payDate");
        int shopID = Integer.parseInt(request.getParameter("branch"));
        int update = dao.updateOrder(oid, address, status, appointment, payDate, shopID);
        System.out.println(update);
        response.sendRedirect("order-list");

    }
}