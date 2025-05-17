package vn.edu.hcmuaf.fit.webike.models;

public class Supplier {
    private int id;
    private String name;
    private String contact_name;
    private String phone;
    private String email;
    private String address;
    private int status; // 0 là ko còn hợp tác, 1 là đang hợp tác
    private String created; // ngayf hợp tác

    public Supplier() {
    }

    public Supplier(int id, String name, String contact_name, String phone, String email, String address, int status, String created) {
        this.id = id;
        this.name = name;
        this.contact_name = contact_name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.created = created;
    }

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

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact_name='" + contact_name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", created='" + created + '\'' +
                '}';
    }
}
