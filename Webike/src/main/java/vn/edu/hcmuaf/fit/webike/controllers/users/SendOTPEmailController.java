//package vn.edu.hcmuaf.fit.webike.controllers.users;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import vn.edu.hcmuaf.fit.webike.services.EmailService;
//import vn.edu.hcmuaf.fit.webike.services.OTPService;
//
//import java.io.IOException;
//
//@WebServlet(name = "SendOTPEmailController", value = "/SendOTPEmail")
//public class SendOTPEmailController extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String newEmail = request.getParameter("newEmail");
//
//        if (newEmail == null || newEmail.isEmpty()) {
//            response.getWriter().write("Email không hợp lệ!");
//            return;
//        }
//
//        String otp = OTPService.generateOTP();
//        HttpSession session = request.getSession();
//        session.setAttribute("otp", otp);
//        session.setAttribute("otpEmail", newEmail);
//        session.setAttribute("otpTimestamp", System.currentTimeMillis());
//
//        // Gửi OTP đến email
//        EmailService.sendEmail(newEmail, "Xác nhận OTP", "Mã OTP của bạn là: " + otp);
//        response.getWriter().write("OTP đã được gửi đến email của bạn!");
//    }
//}