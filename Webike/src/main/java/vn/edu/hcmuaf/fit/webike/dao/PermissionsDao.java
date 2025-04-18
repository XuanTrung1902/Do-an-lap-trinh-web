package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Permissions;

import java.util.List;

public class PermissionsDao {
    public List<Permissions> getAllPermissions() {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM permission")
                        .mapToBean(Permissions.class)
                        .list()
        );
    }
}
