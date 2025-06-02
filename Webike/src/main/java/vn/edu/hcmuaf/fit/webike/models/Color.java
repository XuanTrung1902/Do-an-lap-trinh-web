package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;

public class Color implements Serializable {
    private int id;
    private String name;
    private String code;

    public Color() {
    }

    public Color(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Color(String name, String code) {
        this.name = name;
        this.code = code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Color: " + id + ", " + name + ", " + code;
    }
}
