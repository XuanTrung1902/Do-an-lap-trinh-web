package vn.edu.hcmuaf.fit.webike.models;

public class User {
    private int id;
    private String name;
    private String phoneNum;
    private String DOB;
    private String sex;
    private String password;
    private String created;
    private int locked;
    private int verify;
    private int role;
    private String address;

    // Constructors
    public User() {}

    public User(int id, String name, String phoneNum, String DOB, String sex, String password, String created, int locked, int verify, int role, String address) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.DOB = DOB;
        this.sex = sex;
        this.password = password;
        this.created = created;
        this.locked = locked;
        this.verify = verify;
        this.role = role;
        this.address = address;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getVerify() {
        return verify;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", DOB='" + DOB + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", created='" + created + '\'' +
                ", locked=" + locked +
                ", verify=" + verify +
                ", role=" + role +
                ", address='" + address + '\'' +
                '}';
    }

}


