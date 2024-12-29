package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;

import java.io.IOException;

@WebServlet(name = "DeleteUserController", value = "/admin/deleteUser")
public class DeleteUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        boolean isDeleted = userDao.deleteUser(id);

        if (isDeleted) {
            response.sendRedirect(request.getContextPath() + "/admin/userList");
        } else {
            request.setAttribute("error", "Xóa người dùng thất bại.");
            request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
        }
    }

}