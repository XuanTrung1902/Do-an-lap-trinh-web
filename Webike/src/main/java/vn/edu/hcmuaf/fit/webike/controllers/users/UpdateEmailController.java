package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;
import vn.edu.hcmuaf.fit.webike.services.TwoFAService;

import java.io.IOException;

@WebServlet(name = "UpdateEmailController", value = "/update-email")
public class UpdateEmailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();
        User user = (User) session.getAttribute("auth");
        String emailOld = request.getParameter("email");

        if (user == null) {
            request.setAttribute("error", "Bạn chưa đăng nhập!");
            request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
            return;
        }

        String newEmail = request.getParameter("newEmail");
        String otp = request.getParameter("otpCode");
        String sessionOtp = (String) session.getAttribute("otp");
        Long otpTimestamp = (Long) session.getAttribute("otpTimestamp");

        // Kiểm tra OTP gửi qua email
        if (sessionOtp == null || !otp.equals(sessionOtp)) {
            request.setAttribute("error", "Mã OTP gửi qua email không đúng hoặc chưa được gửi!");
        } else if (otpTimestamp == null || System.currentTimeMillis() - otpTimestamp > 120000) {
            request.setAttribute("error", "Mã OTP đã hết hạn!");
        }
        // Kiểm tra mã xác thực 2FA nếu người dùng đã bật
        else if (user.isOtpEnabled()) {
            String authenticatorCode = request.getParameter("authenticatorCode");
            boolean isOTPValid = TwoFAService.verifyCode(user, authenticatorCode);

            if (!isOTPValid) {
                request.setAttribute("error", "Mã xác thực 2 bước không đúng hoặc đã hết hạn.");
            } else {
                // Cập nhật email
                user.setEmail(newEmail);
                userDao.updateUser(user);
                session.removeAttribute("otp");
                session.removeAttribute("otpTimestamp");
                request.setAttribute("message", "Email đã được cập nhật thành công!");
            }
        }
        else {
            user.setEmail(newEmail);
            userDao.updateUser(user);
            session.removeAttribute("otp");
            session.removeAttribute("otpTimestamp");
            request.setAttribute("message", "Email đã được cập nhật thành công!");
        }
        LogService.log(LEVEL_ALERT, "Đổi email", user.getPhoneNum(),emailOld , user.getEmail());
        response.sendRedirect(request.getContextPath() + "/Profile");
    }

}