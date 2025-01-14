package vn.edu.hcmuaf.fit.webike.models;

public class OrderItem {
    //    private int id;
    private String name;
    private int quantity;
    private String img;
    private String color;
    private String productID;
    private String orderID;
    private double price;
    private String version;
    private String status;
    private String brand;
    private String type;

    public OrderItem() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "OrderItem{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", img='" + img + '\'' +
                ", color='" + color + '\'' +
                ", productID='" + productID + '\'' +
                ", orderID='" + orderID + '\'' +
                ", price=" + price +
                ", version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
