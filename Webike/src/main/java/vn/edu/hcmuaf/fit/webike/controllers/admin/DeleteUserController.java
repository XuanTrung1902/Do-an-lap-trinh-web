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
        boolean isUpdated = userDao.updateUserVerify(id, 1); // Cập nhật verify thành 1

        if (isUpdated) {
            response.sendRedirect(request.getContextPath() + "/userList");
        } else {
            request.setAttribute("error", "Cập nhật trạng thái người dùng thất bại.");
            request.getRequestDispatcher("Admin/user_list.jsp").forward(request, response);
        }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Lỗi dữ liệu đầu vào");
        }
    }
}