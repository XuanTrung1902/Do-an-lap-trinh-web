package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "FacebookLoginServlet", value = "/login")
public class FacebookLoginServlet extends HttpServlet {
    private static final String CLIENT_ID = "1418575426075396";
    private static final String CLIENT_SECRET = "6ce550295abab520ba3a9fd2f6427982";
    private static final String REDIRECT_URI = "http://localhost:8080/Webike/login?action=facebook";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (!"facebook".equals(action)) {
            response.sendRedirect("Login");
            return;
        }

        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            response.sendRedirect("Login");
            return;
        }

        try {
            // 1. Đổi code lấy access_token
            String accessToken = getAccessToken(code);

            // 2. Lấy thông tin người dùng từ Facebook
            JSONObject userInfo = getUserInfo(accessToken);
            String facebookId = userInfo.getString("id");
            String name = userInfo.getString("name");
            String email = userInfo.optString("email", facebookId + "@facebook.com"); // fallback nếu không có email

            // 3. Kiểm tra xem user đã tồn tại chưa
            UserSevice userService = new UserSevice();
            User user = userService.findByEmail(email);

            if (user == null) {
                // Nếu chưa có user → tạo user mới với thông tin mặc định
                userService.insertUser(name, email);
                user = userService.findByEmail(email); // lấy lại user vừa tạo
            }

            // 4. Lưu user vào session
            HttpSession session = request.getSession();
            session.setAttribute("auth", user);

            // 5. Chuyển hướng đến trang chính
            response.sendRedirect("homepage");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Login");
        }
    }

    // Lấy access token từ Facebook
    private String getAccessToken(String code) throws IOException {
        String tokenUrl = String.format(
                "https://graph.facebook.com/v18.0/oauth/access_token?client_id=%s&redirect_uri=%s&client_secret=%s&code=%s",
                CLIENT_ID, URLEncoder.encode(REDIRECT_URI, "UTF-8"), CLIENT_SECRET, code
        );

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(tokenUrl).build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        JSONObject json = new JSONObject(responseBody);
        return json.getString("access_token");
    }

    // Lấy thông tin user từ access token
    private JSONObject getUserInfo(String accessToken) throws IOException {
        String url = String.format(
                "https://graph.facebook.com/me?fields=id,name,email&access_token=%s",
                URLEncoder.encode(accessToken, "UTF-8")
        );

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        return new JSONObject(responseBody);
    }
}
