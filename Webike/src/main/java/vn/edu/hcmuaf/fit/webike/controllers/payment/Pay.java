package vn.edu.hcmuaf.fit.webike.controllers.payment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Order;
import vn.edu.hcmuaf.fit.webike.models.OrderItem;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet(name = "Pay", value = "/pay")
public class Pay extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDAO dao = new PaymentDAO();

        Order order = (Order) request.getSession().getAttribute("order");
        String method = request.getParameter("method");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double remain = Double.parseDouble(request.getParameter("remain"));
        String appointment = request.getParameter("appointment");
        String address = request.getParameter("address");
        String status = "Đã cọc";
        int accountID = Integer.parseInt(request.getParameter("accountID"));

        String branch = request.getParameter("branch");
        StringTokenizer t = new StringTokenizer(branch, "-");
        int shopID = Integer.parseInt(t.nextToken());

        order.getData();

        int oid = dao.insertOrder(deposit, remain, address, appointment, null, status, accountID, shopID);
        System.out.println("Order id:" + oid);


        for (OrderItem o : order.getData()) {
            ProductDAO productDAO = new ProductDAO();
            int quantity = o.getQuantity();
            String color = o.getColor();
            int pid = Integer.parseInt(o.getProductID());
            String img = o.getImg();
            Product p = productDAO.getProduct(pid);
            int productQuantity = p.getQuantity() - quantity;
            int updateProductQuantity = productDAO.updateQuantity(pid, productQuantity);
            int insertOrderItem = dao.insertOrderItem(quantity, img, color, oid, pid);
        }


        response.sendRedirect("list-products");
        request.getSession().removeAttribute("order");

    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        PaymentDAO dao = new PaymentDAO();
//        Order order = (Order) request.getSession().getAttribute("order");
//
////        double deposit = Double.parseDouble(request.getParameter("deposit"));
////        double remain = Double.parseDouble(request.getParameter("remain"));
////        String appointment = request.getParameter("appointment");
////        String address = request.getParameter("address");
////        String status = "Đã cọc";
////        int accountID = Integer.parseInt(request.getParameter("accountID"));
////
////        // branch là chi nhánh =))
////        String branch = request.getParameter("branch");
////        StringTokenizer t = new StringTokenizer(branch, "-");
////        int shopID = Integer.parseInt(t.nextToken());
//
//        int oid = Integer.parseInt(request.getParameter("vnp_TxnRef"));
//        double deposit = (double) request.getAttribute("vnp_Amount");
//        double remain = (double) request.getSession().getAttribute("remain");
//        String appointment = (String) request.getSession().getAttribute("appointment");
//        String payDate = request.getParameter("vnp_CreateDate");
//        String address = (String) request.getSession().getAttribute("address");
//        String status = request.getParameter("vnp_ResponseCode");
//        int accountID = (int) request.getSession().getAttribute("accountID");
//        int shopID= (int) request.getSession().getAttribute("shopID");
//
//
//        int insertOrder = dao.insertOrder(oid, deposit, remain, address, appointment, null, status, accountID, shopID);
//        System.out.println("Order id:" + oid);
//        System.out.println("Order insert:" + insertOrder);
//        System.out.println("Pay date: " + payDate);
//
//        request.getSession().setAttribute("oid", oid);
//        request.getSession().setAttribute("deposit", deposit);
//
//
////        for (OrderItem o : order.getData()) {
////            ProductDAO productDAO = new ProductDAO();
////            int quantity = o.getQuantity();
////            String color = o.getColor();
////            int pid = Integer.parseInt(o.getProductID());
////            String img = o.getImg();
////            Product p = productDAO.getProduct(pid);
////            int productQuantity= p.getQuantity() - quantity;
////            int updateProductQuantity = productDAO.updateQuantity(pid, productQuantity);
////            int insertOrderItem = dao.insertOrderItem(quantity, img, color, oid, pid);
////        }
//        response.sendRedirect("/Webike/GKY/billing.jsp");
//        request.getSession().removeAttribute("order");
//    }
}