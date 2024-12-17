package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.util.List;

public class UserDao {

    public User findUserPhone(String phone) {
        return JDBIConnect.get().withHandle(h-> h.createQuery("select  * from users where phone = :phone")
                .bind("phone",phone)
                .mapToBean(User.class)
                .findFirst()
                .orElse(null));
    }

    public boolean saveUser(User user) {
        return JDBIConnect.get().withHandle(h ->
                h.createUpdate("INSERT INTO users (username, password, name, phone, dob, gender, address, role, img) VALUES (:username, :password, :name, :phone, :dob, :gender, :address, :role, :img)")
                        .bind("username", user.getUsername()) // Gán giá trị cho username
                        .bind("password", user.getPassword())
                        .bind("name", user.getName())         // Gán giá trị cho name
                        .bind("phone", user.getPhone())
                        .bind("dob", user.getDob())
                        .bind("gender", user.getGender())
                        .bind("address", user.getAddress())
                        .bind("role", user.getRole())
                        .bind("img", user.getImg())
                        .execute() > 0
        );
    }
    public boolean updateUser(User user) {
        return JDBIConnect.get().withHandle(h -> h.createUpdate("update users set password = :password where phone = :phone")
                .bind("password", user.getPassword())
                .bind("phone", user.getPhone())
                .execute()) > 0;
    }


    public List<User> findAll() {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM users")
                        .mapToBean(User.class)
                        .list()
        );
    }


}

