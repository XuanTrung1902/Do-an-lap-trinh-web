package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;

import java.io.IOException;

@WebServlet(name = "DeleteProductController", value = "/delete-product")
public class DeleteProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy ID sản phẩm từ tham số yêu cầu
        String idParam = req.getParameter("id");
        if (idParam != null) {
            try {
                int productId = Integer.parseInt(idParam);

                // Gọi hàm xóa sản phẩm trong ProductDAO
                ProductDAO productDAO = new ProductDAO();
                boolean isDeleted = productDAO.deleteProductById(productId);

                if (isDeleted) {
                    // Xóa thành công, chuyển hướng về trang quản lý sản phẩm
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