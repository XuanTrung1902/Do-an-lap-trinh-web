package vn.edu.hcmuaf.fit.webike.models;

public class OrderItem {
    private int id;
    private String name;
    private int quantity;
    private String img;
    private String color;
    private int productID;
    private String orderID;
    private double price;
    private String version;
    private String brand;
    private String type;
    private int commented;

    public OrderItem() {
    }

    public OrderItem(int id, String name, int quantity, String img, String color, int productID, String orderID, double price, String version, String brand, String type, int commented) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.img = img;
        this.color = color;
        this.productID = productID;
        this.orderID = orderID;
        this.price = price;
        this.version = version;
        this.brand = brand;
        this.type = type;
        this.commented = commented;
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

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommented() {
        return commented;
    }

    public void setCommented(int commented) {
        this.commented = commented;
    }
}
