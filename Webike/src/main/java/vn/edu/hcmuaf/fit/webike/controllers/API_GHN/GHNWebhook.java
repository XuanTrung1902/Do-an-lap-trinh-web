package vn.edu.hcmuaf.fit.webike.controllers.API_GHN;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.GHN.GHN_config.GHN_Config;
import vn.edu.hcmuaf.fit.webike.dao.OrderDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GHNWebhook", value = "/ghn-webhook")
public class GHNWebhook extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }
        }
        JsonObject json = JsonParser.parseString(jsonBuffer.toString()).getAsJsonObject();

        // ktra webhook
        System.out.println("Webhook data received: " + json.toString());

        String tokenHeader = request.getHeader("Token");
        if (tokenHeader != null && !tokenHeader.equals(GHN_Config.TOKEN)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return;
        }

        // cac truong lay tu webhook
        String orderCode = json.get("OrderCode").getAsString();
        String status = json.get("Status").getAsString();

        OrderDAO dao = new OrderDAO();
        String oid = dao.find_oid_by_GHN_order_code(orderCode);

        switch (status){
            case "delivering":
                dao.updateOrderStatus(oid, "Đang giao");
            case "ready_to_pick":
                dao.updateOrderStatus(oid, "Đang chuẩn bị hàng");
            case "delivery_fail":
                dao.updateOrderStatus(oid, "Từ chối nhận hàng");
            case "delivered":
                dao.updateOrderStatus(oid, "Đã giao");
        }

        // tra ve response cho GHN
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"message\": \"Webhook received successfully\"}");
        out.flush();
    }
}
