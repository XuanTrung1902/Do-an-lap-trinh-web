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
        int userId = Integer.parseInt(request.getParameter("userId"));
        int roleId = Integer.parseInt(request.getParameter("roleId"));

        try (Handle handle = JDBIConnect.get().open()) {
            // 1. Xóa hết vai trò cũ
            handle.createUpdate("DELETE FROM user_role WHERE user_id = :uid")
                    .bind("uid", userId)
                    .execute();

            // 2. Gán vai trò mới
            handle.createUpdate("INSERT INTO user_role (user_id, role_id) VALUES (:uid, :rid)")
                    .bind("uid", userId)
                    .bind("rid", roleId)
                    .execute();

            // 3. Chuyển về danh sách người dùng
            response.sendRedirect(request.getContextPath() + "/userList");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi phân quyền.");
        }
    }

}