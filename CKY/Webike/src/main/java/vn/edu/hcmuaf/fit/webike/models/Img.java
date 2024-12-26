package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;

public class Img implements Serializable {
    private int id;
    private String url;
    private int productID;
    private int colorID;

    public Img() {
    }

    public Img(int id, String url, int productID, int colorID) {
        this.id = id;
        this.url = url;
        this.productID = productID;
        this.colorID = colorID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }
}
