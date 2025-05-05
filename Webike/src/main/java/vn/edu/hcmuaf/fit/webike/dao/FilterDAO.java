package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Color;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterDAO {
    public static void main(String[] args) {
        FilterDAO filterDAO = new FilterDAO();
//        List<Map<String, Object>> products = filterDAO.getAllProducts(1, 10);
        String [] b = {"Ducati"};
        List<Product> products = filterDAO.getProductsByBrands(b,1, 10);
        System.out.println(products);
    }

//    public List<Map<String, Object>> getAllProducts(int page, int limit) {
//        Jdbi jdbi = JDBIConnect.get();
//        String sql = """
//                    SELECT p.id, p.name, p.des, p.price, p.quantity, p.version, p.launch,
//                           p.status, b.name AS brand, MIN(i.url) AS url
//                    FROM products AS p
//                    LEFT JOIN imgs AS i ON i.productID = p.id
//                    LEFT JOIN brands AS b ON p.brandID = b.id
//                    GROUP BY p.id
//                    LIMIT :limit OFFSET :offset
//                """;
//
//
//        int offset = (page - 1) * limit;
//
//        return jdbi.withHandle(handle ->
//                handle.createQuery(sql)
//                        .bind("limit", limit)
//                        .bind("offset", offset)
//                        .mapToMap()
//                        .list()
//        );
//    }

    public List<Product> getAllProducts(int page, int limit) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """ 
                SELECT p.*, b.name as brand, t.type, d.amount, i.url, i.colorID, c.code, c.name AS colorName
                FROM products p
                JOIN (
                SELECT * FROM imgs
                WHERE (productID, id) IN (
                SELECT productID, MIN(id) FROM imgs
                GROUP BY productID)) 
                i ON p.id = i.productID
                JOIN colors c ON i.colorID = c.id
                JOIN brands b ON b.id = p.brandID
                JOIN biketypes t ON t.id = p.typeID
                JOIN discounts d on d.productID = p.id
                WHERE b.name in ("Ducati")
                ORDER BY p.id
                LIMIT :limit OFFSET :offset
                """;
        int offset = (page - 1) * limit;
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("limit", limit)
                        .bind("offset", offset)
                        .map((rs, ctx) -> {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            String des = rs.getString("des");
                            double price = rs.getDouble("price");
                            int quantity = rs.getInt("quantity");
                            String version = rs.getString("version");
                            String launch = rs.getString("launch");
                            String status = rs.getString("status");
                            String brand = rs.getString("brand");
                            String type = rs.getString("type");
                            double discount = rs.getDouble("amount");

                            int colorID = rs.getInt("colorID");
                            String code = rs.getString("code");
                            String colorName = rs.getString("colorName");
                            Color color = new Color(colorID, code, colorName);
                            String url = rs.getString("url");
                            Map<Color, String> img = new LinkedHashMap<>();
                            img.put(color, url);
                            return new Product(id, name, des, price, quantity, version, launch, status, brand, type, img, discount);
                        })
                        .list()
        );
    }

    public int getTotalProducts() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
            SELECT COUNT(*)
            FROM products AS p
            LEFT JOIN brands AS b ON p.brandID = b.id
            """;

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .mapTo(int.class)
                        .one()
        );
    }

    public int getTotalProductsByBrands(String[] brands) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
            SELECT COUNT(*)
            FROM products AS p
            LEFT JOIN brands AS b ON p.brandID = b.id
            WHERE b.name IN (<brands>)
            """;

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bindList("brands", brands)
                        .mapTo(int.class)
                        .one()
        );
    }

    public List<Map<String, Object>> getProductsByBrands1(String[] brands, int page, int limit) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                SELECT p.id, p.name, p.des, p.price, p.quantity, p.version, p.launch,
                       p.status, b.name AS brand, MIN(i.url) AS url
                FROM products AS p
                LEFT JOIN imgs AS i ON i.productID = p.id
                LEFT JOIN brands AS b ON p.brandID = b.id
                WHERE b.name IN (<brands>)
                GROUP BY p.id
                LIMIT :limit OFFSET :offset
            """;

        int offset = (page - 1) * limit;

        return jdbi.withHandle(handle -> {
            var query = handle.createQuery(sql)
                    .bind("limit", limit)
                    .bind("offset", offset);

            if (brands != null && brands.length > 0) {
                query.bindList("brands", brands);
            } else {
                query.define("brands", null);
            }

            return query.mapToMap().list();
        });
    }

    public List<Product> getProductsByBrands(String[] brands,int page, int limit) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """ 
                SELECT DISTINCT p.*, b.name AS brand, t.type,
                    CASE
                        WHEN d.active = 1 THEN d.amount
                        ELSE 0
                    END AS amount, i.url, i.colorID, c.code, c.name AS colorName
                FROM products p
                JOIN (
                    SELECT *
                    FROM imgs
                    WHERE (productID, id) IN (
                        SELECT productID, MIN(id) FROM imgs
                        GROUP BY productID))
                        i ON p.id = i.productID
                JOIN colors c ON i.colorID = c.id
                JOIN brands b ON b.id = p.brandID
                JOIN biketypes t ON t.id = p.typeID
                LEFT JOIN (
                    SELECT d1.* FROM discounts d1
                    INNER JOIN (
                        SELECT productID, MAX(active) AS max_active, MIN(id) AS min_id FROM discounts
                        GROUP BY productID
                    ) d2 ON d1.productID = d2.productID
                         AND d1.active = d2.max_active
                         AND d1.id = d2.min_id
                ) d ON d.productID = p.id
                WHERE b.name in (<brands>) AND p.deleted = 0
                ORDER BY p.id
                LIMIT :limit OFFSET :offset
                """;
        int offset = (page - 1) * limit;
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bindList("brands", Arrays.asList(brands))
                        .bind("limit", limit)
                        .bind("offset", offset)
                        .map((rs, ctx) -> {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            String des = rs.getString("des");
                            double price = rs.getDouble("price");
                            int quantity = rs.getInt("quantity");
                            String version = rs.getString("version");
                            String launch = rs.getString("launch");
                            String status = rs.getString("status");
                            String brand = rs.getString("brand");
                            String type = rs.getString("type");
                            double discount = rs.getDouble("amount");

                            int colorID = rs.getInt("colorID");
                            String code = rs.getString("code");
                            String colorName = rs.getString("colorName");
                            Color color = new Color(colorID, code, colorName);
                            String url = rs.getString("url");
                            Map<Color, String> img = new LinkedHashMap<>();
                            img.put(color, url);
                            return new Product(id, name, des, price, quantity, version, launch, status, brand, type, img, discount);
                        })
                        .list()
        );
    }
}
