package vn.edu.hcmuaf.fit.webike.models;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String des;
    private double price;
    private int quantity;
    private String version;
    private String launch;
    private String status;
    private String brand;
    private String type;



    public Product() {
    }

    public Product(int id, String name, String des, double price, int quantity, String version, String launch, String status, String brand, String type) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
        this.quantity = quantity;
        this.version = version;
        this.launch = launch;
        this.status = status;
        this.brand = brand;
        this.type = type;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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

    public String getLaunch() {
        return launch;
    }

    public void setLaunch(String launch) {
        this.launch = launch;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", version='" + version + '\'' +
                ", launch='" + launch + '\'' +
                ", status='" + status + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Product product = new Product(1, "name", "des", 1000, 10, "version", "launch", "status", "brand", "type");
        System.out.println(product);
    }
}


