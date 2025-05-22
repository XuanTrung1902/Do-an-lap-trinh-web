package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Supplier;

import java.util.List;

public class SupplierDAO {
    public List<Supplier> getSuppliers() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from suppliers";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .mapToBean(Supplier.class)
                .list()
        );
    }
    public Supplier getSupplierByID(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from suppliers where id = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id",id)
                .mapToBean(Supplier.class)
                .findOne()
                .orElse(null)
        );
    }
}
