package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.models.PermissionDTO;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.services.LogService;
import vn.edu.hcmuaf.fit.webike.services.PermissionService;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;



@WebServlet(name = "loginController", value = "/Login")
public class loginController extends HttpServlet {

    final String LEVEL_INFO = LogService.LEVEL_INFO;
    final String LEVEL_WARNING = LogService.LEVEL_WARNING;
    private static final String SECRET_KEY = "6LfYyu4qAAAAAC7wHwxKsL8AV4NY3f9vgjA1BZM1";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNum = request.getParameter("phone");
        String password = request.getParameter("password");

        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean isCaptchaValid = verifyRecaptcha(gRecaptchaResponse);
        if (isCaptchaValid) {
            User user = UserSevice.checklogin(phoneNum, password);  // kiểm tra login
            if (user != null) { // nếu login đúng
                if (user.isOtpEnabled()) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("pending2fa", user);
                    response.sendRedirect("GKY/verify-login-otp.jsp");
                    return;
                }

                HttpSession session = request.getSession(true);
                session.setAttribute("auth", user); // Đặt user vào session với key "auth"

                Cart cart = new Cart(); // tạo session chứa cart khi đăng nhập thành công
                session.setAttribute("cart", cart);
                cart.setData(user.getId()); // lấy dữ liệu từ DB và lưu vào cart

                LogService.log(LEVEL_INFO, "Đăng nhập", phoneNum, "Trạng thái: Chưa đăng nhập", "Trạng thái: Đã đăng nhập");

                List<PermissionDTO> permissions = PermissionService.getPermissionsForUser(user.getId());
                session.setAttribute("permissions", permissions);

                if (user.getRole() == 0) { // nếu là admin
                    response.sendRedirect("dashboard");
                } else { // nếu là user
                    response.sendRedirect("homepage");
                }
            } else { // nếu login sai
                LogService.log(LEVEL_WARNING, "Đăng nhập", phoneNum, "Trạng thái: Chưa đăng nhập", "Trạng thái: Dăng nhập sai");
                request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
                request.setAttribute("phone", phoneNum);
                request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Xác nhận CAPTCHA không thành công");
            request.setAttribute("phone", phoneNum);
            request.getRequestDispatcher("GKY/Dangnhap.jsp").forward(request, response);
        }
    }

    private boolean verifyRecaptcha(String gRecaptchaResponse) {
        try {
            String url = "https://www.google.com/recaptcha/api/siteverify";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            String postParams = "secret=" + SECRET_KEY + "&response=" + gRecaptchaResponse;
            OutputStream os = con.getOutputStream();
            os.write(postParams.getBytes());
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(con.getInputStream());
                String responseBody = scanner.useDelimiter("\\A").next();
                scanner.close();

                return responseBody.contains("\"success\": true");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
