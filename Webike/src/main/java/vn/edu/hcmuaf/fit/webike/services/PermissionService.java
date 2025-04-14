package vn.edu.hcmuaf.fit.webike.services;

import vn.edu.hcmuaf.fit.webike.dao.PermissionDao;
import vn.edu.hcmuaf.fit.webike.models.Permission;

import java.util.List;

public class PermissionService {
    public static List<Permission> getPermissionsForUser(int userId) {
        return new PermissionDao().getPermissionsByUserId(userId);
    }
}