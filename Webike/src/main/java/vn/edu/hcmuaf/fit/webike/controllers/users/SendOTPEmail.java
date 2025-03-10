package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.EmailService;
import vn.edu.hcmuaf.fit.webike.services.OTPService;

import java.io.IOException;

@WebServlet(name = "SendOTPEmail", value = "/SendOTPEmail")
public class SendOTPEmail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newEmail = request.getParameter("newEmail");

        // Generate OTP
        String generatedOtp = OTPService.generateOTP();

        // Store OTP and timestamp in session
        HttpSession session = request.getSession();
        session.setAttribute("otp", generatedOtp);
        session.setAttribute("otpTimestamp", System.currentTimeMillis());
        session.setAttribute("newEmail", newEmail);

        // Send OTP to new email
        EmailService.sendEmail(newEmail, "OTP Verification", "Your OTP is: " + generatedOtp);

        response.getWriter().write("OTP đã được gửi đến email mới của bạn.");
    }

}