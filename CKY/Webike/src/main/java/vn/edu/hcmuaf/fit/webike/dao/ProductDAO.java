package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.*;

import java.util.List;
import java.util.Map;

public class ProductDAO {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        System.out.println(dao.getProduct(2));
//        System.out.println(dao.getAll());
//        System.out.println(dao.getSpec(1, "động cơ"));
//        System.out.println(dao.getFeature(1));
//        System.out.println(dao.getWarranty(1));
//        System.out.println(dao.getSpecType());
//        System.out.println(dao.getImg(2));
//        System.out.println(dao.getColor(2));
//        System.out.println(dao.chooseColor(2,1));
//        System.out.println(dao.getComment(1));
    }

    public List<Product> getAllProducts() { // lấy ra tca sp
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("select * from products")
                .mapToBean(Product.class).list());
    }


//    public Product getProduct(int id) { // lay sp theo id
//        Jdbi jdbi = JDBIConnect.get();
//        String sql = "select p.*, b.name as brand, t.type as type, c.code, i.url from products as p \n" +
//                "join brands as b on p.brandID = b.id\n" +
//                "join biketypes as t on t.id = p.typeID\n" +
//                "join imgs AS i on p.id= i.productID\n" +
//                "join colors as c on c.id = i.colorID\n" +
//                "WHERE p.id = :id";
//        return jdbi.withHandle(handle -> handle.createQuery(sql)
//                .bind("id", id)
//                // hien thuc code
//                .findOne()
//                .orElse(null));
//    }

    public Product getProduct(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sqlProduct = """
                    SELECT p.*, b.name AS brand, t.type AS type 
                    FROM products AS p
                    JOIN brands AS b ON p.brandID = b.id
                    JOIN biketypes AS t ON t.id = p.typeID
                    WHERE p.id = :id
                """;
        String sqlImg = """
                    SELECT c.code, i.url 
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
                        return p;
                    }).findOne().orElse(null);

            handle.createQuery(sqlImg)
                    .bind("id", id)
                    .map((rs, ctx) -> Map.entry(rs.getString("code"), rs.getString("url")))
                    .forEach(entry -> product.getImg().put(entry.getKey(), entry.getValue()));
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

    public List<Comment> getComment(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select c.content, c.created, a.name as username from comments as c join accounts as a" +
                " on c.accountID = a.id where productID = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .mapToBean(Comment.class).list());
    }
}
