package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchProduct", value = "/search")
public class SearchProduct extends HttpServlet {
    final String LEVEL_INFO = LogService.LEVEL_INFO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        String keyword = request.getParameter("keyword");
//        System.out.println("keyword: " + keyword);

        if (keyword == null || keyword.trim().isEmpty()) {
            keyword = ""; // Nếu không có từ khóa, lấy toàn bộ sản phẩm
        }

        ProductDAO productDAO = new ProductDAO();
        List<Map<String, Object>> products = productDAO.searchProducts(keyword);
//        System.out.println("products: " + products.size());

        // Xây dựng chuỗi JSON thủ công
        StringBuilder jsonResponse = new StringBuilder("[");
        for (int i = 0; i < products.size(); i++) {
            Map<String, Object> product = products.get(i);
            jsonResponse.append("{");

            for (Map.Entry<String, Object> entry : product.entrySet()) {
                jsonResponse.append("\"").append(entry.getKey()).append("\":\"")
                        .append(entry.getValue()).append("\",");
            }

            // Xóa dấu phẩy cuối cùng
            if (jsonResponse.charAt(jsonResponse.length() - 1) == ',') {
                jsonResponse.deleteCharAt(jsonResponse.length() - 1);
            }

            jsonResponse.append("}");
            if (i < products.size() - 1) {
                jsonResponse.append(",");
            }
        }
        jsonResponse.append("]");
        LogService.log(LEVEL_INFO, "Tìm sản phẩm", user.getPhoneNum(), "", keyword);

        // Trả về JSON response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
//        System.out.println(jsonResponse);
        response.getWriter().write(jsonResponse.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}