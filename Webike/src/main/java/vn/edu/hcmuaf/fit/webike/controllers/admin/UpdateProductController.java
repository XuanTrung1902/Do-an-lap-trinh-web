package vn.edu.hcmuaf.fit.webike.controllers.admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.dao.UpdateProductDAO;
import vn.edu.hcmuaf.fit.webike.models.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "UpdateProductController", value = "/update-product")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UpdateProductController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "D:\\DO AN LTW\\Do-an-lap-trinh-web\\CKY\\Webike\\src\\main\\webapp\\img\\products";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        if (productId != null) {
            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.getProductById(Integer.parseInt(productId));
            UpdateProductDAO updateDAO = new UpdateProductDAO();
            List<Integer> listSpecID = updateDAO.getAllSpecID(productId);

            if (product != null) {
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

                request.setAttribute("productID", productId);
                request.setAttribute("colorList", colorList);
                request.setAttribute("brandList", brandList);
                request.setAttribute("typeList", typeList);
                request.setAttribute("product", product);
                request.setAttribute("specType", specType);
                request.setAttribute("tags", tags);
                request.setAttribute("listSpecID", listSpecID);
                request.getRequestDispatcher("/Admin/product_edit.jsp").forward(request, response);
                return;
            }
        }
        response.sendRedirect("products");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String price = request.getParameter("price");
        String launch = request.getParameter("launch");
        String description = request.getParameter("description");
        Part filePart = request.getPart("image"); // File ảnh mới (nếu có)
        String brand = request.getParameter("brand");
        String type = request.getParameter("type");
        String color = request.getParameter("color");
        String version = request.getParameter("version");
        String km = request.getParameter("km");
        String duration = request.getParameter("duration");

        ProductDAO productDAO = new ProductDAO();
        UpdateProductDAO updateDAO = new UpdateProductDAO();

        // Đường dẫn ảnh mới (nếu được upload)
        String imageUrl = null;

        // Nếu có file ảnh mới, xử lý lưu ảnh
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = extractFileName(filePart);
            String filePath = UPLOAD_DIRECTORY + File.separator + fileName;
            filePart.write(filePath); // Lưu file vào thư mục
            imageUrl = "img/products/" + fileName; // Đường dẫn ảnh trong dự án
        }

        boolean isUpdated = productDAO.updateProduct(Integer.parseInt(id), name, quantity,
                Double.parseDouble(price), launch, imageUrl, description, brand, type, version, color);

        // các id của spec sp dạng json
        String json = request.getParameter("selectedValues");
        Gson gson = new Gson();
        // đưa từ json về List<String>
        List<Integer> specID = gson.fromJson(json, new TypeToken<List<Integer>>() {
        }.getType());
        List<Integer> pDetailID = updateDAO.getPDetailID(id);
//        List<Integer> listSpecID = updateDAO.getAllSpecID(id);
        Map<Integer, Integer> specUpdate = new LinkedHashMap<>();
        for (int i = 0; i < pDetailID.size(); i++) {
            specUpdate.put(pDetailID.get(i), specID.get(i));
        }
//        System.out.println("Json data:"+ json);
//        System.out.println(pDetailID);
        System.out.println("PDetail and specID: " + specUpdate);

        if (isUpdated) {
            response.sendRedirect("products");
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