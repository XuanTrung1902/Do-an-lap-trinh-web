package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
        System.out.println(dao.getAllProducts()); // hàm này để load sản phẩm lên trang quản lý sản phẩm của admin
//        System.out.println(dao.searchProductsbyname("Honda"));


    }

    public List<Map<String, Object>> searchProductsbyname(String keyword) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
        SELECT id, name, price, launch, 
               (SELECT url FROM imgs WHERE productID = p.id LIMIT 1) AS imgUrl
        FROM products p
        WHERE name LIKE CONCAT('%', :keyword, '%')
    """;

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("keyword", keyword)
                        .mapToMap()
                        .list()
        );
    }


    public boolean deleteProductById(int productId) {
        Jdbi jdbi = JDBIConnect.get();

        // SQL xóa sản phẩm
//        String deleteProductSql = """
//            DELETE FROM products
//            WHERE id = :id
//        """;

        String deleteProductSql = """
            UPDATE products
            SET deleted = 1
            WHERE id = :id
        """;

        // SQL xóa ảnh liên quan đến sản phẩm
        String deleteImagesSql = """
            DELETE FROM imgs
            WHERE productID = :id
        """;

        return jdbi.inTransaction(handle -> {
            // Xóa ảnh liên quan trước
            handle.createUpdate(deleteImagesSql)
                    .bind("id", productId)
                    .execute();

            // Xóa sản phẩm
            int rowsAffected = handle.createUpdate(deleteProductSql)
                    .bind("id", productId)
                    .execute();

            return rowsAffected > 0;
        });
    }



    // Lấy thông tin sản phẩm theo ID chỉnh sửa trong trang quản lý sản phẩm của admin
    public Product getProductById(int productId) {
        Jdbi jdbi = JDBIConnect.get();

        // Truy vấn thông tin cơ bản của sản phẩm
        String productSql = """
                    SELECT id, name, des, price, quantity, version, launch, status, brandID, typeID
                    FROM products
                    WHERE id = :id
                """;

        // Truy vấn danh sách URL ảnh của sản phẩm
        String imageSql = """
                    SELECT url
                    FROM imgs
                    WHERE productID = :id
                """;

        return jdbi.withHandle(handle -> {
            Product product = handle.createQuery(productSql)
                    .bind("id", productId)
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
                        p.setBrand(rs.getString("brandID"));
                        p.setType(rs.getString("typeID"));
                        return p;
                    })
                    .findOne()
                    .orElse(null);

            if (product == null) {
                return null; // Không tìm thấy sản phẩm
            }

            // Lấy danh sách URL ảnh
            List<String> imageUrls = handle.createQuery(imageSql)
                    .bind("id", productId)
                    .mapTo(String.class)
                    .list();

            // Đưa danh sách URL ảnh vào Map
            Map<Color, String> images = new LinkedHashMap<>();
            int index = 0;
            for (String url : imageUrls) {
                images.put(new Color("default" + index, ""), url);
                index++;
            }

            product.setImg(images);

            return product;
        });
    }


    public boolean updateProduct(int id, String name, int quantity, double price, String launch, String imageUrl, String description) {
        Jdbi jdbi = JDBIConnect.get();

        String sql = """
                    UPDATE products
                    SET name = :name, quantity = :quantity, price = :price, launch = :launch, des = :description
                    WHERE id = :id
                """;

        String updateImageSql = """
                    UPDATE imgs
                    SET url = :url
                    WHERE productID = :id
                """;

        return jdbi.inTransaction(handle -> {
            // Cập nhật thông tin sản phẩm
            int rowsUpdated = handle.createUpdate(sql)
                    .bind("id", id)
                    .bind("name", name)
                    .bind("quantity", quantity)
                    .bind("price", price)
                    .bind("launch", launch)
                    .bind("description", description)
                    .execute();

            // Nếu có ảnh mới, cập nhật URL ảnh
            if (imageUrl != null) {
                handle.createUpdate(updateImageSql)
                        .bind("id", id)
                        .bind("url", imageUrl)
                        .execute();
            }

            return rowsUpdated > 0; // Trả về true nếu cập nhật thành công
        });
    }


    public boolean addProduct(String name, double price, int quantity, String launch, String imageUrl, String des) {
        Jdbi jdbi = JDBIConnect.get();

        String sql = """
                INSERT INTO products (name, price, quantity, launch, des) 
                VALUES (:name, :price, :quantity, :launch, :des)
                """;

        String imageSql = """
                INSERT INTO imgs (productID, url) 
                VALUES (:productID, :url)
                """;

        return jdbi.inTransaction(handle -> {
            int productId = handle.createUpdate(sql)
                    .bind("name", name)
                    .bind("price", price)
                    .bind("quantity", quantity)
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
                    p.quantity,
                    i.url 
                FROM products AS p
                JOIN imgs AS i ON p.id = i.productID
                WHERE p.deleted = 0
                GROUP BY p.id;
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
