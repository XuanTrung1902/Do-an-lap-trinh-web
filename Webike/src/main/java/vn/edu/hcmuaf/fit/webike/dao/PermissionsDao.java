package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Permissions;

import java.util.List;

public class PermissionsDao {
    public List<Permissions> getAllPermissions() {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT r.name AS resource, p.name AS action " +
                                "FROM permission p JOIN resource r ON p.resource_id = r.id")
                        .map((rs, ctx) -> new Permissions(rs.getString("resource"), rs.getString("action")))
                        .list()
        );
    }
}
