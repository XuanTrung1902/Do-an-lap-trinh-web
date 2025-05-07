package vn.edu.hcmuaf.fit.webike.controllers.users;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "Enable2FAController", value = "/enable-2fa")
public class Enable2FAController extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    User user = (User) session.getAttribute("auth");

    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    PrintWriter out = resp.getWriter();

    if (user == null) {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        out.print("{\"error\": \"Người dùng chưa đăng nhập.\"}");
        return;
    }

    if (user.getOtpSecret() == null || user.getOtpSecret().isEmpty()) {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        String secret = key.getKey();

        user.setOtpSecret(secret);
        user.setOtpEnabled(false); // chưa xác thực
        new UserDao().updateOtpSecret(user.getId(), secret);
        session.setAttribute("auth", user);
    }

    String otpSecret = user.getOtpSecret();
    if (otpSecret != null && !otpSecret.isEmpty()) {
        String otpAuthURL = "otpauth://totp/Webike:" + user.getEmail()
                + "?secret=" + otpSecret + "&issuer=Webike";

        out.print("{\"qrUrl\": \"" + otpAuthURL + "\"}");
    } else {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        out.print("{\"error\": \"Không thể tạo mã QR.\"}");
    }

    out.flush();
}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("auth");

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        if (user == null) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.print("{\"success\": false, \"error\": \"Bạn chưa đăng nhập.\"}");
            return;
        }

        String otp = req.getParameter("otp");
        if (otp == null || otp.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"success\": false, \"error\": \"Vui lòng nhập mã OTP.\"}");
            return;
        }

        try {
            GoogleAuthenticator gAuth = new GoogleAuthenticator();
            boolean isCodeValid = gAuth.authorize(user.getOtpSecret(), Integer.parseInt(otp));

            if (isCodeValid) {
                user.setOtpEnabled(true);
                new UserDao().updateOtpEnabled(user.getId(), true);
                session.setAttribute("auth", user);
                resp.sendRedirect(req.getContextPath() + "/Profile");
//                out.print("{\"success\": true, \"redirect\": \"" + req.getContextPath() + "/GKY/trangTTKhachHang.jsp\"}");
            } else {
                resp.sendRedirect(req.getContextPath() + "/Profile");
//                out.print("{\"success\": false, \"error\": \"Mã OTP không chính xác.\"}");
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.sendRedirect(req.getContextPath() + "/Profile");
//            out.print("{\"success\": false, \"error\": \"Mã OTP không hợp lệ.\"}");
        }

        out.flush();
    }

}