package vn.edu.hcmuaf.fit.webike.controllers.admin.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.OrderDAO;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.models.*;

import java.io.IOException;
import java.util.LinkedHashMap;
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
        List<OrderItem> itemList = dao.getOrderItems(oid);

        LinkedHashMap<Integer, List<Color>> colorMap = new LinkedHashMap<>();
        for (OrderItem item : itemList) {
            colorMap.put(item.getProductID(), dao.mapOfColorsAndProductID(item.getProductID()));
        }

        request.setAttribute("order", o);
        request.setAttribute("shops", shops);
        request.setAttribute("branch", branch);
        request.setAttribute("status", status);
        request.setAttribute("itemList", itemList);
        request.setAttribute("colorMap", colorMap);

        request.getRequestDispatcher("Admin/order_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO dao = new OrderDAO();

        int oid = Integer.parseInt(request.getParameter("oid"));
        String phoneNum = request.getParameter("phoneNum");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String appointment = request.getParameter("appointment");
        String payDate = request.getParameter("payDate");
        int shopID = Integer.parseInt(request.getParameter("branch")); // chi nhánh
        int update = dao.updateOrder(oid, phoneNum, address,status, appointment, payDate, shopID);
        response.sendRedirect("order-list");

    }
}