package vn.edu.hcmuaf.fit.webike.models;

public class ProductDetail {
    private int specID;
    private int featureID;
    private int colorID;
    private int productID;

    public ProductDetail() {
    }

    public ProductDetail(int specID, int featureID, int colorID, int productID) {
        this.specID = specID;
        this.featureID = featureID;
        this.colorID = colorID;
        this.productID = productID;
    }

    public int getSpecID() {
        return specID;
    }

    public void setSpecID(int specID) {
        this.specID = specID;
    }

    public int getFeatureID() {
        return featureID;
    }

    public void setFeatureID(int featureID) {
        this.featureID = featureID;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public int getPdID() {
        return productID;
    }

    public void setPdID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "specID=" + specID +
                ", featureID=" + featureID +
                ", colorID=" + colorID +
                ", productID=" + productID +
                '}';
    }
}
