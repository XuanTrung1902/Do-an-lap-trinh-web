package vn.edu.hcmuaf.fit.webike.models;

import java.util.List;

public class StockIn {
    private int id;
    private Supplier supplier;
    private int employeeID;
    private String receiptDate;
    private String note;
    private List<StockBatch> batches;
    private int deleted;

    public StockIn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<StockBatch> getBatches() {
        return batches;
    }

    public void setBatches(List<StockBatch> batches) {
        this.batches = batches;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "StockIn: " + id + ", " + supplier + ", " + employeeID + ", " + receiptDate + ", " +
                note + ", " + batches + ", " + deleted;
    }

}
