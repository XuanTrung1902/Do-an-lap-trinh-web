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
//            System.out.println(" tổng số sảng phẩm: "+totalProducts);
        } else {
            products = filterDAO.getProductsByBrands1(brands, page, limit);
            totalProducts = filterDAO.getTotalProductsByBrands(brands);
//            System.out.println("số sản phẩm sau khi lọc: " +totalProducts);
        }

        int totalPages = (int) Math.ceil((double) totalProducts / limit);

        // Xây dựng JSON
        StringBuilder json = new StringBuilder("{");
        json.append("\"products\":[");

        // Kiểm tra nếu danh sách products không rỗng
        if (!products.isEmpty()) {
            for (int i = 0; i < products.size(); i++) {
                Map<String, Object> product = products.get(i);
                json.append("{");
                json.append("\"id\":\"").append(product.get("id") != null ? product.get("id") : "").append("\",");
                json.append("\"name\":\"").append(product.get("name") != null ? product.get("name") : "").append("\",");
                json.append("\"price\":\"").append(product.get("price") != null ? product.get("price") : "0").append("\",");
                json.append("\"imgUrl\":\"").append(product.get("url") != null ? product.get("url") : "").append("\",");
                json.append("\"version\":\"").append(product.get("version") != null ? product.get("version") : "").append("\",");
                json.append("\"launch\":\"").append(product.get("launch") != null ? product.get("launch") : "").append("\",");
                json.append("\"status\":\"").append(product.get("status") != null ? product.get("status") : "").append("\",");
                json.append("\"brand\":\"").append(product.get("brand") != null ? product.get("brand") : "").append("\"");
                json.append("}");

                // Chỉ thêm dấu phẩy nếu không phải là phần tử cuối cùng
                if (i < products.size() - 1) {
                    json.append(",");
                }

            }
        }

        json.append("],");
        json.append("\"totalPages\":").append(totalPages);
        json.append("}");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toString());

    }
}