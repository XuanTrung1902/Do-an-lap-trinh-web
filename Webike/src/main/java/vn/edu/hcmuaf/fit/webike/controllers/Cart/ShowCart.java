package vn.edu.hcmuaf.fit.webike.controllers.Cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.CartDAO;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.models.CartItem;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowCart", value = "/show-cart")
public class ShowCart extends HttpServlet {
    final String LEVEL_INFO = LogService.LEVEL_INFO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.setData(user.getId());

        LogService.log(LEVEL_INFO, "Xem giỏ hàng", user.getId()+"","", "");
        request.getRequestDispatcher("GKY/cart.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}