package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Product;

import java.util.List;
import java.util.Map;

public class FilterDAO {
    public static void main(String[] args) {
        FilterDAO dao = new FilterDAO();
//        System.out.println(dao.getProductsByBrands(new String[]{"HONDA"}));
    }


    public List<Map<String, Object>> getProductsByBrands(String[] brands) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                    SELECT\s
                                             p.id, p.name, p.des, p.price, p.quantity, p.version, p.launch,\s
                                             p.status, b.name AS brand, i.url
                                         FROM products AS p
                                         JOIN imgs AS i ON i.productID = p.id
                                         JOIN brands AS b ON p.brandID = b.id
                                         WHERE b.name IN (<brands>)
                                         GROUP BY p.id
                
                """;

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bindList("brands", brands) // Ràng buộc danh sách các thương hiệu
                        .mapToMap()
                        .list()
        );
    }
}
