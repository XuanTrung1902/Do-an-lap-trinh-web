package vn.edu.hcmuaf.fit.webike.controllers.Cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.JSONObject;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "RemoveCart", value = "/remove-cart")
public class RemoveCart extends HttpServlet {

    final String LEVEL_ALERT = LogService.LEVEL_ALERT;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String cartOld = cart.toString();
        User user = (User) request.getSession().getAttribute("auth");
        cart.remove(id);
        LogService.log(LEVEL_ALERT, "Xóa sản phẩm trong giỏ hàng", user.getPhoneNum(),cartOld , cart.toString());

        request.getRequestDispatcher("GKY/cart.jsp").forward(request, response);
    }
}