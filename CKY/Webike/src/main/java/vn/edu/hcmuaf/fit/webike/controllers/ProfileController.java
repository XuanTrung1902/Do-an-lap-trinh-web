package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ProfileController", value = "/Profile")
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        System.out.println(user.toString());

        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
        } else {
            response.sendRedirect("GKY/Dangnhap.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");

        if (user != null) {
            String fullname = request.getParameter("fullname");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            String dob = year + "-" + month + "-" + day;
            Date date = Date.valueOf(dob);
            System.out.println(user.toString());
            user.setName(fullname);
            user.setPhoneNum(phone);
            user.setAddress(address);
            user.setSex(gender);
            user.setDOB(date);
            user.setPassword(user.getPassword());


            boolean isUpdated = UserSevice.updateUser(user);

            if (isUpdated) {
                session.setAttribute("auth", user);
                request.setAttribute("message", "Cập nhật thông tin thành công!");
            } else {
                request.setAttribute("error", "Cập nhật thông tin thất bại!");
            }

            request.setAttribute("user", user);
            request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
        } else {
            response.sendRedirect("GKY/Dangnhap.jsp");
        }
    }

}