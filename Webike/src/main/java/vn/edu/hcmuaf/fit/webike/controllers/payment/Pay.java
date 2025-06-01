package vn.edu.hcmuaf.fit.webike.controllers.payment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.*;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "Pay", value = "/pay")
public class Pay extends HttpServlet {
    final String LEVEL_INFO = LogService.LEVEL_INFO;
    final String LEVEL_ALERT = LogService.LEVEL_ALERT;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PaymentDAO dao = new PaymentDAO();
        UserDao userDao = new UserDao();
        Order order = (Order) request.getSession().getAttribute("order");

        double deposit = Double.parseDouble(request.getParameter("vnp_Amount")) / 100; // chia 100k vì mặc định vnp_Amount sẽ nhân thêm 100 đồng
        double remain = (double) request.getSession().getAttribute("remain");
        String phoneNum = (String) request.getSession().getAttribute("phoneNum");
        String appointment = (String) request.getSession().getAttribute("appointment");
        String depositDate = request.getParameter("vnp_PayDate");

        String address = (String) request.getSession().getAttribute("address");

        // lấy thông tin người dùng
        int accountID = (int) request.getSession().getAttribute("accountID");
        User user = userDao.getUserById(accountID);
        if (user != null) {
            request.setAttribute("userName", user.getName());
            request.setAttribute("phoneNum", user.getPhoneNum());
        } else {
            request.setAttribute("userName", "Không tìm thấy thông tin");
            request.setAttribute("phoneNum", "");
        }

        // lấy thông tin chi nhánh
        int shopID = (int) request.getSession().getAttribute("shopID");
        List<Shop> shops = dao.getShops();
        String shopAddress = "Không tìm thấy chi nhánh";
        for (Shop shop : shops) {
            if (shop.getId() == shopID) {
                shopAddress = shop.getAddress();
                break;
            }
        }
        request.setAttribute("shopAddress", shopAddress);
        String responseCode = request.getParameter("vnp_ResponseCode");

        String status = "";
        int oid = 0;
        if (responseCode.equalsIgnoreCase("00")) {
            status = "Đã cọc";
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = inputFormat.parse(depositDate);
                String formattedDate = outputFormat.format(date);
                order.setDepositDate(formattedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            oid = dao.insertOrder(phoneNum, deposit, remain, address, appointment, depositDate, null, status, accountID, shopID);
            Order orderOld = dao.getOrderById(oid);
            LogService.log(LEVEL_INFO, "Thanh toán", user.getId() + "", "", orderOld.toString());
        }else if (responseCode.equalsIgnoreCase("09") || responseCode.equalsIgnoreCase("24")) {
            status = "Đã hủy";
            oid = dao.insertOrder(phoneNum,0, 0, "", null, null,null, status, accountID, shopID);
            request.getSession().setAttribute("cancelMessage", "Bạn đã hủy thanh toán!");
            LogService.log(LEVEL_ALERT, "Hũy thanh toán", user.getId() + "", "", status);
        }

        request.setAttribute("orderItem", order.getData());
        for (OrderItem o : order.getData()) {
            ProductDAO productDAO = new ProductDAO();
            int quantity = o.getQuantity();
            Color color = o.getColor();
            int pid = o.getProductID();
            String img = o.getImg();

            Product p = productDAO.getProduct(pid);
            int productQuantity = p.getQuantity() - quantity;
            int updateProductQuantity = productDAO.updateQuantity(pid, productQuantity);
            int insertOrderItem = dao.insertOrderItem(quantity, img, color, oid, pid);
        }
        // chuyển hướng trang dựa theo trạng thái giao dịch
        switch (responseCode){
            case "00":
                request.getRequestDispatcher("GKY/billing.jsp").forward(request, response);
                break;
            case "09":
            case "24":
                response.sendRedirect(request.getContextPath() + "/list-products");
                break;
        }
    }
}