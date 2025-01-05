package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.io.IOException;

@WebServlet(name = "AddCart", value = "/add-Cart")
public class AddCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProductDAO dao = new ProductDAO();
        Product p = dao.getProduct(Integer.parseInt(request.getParameter("id")));

        HttpSession session = request.getSession(true);
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) cart = new Cart();
        cart.add(p);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp?addCart=ok");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}