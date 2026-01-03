package vn.edu.hcmuaf.fit.webike.controllers.admin.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import vn.edu.hcmuaf.fit.webike.GHN.Ultis.GHN_ultis;
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
        itemStatus();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("Admin/order_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void itemStatus() {
        OrderDAO dao = new OrderDAO();
        List<Order> orders = dao.getOrders();

        for (Order o : orders) {
            String oid = String.valueOf(o.getId());

            String order_code = dao.find_GHN_order_code_by_oid(oid);
            if (order_code == null || order_code.isEmpty()) {
                continue;
            }
            String json = GHN_ultis.generateJsonOrderCode(order_code);
            String ghnResponse = GHN_ultis.getOrderDetail(json);

            JSONObject jsonObj = new JSONObject(ghnResponse);
            JSONObject dataObj = jsonObj.getJSONObject("data");

            String leadtime = dataObj.getString("leadtime"); // tgian giao du kien
            leadtime = leadtime.substring(0, 10);

            String status = dataObj.getString("status"); // trang thai don

            switch (status) {
                case "delivering":
                    dao.updateOrderStatus(oid, "Đang giao");
                    dao.updateLeadTime(oid, leadtime);
                    break;
                case "ready_to_pick":
                    dao.updateOrderStatus(oid, "Đang chuẩn bị hàng");
                    dao.updateLeadTime(oid, leadtime);
                    break;
                case "delivery_fail":
                    dao.updateOrderStatus(oid, "Từ chối nhận hàng");
                    break;
                case "delivered":
                    dao.updateOrderStatus(oid, "Đã giao");
                    break;
                default:
                    // ko lam gi
                    break;
            }
        }
    }
}