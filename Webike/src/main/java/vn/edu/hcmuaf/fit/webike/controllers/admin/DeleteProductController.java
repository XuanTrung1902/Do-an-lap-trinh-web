package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Product;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;

@WebServlet(name = "DeleteProductController", value = "/delete-product")
public class DeleteProductController extends HttpServlet {

    final String LEVEL_DENGER = LogService.LEVEL_DENGER;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy ID sản phẩm từ tham số yêu cầu
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("auth");
        String idParam = req.getParameter("id");
        if (idParam != null) {
            try {
                int productId = Integer.parseInt(idParam);

                // Gọi hàm xóa sản phẩm trong ProductDAO
                ProductDAO productDAO = new ProductDAO();
                Product productOld = productDAO.getProduct(productId);
                boolean isDeleted = productDAO.deleteProductById(productId);
                Product productNew = productDAO.getProduct(productId);

                if (isDeleted) {
                    // Xóa thành công, chuyển hướng về trang quản lý sản phẩm
                    LogService.log(LEVEL_DENGER, "Xóa Product", user.getId()+"",productOld.toString() ,productNew.toString());
                    resp.sendRedirect(req.getContextPath() + "/products");
                } else {
                    // Xóa thất bại, gửi thông báo lỗi
                    req.setAttribute("error", "Không thể xóa sản phẩm này!");
                    req.getRequestDispatcher("/admin/error.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID sản phẩm không hợp lệ");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID sản phẩm không được để trống");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ;
    }
}