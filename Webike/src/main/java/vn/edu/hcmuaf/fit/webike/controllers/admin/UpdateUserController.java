package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;

@WebServlet(name = "UpdateUserController", value = "/updateUser")
@MultipartConfig
public class UpdateUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(id);
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
        UserDao userDao = new UserDao();
        User oldUser = userDao.getUserById(id); // Lấy thông tin trước khi cập nhật

//        int id = Integer.parseInt(userIdStr);
        String name = request.getParameter("username");
        String phoneNum = request.getParameter("phone");
        String DOB = request.getParameter("birthday");
        Date date = Date.valueOf(DOB);
        String sex = request.getParameter("sex");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String created = request.getParameter("created_at");
        int locked = Integer.parseInt(request.getParameter("status"));
        int verify = Integer.parseInt(request.getParameter("verify"));
        int role = Integer.parseInt(request.getParameter("role"));
        String email = request.getParameter("email");


        Part filePart = request.getPart("image");
        String imagePath = null;
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String uploadPath = getServletContext().getRealPath("") + "img" + File.separator + "Users";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
            }
            filePart.write(uploadPath + File.separator + fileName);
            imagePath = "img/Users/" + fileName;
        }



//        User user = new User(id, name, phoneNum, date, sex, password, created, locked, verify, role, address);
//        user.setEmail(email);
//        if (imagePath != null) {
//            user.setImage(imagePath);
//        }
        User newUser = new User(id, name, phoneNum, date, sex, password, created, locked, verify, role, address);
        newUser.setEmail(email);
        if (imagePath != null) {
            newUser.setImage(imagePath);
        }


        userDao = new UserDao();
        boolean isUpdated = userDao.updateUserSua(newUser);

        if (isUpdated) {
            HttpSession session = request.getSession();
            User currentUser = (User) session.getAttribute("auth");
            String adminInfo = (currentUser != null) ? currentUser.getPhoneNum() : "Admin vô danh";

            String beforeData = oldUser.toString();
            String afterData = newUser.toString();
            String logLevel = (oldUser.getRole() != newUser.getRole()) ? LogService.LEVEL_WARNING : LogService.LEVEL_ALERT;

//            LogService.log(logLevel, "Sữa user admin", adminInfo, beforeData, afterData);

            response.sendRedirect(request.getContextPath() + "/userList");
        } else {
            request.setAttribute("error", "Cập nhật thông tin người dùng thất bại.");
            request.getRequestDispatcher("/Admin/user_edit.jsp").forward(request, response);
        }
    }
}
