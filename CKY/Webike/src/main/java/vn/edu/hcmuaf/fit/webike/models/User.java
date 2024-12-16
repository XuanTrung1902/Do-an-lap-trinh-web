package vn.edu.hcmuaf.fit.webike.models;
import java.util.Date;

public class User {
    private int userid;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String dob;
    private String gender; // "M" hoặc "F"
    private String address;
    private String createdAt;
    private boolean locked; // true nếu tài khoản bị khóa
    private int role; // 1 = admin, 0 = user
    private String img; // URL ảnh đại diện

    // Constructors
//    public User() {}

    public User(int userid, String username, String password, String name, String phone, String dob, String gender,
                String address, String createdAt, boolean locked, int role, String img) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.createdAt = createdAt;
        this.locked = locked;
        this.role = role;
        this.img = img;
    }


    public User() {
        this.createdAt = new Date().toString(); // Tạo ngày hiện tại
        this.locked = false; // Mặc định không bị khóa
        this.img = "default.png"; // Ảnh mặc định
    }

    // Getters and Setters
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                ", locked=" + locked +
                ", role=" + role +
                ", img='" + img + '\'' +
                '}';
    }
}


