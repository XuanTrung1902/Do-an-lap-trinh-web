package vn.edu.hcmuaf.fit.webike.controllers.Cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.CartDAO;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.models.CartItem;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowCart", value = "/show-cart")
public class ShowCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.setData(user.getId());

        request.getRequestDispatcher("GKY/cart.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}