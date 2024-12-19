package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Products;

import java.io.IOException;

@WebServlet(name = "productDetail", value = "/productDetail")
public class Product extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();
        Products p = dao.getProduct(1);

        request.setAttribute("p", p);

        request.getRequestDispatcher("GKY/productDetail.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}