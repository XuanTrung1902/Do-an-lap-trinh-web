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



@WebServlet(name = "GoogleLoginServlet", value = "/login-google")
public class GoogleLoginServlet extends HttpServlet {
//    private static final String CLIENT_ID = "101282606498-ogsnp108d3sk4f25rbc8pjrq6ad9m4b8.apps.googleusercontent.com";
//
//    private static final String CLIENT_SECRET = "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";
//
//    private static final String REDIRECT_URI = "http://localhost:8080/Webike/homepage";
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String code = request.getParameter("code");
//
//        if (code != null) {
//            GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(
//                    new NetHttpTransport(),
//                    GsonFactory.getDefaultInstance(),
//                    "https://oauth2.googleapis.com/token",
//                    CLIENT_ID,
//                    CLIENT_SECRET,
//                    code,
//                    REDIRECT_URI
//            ).execute();
//
//            GoogleIdToken idToken = tokenResponse.parseIdToken();
//            GoogleIdToken.Payload payload = idToken.getPayload();
//
//
//            String userId = payload.getSubject();
//            String email = payload.getEmail();
//            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
//            String name = (String) payload.get("name");
//            String pictureUrl = (String) payload.get("picture");
//
//            System.out.println("Email: " + email);
//            System.out.println("Name: " + name);
//            System.out.println("Picture URL: " + pictureUrl);
//
////            User user = new User();
////            user.setEmail(email);
////            user.setName(name);
////            user.setImage(pictureUrl);
////
////            System.out.println("User Email: " + user.getEmail());
////            System.out.println("User Name: " + user.getName());
////            System.out.println("User Image: " + user.getImage());
////
////            HttpSession session = request.getSession();
////            session.setAttribute("auth", user);
////            response.sendRedirect("homepage");
//            if (email != null && name != null && pictureUrl != null) {
//                User user = new User();
//                user.setEmail(email);
//                user.setName(name);
//                user.setImage(pictureUrl);
//
//                HttpSession session = request.getSession();
//                session.setAttribute("auth", user);
//                if (user != null) {
//                    System.out.println("User Email: " + user.getEmail());
//                    System.out.println("User Name: " + user.getName());
//                    System.out.println("User Image: " + user.getImage());
//                } else {
//                    System.out.println("User not found in session.");
//                }
//                response.sendRedirect("homepage");
//            } else {
//                response.sendRedirect("errorPage");
//            }
//        } else {
////            String authUrl = new GoogleAuthorizationCodeRequestUrl(
////                    CLIENT_ID,
////                    REDIRECT_URI,
////                    Collections.singleton("email")
////            ).setAccessType("offline").build();
////            response.sendRedirect(authUrl);
//            String authUrl = new GoogleAuthorizationCodeRequestUrl(
//                    CLIENT_ID,
//                    REDIRECT_URI,
//                    Arrays.asList("email", "profile")
//            ).setAccessType("offline").build();
//            response.sendRedirect(authUrl);
//
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String code = request.getParameter("code");
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