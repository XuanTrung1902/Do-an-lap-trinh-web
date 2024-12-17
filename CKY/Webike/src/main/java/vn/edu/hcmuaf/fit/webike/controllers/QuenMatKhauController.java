package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;

@WebServlet(name = "QuenMatKhauController", value = "/QuenMatKhauController")
public class QuenMatKhauController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String captcha = request.getParameter("captcha");

        // Kiểm tra captcha (giả sử bạn đã có logic kiểm tra captcha)
        boolean isCaptchaValid = checkCaptcha(captcha);
        if (!isCaptchaValid) {
            request.setAttribute("error", "Mã captcha không hợp lệ.");
            request.getRequestDispatcher("GKY/quenMatKhau.jsp").forward(request, response);
            return;
        }

        // Tạo mật khẩu mới
        String newPassword = generateRandomPassword();

        // Cập nhật mật khẩu mới vào cơ sở dữ liệu
        boolean isUpdated = UserSevice.updatePasswordByPhone(phone, newPassword);
        if (isUpdated) {
            // Gửi mật khẩu mới về số điện thoại
            sendPasswordToPhone(phone, newPassword);
            request.setAttribute("message", "Mật khẩu mới đã được gửi về số điện thoại của bạn.");
            request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Không tìm thấy số điện thoại này.");
            request.getRequestDispatcher("GKY/quenMatKhau.jsp").forward(request, response);
        }
    }

    private boolean checkCaptcha(String captcha) {
        // Logic kiểm tra captcha
        return true; // Giả sử captcha luôn hợp lệ
    }

    private String generateRandomPassword() {
        // Logic tạo mật khẩu ngẫu nhiên
        return "newRandomPassword123";
    }

    private void sendPasswordToPhone(String phone, String newPassword) {
        // Logic gửi mật khẩu mới về số điện thoại
    }
}