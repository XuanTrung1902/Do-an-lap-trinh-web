package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "RegisterController", value = "/Dangky")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String fullname = request.getParameter("fullname");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
//        String gender = request.getParameter("gender");
//        String day = request.getParameter("day");
//        String month = request.getParameter("month");
//        String year = request.getParameter("year");
//        String dob = year + "-" + month + "-" + day;
//        String password = request.getParameter("password");
//        String confirmPassword = request.getParameter("confirm_password");
//        System.out.println("Fullname: " + fullname);
//        System.out.println("Phone: " + phone);
//        System.out.println("Address: " + address);
//        System.out.println("Gender: " + gender);
//        System.out.println("DOB: " + dob);
//        System.out.println("Password: " + password);
//        System.out.println("Confirm Password: " + confirmPassword);
//
//        if (!password.equals(confirmPassword)) {
//            request.setAttribute("error", "Mật khẩu không khớp");
//            request.getRequestDispatcher("GKY/dangky.jsp").forward(request, response);
//            return;
//        }
//
//        if (UserSevice.isPhoneNumExists(phone)) {
//            request.setAttribute("error", "Số điện thoại đã tồn tại");
//            request.getRequestDispatcher("GKY/dangky.jsp").forward(request, response);
//            return;
//        }
//
//        User user = new User();
//        user.setName(fullname);
//        user.setPhoneNum(phone);
//        user.setAddress(address);
//        user.setSex(gender);
//        user.setDOB(dob);
//        user.setPassword(UserSevice.hashPassword(password));
//        user.setCreated(LocalDate.now().toString());
//        user.setLocked(0);
//        user.setVerify(0);
//        user.setRole(1);
//
//        boolean isRegistered = UserSevice.registerUser(user);
//
//        if (isRegistered) {
//            response.sendRedirect("GKY/Dangnhap.jsp");
//        } else {
//            request.setAttribute("error", "Đăng ký thất bại");
//            request.getRequestDispatcher("GKY/dangky.jsp").forward(request, response);
//        }
//    }
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

        System.out.println("fullname: " + fullname);
        System.out.println("phone: " + phone);

        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Mật khẩu không khớp");
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
            return;
        }
        if (UserSevice.isPhoneNumExists(phone)) {
            request.setAttribute("error", "Số điện thoại đã tồn tại");
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setName(fullname);
        user.setPhoneNum(phone);
        user.setAddress(address);
        user.setSex(gender);
        user.setDOB(dob);
        user.setPassword(UserSevice.hashPassword(password));
        user.setCreated(LocalDate.now().toString());
        user.setLocked(0);
        user.setVerify(0);
        user.setRole(1);

        boolean isRegistered = UserSevice.registerUser(user);

        if (isRegistered) {
            response.sendRedirect("GKY/Dangnhap.jsp");
        } else {
            request.setAttribute("error", "Đăng ký thất bại");
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
        }
    }



}