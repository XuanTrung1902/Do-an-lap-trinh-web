package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "UpdateProductController", value = "/update-product")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UpdateProductController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "G:\\testGitHub\\Test\\Test\\CKY\\Webike\\src\\main\\webapp\\img\\products";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id"); // Lấy ID từ query string

        if (productId != null) {
            // Lấy sản phẩm từ database
            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.getProductById(Integer.parseInt(productId));

            if (product != null) {
                // Gửi sản phẩm sang form sửa
                request.setAttribute("product", product);
                request.getRequestDispatcher("/Admin/product_edit.jsp").forward(request, response);
                return;
            }
        }

        // Nếu không tìm thấy sản phẩm, chuyển hướng về danh sách sản phẩm
        response.sendRedirect("products");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String id = request.getParameter("id"); // ID sản phẩm
        String name = request.getParameter("name"); // Tên sản phẩm
        int quantity = Integer.parseInt(request.getParameter("quantity")); // Số lượng sản phẩm
        String price = request.getParameter("price"); // Giá sản phẩm
        String launch = request.getParameter("launch"); // Ngày sản xuất
        String description = request.getParameter("description"); // Mô tả sản phẩm
        Part filePart = request.getPart("image"); // File ảnh mới (nếu có)

        // Tạo DAO để xử lý với DB
        ProductDAO productDAO = new ProductDAO();

        // Đường dẫn ảnh mới (nếu được upload)
        String imageUrl = null;

        // Nếu có file ảnh mới, xử lý lưu ảnh
        if (filePart != null && filePart.getSize() > 0) {
//            String fileName = System.currentTimeMillis() + "_" + extractFileName(filePart);
            String fileName = extractFileName(filePart);
            String filePath = UPLOAD_DIRECTORY + File.separator + fileName;
            filePart.write(filePath); // Lưu file vào thư mục
            imageUrl = "img/products/" + fileName; // Đường dẫn ảnh trong dự án
        }

        // Gọi phương thức cập nhật sản phẩm
        boolean isUpdated = productDAO.updateProduct(
                Integer.parseInt(id), // ID
                name, // Tên
                quantity, // Số lượng
                Double.parseDouble(price), // Giá
                launch, // Ngày sản xuất
                imageUrl, // Đường dẫn ảnh (nếu có)
                description // Mô tả
        );

        // Phản hồi tới người dùng
        if (isUpdated) {
            response.sendRedirect("products"); // Thành công: quay lại danh sách sản phẩm
        } else {
            request.setAttribute("errorMessage", "Cập nhật sản phẩm thất bại!");
            request.getRequestDispatcher("/Admin/product_edit.jsp").forward(request, response);
        }

    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String content : contentDisp.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }

}