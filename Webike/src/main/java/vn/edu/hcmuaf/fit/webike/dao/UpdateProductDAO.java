package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Color;

import java.util.List;
import java.util.Set;

public class UpdateProductDAO {
    public List<Integer> getAllSpecID(String pid) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("SELECT specID FROM productdetails where productID=:pid")
                .bind("pid", pid)
                .mapTo(Integer.class).list());
    }

    public List<Integer> getPDetailID(String pid) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("SELECT id FROM productdetails where productID=:pid")
                .bind("pid", pid)
                .mapTo(Integer.class).list());
    }

    public int updateSpec(int pdetail, int specID) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "update productdetails set specID=:specID where id=:pdetail";
        return jdbi.withHandle(handle -> handle
                .createUpdate(sql)
                .bind("specID", specID)
                .bind("pdetail", pdetail)
                .execute()
        );
    }

    public static void main(String[] args) {
        UpdateProductDAO dao = new UpdateProductDAO();
//        System.out.println(dao.getAllSpecID("1"));
//        System.out.println(dao.getPDetailID("1"));
//        System.out.println(dao.updateSpec(3426, 5));
    }
}
