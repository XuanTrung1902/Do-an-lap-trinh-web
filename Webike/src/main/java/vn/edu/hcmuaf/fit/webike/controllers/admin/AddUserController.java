package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;

import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.Gson;

@WebServlet(name = "AddUserController", value = "/addUser")
@MultipartConfig
public class AddUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String phoneNum = request.getParameter("phone");
        String DOB = request.getParameter("birthday");
        System.out.println(DOB);
        Date date = Date.valueOf(DOB);
        String sex = request.getParameter("sex");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        int locked = Integer.parseInt(request.getParameter("status"));
        int verify = Integer.parseInt(request.getParameter("verify"));
        int role = Integer.parseInt(request.getParameter("role"));
        String email = request.getParameter("email");

        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("") + File.separator + "img" + File.separator + "Users";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
        }
//        // Đường dẫn thực tế tới tệp ảnh nguồn
        File sourceFile = new File("C:\\Users\\user\\Pictures\\web\\" + fileName);
        File destFile = new File(uploadPath + File.separator + fileName);
        Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

//        filePart.write(uploadPath + File.separator + fileName);
        String imagePath = "img/Users/" + fileName;
        // In ra đường dẫn tuyệt đối để kiểm tra
        System.out.println("File saved at: " + uploadPath + File.separator + fileName);


        if (UserSevice.isPhoneNumExists(phoneNum)) {
            request.setAttribute("error", "Số điện thoại đã tồn tại");
            request.setAttribute("username", name);
            request.setAttribute("phone", phoneNum);
            request.setAttribute("address", address);
            request.setAttribute("sex", sex);
            request.setAttribute("birthday", DOB);
            request.setAttribute("status", locked);
            request.setAttribute("verify", verify);
            request.setAttribute("role", role);
            request.setAttribute("email", email);
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
        user.setImage(imagePath);
        user.setEmail(email);



        UserDao userDao = new UserDao();
        boolean isAdded = userDao.addUserAdmin(user);

        if (isAdded) {
//            response.sendRedirect(request.getContextPath() + "/userList");

            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Lấy ID mới thêm từ DB
                User addedUser = userDao.findUserPhone(phoneNum); // hoặc dùng cách khác nếu cần

                System.out.println(addedUser);

                // Trả về user JSON
                String userJson = new Gson().toJson(addedUser);
                String contextPath = request.getContextPath();

                response.getWriter().write("{\"success\": true, \"user\": " + userJson + ", \"contextPath\": \"" + contextPath + "\"}");
            } else {
                response.sendRedirect(request.getContextPath() + "/userList");
            }
        } else {
//            request.setAttribute("error", "Thêm người dùng thất bại.");
//            request.getRequestDispatcher("/addUser").forward(request, response);
            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"success\": false, \"message\": \"Thêm người dùng thất bại.\"}");
            } else {
                request.setAttribute("error", "Thêm người dùng thất bại.");
                request.getRequestDispatcher("/addUser").forward(request, response);
            }
        }
    }

}