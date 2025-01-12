package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Brand;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Products", value = "/products")
public class Products extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        List<Map<String, Object>> products = dao.getAllProductImg(); // Lấy danh sách sản phẩm kèm ảnh
        List<Map<String, Object>> products2 = dao.getAllProductImg2(); // Lấy  9 sản phẩm
        List<String> brands = dao.getBrandOfProduct(); // Lấy 10 thương hiệu
        List<Brand> allBrand = dao.getAllBrand(); // Lấy tất cả thương hiệu



        request.setAttribute("allBrand", allBrand);                 // Gửi dữ liệu sang JSP
        request.setAttribute("brands", brands);                 // Gửi dữ liệu sang JSP
        request.setAttribute("products2", products2);                 // Gửi dữ liệu sang JSP
        request.setAttribute("products", products);                 // Gửi dữ liệu sang JSP
        request.getRequestDispatcher("GKY/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String brand = request.getParameter("brand");
//        String type = request.getParameter("type");
//        String cubic = request.getParameter("cubic");
//        String price = request.getParameter("price");
//
//        ProductDAO dao = new ProductDAO();
//        List<Map<String, Object>> products = dao.searchProducts(brand, type, cubic, price);
//
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        for (Map<String, Object> product : products) {
//            out.println("<div class='grid__column-2' style='padding: 10px;'>");
//            out.println("<a href='products?id=" + product.get("id") + "' class='bike--item'>");
//            out.println("<div class='bike__img zoom-img'>");
//            out.println("<img src='" + product.get("imgUrl") + "' alt='" + product.get("name") + "'/>");
//            out.println("</div>");
//            out.println("<div class='bike__info'>");
//            out.println("<h3 class='bike__name'>" + product.get("name") + "</h3>");
//            out.println("<span class='bike__price'>" + product.get("price") + "đ</span>");
//            out.println("</div>");
//            out.println("</a>");
//            out.println("</div>");
//        }
    }
}