package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.util.Map;

public class CartProduct implements Serializable {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String version;
    private String status;
    private String brand;
    private String type;
    private Map<String, String> img;

    public CartProduct() {
    }

    public CartProduct(String id, String name, double price, int quantity, String version, String status, String brand, String type, Map<String, String> img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.version = version;
        this.status = status;
        this.brand = brand;
        this.type = type;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Map<String, String> getImg() {
        return img;
    }

    public void setImg(Map<String, String> img) {
        this.img = img;
    }
}
