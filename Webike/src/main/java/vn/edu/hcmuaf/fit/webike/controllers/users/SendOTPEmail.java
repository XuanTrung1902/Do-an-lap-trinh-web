//package vn.edu.hcmuaf.fit.webike.controllers.users;
//
//import com.google.gson.JsonObject;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//import vn.edu.hcmuaf.fit.webike.services.EmailService;
//import vn.edu.hcmuaf.fit.webike.services.OTPService;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//
//
//@WebServlet(name = "SendOTPEmail", value = "/SendOTPEmail")
//public class SendOTPEmail extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
////    @Override
////    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String newEmail = request.getParameter("newEmail");
////
////        // Generate OTP
////        String generatedOtp = OTPService.generateOTP();
////
////        // Store OTP and timestamp in session
////        HttpSession session = request.getSession();
////        session.setAttribute("otp", generatedOtp);
////        session.setAttribute("otpTimestamp", System.currentTimeMillis());
////        session.setAttribute("newEmail", newEmail);
////
////        // Send OTP to new email
////        EmailService.sendEmail(newEmail, "OTP Verification", "Your OTP is: " + generatedOtp);
////
////        response.getWriter().write("OTP đã được gửi đến email mới của bạn.");
////    }
//@Override
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String email = request.getParameter("newEmail");
//
//    if (email == null || email.trim().isEmpty()) {
//        request.setAttribute("error", "Email không được để trống!");
//        request.getRequestDispatcher("/change-email.jsp").forward(request, response);
//        return;
//    }
//
//    try {
//        EmailService.sendEmail(email);
//        request.setAttribute("message", "Mã OTP đã được gửi đến email của bạn!");
//    } catch (Exception e) {
//        request.setAttribute("error", "Gửi email thất bại! Vui lòng thử lại.");
//    }
//
//    request.getRequestDispatcher("/change-email.jsp").forward(request, response);
//}
//
//
//}
//
