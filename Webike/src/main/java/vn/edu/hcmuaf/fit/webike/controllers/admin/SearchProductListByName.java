package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchProductAjax", value = "/search_by_name")
public class SearchProductListByName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
//        System.out.println("Keyword: " + keyword);

        // Gọi DAO để lấy danh sách sản phẩm theo từ khóa
        ProductDAO dao = new ProductDAO();
        List<Map<String, Object>> products = dao.searchProductsbyname(keyword);

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");

        for (int i = 0; i < products.size(); i++) {
            Map<String, Object> product = products.get(i);
            jsonBuilder.append("{")
                    .append("\"id\":").append(product.getOrDefault("id", "null")).append(",")
                    .append("\"name\":\"").append(product.getOrDefault("name", "")).append("\",")
                    .append("\"price\":").append(product.getOrDefault("price", 0)).append(",")
                    .append("\"quantity\":\"").append(product.getOrDefault("quantity", "")).append("\",")
                    .append("\"imgurl\":\"").append(product.getOrDefault("imgurl", "")).append("\"")
                    .append("}");

            // Thêm dấu phẩy nếu không phải phần tử cuối
            if (i < products.size() - 1) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("]");

        // Trả về JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonBuilder.toString());
    }
}