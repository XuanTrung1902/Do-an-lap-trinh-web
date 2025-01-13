package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.sql.Date;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "AddUserController", value = "/addUser")
public class AddUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String phoneNum = request.getParameter("phone");
        String DOB = request.getParameter("birthday");
        Date date = Date.valueOf(DOB);
        String sex = request.getParameter("sex");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        int locked = Integer.parseInt(request.getParameter("status"));
        int verify = Integer.parseInt(request.getParameter("verify"));
        int role = Integer.parseInt(request.getParameter("role"));

        if (UserSevice.isPhoneNumExists(phoneNum)) {
            request.setAttribute("error", "Số điện thoại đã tồn tại");
            request.getRequestDispatcher("/addUser").forward(request, response);
            return;
        }

        User user = new User();
        user.setName(name);
        user.setPhoneNum(phoneNum);
        user.setAddress(address);
        user.setSex(sex);
        user.setDOB(date);
        user.setPassword(UserSevice.hashPassword(password));
        user.setCreated(LocalDate.now().toString());
        user.setLocked(locked);
        user.setVerify(verify);
        user.setRole(role);

        UserDao userDao = new UserDao();
        boolean isAdded = userDao.addUserAdmin(user);

        if (isAdded) {
            response.sendRedirect(request.getContextPath() + "/userList");
        } else {
            request.setAttribute("error", "Thêm người dùng thất bại.");
            request.getRequestDispatcher("/addUser").forward(request, response);
        }
    }

}