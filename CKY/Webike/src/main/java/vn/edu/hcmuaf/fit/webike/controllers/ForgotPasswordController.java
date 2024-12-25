package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ForgotPasswordController", value = "/QuenMatKhau")
public class ForgotPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("GKY/trangQuenMatKhau.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");


        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Mật khẩu và Nhập lại mật khẩu không khớp!");
            request.getRequestDispatcher("GKY/trangQuenMatKhau.jsp").forward(request, response);
            return;
        }


        boolean isUpdated = UserSevice.updatePasswordByPhone(phone, password);

        if (isUpdated) {
            request.setAttribute("message", "Mật khẩu đã được cập nhật thành công!");
            request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Không tìm thấy số điện thoại này!");
            request.getRequestDispatcher("GKY/trangQuenMatKhau.jsp").forward(request, response);
        }

    }

}