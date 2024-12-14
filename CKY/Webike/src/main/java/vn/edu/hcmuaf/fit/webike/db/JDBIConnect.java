package vn.edu.hcmuaf.fit.webike.db;

//import com.hcmuaf.edu.vn.demo1.model.Product;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;
import java.util.List;

public class JDBIConnect {
    private static Jdbi jdbi;
    static String url = "jdbc:mysql://" + DBProperties.host() + ":" + DBProperties.port() + "/" + DBProperties.dbname() + "?" + DBProperties.option();
    public static Jdbi get() {
        if (jdbi == null) {
            makeConnect();
        }
        return jdbi;
    }

    private static void makeConnect() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(url);
        ds.setUser(DBProperties.username());
        ds.setPassword(DBProperties.password());

        try {
            ds.setUseCompression(true);
            ds.setAutoReconnect(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbi = Jdbi.create(ds);
    }

//    public static void main(String[] args) {
//        Jdbi jdbi1 = get();
//        List<Product> products = jdbi1.withHandle(handle -> handle.createQuery("select * from products")
//                .mapToBean(Product.class)
//                .list());
//        System.out.println(products);
//    }

}
