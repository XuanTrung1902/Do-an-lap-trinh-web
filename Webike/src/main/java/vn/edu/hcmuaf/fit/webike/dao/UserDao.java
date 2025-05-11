package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
// dăng nhập
    public User findUserPhone(String phoneNum) {
        return JDBIConnect.get().withHandle(h -> h.createQuery("SELECT * FROM accounts WHERE phoneNum = :phoneNum")
                .bind("phoneNum", phoneNum)
                .mapToBean(User.class)
                .findFirst()
                .orElse(null));
    }


    // Đăng ký
    public boolean saveUser(User user) {
        return JDBIConnect.get().withHandle(h ->
                h.createUpdate("INSERT INTO accounts (name, phoneNum, DOB, sex, password, created, locked, verify, role, address, email) VALUES (:name, :phoneNum, :DOB, :sex, :password, :created, :locked, :verify, :role, :address, :email)")
                        .bind("name", user.getName())
                        .bind("phoneNum", user.getPhoneNum())
                        .bind("DOB", user.getDOB())
                        .bind("sex", user.getSex())
                        .bind("password", user.getPassword())
                        .bind("created", user.getCreated())
                        .bind("locked", user.getLocked())
                        .bind("verify", user.getVerify())
                        .bind("role", user.getRole())
                        .bind("address", user.getAddress())
                        .bind("email", user.getEmail())
                        .execute() > 0
        );
    }

    // Admin
    // Thêm người dùng mới
    public boolean addUser(User user) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("INSERT INTO accounts (name, phoneNum, DOB, sex, password, created, locked, verify, role, address) VALUES (:name, :phoneNum, :DOB, :sex, :password, :created, :locked, :verify, :role, :address)")
                        .bind("name", user.getName())
                        .bind("phoneNum", user.getPhoneNum())
                        .bind("DOB", user.getDOB())
                        .bind("sex", user.getSex())
                        .bind("password", user.getPassword())
                        .bind("created", user.getCreated())
                        .bind("locked", user.getLocked())
                        .bind("verify", user.getVerify())
                        .bind("role", user.getRole())
                        .bind("address", user.getAddress())
                        .execute() > 0
        );
    }



    // Kiểm tra sdt
    public boolean isPhoneNumExists(String phoneNum) {
        return JDBIConnect.get().withHandle(h ->
                h.createQuery("SELECT COUNT(*) FROM accounts WHERE phoneNum = :phoneNum")
                        .bind("phoneNum", phoneNum)
                        .mapTo(Integer.class)
                        .findOnly() > 0
        );
    }



// Cập nhật user cho trang TT kHách hàng

    public boolean updateUser(User user) {
        return JDBIConnect.get().withHandle(h -> h.createUpdate("UPDATE accounts SET name = :name, phoneNum = :phoneNum, DOB = :DOB, sex = :sex, address = :address, password = :password, email = :email WHERE id = :id")
                .bind("name", user.getName())
                .bind("phoneNum", user.getPhoneNum())
                .bind("DOB", user.getDOB())
                .bind("sex", user.getSex())
                .bind("address", user.getAddress())
                .bind("password", user.getPassword())
                .bind("email", user.getEmail())
                .bind("id", user.getId())
                .execute() > 0);
    }


    // Lấy danh sách tất cả người dùng
    // chức năng quản lý người duùng admin
    public List<User> getAllUsers() {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM accounts")
                        .mapToBean(User.class)
                        .list()
        );
    }

// Admin
    // Sửa thông tin người dùng
    public boolean updateUserAdmin(User user) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("UPDATE accounts SET name = :name, phoneNum = :phoneNum, DOB = :DOB, sex = :sex, password = :password, created = :created, locked = :locked, verify = :verify, role = :role, address = :address WHERE id = :id")
                        .bind("name", user.getName())
                        .bind("phoneNum", user.getPhoneNum())
                        .bind("DOB", user.getDOB())
                        .bind("sex", user.getSex())
                        .bind("password", user.getPassword())
                        .bind("created", user.getCreated())
                        .bind("locked", user.getLocked())
                        .bind("verify", user.getVerify())
                        .bind("role", user.getRole())
                        .bind("address", user.getAddress())
                        .bind("id", user.getId())
                        .execute() > 0
        );
    }
// Admin
    // Xóa người dùng
    public boolean deleteUser(int id) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("DELETE FROM accounts WHERE id = :id")
                        .bind("id", id)
                        .execute() > 0
        );
    }
    // admin quan lý ngươi dung
    // Lấy danh sách tất cả người dùng có verify = 0
    public List<User> getVerifiedUsers(int verify) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM accounts WHERE verify = :verify")
                        .bind("verify", verify)
                        .mapToBean(User.class)
                        .list()
        );
    }
    // admin quản lý người dùng
    // Cập nhật verify của người dùng
    public boolean updateUserVerify(int id, int verify) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("UPDATE accounts SET verify = :verify WHERE id = :id")
                        .bind("verify", verify)
                        .bind("id", id)
                        .execute() > 0
        );
    }


    // Lấy người dùng theo ID
    public User getUserById(int id) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM accounts WHERE id = :id")
                        .bind("id", id)
                        .mapToBean(User.class)
                        .findOne()
                        .orElse(null)
        );
    }

    // Sửa thông tin người dùng
    public boolean updateUserSua(User user) {
        return JDBIConnect.get().withHandle(handle -> {
            StringBuilder query = new StringBuilder("UPDATE accounts SET name = :name, phoneNum = :phoneNum, DOB = :DOB, password = :password, address = :address, created = :created, locked = :locked, verify = :verify, role = :role, email = :email");
            if (user.getImage() != null) {
                query.append(", image = :image");
            }
            query.append(" WHERE id = :id");

            var update = handle.createUpdate(query.toString())
                    .bind("name", user.getName())
                    .bind("phoneNum", user.getPhoneNum())
                    .bind("DOB", user.getDOB())
                    .bind("password", user.getPassword())
                    .bind("address", user.getAddress())
                    .bind("created", user.getCreated())
                    .bind("locked", user.getLocked())
                    .bind("verify", user.getVerify())
                    .bind("role", user.getRole())
                    .bind("email", user.getEmail()) // Bind email
                    .bind("id", user.getId());

            if (user.getImage() != null) {
                update.bind("image", user.getImage());
            }

            return update.execute() > 0;
        });
    }



    public boolean addUserAdmin(User user) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("INSERT INTO accounts (name, phoneNum, DOB, sex, password, created, locked, verify, role, address, image, email) VALUES (:name, :phoneNum, :DOB, :sex, :password, :created, :locked, :verify, :role, :address, :image, :email)")
                        .bind("name", user.getName())
                        .bind("phoneNum", user.getPhoneNum())
                        .bind("DOB", user.getDOB())
                        .bind("sex", user.getSex())
                        .bind("password", user.getPassword())
                        .bind("created", user.getCreated())
                        .bind("locked", user.getLocked())
                        .bind("verify", user.getVerify())
                        .bind("role", user.getRole())
                        .bind("address", user.getAddress())
                        .bind("image", user.getImage())
                        .bind("email", user.getEmail())
                        .execute() > 0
        );
    }

    // thông tin khách hàng phần avatar
    public boolean updateUserAvatar(User user) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("UPDATE accounts SET image = :image WHERE id = :id")
                        .bind("image", user.getImage())
                        .bind("id", user.getId())
                        .execute() > 0
        );
    }
    public User findUserByEmail(String email) {
        return JDBIConnect.get().withHandle(h -> h.createQuery("SELECT * FROM accounts WHERE email = :email")
                .bind("email", email)
                .mapToBean(User.class)
                .findFirst()
                .orElse(null));
    }
    // sữa gg
//    public void insertUser(String name, String email) {
//        JDBIConnect.get().withHandle(h -> h.createUpdate("INSERT INTO accounts (name, email) VALUES (:name, :email)")
//                .bind("name", name)
//                .bind("email", email)
//                .execute());
//    }

    public void insertUser(String name, String email) {
        JDBIConnect.get().withHandle(h -> h.createUpdate(
                        "INSERT INTO accounts (name, email, phoneNum, password, image, DOB, sex, address) VALUES (:name, :email, :phoneNum, :password, :image, :dob, :sex, :address)")
                .bind("name", name)
                .bind("email", email)
                .bind("phoneNum", "0000000000")
                .bind("password", "google")
                .bind("image", "img/Users/default.png")
                .bind("dob", "2000-01-01")
                .bind("sex", "Khác")
                .bind("address", "Chưa cập nhật")
                .execute());
    }

    public String getPasswordByEmail(String email) {
        return JDBIConnect.get().withHandle(h ->
                h.createQuery("SELECT password FROM accounts WHERE email = :email")
                        .bind("email", email)
                        .mapTo(String.class)
                        .findOne()
                        .orElse(null)
        );
    }

//    public void insertUsers(List<User> users) {
//        JDBIConnect.get().useHandle(handle -> {
//            String sql = "INSERT INTO users (name, password, DOB, sex, address, phoneNum, role, locked) VALUES (:name, :password, :DOB, :sex, :address, :phoneNum, :role, :locked)";
//            handle.prepareBatch(sql)
//                    .bindList("name", users.stream().map(User::getName).toList())
//                    .bindList("password", users.stream().map(User::getPassword).toList())
//                    .bindList("DOB", users.stream().map(u -> u.getDOB() != null ? u.getDOB().toString() : null).toList())
//                    .bindList("sex", users.stream().map(User::getSex).toList())
//                    .bindList("address", users.stream().map(User::getAddress).toList())
//                    .bindList("phoneNum", users.stream().map(User::getPhoneNum).toList())
//                    .bindList("role", users.stream().map(User::getRole).toList())
//                    .bindList("locked", users.stream().map(User::getLocked).toList())
//                    .execute();
//        });
//    }

    public void insertUsers(List<User> users) {
        JDBIConnect.get().useHandle(handle -> {
            String sql = "INSERT INTO accounts (name, phoneNum, DOB, sex, password, address, role, locked, verify, email) " +
                    "VALUES (:name, :phoneNum, :DOB, :sex, :password, :address, :role, :locked, :verify, :email)";

            var batch = handle.prepareBatch(sql);

            for (User user : users) {
                batch.bind("name", user.getName())
                        .bind("phoneNum", user.getPhoneNum())
                        .bind("DOB", user.getDOB() != null ? user.getDOB().toString() : null)
                        .bind("sex", user.getSex())
                        .bind("password", user.getPassword())
                        .bind("address", user.getAddress())
                        .bind("role", user.getRole())
                        .bind("locked", user.getLocked())
                        .bind("verify", user.getVerify())
                        .bind("email", user.getEmail())
                        .add();
            }
            batch.execute();
        });
    }

    public boolean checkForceLogout(int userId) {
        return JDBIConnect.get().withHandle(h ->
                h.createQuery("SELECT force_logout FROM accounts WHERE id = :id")
                        .bind("id", userId)
                        .mapTo(Boolean.class)
                        .findOne()
                        .orElse(false)
        );
    }
    public void forceLogoutUser(int userId) {
        JDBIConnect.get().withHandle(h ->
                h.createUpdate("UPDATE accounts SET force_logout = 1 WHERE id = :id")
                        .bind("id", userId)
                        .execute()
        );
    }
    public void updateOtpSecret(int userId, String secret) {
        JDBIConnect.get().useHandle(handle ->
                handle.createUpdate("UPDATE accounts SET otp_secret = :secret WHERE id = :id")
                        .bind("secret", secret)
                        .bind("id", userId)
                        .execute()
        );
    }

    public void updateOtpEnabled(int userId, boolean enabled) {
        JDBIConnect.get().useHandle(handle ->
                handle.createUpdate("UPDATE accounts SET otp_enabled = :enabled WHERE id = :id")
                        .bind("enabled", enabled ? 1 : 0)
                        .bind("id", userId)
                        .execute()
        );
    }

}

