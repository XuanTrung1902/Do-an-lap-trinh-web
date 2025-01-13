package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.User;

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
                h.createUpdate("INSERT INTO accounts (name, phoneNum, DOB, sex, password, created, locked, verify, role, address) VALUES (:name, :phoneNum, :DOB, :sex, :password, :created, :locked, :verify, :role, :address)")
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
        return JDBIConnect.get().withHandle(h -> h.createUpdate("UPDATE accounts SET name = :name, phoneNum = :phoneNum, DOB = :DOB, sex = :sex, address = :address, password = :password WHERE id = :id")
                .bind("name", user.getName())
                .bind("phoneNum", user.getPhoneNum())
                .bind("DOB", user.getDOB())
                .bind("sex", user.getSex())
                .bind("address", user.getAddress())
                .bind("password", user.getPassword())
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
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("UPDATE accounts SET name = :name, phoneNum = :phoneNum, DOB = :DOB, password = :password, address = :address, created = :created, locked = :locked, verify = :verify, role = :role WHERE id = :id")
                        .bind("name", user.getName())
                        .bind("phoneNum", user.getPhoneNum())
                        .bind("DOB", user.getDOB())
                        .bind("password", user.getPassword())
                        .bind("address", user.getAddress())
                        .bind("created", user.getCreated())
                        .bind("locked", user.getLocked())
                        .bind("verify", user.getVerify())
                        .bind("role", user.getRole())
                        .bind("id", user.getId())
                        .execute() > 0
        );
    }


    public boolean addUserAdmin(User user) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("INSERT INTO accounts (name, phoneNum, DOB, sex, password, created, locked, verify, role, address, image) VALUES (:name, :phoneNum, :DOB, :sex, :password, :created, :locked, :verify, :role, :address, :image)")
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
                        .execute() > 0
        );
    }

}

