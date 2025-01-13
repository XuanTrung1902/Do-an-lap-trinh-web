package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductDAO {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

//        System.out.println(dao.getProduct(1));
//        System.out.println(dao.getAll());
//        System.out.println(dao.getSpec(1, "động cơ"));
//        System.out.println(dao.getFeature(1));
//        System.out.println(dao.getWarranty(1));
//        System.out.println(dao.getSpecType());
//        System.out.println(dao.getComment(1));
//        System.out.println(dao.getAllProductImg2());
//        System.out.println(dao.getAllProductImg());
//        System.out.println(dao.getBrandOfProduct());
//        System.out.println(dao.getAllBrand());
//        System.out.println(dao.searchProducts("Honda"));
//        System.out.println(dao.getAllProducts()); // hàm này để load sản phẩm lên trang quản lý sản phẩm của admin


    }


    public boolean addProduct(String name, double price, String launch, String imageUrl, String des) {
        Jdbi jdbi = JDBIConnect.get();

        String sql = """
                INSERT INTO products (name, price, launch, des) 
                VALUES (:name, :price, :launch, :des)
                """;

        String imageSql = """
                INSERT INTO imgs (productID, url) 
                VALUES (:productID, :url)
                """;

        return jdbi.inTransaction(handle -> {
            int productId = handle.createUpdate(sql)
                    .bind("name", name)
                    .bind("price", price)
                    .bind("launch", launch)
                    .bind("des", des)
                    .executeAndReturnGeneratedKeys("id")
                    .mapTo(int.class)
                    .one();

            return handle.createUpdate(imageSql)
                    .bind("productID", productId)
                    .bind("url", imageUrl)
                    .execute() > 0;
        });
    }


    public List<Map<String, Object>> getAllProducts() {
        // load product to admin manage product page
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                SELECT 
                    p.id ,
                    p.name ,
                    p.price ,
                    p.launch ,
                    i.url 
                FROM products AS p
                JOIN imgs AS i ON p.id = i.productID
                GROUP BY p.id, i.id
                """;
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .mapToMap()
                        .list()
        );
    }

    public List<Map<String, Object>> searchProducts(String keyword) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
            SELECT p.id, p.name, p.des, p.price, p.quantity, p.version, p.launch,
                   p.status, b.name AS brand, MIN(i.url) AS imgUrl
            FROM products AS p
            JOIN imgs AS i ON i.productID = p.id
            JOIN brands AS b ON p.brandID = b.id
            WHERE p.name LIKE CONCAT('%', :keyword, '%')
            GROUP BY p.id;
        """;

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("keyword", keyword)
                        .mapToMap()
                        .list()
        );
    }




    public List<Brand> getAllBrand() {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("SELECT * FROM brands")
                .mapToBean(Brand.class).list());
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
                    SELECT p.*, min(i.url) AS imgUrl
                    FROM products AS p
                    JOIN imgs AS i ON i.productID = p.id
                    GROUP BY p.id
                    LIMIT 9;
                """;
        return jdbi.withHandle(handle ->
                handle.createQuery(sql).mapToMap().list()
        );
    }

    // lay ra tat ca sp kem anh
    public List<Map<String, Object>> getAllProductImg() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                    SELECT p.*, min(i.url) AS imgUrl
                    FROM products AS p
                    JOIN imgs AS i ON i.productID = p.id
                    GROUP BY p.id
                    LIMIT 100;
                """;
        return jdbi.withHandle(handle ->
                handle.createQuery(sql).mapToMap().list()
        );
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

    public List<Comment> getComment(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select c.content, c.created, a.name as username from comments as c join accounts as a" +
                " on c.accountID = a.id where productID = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .mapToBean(Comment.class).list());
    }


}
