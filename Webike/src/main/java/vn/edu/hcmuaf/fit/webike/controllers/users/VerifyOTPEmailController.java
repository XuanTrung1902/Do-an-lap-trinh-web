//package vn.edu.hcmuaf.fit.webike.controllers.users;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import vn.edu.hcmuaf.fit.webike.services.UserSevice;
//
//import java.io.IOException;
//
//@WebServlet(name = "VerifyOTPEmailController", value = "/VerifyOTPEmail")
//public class VerifyOTPEmailController extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        String enteredOtp = request.getParameter("otpCode");
//        String sessionOtp = (String) session.getAttribute("otp");
//        String newEmail = (String) session.getAttribute("otpEmail");
//
//        Long otpTimestamp = (Long) session.getAttribute("otpTimestamp");
//        if (otpTimestamp == null || System.currentTimeMillis() - otpTimestamp > 120000) {
//            response.getWriter().write("OTP đã hết hạn, vui lòng gửi lại!");
//            return;
//        }
//
//        if (sessionOtp == null || !sessionOtp.equals(enteredOtp)) {
//            response.getWriter().write("Mã OTP không đúng, vui lòng thử lại!");
//            return;
//        }
//
//        // Lấy ID người dùng từ session
//        Integer userId = (Integer) session.getAttribute("userId");
//        if (userId == null) {
//            response.getWriter().write("Lỗi hệ thống, vui lòng đăng nhập lại!");
//            return;
//        }
//
//        // Cập nhật email trong database
//        boolean isUpdated = UserSevice.updateUserEmail(userId, newEmail);
//        if (isUpdated) {
//            session.removeAttribute("otp"); // Xóa OTP sau khi xác nhận
//            response.getWriter().write("Email đã được cập nhật thành công!");
//        } else {
//            response.getWriter().write("Có lỗi xảy ra, vui lòng thử lại!");
//        }
//    }
//
//}