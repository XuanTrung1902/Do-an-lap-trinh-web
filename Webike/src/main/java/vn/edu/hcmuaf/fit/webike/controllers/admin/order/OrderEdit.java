package vn.edu.hcmuaf.fit.webike.controllers.admin.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import vn.edu.hcmuaf.fit.webike.GHN.Ultis.GHN_ultis;
import vn.edu.hcmuaf.fit.webike.dao.OrderDAO;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.models.*;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet(name = "OrderEdit", value = "/order-edit")
public class OrderEdit extends HttpServlet {
    final String LEVEL_INFO = LogService.LEVEL_INFO;
    final String LEVEL_ALERT = LogService.LEVEL_ALERT;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oid = Integer.parseInt(request.getParameter("oid"));
        User user = (User) request.getSession().getAttribute("auth");
        String username = request.getParameter("username");
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

        request.setAttribute("username", username);
        request.setAttribute("order", o);
        request.setAttribute("shops", shops);
        request.setAttribute("branch", branch);
        request.setAttribute("status", status);
        request.setAttribute("itemList", itemList);
        request.setAttribute("colorMap", colorMap);
        LogService.log(LEVEL_INFO, "Truy cập chỉnh sửa đơn hàng", user.getId()+"",oid+"" ,"" );
        request.getRequestDispatcher("Admin/order_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        OrderDAO dao = new OrderDAO();
        String username = request.getParameter("username");
        int oid = Integer.parseInt(request.getParameter("oid"));
        Order oOLd = dao.getOrdersByID(oid);
        String phoneNum = request.getParameter("phoneNum");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String appointment = request.getParameter("appointment");
        String payDate = request.getParameter("payDate");
        int shopID = Integer.parseInt(request.getParameter("branch")); // chi nhánh
        int update = dao.updateOrder(oid, phoneNum, address,status, appointment, payDate, shopID);
        Order oNew = dao.getOrdersByID(oid);
        LogService.log(LEVEL_ALERT, "Chỉnh sửa đơn hàng",user.getId()+"", oOLd.toString(), oNew.toString());

        if (status.equalsIgnoreCase("Đã thanh toán")) {
            String json = GHN_ultis.generateJsonOrder(oid, username, phoneNum, address);
            String ghnResponse = GHN_ultis.createOrder(json);
            System.out.println("GHN RESPONSE: " + ghnResponse);

            JSONObject jsonObj = new JSONObject(ghnResponse);
            JSONObject dataObj = jsonObj.getJSONObject("data");
            String order_code = dataObj.getString("order_code");

            dao.insert_order_code(oid, order_code);
        }
        response.sendRedirect("order-list");
    }
}