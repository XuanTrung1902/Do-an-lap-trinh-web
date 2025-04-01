package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListController", value = "/userList")
public class UserListController extends HttpServlet {
    final String level = LogService.LEVEL_INFO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getVerifiedUsers(0);
        // Lấy thông tin user hiện tại
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("auth");
        String userInfo = (currentUser != null) ? currentUser.getPhoneNum() : "Khách";

        LogService.log(level, "Xem danh sách users", userInfo, "", "");


        if (!userList.isEmpty()) {
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("Admin/user_list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}