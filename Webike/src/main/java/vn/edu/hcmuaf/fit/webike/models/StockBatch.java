package vn.edu.hcmuaf.fit.webike.models;

public class StockBatch {
    private int id;
    private int stockID;
    private int productID;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private String batch;
    private int importID;
    private int deleted;

    public StockBatch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getImportID() {
        return importID;
    }

    public void setImportID(int importID) {
        this.importID = importID;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "StockBatch: " + id + ", " + stockID + ", " + productID + ", " + quantity + ", " +
                unitPrice + ", " + totalPrice + ", " + batch + ", " + importID + ", " + deleted;
    }

}
