package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.BikeType;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        String typeIDParam = request.getParameter("typeID");
        List<Map<String, Object>> loadProducts;

        if (typeIDParam != null && !typeIDParam.isEmpty()) {
            int typeID = Integer.parseInt(typeIDParam);
            loadProducts = dao.getProductsByType(typeID); // Lọc theo typeID
        } else {
            loadProducts = dao.getAllProducts(); // Mặc định lấy tất cả sản phẩm
        }

        List<BikeType> loadBikeTypes = dao.getTypes();

        request.setAttribute("p", loadProducts);
        request.setAttribute("bt", loadBikeTypes);
        request.getRequestDispatcher("Admin/product_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}