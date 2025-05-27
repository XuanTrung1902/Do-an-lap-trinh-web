package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.*;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AddProductController", value = "/add-product")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class AddProductController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "D:\\DO AN LTW\\Do-an-lap-trinh-web\\CKY\\Webike\\src\\main\\webapp\\img\\products";
    final String LEVEL_ALERT = LogService.LEVEL_ALERT;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        List<Color> colorList = productDAO.getColors();
        List<Brand> brandList = productDAO.getBrands();
        List<BikeType> typeList = productDAO.getTypes();

        List<String> specType = productDAO.getSpecType();

        Map<String, Map<String, List<Spec>>> tags = new LinkedHashMap<>();
        for (String s : specType) {
            List<String> tag = productDAO.getTag(s);
            Map<String, List<Spec>> specMap = new LinkedHashMap<>();
            for (String t : tag) {
                List<Spec> specs = productDAO.getSpec1(t);
                specMap.put(t, specs);
            }
            tags.put(s, specMap);
        }


        request.setAttribute("colorList", colorList);
        request.setAttribute("brandList", brandList);
        request.setAttribute("typeList", typeList);
        request.setAttribute("specType", specType);
        request.setAttribute("tags", tags);


        request.getRequestDispatcher("/Admin/product_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("auth");
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
        int colorID = Integer.parseInt(request.getParameter("color"));
        int brandID = Integer.parseInt(request.getParameter("brand"));
        int typeID = Integer.parseInt(request.getParameter("type"));
        String version = request.getParameter("version");


        ProductDAO productDAO = new ProductDAO();
//        boolean success = productDAO.addProduct(name, Double.parseDouble(price), quantity, launch, "img/products/" + fileName, description, colorID, brandID, typeID);
        int success = productDAO.addProduct(name, Double.parseDouble(price), quantity, launch, "img/products/" + fileName, description, colorID, brandID, typeID, version);

        // lay ra id thong so va them thong so
        String specs = request.getParameter("selectedValues");
        String result = specs.replace("[", "").replace("]", "").replace("\"", "");
        List<String> list = Arrays.asList(result.split(","));
        for (String s : list) {
            int item = Integer.parseInt(s);
            int insertSpec = productDAO.insertSpec(success, item);
        }

        // them bao hanh
        int km = Integer.parseInt(request.getParameter("km"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        int insertWarranty = productDAO.insertWarranty(success, km, duration);


        // Chuyển hướng hoặc thông báo
        if (success > 0) {
            LogService.log(LEVEL_ALERT, "Thêm sản phầm", u.getId()+"","" ,success+"");
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