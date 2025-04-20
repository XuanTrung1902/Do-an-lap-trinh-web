package vn.edu.hcmuaf.fit.webike.services;

import vn.edu.hcmuaf.fit.webike.dao.PermissionDao;
import vn.edu.hcmuaf.fit.webike.models.PermissionDTO;

import java.util.List;

public class PermissionService {
    public static List<PermissionDTO> getPermissionsForUser(int userId) {
        return new PermissionDao().getPermissionsByUserId(userId);
    }
}