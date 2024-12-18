package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Feature;
import vn.edu.hcmuaf.fit.webike.models.Spec;
import vn.edu.hcmuaf.fit.webike.models.Warranty;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetail", value = "/ProductDetail")
public class ProductDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 1;
        ProductDAO dao = new ProductDAO();
        List<Spec> spec = dao.getSpec(id);
        List<Feature> feature = dao.getFeature(id);
        List<Warranty> warranty = dao.getWarranty(id);


        request.setAttribute("id", id);
        request.setAttribute("spec", spec);
        request.getRequestDispatcher("productDetail.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}