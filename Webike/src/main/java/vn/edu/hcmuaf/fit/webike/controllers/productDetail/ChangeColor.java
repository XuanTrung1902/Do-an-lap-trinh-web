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
        int pid = Integer.parseInt(request.getParameter("id"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        ProductDAO dao = new ProductDAO();
        String imgURL = dao.getImgByColor(pid, cid);

        response.setContentType("text/plain");
        response.getWriter().write(imgURL);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}