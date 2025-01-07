package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.io.IOException;

@WebServlet(name = "RemoveCart", value = "/remove-cart")
public class RemoveCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");


        HttpSession session = request.getSession(true);
        Cart cart = (Cart) session.getAttribute("cart");


        if (cart == null) cart = new Cart();
        cart.remove(id);
        session.setAttribute("cart", cart);

        request.getRequestDispatcher("GKY/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}