package vn.edu.hcmuaf.fit.webike.controllers.Cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.JSONObject;
import vn.edu.hcmuaf.fit.webike.models.Cart;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "RemoveCart", value = "/remove-cart")
public class RemoveCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }
        }

        JSONObject jsonObject = new JSONObject(jsonBuffer.toString());
        String id = jsonObject.getString("id");

        HttpSession cartSession = request.getSession(true);
        Cart cart = (Cart) cartSession.getAttribute("cart");

        if (cart == null) cart = new Cart();
        cart.remove(id);
        cartSession.setAttribute("cart", cart);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new JSONObject().put("isSuccess", true).toString());

    }
}