package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.ImportType;


import java.util.List;

public class ImportTypeDAO {
    public List<ImportType> getImportTypes() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from importtypes";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .mapToBean(ImportType.class)
                .list()
        );
    }

    public ImportType getImportTypesById(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from importtypes where id = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .mapToBean(ImportType.class)
                .findOne()
                .orElse(null)
        );
    }

    public ImportType getImportTypesByCode(int code) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from importtypes where code = :code";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("code", code)
                .mapToBean(ImportType.class)
                .findOne()
                .orElse(null)
        );
    }
}
