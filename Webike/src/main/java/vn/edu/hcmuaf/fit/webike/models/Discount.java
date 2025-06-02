package vn.edu.hcmuaf.fit.webike.models;
import java.sql.Date;

public class Discount {
    private int id;
    private double amount;
    private Date start;
    private Date end;
    private int productID;

    public Discount() {
    }

    public Discount(int id, double amount, Date start, Date end, int productID) {
        this.id = id;
        this.amount = amount;
        this.start = start;
        this.end = end;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Discount: " + id + ", " + amount + ", " + start + ", " + end + ", " + productID;
    }
}
