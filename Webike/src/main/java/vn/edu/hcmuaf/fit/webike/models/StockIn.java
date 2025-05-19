package vn.edu.hcmuaf.fit.webike.models;

public class StockIn {
    private int id;
    private Supplier supplier;
    private int employeeID;
    private String receiptDate;
    private String note;

    public StockIn() {
    }

    public StockIn(int id, Supplier supplier, String receiptDate, String note) {
        this.id = id;
        this.supplier = supplier;
        this.receiptDate = receiptDate;
        this.note = note;
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

    @Override
    public String toString() {
        return "StockIn{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", employeeID=" + employeeID +
                ", receiptDate='" + receiptDate + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
