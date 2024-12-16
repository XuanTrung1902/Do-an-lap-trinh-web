package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;

@WebServlet(name = "DangkyController", value = "/Dangky")
public class DangkyController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("GKY/Dangky.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String dob = year + "-" + month + "-" + day;
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        if (password.equals(confirmPassword)) {
            User newUser = new User();
            newUser.setName(fullname);
            newUser.setPhone(phone);
            newUser.setAddress(address);
            newUser.setGender(gender);
            newUser.setDob(dob);
            newUser.setPassword(UserSevice.hashPassword(password));
            newUser.setRole(0); // Mặc định là user

            boolean isRegistered = UserSevice.registerUser(newUser);
            if (isRegistered) {
                response.sendRedirect("GKY/Dangnhap.jsp");
            } else {
                request.setAttribute("error", "Đăng ký thất bại, vui lòng thử lại.");
                request.getRequestDispatcher("GKY/Dangky.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Mật khẩu không khớp.");
            request.getRequestDispatcher("GKY/Dangky.jsp").forward(request, response);
        }
    }
}