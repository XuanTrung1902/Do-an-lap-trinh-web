package vn.edu.hcmuaf.fit.webike.controllers.payment;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.models.Shop;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowOrder", value = "/show-order")
public class ShowOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDAO dao = new PaymentDAO();

        List<Shop> shops = dao.getShops();
        request.setAttribute("shops", shops);

        request.getRequestDispatcher("GKY/payment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}