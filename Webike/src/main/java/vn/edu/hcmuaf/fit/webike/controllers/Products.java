package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.hcmuaf.fit.webike.dao.FilterDAO;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Brand;
import vn.edu.hcmuaf.fit.webike.models.Product;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Products", value = "/list-products")
public class Products extends HttpServlet {

    final String LEVEL_INFO = LogService.LEVEL_INFO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProduct();
        List<Map<String, Object>> products2 = dao.getAllProductImg2();
        List<Brand> allBrand = dao.getAllBrand();

        request.setAttribute("allBrand", allBrand);
        request.setAttribute("products2", products2);
        request.setAttribute("products", products);
        request.getRequestDispatcher("GKY/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        String[] brands = request.getParameterValues("brands");
//        int page = Integer.parseInt(request.getParameter("page"));
        FilterDAO dao = new FilterDAO();
        ProductDAO pdao = new ProductDAO();

        List<Brand> allBrand = pdao.getAllBrand();
        List<Product> products = new ArrayList<>();
        if (brands != null) {
            products = dao.getProductsByBrands(brands, 1, 10);
        } else {
            products = pdao.getAllProduct();
        }
        List<String> brandList = (brands == null) ? new ArrayList<>() : Arrays.asList(brands);

        LogService.log(LEVEL_INFO, "Xem danh sách sản phẩm", user.getPhoneNum(), "", "");
        request.setAttribute("checkedBrands", brandList);
        request.setAttribute("allBrand", allBrand);
        request.setAttribute("products", products);

        request.getRequestDispatcher("GKY/product.jsp").forward(request, response);
    }
}