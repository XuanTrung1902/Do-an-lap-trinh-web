package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.FilterDAO;

import java.io.IOException;
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
        List<Map<String, Object>> products = filterDAO.getProductsByBrands1(brands, page, limit);
        int totalProducts = filterDAO.getTotalProductsByBrands(brands);
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
            json.append("\"status\":\"").append(product.get("status")).append("\"");
            json.append("},");
        }
        if (json.length() > 1) json.setLength(json.length() - 1); // Remove the last comma
        json.append("],");
        json.append("\"totalPages\":").append(totalPages);
        json.append("}");
        response.getWriter().write(json.toString());



//code cũ
//        String[] brands = request.getParameterValues("brand");
//
//        FilterDAO filterDAO = new FilterDAO();
//        List<Map<String, Object>> products;
//
//        if (brands == null || brands.length == 0) {
//            // Nếu không có thương hiệu nào được chọn, lấy tất cả sản phẩm
//            products = filterDAO.getAllProducts();
//        } else {
//            // Lọc theo thương hiệu
//            products = filterDAO.getProductsByBrands(brands);
//        }
//
//        // Trả kết quả dưới dạng JSON
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        StringBuilder json = new StringBuilder("[");
//        for (Map<String, Object> product : products) {
//            json.append("{");
//            json.append("\"id\":\"").append(product.get("id")).append("\",");
//            json.append("\"name\":\"").append(product.get("name")).append("\",");
//            json.append("\"price\":\"").append(product.get("price")).append("\",");
//            json.append("\"imgUrl\":\"").append(product.get("url")).append("\",");
//            json.append("\"version\":\"").append(product.get("version")).append("\",");
//            json.append("\"launch\":\"").append(product.get("launch")).append("\",");
//            json.append("\"status\":\"").append(product.get("status")).append("\"");
//            json.append("},");
//        }
//        if (json.length() > 1) json.setLength(json.length() - 1); // Xóa dấu phẩy cuối
//        json.append("]");
//        response.getWriter().write(json.toString());
    }
}