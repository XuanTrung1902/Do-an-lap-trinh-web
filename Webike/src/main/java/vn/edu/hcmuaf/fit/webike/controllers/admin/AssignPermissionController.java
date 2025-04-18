package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.jdbi.v3.core.Handle;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;

import java.io.IOException;

@WebServlet(name = "AssignPermissionController", value = "/assignPermission")
public class AssignPermissionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            // Kiểm tra xem userId có hợp lệ không
            String userIdStr = request.getParameter("userId");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("userId không hợp lệ.");
            }

            int userId = Integer.parseInt(userIdStr);

            String[] permissionValues = request.getParameterValues("permissions");
            if (permissionValues == null || permissionValues.length == 0) {
                throw new IllegalArgumentException("Permissions không hợp lệ.");
            }

            RoleDao roleDao = new RoleDao();
            int roleId = roleDao.getOrCreateCustomRoleForUser(userId);

            roleDao.clearPermissionsForRole(roleId);

            if (permissionValues != null) {
                for (String value : permissionValues) {
                    String[] parts = value.split("-");
                    if (parts.length == 2) {
                        int resId = Integer.parseInt(parts[0]);
                        int permId = Integer.parseInt(parts[1]);
                        roleDao.addPermissionForRole(roleId, resId, permId);
                    }
                }
            }

            roleDao.assignRoleToUser(userId, roleId);

            response.sendRedirect(request.getContextPath() + "/userList");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.getWriter().write("{\"status\": \"error\", \"message\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.getWriter().write("{\"status\": \"error\", \"message\": \"Lỗi khi xử lý yêu cầu. Vui lòng thử lại sau.\"}");
        }
    }

}