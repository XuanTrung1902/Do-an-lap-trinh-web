package vn.edu.hcmuaf.fit.webike.models;

public class Feature {
    private int id;
    private String tag;
    private String des;
    private String img;

    public Feature() {
    }

    public Feature(int id, String tag, String des, String img) {
        this.id = id;
        this.tag = tag;
        this.des = des;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String imgID) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", des='" + des + '\'' +
                ", img='" + img + '\'' +
                '}' + "\n";
    }
}
