package vn.edu.hcmuaf.fit.webike.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.models.Product;
import vn.edu.hcmuaf.fit.webike.models.Spec;

import java.sql.SQLException;
import java.util.List;

public class JDBIConnect {
    static String url = "jdbc:mysql://" + DBProperties.host() + ":" + DBProperties.port() + "/" + DBProperties.dbname() + "?" + DBProperties.option();
    private static Jdbi jdbi;

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
//        List<Spec> products = jdbi1.withHandle(handle -> handle.createQuery(
//                        "SELECT s.id, s.tag, s.des, s.type from products as p join productdetails as pd on p.id = pd.productID "
//                                + "join detailrecords as dr on pd.id = dr.pdID "
//                                + "join specs as s on s.id = dr.specID where p.id = 1")
//                .mapToBean(Spec.class)
//                .list());
//        System.out.println(products);
//    }

}


