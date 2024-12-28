package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.HomepageDAO;
import vn.edu.hcmuaf.fit.webike.models.BikeType;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Homepage", value = "/homepage")
public class Homepage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomepageDAO dao = new HomepageDAO();
        List<BikeType> bikeTypes = dao.getAllBikeType();  // Lấy danh sách loại xe
        List<String> brands = dao.getBrandOfProduct();  // Lấy 10 thương hiệu


        request.setAttribute("brands", brands);  // Gửi dữ liệu sang JSP
        request.setAttribute("bikeTypes", bikeTypes);  // Gửi dữ liệu sang JSP
        request.getRequestDispatcher("GKY/homepage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}