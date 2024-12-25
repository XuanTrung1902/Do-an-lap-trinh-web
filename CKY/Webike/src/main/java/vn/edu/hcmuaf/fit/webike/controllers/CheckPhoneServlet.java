package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckPhoneServlet", value = "/CheckPhone")
public class CheckPhoneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        System.out.println(phone);
        boolean exists = UserSevice.isPhoneNumExists(phone);
//        boolean exists = new UserDao().isPhoneNumExists(phone);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"exists\": " + exists + "}");
    }

}