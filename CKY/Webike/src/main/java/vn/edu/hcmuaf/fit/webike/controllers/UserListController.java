package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserListController", value = "/userList")
public class UserListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getVerifiedUsers(0); // Chỉ lấy những tài khoản có verify = 0
        if (!userList.isEmpty()) {
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("Admin/user_list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}