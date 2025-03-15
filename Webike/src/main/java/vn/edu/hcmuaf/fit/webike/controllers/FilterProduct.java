package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.FilterDAO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FilterProduct", value = "/filter")
public class FilterProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] brands = request.getParameterValues("brand");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));

        FilterDAO filterDAO = new FilterDAO();
        List<Map<String, Object>> products;
        int totalProducts;

        if (brands == null || brands.length == 0) {
            products = filterDAO.getAllProducts(page, limit);
            totalProducts = filterDAO.getTotalProducts();
        } else {
            products = filterDAO.getProductsByBrands1(brands, page, limit);
            totalProducts = filterDAO.getTotalProductsByBrands(brands);
        }

        int totalPages = (int) Math.ceil((double) totalProducts / limit);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        StringBuilder json = new StringBuilder("{");
        json.append("\"products\":[");
        for (Map<String, Object> product : products) {
            json.append("{");
            json.append("\"id\":\"").append(product.get("id")).append("\",");
            json.append("\"name\":\"").append(product.get("name")).append("\",");
            json.append("\"price\":\"").append(product.get("price")).append("\",");
            json.append("\"imgUrl\":\"").append(product.get("url")).append("\",");
            json.append("\"version\":\"").append(product.get("version")).append("\",");
            json.append("\"launch\":\"").append(product.get("launch")).append("\",");
            json.append("\"status\":\"").append(product.get("status")).append("\",");
            json.append("\"brand\":\"").append(product.get("brand")).append("\"");
            json.append("},");
        }
        if (json.length() > 1) json.setLength(json.length() - 1);
        json.append("],");
        json.append("\"totalPages\":").append(totalPages);
        json.append("}");
        System.out.println("Fetching page: " + page + ", products: " + products.size() + ", totalProducts: " + totalProducts);
        response.getWriter().write(json.toString());

    }
}