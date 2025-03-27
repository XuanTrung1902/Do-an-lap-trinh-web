//package vn.edu.hcmuaf.fit.webike.controllers.users;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//import vn.edu.hcmuaf.fit.webike.dao.UserDao;
//import vn.edu.hcmuaf.fit.webike.models.User;
//import vn.edu.hcmuaf.fit.webike.services.EmailService;
//import vn.edu.hcmuaf.fit.webike.services.OTPService;
//
//import java.io.IOException;
//
//@WebServlet(name = "SendOtpController", value = "/sendotp")
//public class SendOtpController extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String email = request.getParameter("email");
//
//        String generatedOtp = OTPService.generateOTP();
//        HttpSession session = request.getSession();
//        session.setAttribute("otp", generatedOtp);
//        session.setAttribute("otpTimestamp", System.currentTimeMillis());
//        EmailService.sendEmail(email, "OTP Verification", "Your OTP is: " + generatedOtp);
//        response.getWriter().write("OTP đã được gửi đến email của bạn.");
//    }
//
//}