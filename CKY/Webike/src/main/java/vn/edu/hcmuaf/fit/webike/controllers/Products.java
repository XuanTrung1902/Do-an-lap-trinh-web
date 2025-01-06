package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Products", value = "/list-products")
public class Products extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        List<Map<String, Object>> products = dao.getAllProductImg(); // Lấy danh sách sản phẩm kèm ảnh
//        List<Product> products = dao.getAllProductImg(); // Lấy danh sách sản phẩm kèm ảnh

        List<Map<String, Object>> products2 = dao.getAllProductImg2(); // Lấy  9 sản phẩm
        List<String> brands = dao.getBrandOfProduct(); // Lấy 10 thương hiệu


        request.setAttribute("brands", brands);                 // Gửi dữ liệu sang JSP
        request.setAttribute("products2", products2);                 // Gửi dữ liệu sang JSP
        request.setAttribute("products", products);                 // Gửi dữ liệu sang JSP
        request.getRequestDispatcher("GKY/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}