package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;

@WebServlet(name = "loginController", value = "/Login")
public class loginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNum = request.getParameter("phone");
        String password = request.getParameter("password");
        User user = UserSevice.checklogin(phoneNum, password);  // kiểm tra login

        if (user != null) { // nếu login đúng
            HttpSession session = request.getSession(true);
            session.setAttribute("auth", user); // Đặt user vào session với key "auth"
//            session.setAttribute("welcomeMessage", "Xin chào, " + user.getName() + "!");

            if (user.getRole() == 0) { // nếu là admin
                response.sendRedirect(" admin");
            } else { // nếu là user
                response.sendRedirect("GKY/homepage.jsp");
            }
        } else { // nếu login sai
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            request.setAttribute("phone", phoneNum);
//            request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
            response.sendRedirect("Login");
        }
    }

}
