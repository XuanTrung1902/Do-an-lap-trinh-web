package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.LogService;
import vn.edu.hcmuaf.fit.webike.services.TwoFAService;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", value = "/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {

    final String LEVEL_ALERT = LogService.LEVEL_ALERT;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");

        if (user != null) {
            String currentPassword = request.getParameter("current-password");
            String newPassword = request.getParameter("new-password");
            String confirmPassword = request.getParameter("confirm-password");

            // Nếu bật 2FA thì kiểm tra mã OTP
            if (user.isOtpEnabled()) {
                String otpCode = request.getParameter("otp-code");
                boolean isOTPValid = TwoFAService.verifyCode(user, otpCode);
                if (!isOTPValid) {
                    request.setAttribute("error", "Mã xác thực không đúng hoặc đã hết hạn.");
                    request.setAttribute("current-password", currentPassword);
                    request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
                    return;
                }
            }


            if (newPassword.equals(confirmPassword)) {
                String passOld = user.getPassword();
                boolean isUpdated = UserSevice.updatePassword(user, currentPassword, newPassword);
                if (isUpdated) {
                    request.setAttribute("message", "Đổi mật khẩu thành công!");
                    LogService.log(LEVEL_ALERT, "Đổi mật khẩu", user.getPhoneNum(), passOld, UserSevice.hashPassword(newPassword));
                } else {
                    request.setAttribute("error", "Mật khẩu cũ không đúng!");
                    request.setAttribute("current-password", currentPassword);
                }
            } else {
                request.setAttribute("error", "Mật khẩu mới và xác nhận không khớp!");
                request.setAttribute("current-password", currentPassword);
            }

            response.sendRedirect(request.getContextPath() + "/Profile");
        } else {
            response.sendRedirect("Login");
        }
    }


}