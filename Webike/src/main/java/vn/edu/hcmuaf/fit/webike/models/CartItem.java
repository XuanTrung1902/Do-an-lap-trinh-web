package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.util.Map;

public class CartItem implements Serializable {
    private int id;
    private int pid;
    private String name;
    private double price;
    private int quantity;
    private String status;
    private String version;
    private String brand;
    private String type;
    private int cid;
    private String img;
    private int uid;

    public CartItem() {
    }

    public CartItem(int id, int pid, String name, double price, int quantity, String status, String version, String brand, String type, int cid, String img, int uid) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.version = version;
        this.brand = brand;
        this.type = type;
        this.cid = cid;
        this.img = img;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", version='" + version + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", cid=" + cid +
                ", img='" + img + '\'' +
                ", uid=" + uid +
                '}';
    }
}
