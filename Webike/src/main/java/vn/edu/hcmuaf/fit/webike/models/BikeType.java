package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;

public class BikeType implements Serializable {
    private int id;
    private String type;
    private String img;

    public BikeType() {
    }
    public BikeType(int id, String type, String img) {
        this.id = id;
        this.type = type;
        this.img = img;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "BikeType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
