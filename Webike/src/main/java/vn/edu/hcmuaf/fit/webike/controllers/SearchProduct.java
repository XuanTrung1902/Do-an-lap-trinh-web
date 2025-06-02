package vn.edu.hcmuaf.fit.webike.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.SearchDAO;
import vn.edu.hcmuaf.fit.webike.models.Product;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.HashMap;
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
        int page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
        int limit = request.getParameter("limit") != null ? Integer.parseInt(request.getParameter("limit")) : 10;

        if (keyword == null || keyword.trim().isEmpty()) {
            keyword = "";
        }

        SearchDAO sDao = new SearchDAO();
        List<Product> products = sDao.searchProductsWithImages(keyword, page, limit);
        int totalProducts = sDao.countSearchProducts(keyword);

        int totalPages = (int) Math.ceil((double) totalProducts / limit);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("products", products);
        responseData.put("totalPages", totalPages);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(responseData);

        // Log chỉ khi user đã đăng nhập
        if (user != null) {
            LogService.log(LEVEL_INFO, "Tìm sản phẩm", String.valueOf(user.getId()), "", keyword);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}