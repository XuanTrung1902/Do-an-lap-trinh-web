package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;

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

        String newEmail = request.getParameter("newEmail");
        String otp = request.getParameter("otpCode");
        String sessionOtp = (String) session.getAttribute("otp");
        Long otpTimestamp = (Long) session.getAttribute("otpTimestamp");

        if (sessionOtp == null || !otp.equals(sessionOtp)) {
            request.setAttribute("error", "Mã OTP không đúng hoặc chưa được gửi!");
        } else if (otpTimestamp == null || System.currentTimeMillis() - otpTimestamp > 120000) {
            request.setAttribute("error", "Mã OTP đã hết hạn!");
        } else {
            User user = (User) session.getAttribute("auth");
            if (user != null) {
                user.setEmail(newEmail);
                userDao.updateUser(user);
                session.removeAttribute("otp");
                session.removeAttribute("otpTimestamp");
                request.setAttribute("message", "Email đã được cập nhật thành công!");

            } else {
                request.setAttribute("error", "Không tìm thấy người dùng!");
            }
        }
        request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
    }
}