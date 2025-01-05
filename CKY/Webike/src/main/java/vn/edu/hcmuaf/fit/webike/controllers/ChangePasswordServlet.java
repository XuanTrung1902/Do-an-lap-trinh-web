package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", value = "/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");

        if (user != null) {
            String currentPassword = request.getParameter("current-password");
            String newPassword = request.getParameter("new-password");
            String confirmPassword = request.getParameter("confirm-password");

            if (newPassword.equals(confirmPassword)) {
                boolean isUpdated = UserSevice.updatePassword(user, currentPassword, newPassword);
                if (isUpdated) {
                    request.setAttribute("message", "Đổi mật khẩu thành công!");
                } else {
                    request.setAttribute("error", "Mật khẩu cũ không đúng!");
                }
            } else {
                request.setAttribute("error", "Mật khẩu mới và xác nhận mật khẩu không khớp!");
            }
            response.sendRedirect(request.getContextPath() + "/Profile");
//            request.getRequestDispatcher("GKY/trangTTKhachHang.jsp").forward(request, response);
        } else {
            response.sendRedirect("GKY/Dangnhap.jsp");
        }
    }

}