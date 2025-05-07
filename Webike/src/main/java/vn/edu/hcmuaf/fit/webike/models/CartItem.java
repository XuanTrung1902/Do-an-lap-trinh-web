package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class CartItem implements Serializable {
    private String id;
    private int pid;
    private String name;
    private double price;
    private int quantity;
    private String status;
    private String version;
    private String brand;
    private String type;
    private int cid;
    private String colorName;
    private String img;
    private int uid;
    private LocalDateTime added;

    public CartItem() {
    }

    public CartItem(String id, int pid, String name, double price, int quantity, String status, String version, String brand, String type, int cid, String colorName, String img, int uid, LocalDateTime added) {
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
        this.colorName = colorName;
        this.img = img;
        this.uid = uid;
        this.added = added;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
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

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
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
                ", colorName='" + colorName + '\'' +
                ", img='" + img + '\'' +
                ", uid=" + uid +
                ", added=" + added +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem)) return false;
        CartItem item = (CartItem) o;
        return pid == item.pid &&
                cid == item.cid &&
                uid == item.uid &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(status, item.status) &&
                Objects.equals(version, item.version) &&
                Objects.equals(brand, item.brand) &&
                Objects.equals(type, item.type) &&
                Objects.equals(colorName, item.colorName) &&
                Objects.equals(img, item.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, name, price, quantity, status, version, brand, type, cid, colorName, img, uid);
    }
}


