package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "UpdateUserController", value = "/updateUser")
public class UpdateUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(id);
        System.out.println(user);
        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/Admin/user_edit.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/userList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter("userId");
        if (userIdStr == null || userIdStr.isEmpty()) {
            request.setAttribute("error", "ID người dùng không hợp lệ.");
            request.getRequestDispatcher("/Admin/user_edit.jsp").forward(request, response);
            return;
        }

        int id = Integer.parseInt(userIdStr);
        System.out.println(id);
        String name = request.getParameter("username");
        String phoneNum = request.getParameter("phone");
        String DOB = request.getParameter("birthday");
        Date date = Date.valueOf(DOB);
        String sex = request.getParameter("sex");
        System.out.println(sex);
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String created = request.getParameter("created_at");
        int locked = Integer.parseInt(request.getParameter("status"));
        int verify = Integer.parseInt(request.getParameter("verify"));
        int role = Integer.parseInt(request.getParameter("role"));

        User user = new User(id, name, phoneNum, date, sex, password, created, locked, verify, role, address);
        UserDao userDao = new UserDao();
        boolean isUpdated = userDao.updateUserSua(user);
        System.out.println(isUpdated);

        if (isUpdated) {
            response.sendRedirect(request.getContextPath() + "/userList");
        } else {
            request.setAttribute("error", "Cập nhật thông tin người dùng thất bại.");
            request.getRequestDispatcher("/Admin/user_edit.jsp").forward(request, response);
        }
    }
}
