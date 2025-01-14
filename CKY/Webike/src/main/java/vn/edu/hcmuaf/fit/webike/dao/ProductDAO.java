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
        System.out.println(dao.getProduct(1));
//        System.out.println(dao.getAll());
//        System.out.println(dao.getSpec(1, "động cơ"));
//        System.out.println(dao.getFeature(1));
//        System.out.println(dao.getWarranty(1));
//        System.out.println(dao.getSpecType());
//        System.out.println(dao.getComment(1));
//        System.out.println(dao.getAllProductImg2());
//        System.out.println(dao.getAllProductImg());
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

                    SELECT p.*,
                             (SELECT d.amount FROM discounts AS d WHERE d.productID = p.id ORDER BY d.id DESC LIMIT 1) AS discount,
                             MIN(i.url) AS imgUrl
                      FROM products AS p
                      LEFT JOIN imgs AS i ON i.productID = p.id
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
        //                    SELECT p.*, min(i.url) AS imgUrl
//                    FROM products AS p
//                    JOIN imgs AS i ON i.productID = p.id
//                    GROUP BY p.id
        String sql = """    
                      SELECT p.*,
                             (SELECT d.amount FROM discounts AS d WHERE d.productID = p.id ORDER BY d.id DESC LIMIT 1) AS discount,
                             MIN(i.url) AS imgUrl
                      FROM products AS p
                      LEFT JOIN imgs AS i ON i.productID = p.id
                      GROUP BY p.id;
                """;
        return jdbi.withHandle(handle ->
                handle.createQuery(sql).mapToMap().list()
        );
    }

//    public List<Product> getAllProductImg() {
//        Jdbi jdbi = JDBIConnect.get();
//        String sqlProduct = """
//                    SELECT p.*, b.name AS brand, t.type AS type
//                    FROM products AS p
//                    JOIN brands AS b ON p.brandID = b.id
//                    JOIN biketypes AS t ON t.id = p.typeID
//                    ORDER BY p.id
////                    limit 30
//                """;
//        String sqlImg = """
//                    SELECT c.name, c.code, i.url, i.productID
//                    FROM imgs AS i
//                    JOIN colors AS c ON c.id = i.colorID ;
//                """;
//
//        return jdbi.withHandle(handle -> {
//            // danh sách sản phẩm
//            List<Product> products = handle.createQuery(sqlProduct)
//                    .map((rs, ctx) -> {
//                        Product p = new Product();
//                        p.setId(rs.getInt("id"));
//                        p.setName(rs.getString("name"));
//                        p.setDes(rs.getString("des"));
//                        p.setPrice(rs.getDouble("price"));
//                        p.setQuantity(rs.getInt("quantity"));
//                        p.setVersion(rs.getString("version"));
//                        p.setLaunch(rs.getString("launch"));
//                        p.setStatus(rs.getString("status"));
//                        p.setBrand(rs.getString("brand"));
//                        p.setType(rs.getString("type"));
//                        p.setImg(new HashMap<>());
//                        return p;
//                    }).list();
//
//            // Tạo map từ productID đến Product để xử lý nhanh
//            Map<Integer, Product> productMap = products.stream()
//                    .collect(Collectors.toMap(Product::getId, p -> p));
//
//            // Xử lý ảnh và gán vào sản phẩm
//            handle.createQuery(sqlImg)
//                    .mapToMap()
//                    .forEach(rs -> {
//                        Integer productId = (Integer) rs.get("productid");
//                        Product product = productMap.get(productId);
//                        if (product != null) {
//                            Color c = new Color();
//                            c.setName((String) rs.get("name"));
//                            c.setCode((String) rs.get("code"));
//                            String url = (String) rs.get("url");
//                            product.getImg().put(c, url);
//                        }
//                    });
//            return products;
//        });
//    }

    public Product getProduct(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sqlProduct = """
                    SELECT p.*, b.name AS brand, t.type AS type, (SELECT d.amount FROM discounts AS d WHERE d.productID = p.id ORDER BY d.id DESC LIMIT 1) as discount
                    FROM products AS p
                    JOIN brands AS b ON p.brandID = b.id
                    JOIN biketypes AS t ON t.id = p.typeID
                    WHERE p.id = :id
                """;
        String sqlImg = """
                    SELECT c.name, c.code, i.url 
                    FROM imgs AS i
                    JOIN colors AS c ON c.id = i.colorID
                    WHERE i.productID = :id
                """;

        return jdbi.withHandle(handle -> {
            Product product = handle.createQuery(sqlProduct)
                    .bind("id", id)
                    .map((rs, ctx) -> {
                        Product p = new Product();
                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setDes(rs.getString("des"));
                        p.setPrice(rs.getDouble("price"));
                        p.setQuantity(rs.getInt("quantity"));
                        p.setVersion(rs.getString("version"));
                        p.setLaunch(rs.getString("launch"));
                        p.setStatus(rs.getString("status"));
                        p.setBrand(rs.getString("brand"));
                        p.setType(rs.getString("type"));
                        p.setDiscount(rs.getDouble("discount"));
//                        p.setImg(new HashMap<>());
                        return p;
                    }).findOne().orElse(null);

            // Xử lý ảnh
            handle.createQuery(sqlImg)
                    .bind("id", id)
                    .mapToMap()
                    .forEach(rs -> {
                        Color c = new Color();
                        c.setName((String) rs.get("name"));
                        c.setCode((String) rs.get("code"));
                        String url = (String) rs.get("url");
                        product.getImg().put(c, url);
                    });

            return product;
        });
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
