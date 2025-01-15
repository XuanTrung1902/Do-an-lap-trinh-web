package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.EmailService;
import vn.edu.hcmuaf.fit.webike.services.OTPService;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;

@WebServlet(name = "ForgotPasswordController", value = "/forgot-password")
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
    String otp = request.getParameter("otp");

    HttpSession session = request.getSession();
    String sessionOtp = (String) session.getAttribute("otp");

    if (otp == null || otp.isEmpty()) {
        request.setAttribute("error", "Vui lòng nhập OTP.");
        request.setAttribute("phone", phone);
        request.getRequestDispatcher("GKY/trangQuenMatKhau.jsp").forward(request, response);
        return;
    }

    Long otpTimestamp = (Long) session.getAttribute("otpTimestamp");
    if (otpTimestamp == null || System.currentTimeMillis() - otpTimestamp > 120000) {
        request.setAttribute("error", "OTP đã hết hạn!");
        request.setAttribute("phone", phone);
        request.getRequestDispatcher("GKY/trangQuenMatKhau.jsp").forward(request, response);
        return;
    }

    if (!otp.equals(sessionOtp)) {
        request.setAttribute("error", "OTP không đúng!");
        request.setAttribute("phone", phone);
        request.getRequestDispatcher("GKY/trangQuenMatKhau.jsp").forward(request, response);
        return;
    }

    if (!password.equals(confirmPassword)) {
        request.setAttribute("error", "Mật khẩu và Nhập lại mật khẩu không khớp!");
        request.setAttribute("phone", phone);
        request.getRequestDispatcher("GKY/trangQuenMatKhau.jsp").forward(request, response);
        return;
    }

    boolean isUpdated = UserSevice.updatePasswordByPhone(phone, password);

    if (isUpdated) {
        request.setAttribute("message", "Mật khẩu đã được cập nhật thành công!");
        request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
    } else {
        request.setAttribute("error", "Không tìm thấy số điện thoại này!");
        request.setAttribute("phone", phone);
        request.getRequestDispatcher("GKY/trangQuenMatKhau.jsp").forward(request, response);
    }
}

    @WebServlet(name = "SendOtpController", value = "/send-otp")
    public static class SendOtpController extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String phone = request.getParameter("phone");

            UserDao userDao = new UserDao();
            User user = userDao.findUserPhone(phone);
            if (user == null) {
                response.getWriter().write("Không tìm thấy số điện thoại này!");
                return;
            }

            String generatedOtp = OTPService.generateOTP();
            HttpSession session = request.getSession();
            session.setAttribute("otp", generatedOtp);
            session.setAttribute("otpTimestamp", System.currentTimeMillis());
            EmailService.sendEmail(user.getEmail(), "OTP Verification", "Your OTP is: " + generatedOtp);
            response.getWriter().write("OTP đã được gửi đến email của bạn.");
        }
    }


}