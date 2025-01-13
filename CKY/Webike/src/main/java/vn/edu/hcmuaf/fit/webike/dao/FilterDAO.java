package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.util.List;
import java.util.Map;

public class FilterDAO {
//    public List<Map<String, Object>> getProductsByBrands(String[] brands) {
//        Jdbi jdbi = JDBIConnect.get();
//        String sql = """
//                    SELECT\s
//                                             p.id, p.name, p.des, p.price, p.quantity, p.version, p.launch,\s
//                                             p.status, b.name AS brand, i.url
//                                         FROM products AS p
//                                         JOIN imgs AS i ON i.productID = p.id
//                                         JOIN brands AS b ON p.brandID = b.id
//                                         WHERE b.name IN (<brands>)
//                                         GROUP BY p.id
//
//                """;
//
//        return jdbi.withHandle(handle ->
//                handle.createQuery(sql)
//                        .bindList("brands", brands) // Ràng buộc danh sách các thương hiệu
//                        .mapToMap()
//                        .list()
//        );
//    }

    public List<Map<String, Object>> getAllProducts() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                    SELECT p.id, p.name, p.des, p.price, p.quantity, p.version, p.launch,
                           p.status, b.name AS brand, i.url
                    FROM products AS p
                    JOIN imgs AS i ON i.productID = p.id
                    JOIN brands AS b ON p.brandID = b.id
                    GROUP BY p.id;

                """;

        return jdbi.withHandle(handle -> handle.createQuery(sql).mapToMap().list());
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
                query.define("brands", null); // Tránh lỗi bindList
            }


            return query.mapToMap().list();
        });
    }



}
