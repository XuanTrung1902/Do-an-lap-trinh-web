package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.util.List;

public class UserDao {

    public User findUserPhone(String phoneNum) {
        return JDBIConnect.get().withHandle(h -> h.createQuery("SELECT * FROM accounts WHERE phoneNum = :phoneNum")
                .bind("phoneNum", phoneNum)
                .mapToBean(User.class)
                .findFirst()
                .orElse(null));
    }

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

    public boolean isPhoneNumExists(String phoneNum) {
        return JDBIConnect.get().withHandle(h ->
                h.createQuery("SELECT COUNT(*) FROM accounts WHERE phoneNum = :phoneNum")
                        .bind("phoneNum", phoneNum)
                        .mapTo(Integer.class)
                        .findOnly() > 0
        );
    }

//    public boolean updateUser(User user) {
//        return JDBIConnect.get().withHandle(h -> h.createUpdate("UPDATE accounts SET name = :name, phoneNum = :phoneNum, DOB = :DOB, sex = :sex, address = :address WHERE id = :id")
//                .bind("name", user.getName())
//                .bind("phoneNum", user.getPhoneNum())
//                .bind("DOB", user.getDOB())
//                .bind("sex", user.getSex())
//                .bind("address", user.getAddress())
//                .bind("id", user.getId())
//                .execute() > 0);
//    }
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




    public List<User> findAll() {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM accounts")
                        .mapToBean(User.class)
                        .list()
        );
    }

}

