package vn.edu.hcmuaf.fit.webike.models;

public class DetailRecord {
    private int specID;
    private int featureID;
    private int colorID;
    private int pdID;

    public DetailRecord() {
    }

    public DetailRecord(int specID, int featureID, int colorID, int pdID) {
        this.specID = specID;
        this.featureID = featureID;
        this.colorID = colorID;
        this.pdID = pdID;
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
        return pdID;
    }

    public void setPdID(int pdID) {
        this.pdID = pdID;
    }

    @Override
    public String toString() {
        return "DetailRecord{" +
                "specID=" + specID +
                ", featureID=" + featureID +
                ", colorID=" + colorID +
                ", pdID=" + pdID +
                '}';
    }
}
