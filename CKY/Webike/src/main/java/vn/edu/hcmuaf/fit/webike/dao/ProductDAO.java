package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.*;

import java.util.List;
import java.util.Map;

public class ProductDAO {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        System.out.println(dao.getProduct(1));
//        System.out.println(dao.getAll());
//        System.out.println(dao.getSpec(1, "động cơ"));
//        System.out.println(dao.getFeature(1));
//        System.out.println(dao.getWarranty(1));
//        System.out.println(dao.getSpecType());
//        System.out.println(dao.getImg(2));
//        System.out.println(dao.getColor(2));
//        System.out.println(dao.chooseColor(2,1));
//        System.out.println(dao.getAllProductImg2());
//        System.out.println(dao.getBrandOfProduct());
    }




    // lay ra 10 thuong hieu
    public List<String> getBrandOfProduct() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "SELECT img FROM brands LIMIT 10";
        return jdbi.withHandle(handle ->
                handle.createQuery(sql).mapTo(String.class).list()
        );
    }

    // lay ra 9 sp kem anh cho slider
    public List<Map<String, Object>> getAllProductImg2() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
        SELECT DISTINCT p.*, i.url AS imgUrl
        FROM products AS p
        JOIN imgs AS i ON i.productID = p.id
        WHERE p.id > 20
        LIMIT 9
    """;
        return jdbi.withHandle(handle ->
                handle.createQuery(sql).mapToMap().list()
        );
    }


    // lay ra tat ca sp kem anh
    public List<Map<String, Object>> getAllProductImg() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
        SELECT p.*, i.url AS imgUrl
        FROM products AS p
        JOIN imgs AS i ON i.productID = p.id
        LIMIT 100
    """;
        return jdbi.withHandle(handle ->
                handle.createQuery(sql).mapToMap().list()
        );
    }

    public List<Product> getAllProducts() { // lấy ra tca sp
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("select * from products")
                .mapToBean(Product.class).list());
    }

    public Product getProduct(int id) { // lay sp theo id
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("select p.*, b.name as brand, t.type as type " +
                        "from products AS p \n" +
                        "join brands as b on b.id = p.brandID\n" +
                        "join biketypes as t ON t.id = p.typeID\n" +
                        "where p.id = :id")
                .bind("id", id)
                .mapToBean(Product.class)
                .findOne()
                .orElse(null));
    }

    public List<String> getSpecType() { // lay ra cac type trong specs [ho tro cho getSpec() ]
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery(
                "SELECT DISTINCT s.type from specs as s").mapTo(String.class).list());
    }

    public List<Spec> getSpec(int id, String type) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery
                        ("SELECT s.id, s.tag, s.des, s.type from products as p\n" +
                                "join productdetails as pd on pd.productID = p.id \n" +
                                "join specs as s on s.id = pd.specID where p.id = :id and s.type = :type")
                .bind("id", id)
                .bind("type", type)
                .mapToBean(Spec.class).list());
    }

    public List<Feature> getFeature(int id) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery
                        ("SELECT f.id, f.tag, f.des, f.img from products as p\n" +
                                "join productdetails as pd on pd.productID = p.id\n" +
                                "join features as f on f.id = pd.featureID where p.id =  :id")
                .bind("id", id)
                .mapToBean(Feature.class).list());
    }

    public List<Warranty> getWarranty(int id) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery
                        ("select w.id, w.km, w.duration, w.productID from products as p\n"
                                + "join warranties as w on w.productID= p.id where p.id =  :id")
                .bind("id", id)
                .mapToBean(Warranty.class).list());
    }

    public List<String> getImg(int id) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("" +
                        "SELECT i.url, c.code, c.name from products as p \n" +
                        "join imgs as i on p.id= i.productID\n" +
                        "join colors as c on i.colorID = c.id \n" +
                        "WHERE p.id = :id")
                .bind("id", id)
                .mapTo(String.class).list());
    }

    public List<Color> getColor(int id) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("" +
                        "SELECT c.id, c.code, c.name from products as p \n" +
                        "JOIN imgs as i on p.id= i.productID\n" +
                        "JOIN colors as c on i.colorID = c.id \n" +
                        "WHERE p.id = :id")
                .bind("id", id)
                .mapToBean(Color.class).list());
    }

    // lay anh sp dua vao id mau (chon mau sp)
    public String chooseColor(int id, int colorID) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery(
                        "SELECT i.url FROM products AS p " +
                                "JOIN imgs AS i ON p.id = i.productID " +
                                "JOIN colors AS c ON i.colorID = c.id " +
                                "WHERE p.id = :id AND c.id = :colorID")
                .bind("id", id)
                .bind("colorID", colorID)
                .mapTo(String.class)
                .findOne()
                .orElse(null));
    }
}
