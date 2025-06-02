package vn.edu.hcmuaf.fit.webike.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.FilterDAO;
import vn.edu.hcmuaf.fit.webike.models.Color;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FilterProduct", value = "/filter")
public class FilterProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        FilterDAO filterDAO = new FilterDAO();
        String[] brands = request.getParameterValues("brand");
        int page = 1;
        int limit = 10;
        try {
            page = Integer.parseInt(request.getParameter("page"));
            limit = Integer.parseInt(request.getParameter("limit"));
        } catch (NumberFormatException e) {
            // Mặc định nếu tham số không hợp lệ
        }

        List<Product> products;
        int totalProducts;
        if (brands != null && brands.length > 0) {
            products = filterDAO.getProductsByBrands(brands, page, limit);
            totalProducts = filterDAO.getTotalProductsByBrands(brands);
        } else {
            products = filterDAO.getAllProducts(page, limit);
            totalProducts = filterDAO.getTotalProducts();
        }

        int totalPages = (int) Math.ceil((double) totalProducts / limit);

        // Chuẩn bị dữ liệu trả về
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("products", products);
        responseData.put("totalPages", totalPages);
        responseData.put("currentPage", page);

        // Tùy chỉnh Gson để xử lý Map<Color, String>
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Map.class, (com.google.gson.JsonSerializer<Map<Color, String>>) (src, typeOfSrc, context) -> {
                    com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
                    for (Map.Entry<Color, String> entry : src.entrySet()) {
                        jsonObject.addProperty(String.valueOf(entry.getKey().getId()), entry.getValue());
                    }
                    return jsonObject;
                })
                .create();

        String json = gson.toJson(responseData);
        response.getWriter().write(json);
    }
}