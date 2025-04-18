package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;

public class RoleDao {
    public int getOrCreateCustomRoleForUser(int userId) {
        String roleName = "custom_user_" + userId;
        return JDBIConnect.get().withHandle(handle -> {
            Integer roleId = handle.createQuery("SELECT id FROM role WHERE name = :name")
                    .bind("name", roleName)
                    .mapTo(Integer.class)
                    .findOne()
                    .orElse(null);

            if (roleId == null) {
                handle.createUpdate("INSERT INTO role(name, description) VALUES(:name, 'Role for user " + userId + "')")
                        .bind("name", roleName)
                        .execute();
                roleId = handle.createQuery("SELECT id FROM role WHERE name = :name")
                        .bind("name", roleName)
                        .mapTo(Integer.class)
                        .one();
            }

            return roleId;
        });
    }

    public void clearPermissionsForRole(int roleId) {
        JDBIConnect.get().useHandle(handle ->
                handle.createUpdate("DELETE FROM role_resource_permission WHERE role_id = :roleId")
                        .bind("roleId", roleId)
                        .execute());
    }

    public void addPermissionForRole(int roleId, int resId, int permId) {
        JDBIConnect.get().useHandle(handle ->
                handle.createUpdate("INSERT INTO role_resource_permission(role_id, resource_id, permission_id) VALUES(:r, :res, :perm)")
                        .bind("r", roleId)
                        .bind("res", resId)
                        .bind("perm", permId)
                        .execute());
    }

    public void assignRoleToUser(int userId, int roleId) {
        JDBIConnect.get().useHandle(handle -> {
            int count = handle.createQuery("SELECT COUNT(*) FROM user_role WHERE user_id = :uid AND role_id = :rid")
                    .bind("uid", userId)
                    .bind("rid", roleId)
                    .mapTo(Integer.class)
                    .one();

            if (count == 0) {
                handle.createUpdate("INSERT INTO user_role(user_id, role_id) VALUES(:uid, :rid)")
                        .bind("uid", userId)
                        .bind("rid", roleId)
                        .execute();
            }
        });
    }
}
