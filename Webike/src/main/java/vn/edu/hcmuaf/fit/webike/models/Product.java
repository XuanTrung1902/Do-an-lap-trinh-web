package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Product implements Serializable {
    private int id;
    private String name;
    private String des;
    private double price;
    private int quantity;
    private String version;
    private String launch;
    private String status;
    private String brand;
    private String type;
    private Map<Color, String> img;
    private double discount;



    public Product() {
        this.img = new LinkedHashMap<>();
    }

    public Product(int id, String name, String des, double price, int quantity, String version, String launch, String status, String brand, String type, Map<Color, String> img, double discount) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
        this.quantity = quantity;
        this.version = version;
        this.launch = launch;
        this.status = status;
        this.brand = brand;
        this.type = type;
        this.img = img;
        this.discount = discount;
    }

//    public static void main(String[] args) {
//        Map<Color, String> img = new LinkedHashMap<>();
//        Color c1 = new Color("do", "#111");
//        Color c2 = new Color("do", "#22");
//        img.put(c1, "anh");
//        img.put(c2, "anh1");
//
//        Map<Color, String> img2 = new LinkedHashMap<>();
//        Color c3 = new Color("c3", "#c3");
//        Color c4 = new Color("c4", "#c4");
//        img2.put(c3, "anh2");
//        img2.put(c4, "anh3");
//
//        Product p = new Product(1, "ten", "des", 12.3, 43, "ver", "launch", "status", "brand", "type", img);
//        Product p1 = new Product(2, "ten", "des", 12.3, 43, "ver", "launch", "status", "brand", "type", img2);
//        List<Product> ls = new ArrayList<>();
//        ls.add(p);
//        ls.add(p1);
//
//        for (Product x : ls) {
//            System.out.println("id: "+x.getId()+ "\n+\t"+x.getImg());
//            System.out.println("-----------------------------"+ p.getImg().size());
//            Color key= x.getImg().entrySet().iterator().next().getKey();
//            System.out.println("Key:"+key);
//            System.out.println("Value:"+x.getImg().get(key));
//        }

//        System.out.println(p.getImg().keySet().iterator().next());
//        for (Map.Entry<Color, String> x : p.getImg().entrySet()) {
//            System.out.println("Mau: "+x.getKey().getName());
//            System.out.println(x.getKey().getCode());
//        }

//        p.getImg().keySet().forEach(System.out::println);
//        System.out.println("///////");
//        for (Map.Entry<String, String> entry : img.entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
//    }

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<Color, String> getImg() {
        return img;
    }

    public void setImg(Map<Color, String> img) {
        this.img = img;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", version='" + version + '\'' +
                ", launch='" + launch + '\'' +
                ", status='" + status + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", img=" + img +
                ", discount=" + discount +
                '}';
    }

    // hàm lấy đường dẫn ảnh theo tên màu
    public String getImageByColorName(String colorName) {
        for (Map.Entry<Color, String> entry : img.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(colorName)) {
                return entry.getValue();
            }
        }
        return "img/default.png";
    }
}


