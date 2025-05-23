package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;
import vn.edu.hcmuaf.fit.webike.services.PermissionService;

import java.io.IOException;
import java.util.List;
import vn.edu.hcmuaf.fit.webike.models.PermissionDTO;
@WebServlet(name = "VerifyOtpController", value = "/verify-otp")
public class VerifyOtpController extends HttpServlet {
    final String LEVEL_INFO = LogService.LEVEL_INFO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputOtp = request.getParameter("otp");
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("pending2fa") == null) {
            response.sendRedirect("Login");
            return;
        }

        User user = (User) session.getAttribute("pending2fa");

        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        boolean isValid = gAuth.authorize(user.getOtpSecret(), Integer.parseInt(inputOtp));

        if (isValid) {
            session.removeAttribute("pending2fa");
            session.setAttribute("auth", user);

            // Khởi tạo giỏ hàng
            Cart cart = new Cart();
            session.setAttribute("cart", cart);
            cart.setData(user.getId());

            // Ghi log
            LogService.log(LEVEL_INFO, "Xác thực OTP thành công", user.getId()+"", "Trạng thái: Chờ OTP", "Trạng thái: Đã xác minh");

            // Phân quyền
            List<PermissionDTO> permissions = PermissionService.getPermissionsForUser(user.getId());
            session.setAttribute("permissions", permissions);

            // Điều hướng
            if (user.getRole() == 0) {
                response.sendRedirect("dashboard");
            } else {
                response.sendRedirect("homepage");
            }
        } else {
            request.setAttribute("error", "Mã OTP không hợp lệ");
            request.getRequestDispatcher("GKY/verify-login-otp.jsp").forward(request, response);
        }
    }

}