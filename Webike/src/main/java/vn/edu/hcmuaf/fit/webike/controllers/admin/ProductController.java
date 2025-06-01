package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.BikeType;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {

    final String level = LogService.LEVEL_INFO;
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
        // Lấy thông tin user hiện tại từ session để ghi log
        HttpSession session = request.getSession(false);
        User currentUser = (session != null) ? (User) session.getAttribute("auth") : null;
        String userInfo = (currentUser != null) ? currentUser.getId()+"" : "Khách";

        // Ghi log hành động xem danh sách sản phẩm
        LogService.log(level, "Xem danh sách sản phẩm", userInfo, "", "");

        request.setAttribute("p", loadProducts);
        request.setAttribute("bt", loadBikeTypes);
        request.getRequestDispatcher("Admin/product_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}