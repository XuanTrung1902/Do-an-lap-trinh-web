package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Color;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchDAO {

    public List<Product> searchProductsWithImages(String keyword, int page, int limit) {
        Jdbi jdbi = JDBIConnect.get();
        int offset = (page - 1) * limit;
        String sql = """
        SELECT DISTINCT p.*, b.name AS brand, t.type,
            CASE WHEN d.active = 1 THEN d.amount ELSE 0 END AS amount,
            i.url, i.colorID, c.code, c.name AS colorName
        FROM products p
        LEFT JOIN (
            SELECT * FROM imgs
            WHERE (productID, id) IN (
                SELECT productID, MIN(id) FROM imgs
                GROUP BY productID)
        ) i ON p.id = i.productID
        LEFT JOIN colors c ON i.colorID = c.id
        JOIN brands b ON b.id = p.brandID
        JOIN biketypes t ON t.id = p.typeID
        LEFT JOIN (
            SELECT d1.* FROM discounts d1
            INNER JOIN (
                SELECT productID, MAX(active) AS max_active, MIN(id) AS min_id
                FROM discounts
                GROUP BY productID
            ) d2 ON d1.productID = d2.productID
                AND d1.active = d2.max_active
                AND d1.id = d2.min_id
        ) d ON d.productID = p.id
        WHERE p.name LIKE CONCAT('%', :keyword, '%') AND p.deleted = 0
        ORDER BY p.id
        LIMIT :limit OFFSET :offset
    """;

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("keyword", keyword)
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
                            String url = rs.getString("url") != null ? rs.getString("url") : "";
                            Map<Color, String> img = new LinkedHashMap<>();
                            img.put(color, url);

                            return new Product(id, name, des, price, quantity, version, launch, status, brand, type, img, discount);
                        })
                        .list()
        );
    }

    public int countSearchProducts(String keyword) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
        SELECT COUNT(DISTINCT p.id)
        FROM products p
        JOIN brands b ON b.id = p.brandID
        WHERE p.name LIKE CONCAT('%', :keyword, '%') AND p.deleted = 0
    """;

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("keyword", keyword)
                        .mapTo(int.class)
                        .one()
        );
    }
}
