package vn.edu.hcmuaf.fit.webike.models;

public class Products {
    private int id;
    private String name;
    private String des;
    private double price;
    private int quantity;
    private String version;
    private String launch;
    private String status;
    private int brandID;
    private int typeID;
//    private List<Product> details;

    public Products() {
    }

    public Products(int id, String name, String des, double price, int quantity, String version, String launch, String status, int brandID, int typeID) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
        this.quantity = quantity;
        this.version = version;
        this.launch = launch;
        this.status = status;
        this.brandID = brandID;
        this.typeID = typeID;
//        this.details = details;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLaunch() {
        return launch;
    }

    public void setLaunch(String launch) {
        this.launch = launch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", version='" + version + '\'' +
                ", launch='" + launch + '\'' +
                ", status='" + status + '\'' +
                ", brandID=" + brandID +
                ", typeID=" + typeID +
                '}' + "\n";
    }
}


