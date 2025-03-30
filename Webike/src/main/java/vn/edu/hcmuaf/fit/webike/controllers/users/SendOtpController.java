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
//@WebServlet(name = "SendOtpController", value = "/send-otp")
//public class SendOtpController extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String phone = request.getParameter("phone");
//        System.out.println(phone);
//
//        UserDao userDao = new UserDao();
//        User user = userDao.findUserPhone(phone);
//        System.out.println("User forget pass: "+ user.toString());
//        if (user == null) {
//            response.getWriter().write("Không tìm thấy số điện thoại này!");
//            return;
//        }
//
//        String generatedOtp = OTPService.generateOTP();
//        HttpSession session = request.getSession();
//        session.setAttribute("otp", generatedOtp);
//        session.setAttribute("otpTimestamp", System.currentTimeMillis());
//        EmailService.sendEmail(user.getEmail(), "OTP Verification", "Your OTP is: " + generatedOtp);
//        response.getWriter().write("OTP đã được gửi đến email của bạn.");
//    }
//}
