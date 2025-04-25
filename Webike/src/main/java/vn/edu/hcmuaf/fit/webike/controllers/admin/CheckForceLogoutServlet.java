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
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    HttpSession session = request.getSession(false);
    response.setContentType("application/json");

    if (session == null || session.getAttribute("auth") == null) {
        response.getWriter().write("{\"forceLogout\": true}");
        return;
    }

    User user = (User) session.getAttribute("auth");
    int userId = user.getId();

    List<PermissionDTO> sessionPermissions = (List<PermissionDTO>) session.getAttribute("permissions");
    List<PermissionDTO> dbPermissions = PermissionService.getPermissionsForUser(userId);

    boolean isPermissionChanged = !comparePermissions(sessionPermissions, dbPermissions);

    if (isPermissionChanged) {
        session.invalidate(); // Xoá session để logout user
        response.getWriter().write("{\"forceLogout\": true}");
    } else {
        response.getWriter().write("{\"forceLogout\": false}");
    }
}

    private boolean comparePermissions(List<PermissionDTO> sessionList, List<PermissionDTO> dbList) {
        if (sessionList == null || dbList == null || sessionList.size() != dbList.size()) return false;

        for (PermissionDTO p : sessionList) {
            boolean match = dbList.stream().anyMatch(d ->
                    d.getResource().equals(p.getResource()) &&
                            d.getAction().equals(p.getAction()));
            if (!match) return false;
        }
        return true;
    }

}