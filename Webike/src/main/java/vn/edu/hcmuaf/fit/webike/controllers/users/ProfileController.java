package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.LogService;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ProfileController", value = "/Profile")
public class ProfileController extends HttpServlet {
    final String levelInfo = LogService.LEVEL_INFO;
    final String levelAlert = LogService.LEVEL_ALERT;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        if (user != null) {
            LogService.log(levelInfo, "Xem thông tin cá nhân", user.getPhoneNum(), user.toString(), "");
            request.setAttribute("user", user);
            request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        if (user != null) {
            String fullname = request.getParameter("fullname");
            String newPhone = request.getParameter("phone");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            String dob = year + "-" + month + "-" + day;
            Date date = Date.valueOf(dob);
            String email = request.getParameter("email");

            if (!newPhone.equals(user.getPhoneNum())) {
                if (UserSevice.isPhoneNumExists(newPhone)) {
                    request.setAttribute("error", "Số điện thoại đã tồn tại");
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
                    return;
                }
            }
            String before = user.toString();

            user.setName(fullname);
            user.setPhoneNum(newPhone);
            user.setAddress(address);
            user.setSex(gender);
            user.setDOB(date);
            user.setEmail(email);
            user.setPassword(user.getPassword());

            boolean isUpdated = UserSevice.updateUser(user);

            if (isUpdated) {
                String after = user.toString();
                LogService.log(levelAlert, "Sữa thông tin cá nhân", user.getPhoneNum(), before, after);

                session.setAttribute("auth", user);
                request.setAttribute("message", "Cập nhật thông tin thành công!");
            } else {
                request.setAttribute("error", "Cập nhật thông tin thất bại!");
            }

            request.setAttribute("user", user);
            request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
    }

}