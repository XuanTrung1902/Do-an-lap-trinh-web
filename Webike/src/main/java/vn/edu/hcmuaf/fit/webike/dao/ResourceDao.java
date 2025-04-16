package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Resource;

import java.util.List;

public class ResourceDao {
    public List<Resource> getAllResources() {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM resource")
                        .mapToBean(Resource.class)
                        .list()
        );
    }
}
