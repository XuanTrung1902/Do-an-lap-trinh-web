package vn.edu.hcmuaf.fit.webike.controllers.payment;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.models.CartItem;
import vn.edu.hcmuaf.fit.webike.models.Order;
import vn.edu.hcmuaf.fit.webike.models.Shop;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartBuy", value = "/cart-buy")
public class CartBuy extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDAO dao = new PaymentDAO();
        List<Shop> shops = dao.getShops();

        String method = "from cart";
        String total = request.getParameter("total");

        Cart cart= (Cart) request.getSession().getAttribute("cart");
        Order order = new Order();
        double percent = 0.25;
        List<CartItem> ls= cart.getList();
        order.add(cart, null, method, null, null, null);

        request.getSession().setAttribute("order", order);
        request.setAttribute("method", method);
        request.setAttribute("order", order);
        request.setAttribute("percent", percent);
        request.setAttribute("total", total);
        request.setAttribute("shops", shops);
        request.getRequestDispatcher("GKY/payment.jsp").forward(request, response);

    }
}