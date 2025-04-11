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
    }

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
            int productQuantity= p.getQuantity() - quantity;
            int updateProductQuantity = productDAO.updateQuantity(pid, productQuantity);
            int insertOrderItem = dao.insertOrderItem(quantity, img, color, oid, pid);
        }


        response.sendRedirect("list-products");
        request.getSession().removeAttribute("order");

    }
}