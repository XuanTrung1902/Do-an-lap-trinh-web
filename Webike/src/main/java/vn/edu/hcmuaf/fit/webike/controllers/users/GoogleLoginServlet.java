package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.models.GoogleAccount;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.GoogleLogin;
import vn.edu.hcmuaf.fit.webike.services.LogService;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;



@WebServlet(name = "GoogleLoginServlet", value = "/googlelogin")
public class GoogleLoginServlet extends HttpServlet {
    final String LEVEL_INFO = LogService.LEVEL_INFO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            response.sendRedirect("/login.jsp?error=Google login failed");
            return;
        }
        GoogleLogin gg = new GoogleLogin();
        String accessToken = gg.getToken(code);
        GoogleAccount account = gg.getUserInfo(accessToken);
        HttpSession session = request.getSession();

        if (account == null || account.getEmail() == null) {
            response.sendRedirect("/WEB-INF/404.jsp");
            return;
        }

        UserSevice userService = new UserSevice();
        User user = userService.findByEmail(account.getEmail());

        if (user != null) {
            session.setAttribute("auth", user);
        } else {
            userService.insertUser(account.getName(), account.getEmail());
            user = userService.findByEmail(account.getEmail());
            session.setAttribute("auth", user);
        }
        LogService.log(LEVEL_INFO, "Đăng nhập Google", user.getPhoneNum(), "Trạng thái: Chưa đăng nhập", "Trạng thái: Đã đăng nhập");

        response.sendRedirect("homepage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}