package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.BikeType;

import java.util.List;

public class HomepageDAO {
    public static void main(String[] args) {
        HomepageDAO dao = new HomepageDAO();
        System.out.println(dao.getAllBikeType());
    }

    public List<BikeType> getAllBikeType() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "SELECT * FROM biketypes";
        return jdbi.withHandle(handle ->
                handle.createQuery(sql).mapToBean(BikeType.class).list()
        );
    }

    // lay ra 7 thuong hieu
    public List<String> getBrandOfProduct() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "SELECT img FROM brands WHERE id > 7";
        return jdbi.withHandle(handle ->
                handle.createQuery(sql).mapTo(String.class).list()
        );
    }
}
