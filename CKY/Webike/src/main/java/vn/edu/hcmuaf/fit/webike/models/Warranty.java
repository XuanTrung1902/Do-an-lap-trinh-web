package vn.edu.hcmuaf.fit.webike.models;

public class Warranty {
    private int id;
    private int km;
    private int duration;
    private int productID;


    public Warranty() {
    }

    public Warranty(int id, int km, int duration, int productID) {
        this.id = id;
        this.km = km;
        this.duration = duration;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Warranty{" +
                "id=" + id +
                ", km=" + km +
                ", duration=" + duration +
                ", productID=" + productID +
                '}' + "\n";
    }
}
