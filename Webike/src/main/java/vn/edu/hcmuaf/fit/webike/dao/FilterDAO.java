package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.util.List;
import java.util.Map;

public class FilterDAO {
    public static void main(String[] args) {
        FilterDAO filterDAO = new FilterDAO();
        List<Map<String, Object>> products = filterDAO.getAllProducts(1, 10);
        System.out.println(products);
    }

    public List<Map<String, Object>> getAllProducts(int page, int limit) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                    SELECT p.id, p.name, p.des, p.price, p.quantity, p.version, p.launch,
                           p.status, b.name AS brand, i.url
                    FROM products AS p
                    JOIN imgs AS i ON i.productID = p.id
                    JOIN brands AS b ON p.brandID = b.id
                    GROUP BY p.id
                    LIMIT :limit OFFSET :offset
                """;

        int offset = (page - 1) * limit;

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("limit", limit)
                        .bind("offset", offset)
                        .mapToMap()
                        .list()
        );
    }

    public int getTotalProducts() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
            SELECT COUNT(*)
            FROM products AS p
            JOIN brands AS b ON p.brandID = b.id
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
            JOIN brands AS b ON p.brandID = b.id
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
                       p.status, b.name AS brand, i.url
                FROM products AS p
                JOIN imgs AS i ON i.productID = p.id
                JOIN brands AS b ON p.brandID = b.id
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



}
