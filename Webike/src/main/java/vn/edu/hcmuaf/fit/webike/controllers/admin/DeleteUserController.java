package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;

import java.io.IOException;

@WebServlet(name = "DeleteUserController", value = "/deleteUser")
public class DeleteUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserDao userDao = new UserDao();
            boolean isUpdated = userDao.updateUserVerify(id, 1); // Soft delete

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            if (isUpdated) {
                response.getWriter().write("{\"success\": true}");
            } else {
                response.getWriter().write("{\"success\": false, \"message\": \"Không thể cập nhật trạng thái người dùng.\"}");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": false, \"message\": \"Dữ liệu đầu vào không hợp lệ.\"}");
        }
    }

}