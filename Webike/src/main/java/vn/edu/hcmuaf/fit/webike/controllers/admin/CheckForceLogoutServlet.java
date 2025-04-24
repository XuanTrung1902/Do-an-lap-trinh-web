package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.PermissionDTO;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.PermissionService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckForceLogoutServlet", value = "/checkForceLogout")
public class CheckForceLogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        boolean result = false;
        if (session != null && session.getAttribute("auth") != null) {
            User user = (User) session.getAttribute("auth");
            System.out.println("🔍 Check force logout servlet gọi");
            System.out.println("User ID: " + user.getId() + " - Force Logout: " + result);
            UserDao dao = new UserDao();
            result = dao.checkForceLogout(user.getId());
        }

        resp.setContentType("application/json");
        resp.getWriter().write("{\"forceLogout\": " + result + "}");
    }
}