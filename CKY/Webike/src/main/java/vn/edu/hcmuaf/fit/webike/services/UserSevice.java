package vn.edu.hcmuaf.fit.webike.services;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class UserSevice {
    public static User checklogin(String phoneNum, String password) {
        UserDao userdao = new UserDao();
        User u = userdao.findUserPhone(phoneNum);

        if (u != null && password != null) {
            String hashedPassword = hashPassword(password);
            System.out.println("Hashed Password: " + hashedPassword); // In ra mật khẩu đã mã hóa
            if (hashedPassword.equals(u.getPassword())) {
                u.setPassword(null); // Xóa mật khẩu trước khi trả về user
                return u;
            }
        }
        return null;
    }

    public static boolean isPhoneNumExists(String phoneNum) {
        UserDao userdao = new UserDao();
        return userdao.isPhoneNumExists(phoneNum);
    }

    public static boolean registerUser(User user) {
        UserDao userdao = new UserDao();
        if (isPhoneNumExists(user.getPhoneNum())) {
            return false; // Số điện thoại đã tồn tại
        }
        return userdao.saveUser(user);
    }

    public static boolean updatePasswordByPhone(String phoneNum, String newPassword) {
        UserDao userdao = new UserDao();
        User user = userdao.findUserPhone(phoneNum);
        if (user != null) {
            user.setPassword(hashPassword(newPassword));
            return userdao.updateUser(user);
        }
        return false;
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
