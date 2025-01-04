package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "productDetail", value = "/productDetail")
public class ProductDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));

        ProductDAO dao = new ProductDAO();
        Product p = dao.getProduct(2);
        List<String> specType = dao.getSpecType();
        Map<String, List<Spec>> specMap = new HashMap<>();
        for (String s : specType) {
            List<Spec> specs = dao.getSpec(p.getId(), s);
            specMap.put(s, specs);
        }

        List<Feature> features = dao.getFeature(p.getId());
        List<Warranty> warranties = dao.getWarranty(p.getId());
        List<Comment> comments = dao.getComment(p.getId());

        request.setAttribute("p", p);
        request.setAttribute("specType", specType);
        request.setAttribute("specMap", specMap);
        request.setAttribute("f", features);
        request.setAttribute("warranties", warranties);
        request.setAttribute("c", comments);

        request.getRequestDispatcher("GKY/productDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}