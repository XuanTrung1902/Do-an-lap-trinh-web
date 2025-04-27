package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.webike.dao.HomepageDAO;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.BikeType;
import vn.edu.hcmuaf.fit.webike.models.Product;
import vn.edu.hcmuaf.fit.webike.models.Shop;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Homepage", value = "/homepage")
public class Homepage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomepageDAO dao = new HomepageDAO();
        PaymentDAO pdao = new PaymentDAO();

        List<BikeType> bikeTypes = dao.getAllBikeType();
        List<String> brands = dao.getBrandOfProduct();
        List<Shop> shops = pdao.getShops();

        request.setAttribute("brands", brands);
        request.setAttribute("bikeTypes", bikeTypes);
        request.setAttribute("shops", shops);
        request.getRequestDispatcher("GKY/homepage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}