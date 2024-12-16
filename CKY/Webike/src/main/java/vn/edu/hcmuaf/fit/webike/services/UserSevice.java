package vn.edu.hcmuaf.fit.webike.services;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.db.DBConnect;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class UserSevice {
    public static User checklogin(String phone, String password) {
        UserDao userdao = new UserDao();
        User u = userdao.findUserPhone(phone);

        if (u != null && password != null && hashPassword(password).equals(u.getPassword())) {
            u.setPassword(null); // Xóa mật khẩu trước khi trả về user
            return u;
        }
        return null;
    }

    public static boolean registerUser(User user) {
        UserDao userdao = new UserDao();
        return userdao.saveUser(user);
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
