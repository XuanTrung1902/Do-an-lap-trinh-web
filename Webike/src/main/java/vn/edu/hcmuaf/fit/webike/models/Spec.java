package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;

public class Spec implements Serializable {
    private int id;
    private String tag;
    private String des;
    private String type;

    public Spec() {
    }

    public Spec(int id, String tag, String des, String type) {
        this.id = id;
        this.tag = tag;
        this.des = des;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Spec: " + id + ", " + tag + ", " + des + ", " + type;
    }

}
