package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;

@WebServlet(name = "VerifyOTPEmail", value = "/VerifyOTPEmail")
public class VerifyOTPEmail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String otpCode = request.getParameter("otpCode");
//
//        HttpSession session = request.getSession();
//        String sessionOtp = (String) session.getAttribute("otp");
//        String newEmail = (String) session.getAttribute("newEmail");
//        Long otpTimestamp = (Long) session.getAttribute("otpTimestamp");
//        User user = (User) session.getAttribute("auth"); // Lấy đối tượng User từ session
//
//        if (otpTimestamp == null || System.currentTimeMillis() - otpTimestamp > 120000) {
//            response.getWriter().write("OTP đã hết hạn!");
//            return;
//        }
//
//        if (!otpCode.equals(sessionOtp)) {
//            response.getWriter().write("OTP không đúng!");
//            return;
//        }
//
//        // Update email in database
//        boolean isUpdated = UserSevice.updateEmailByPhone(user.getPhoneNum(), newEmail);
//
//        if (isUpdated) {
//            response.getWriter().write("Email đã được cập nhật thành công!");
//        } else {
//            response.getWriter().write("Không thể cập nhật email!");
//        }
//    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/plain;charset=UTF-8");

    String otpCode = request.getParameter("otpCode");
    HttpSession session = request.getSession();
    String sessionOtp = (String) session.getAttribute("otp");
    String newEmail = (String) session.getAttribute("newEmail");
    Long otpTimestamp = (Long) session.getAttribute("otpTimestamp");
    User user = (User) session.getAttribute("auth");

    if (otpTimestamp == null || System.currentTimeMillis() - otpTimestamp > 120000) {
        response.getWriter().write("OTP đã hết hạn!");
        return;
    }

    if (!otpCode.equals(sessionOtp)) {
        response.getWriter().write("OTP không đúng!");
        return;
    }

    boolean isUpdated = UserSevice.updateEmailByPhone(user.getPhoneNum(), newEmail);
    if (isUpdated) {
        response.getWriter().write("Email đã được cập nhật thành công!");
    } else {
        response.getWriter().write("Không thể cập nhật email!");
    }
}
}