package vn.edu.hcmuaf.fit.webike.controllers.productDetail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.*;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "productDetail", value = "/productDetail")
public class ProductDetail extends HttpServlet {
    final String LEVEL_INFO = LogService.LEVEL_INFO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        if (request.getParameter("id") == null) {
            System.out.println("ko nhan dc id");
        }
        int id = Integer.parseInt(request.getParameter("id"));
        int cid = Integer.parseInt(request.getParameter("cid"));

        ProductDAO dao = new ProductDAO();
        Product p = dao.getProduct(id);
        List<String> specType = dao.getSpecType();
        Map<String, List<Spec>> specMap = new HashMap<>();
        for (String s : specType) {
            List<Spec> specs = dao.getSpec(p.getId(), s);
            specMap.put(s, specs);
        }

        String imgURL = dao.getImgByColor(id, cid);
        List<Feature> features = dao.getFeature(p.getId());
        List<Warranty> warranties = dao.getWarranty(p.getId());
        List<Comment> comments = dao.getComment(p.getId());

        request.setAttribute("p", p);
        request.setAttribute("img", imgURL);
        request.setAttribute("color", dao.getColorByID(cid));
        request.setAttribute("specType", specType);
        request.setAttribute("specMap", specMap);
        request.setAttribute("f", features);
        request.setAttribute("warranties", warranties);
        request.setAttribute("c", comments);
        LogService.log(LEVEL_INFO, "Xem sản phẩm"+p.getName(), user.getPhoneNum(), p.toString(), "");

        request.getRequestDispatcher("GKY/productDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}