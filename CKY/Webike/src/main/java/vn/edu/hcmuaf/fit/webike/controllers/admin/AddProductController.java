package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "AddProductController", value = "/add-product")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class AddProductController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "G:\\testGitHub\\Test\\Test\\CKY\\Webike\\src\\main\\webapp\\img\\products";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Admin/product_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String launch = request.getParameter("launch");
        String description = request.getParameter("description");

        // Xử lý tệp ảnh
        Part filePart = request.getPart("image");
//        String fileName = System.currentTimeMillis() + "_" + extractFileName(filePart); // tránh trùng tên tệp ảnh
        String fileName = extractFileName(filePart); // tránh trùng tên tệp ảnh

        if (name == null || price == null || launch == null || description == null || filePart == null) {
            request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin.");
            request.getRequestDispatcher("Admin/add_product.jsp").forward(request, response);
            return;
        }

        // Đường dẫn lưu tệp
        File uploadDir = new File(UPLOAD_DIRECTORY);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
        }

        String filePath = UPLOAD_DIRECTORY + File.separator + fileName;
        filePart.write(filePath); // Lưu tệp vào thư mục

        // Lưu thông tin sản phẩm vào database
        ProductDAO productDAO = new ProductDAO();
        boolean success = productDAO.addProduct(name, Double.parseDouble(price), quantity, launch, "img/products/" + fileName, description);

        // Chuyển hướng hoặc thông báo
        if (success) {
            request.setAttribute("successMessage", "Thêm sản phẩm thành công!");
            response.sendRedirect("products"); // Quay lại trang danh sách sản phẩm
        } else {
            request.setAttribute("errorMessage", "Thêm sản phẩm thất bại!");
            request.getRequestDispatcher("Admin/add_product.jsp").forward(request, response);
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