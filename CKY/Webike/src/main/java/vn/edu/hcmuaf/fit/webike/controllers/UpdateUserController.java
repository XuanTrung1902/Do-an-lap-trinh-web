package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "UpdateUserController", value = "/admin/updateUser")
public class UpdateUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phoneNum = request.getParameter("phoneNum");
        String DOB = request.getParameter("DOB");
        Date date = Date.valueOf(DOB);
        String sex = request.getParameter("sex");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        User user = new User(id, name, phoneNum, date, sex, password, null, 0, 0, 1, address);
        UserDao userDao = new UserDao();
        boolean isUpdated = userDao.updateUserAdmin(user);

        if (isUpdated) {
            response.sendRedirect(request.getContextPath() + "/admin/userList");
        } else {
            request.setAttribute("error", "Cập nhật thông tin người dùng thất bại.");
            request.getRequestDispatcher("/admin/user_edit.jsp").forward(request, response);
        }
    }

}