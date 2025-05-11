package vn.edu.hcmuaf.fit.webike.controllers.users;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//import com.google.api.client.json.gson.GsonFactory;
//import vn.edu.hcmuaf.fit.webike.models.User;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Collections;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.models.GoogleAccount;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.GoogleLogin;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;



@WebServlet(name = "GoogleLoginServlet", value = "/googlelogin")
public class GoogleLoginServlet extends HttpServlet {

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

    response.sendRedirect("homepage");
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}