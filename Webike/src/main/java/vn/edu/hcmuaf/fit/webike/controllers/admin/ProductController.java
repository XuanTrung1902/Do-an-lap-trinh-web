package vn.edu.hcmuaf.fit.webike.controllers.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.BikeType;
import vn.edu.hcmuaf.fit.webike.models.Product;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", value = {"/products", "/products/filter"})
public class ProductController extends HttpServlet {

    final String level = LogService.LEVEL_INFO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        String typeIDParam = request.getParameter("typeID");
        String path = request.getServletPath();

        if ("/products/filter".equals(path)) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            List<Product> loadProducts;
            if (typeIDParam != null && !typeIDParam.isEmpty()) {
                int typeID = Integer.parseInt(typeIDParam);
                loadProducts = dao.getAllProductByType(typeID);
            } else {
                loadProducts = dao.getAllProduct();
            }

            // Chan đổi sang JSON
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), loadProducts);
        } else {
            List<Product> loadProducts;
            if (typeIDParam != null && !typeIDParam.isEmpty()) {
                int typeID = Integer.parseInt(typeIDParam);
                loadProducts = dao.getAllProductByType(typeID);
            } else {
                loadProducts = dao.getAllProduct();
            }

            List<BikeType> loadBikeTypes = dao.getTypes();

            // Lấy thông tin người dùng từ session để ghi log
            HttpSession session = request.getSession(false);
            User currentUser = (session != null) ? (User) session.getAttribute("auth") : null;
            String userInfo = (currentUser != null) ? currentUser.getId() + "" : "Khách";

            // Ghi log hành động xem danh sách sản phẩm
            LogService.log(level, "Xem danh sách sản phẩm", userInfo, "", "");

            request.setAttribute("products", loadProducts);
            request.setAttribute("bt", loadBikeTypes);
            request.getRequestDispatcher("Admin/product_list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}