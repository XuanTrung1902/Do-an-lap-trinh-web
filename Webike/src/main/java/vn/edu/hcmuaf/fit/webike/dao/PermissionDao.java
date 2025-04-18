package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Permission;
import vn.edu.hcmuaf.fit.webike.models.PermissionPair;

import java.util.List;

public class PermissionDao {
    public List<Permission> getPermissionsByUserId(int userId) {
        String sql = """
            SELECT re.name AS resource, pe.name AS action
            FROM user_role ur
            JOIN role_resource_permission rrp ON ur.role_id = rrp.role_id
            JOIN resource re ON rrp.resource_id = re.id
            JOIN permission pe ON rrp.permission_id = pe.id
            WHERE ur.user_id = :userId
        """;

        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery(sql)
                        .bind("userId", userId)
                        .map((rs, ctx) -> new Permission(
                                rs.getString("resource"),
                                rs.getString("action")
                        ))
                        .list()
        );
    }

    public List<PermissionPair> getUserPermissions(int userId) {
        String sql = """
        SELECT rrp.resource_id, rrp.permission_id
        FROM user_role ur
        JOIN role_resource_permission rrp ON ur.role_id = rrp.role_id
        WHERE ur.user_id = :userId
    """;

        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery(sql)
                        .bind("userId", userId)
                        .map((rs, ctx) -> new PermissionPair(
                                rs.getInt("resource_id"),
                                rs.getInt("permission_id")
                        ))
                        .list()
        );
    }
    
}