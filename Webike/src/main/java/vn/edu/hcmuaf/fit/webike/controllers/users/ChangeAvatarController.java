package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet(name = "ChangeAvatarController", value = "/ChangeAvatar")
@MultipartConfig
public class ChangeAvatarController extends HttpServlet {

    final String LEVEL_WARNING = LogService.LEVEL_WARNING;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        String imgold= user.getImage();

        if (user == null) {
            response.sendRedirect("Login");
            return;
        }

        Part filePart = request.getPart("avatar");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("") + "img" + File.separator + "Users";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
        }
        filePart.write(uploadPath + File.separator + fileName);
        String imagePath = "img/Users/" + fileName;

        user.setImage(imagePath);
        UserDao userDao = new UserDao();
        boolean isUpdated = userDao.updateUserAvatar(user);

        if (isUpdated) {
            session.setAttribute("auth", user);
            response.sendRedirect("Profile");
            LogService.log(LEVEL_WARNING, "Dổi ảnh", user.getId()+"", imgold, user.getImage());
        } else {
            request.setAttribute("error", "Cập nhật ảnh đại diện thất bại.");
            request.getRequestDispatcher("Profile").forward(request, response);
        }
    }

}