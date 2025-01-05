package vn.edu.hcmuaf.fit.webike.models;

public class Brand {
    private int id;
    private String name;
    private String des;
    private String img;

    public Brand() {
    }

    public Brand(int id, String name, String des, String img) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
