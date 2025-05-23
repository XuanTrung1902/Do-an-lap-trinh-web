package vn.edu.hcmuaf.fit.webike.controllers.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "UpdateCart", value = "/update-cart")
public class UpdateCart extends HttpServlet {

    final String LEVEL_ALERT = LogService.LEVEL_ALERT;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = (User) request.getSession().getAttribute("auth");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String cartOld = cart.toString();
        cart.update(id, quantity);

        LogService.log(LEVEL_ALERT, "Câập nhật sản phẩm trong giỏ hàng", user.getPhoneNum(),cartOld , cart.toString());
        request.getRequestDispatcher("GKY/cart.jsp").forward(request, response);
    }
}