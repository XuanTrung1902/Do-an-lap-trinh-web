package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;

@WebServlet(name = "loginController", value = "/Dangnhap")
public class loginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        User user = UserSevice.checklogin(phone, password);  // kiểm tra login

        if (user != null) { // nếu login đúng
            HttpSession session = request.getSession(true);
            session.setAttribute("auth", user); // Đặt user vào session với key "auth"

            if (user.getRole() == 1) { // nếu là admin
                response.sendRedirect("Admin/admin.jsp");
            } else { // nếu là user
                response.sendRedirect("GKY/homepage.jsp");
            }
        } else { // nếu login sai
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
        }
    }

}
