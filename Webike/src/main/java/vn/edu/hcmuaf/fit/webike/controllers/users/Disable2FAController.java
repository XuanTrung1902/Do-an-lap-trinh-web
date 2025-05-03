package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;

@WebServlet(name = "Disable2FAController", value = "/disable-2fa")
public class Disable2FAController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("auth");

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/Login");
            return;
        }

        // Tắt 2FA
        user.setOtpEnabled(false);
        user.setOtpSecret(null);
        new UserDao().updateOtpEnabled(user.getId(), false);
        new UserDao().updateOtpSecret(user.getId(), null);

        session.setAttribute("auth", user);
        resp.sendRedirect(req.getContextPath() + "/Profile");
    }
}