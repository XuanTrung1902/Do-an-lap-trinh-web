package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
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
        Date date = Date.valueOf(dob);
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Mật khẩu không khớp");
            setRequestAttributes(request, fullname, phone, address, gender, day, month, year);
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
            return;
        }
        if (UserSevice.isPhoneNumExists(phone)) {
            request.setAttribute("error", "Số điện thoại đã tồn tại");
            setRequestAttributes(request, fullname, phone, address, gender, day, month, year);
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setName(fullname);
        user.setPhoneNum(phone);
        user.setAddress(address);
        user.setSex(gender);
        user.setDOB(date);
        user.setPassword(UserSevice.hashPassword(password));
        user.setCreated(LocalDate.now().toString());
        user.setLocked(0);
        user.setVerify(0);
        user.setRole(1);

        boolean isRegistered = UserSevice.registerUser(user);

        if (isRegistered) {
            response.sendRedirect("Login");
        } else {
            request.setAttribute("error", "Đăng ký thất bại");
            setRequestAttributes(request, fullname, phone, address, gender, day, month, year);
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
        }
    }
    private void setRequestAttributes(HttpServletRequest request, String fullname, String phone, String address, String gender, String day, String month, String year) {
        request.setAttribute("fullname", fullname);
        request.setAttribute("phone", phone);
        request.setAttribute("address", address);
        request.setAttribute("gender", gender);
        request.setAttribute("day", day);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
    }


}