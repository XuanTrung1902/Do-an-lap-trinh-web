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
        FilterDAO filterDAO = new FilterDAO();

        // Lấy tham số trang, mặc định là trang 1
        int page = 1;
        int limit = 10; // 10 sản phẩm mỗi trang
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                page = 1;
            }
        }

        // Lấy sản phẩm theo trang
        List<Product> products = filterDAO.getAllProducts(page, limit);
        List<Map<String, Object>> products2 = dao.getAllProductImg2(); // Sản phẩm cho slider
        List<Brand> allBrand = dao.getAllBrand();

        // Tính tổng số trang
        int totalProducts = filterDAO.getTotalProducts();
        int totalPages = (int) Math.ceil((double) totalProducts / limit);

        // Đặt các thuộc tính cho JSP
        request.setAttribute("allBrand", allBrand);
        request.setAttribute("products2", products2);
        request.setAttribute("products", products);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("GKY/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        FilterDAO filterDAO = new FilterDAO();
        ProductDAO pdao = new ProductDAO();

        // Lấy tham số lọc và trang
        String[] brands = request.getParameterValues("brands");
        int page = 1;
        int limit = 10;
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                page = 1;
            }
        }

        // Lấy sản phẩm theo bộ lọc
        List<Product> products;
        int totalProducts;
        List<String> brandList = (brands == null) ? new ArrayList<>() : Arrays.asList(brands);
        if (brands != null && brands.length > 0) {
            products = filterDAO.getProductsByBrands(brands, page, limit);
            totalProducts = filterDAO.getTotalProductsByBrands(brands);
        } else {
            products = filterDAO.getAllProducts(page, limit);
            totalProducts = filterDAO.getTotalProducts();
        }
        int totalPages = (int) Math.ceil((double) totalProducts / limit);

        // Ghi log
        LogService.log(LEVEL_INFO, "Xem danh sách sản phẩm", user != null ? user.getId() + "" : "Guest", "", "");

        // Đặt các thuộc tính
        request.setAttribute("checkedBrands", brandList);
        request.setAttribute("allBrand", pdao.getAllBrand());
        request.setAttribute("products", products);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("GKY/product.jsp").forward(request, response);
    }
}