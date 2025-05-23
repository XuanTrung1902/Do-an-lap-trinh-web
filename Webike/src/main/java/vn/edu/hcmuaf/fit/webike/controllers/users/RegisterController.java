package vn.edu.hcmuaf.fit.webike.controllers.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.services.EmailService;
import vn.edu.hcmuaf.fit.webike.services.LogService;
import vn.edu.hcmuaf.fit.webike.services.OTPService;
import vn.edu.hcmuaf.fit.webike.services.UserSevice;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private static final String SECRET_KEY = "6LfYyu4qAAAAAC7wHwxKsL8AV4NY3f9vgjA1BZM1";
    final String LEVEL_INFO = LogService.LEVEL_INFO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String dob = year + "-" + month + "-" + day;
        Date date = Date.valueOf(dob);
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String email = request.getParameter("email");
        String otp = request.getParameter("otp");

        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean isCaptchaValid = verifyRecaptcha(gRecaptchaResponse);

        if (!isCaptchaValid) {
            request.setAttribute("error", "Xác nhận CAPTCHA không thành công");
            setRequestAttributes(request, fullname, phone, address, gender, day, month, year, email);
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        String sessionOtp = (String) session.getAttribute("otp");

        if (!otp.equals(sessionOtp)) {
            request.setAttribute("error", "OTP không đúng!");
            setRequestAttributes(request, fullname, phone, address, gender, day, month, year, email);
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
            return;
        }

        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Mật khẩu không khớp");
            setRequestAttributes(request, fullname, phone, address, gender, day, month, year, email);
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
            return;
        }
        if (UserSevice.isPhoneNumExists(phone)) {
            request.setAttribute("error", "Số điện thoại đã tồn tại");
            setRequestAttributes(request, fullname, phone, address, gender, day, month, year, email);
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setName(fullname);
        user.setPhoneNum(phone);
        user.setAddress(address);
        user.setSex(gender);
        user.setDOB(date);
        user.setPassword(UserSevice.hashPassword(password));
        user.setCreated(LocalDate.now().toString());
        user.setLocked(0);
        user.setVerify(0);
        user.setRole(1);
        user.setEmail(email);

        boolean isRegistered = UserSevice.registerUser(user);

        if (isRegistered) {
            LogService.log(LEVEL_INFO, "Đăng ký", phone, "", user.toString());
            response.sendRedirect("Login");
        } else {
            request.setAttribute("error", "Đăng ký thất bại");
            setRequestAttributes(request, fullname, phone, address, gender, day, month, year, email);
            request.getRequestDispatcher("GKY/dangKy.jsp").forward(request, response);
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

    private void setRequestAttributes(HttpServletRequest request, String fullname, String phone, String address, String gender, String day, String month, String year, String email) {
        request.setAttribute("fullname", fullname);
        request.setAttribute("phone", phone);
        request.setAttribute("address", address);
        request.setAttribute("gender", gender);
        request.setAttribute("day", day);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        request.setAttribute("email", email);
    }

}