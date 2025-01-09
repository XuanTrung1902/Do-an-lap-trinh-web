package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.FilterDAO;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TestFilter", value = "/filter")
public class TestFilter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String[] brands = request.getParameterValues("brand");

        FilterDAO filterDAO = new FilterDAO();
//        List<Map<String, Object>> products = filterDAO.getProductsByBrands(brands);
        List<Map<String, Object>> products = filterDAO.getProductsByBrands(brands);
        System.out.println(products.toString());

        // Trả kết quả dưới dạng JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        StringBuilder json = new StringBuilder("[");
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
        if (json.length() > 1) json.setLength(json.length() - 1); // Xóa dấu phẩy cuối
        json.append("]");


        response.getWriter().write(json.toString());





//        String[] brands = request.getParameterValues("brand");
//        for(String brand: brands) {
//            System.out.println(brand);
//        }
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.setStatus(200);
    }
}