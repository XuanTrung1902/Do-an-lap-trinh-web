package vn.edu.hcmuaf.fit.webike.models;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private String des;
    private String launch;
    private int brandID;
    private int typeID;
    private List<ProductDetail> details;

    public Product() {
    }

    public Product(int id, String name, String des, String launch, int brandID, int typeID, List<ProductDetail> details) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.launch = launch;
        this.brandID = brandID;
        this.typeID = typeID;
        this.details = details;
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

    public String getLaunch() {
        return launch;
    }

    public void setLaunch(String launch) {
        this.launch = launch;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public List<ProductDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", launch='" + launch + '\'' +
                ", brandID=" + brandID +
                ", typeID=" + typeID +
                ", details=" + details +
                '}' + "\n";
    }
}


