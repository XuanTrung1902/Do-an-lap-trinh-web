package vn.edu.hcmuaf.fit.webike.models;

public class StockItem {
    private int id;
    private Color color;
    private StockBatch batch;
    private Product product;
    private String status;

    public StockItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public StockBatch getBatch() {
        return batch;
    }

    public void setBatch(StockBatch batch) {
        this.batch = batch;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", color=" + color +
                ", batch=" + batch +
                ", product=" + product +
                ", status='" + status +
                '}';
    }
}
