package vn.edu.hcmuaf.fit.webike.controllers.productDetail;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Color;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "changeColor", value = "/changeColor")
public class ChangeColor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String colorName = req.getParameter("color");
        String productIdStr = req.getParameter("id");

        int productId = Integer.parseInt(productIdStr);
        Product p = new ProductDAO().getProduct(productId);

        String imgUrl = null;
        for (Map.Entry<Color, String> entry : p.getImg().entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(colorName)) {
                imgUrl = entry.getValue();
                break;
            }
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        if (imgUrl != null) {
            resp.getWriter().write("{\"imgUrl\":\"" + imgUrl + "\"}");
        } else {
            resp.getWriter().write("{\"error\":\"Image not found for color\"}");
        }
    }
}