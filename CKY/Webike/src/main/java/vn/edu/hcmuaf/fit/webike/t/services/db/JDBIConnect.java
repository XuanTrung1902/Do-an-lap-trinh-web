package vn.edu.hcmuaf.fit.webike.t.services.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class JDBIConnect {
    private static final Logger logger = LoggerFactory.getLogger(JDBIConnect.class);
    private static Jdbi jdbi;
    static String url = "jdbc:mysql://" + DBProperties.host() + ":" + DBProperties.port() + "/" + DBProperties.dbname() + "?" + DBProperties.option();

    public static Jdbi get() {
        if (jdbi == null) {
            synchronized (JDBIConnect.class) {
                if (jdbi == null) {
                    makeConnect();
                }
            }
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
            logger.info("Database connection successfully established.");
        } catch (SQLException e) {
            logger.error("Failed to configure the data source", e);
            throw new RuntimeException(e);
        }

        jdbi = Jdbi.create(ds);
    }
}

