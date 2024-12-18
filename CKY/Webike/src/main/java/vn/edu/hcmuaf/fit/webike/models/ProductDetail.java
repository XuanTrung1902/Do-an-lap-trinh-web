package vn.edu.hcmuaf.fit.webike.models;

public class ProductDetail {
    private int id;
    private String version;
    private String status;
    private int quantity;
    private double price;
    private int productId;

    public ProductDetail() {
    }

    public ProductDetail(int id, String version, String status, int quantity, double price, int productId) {
        this.id = id;
        this.version = version;
        this.status = status;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", productId=" + productId +
                '}';
    }
}
