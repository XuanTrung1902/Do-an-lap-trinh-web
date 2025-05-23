package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;

@WebServlet(name = "Disable2FAController", value = "/disable-2fa")
public class Disable2FAController extends HttpServlet {

    final String LEVEL_ALERT = LogService.LEVEL_ALERT;
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
        LogService.log(LEVEL_ALERT, "Tắt xác thực bước 2", user.getId()+"", "", "");
        user.setOtpEnabled(false);
        user.setOtpSecret(null);
        new UserDao().updateOtpEnabled(user.getId(), false);
        new UserDao().updateOtpSecret(user.getId(), null);

        session.setAttribute("auth", user);
        resp.sendRedirect(req.getContextPath() + "/Profile");
    }
}