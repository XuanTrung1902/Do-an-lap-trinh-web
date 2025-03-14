package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Color;

import java.util.List;

public class UpdateProductDAO {
    public List<Integer> getAllSpecID(String pid){
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("SELECT specID FROM productdetails where productID=:pid")
                .bind("pid", pid)
                .mapTo(Integer.class).list());
    }

    public static void main(String[] args) {
        UpdateProductDAO dao = new UpdateProductDAO();
        System.out.println(dao.getAllSpecID("1"));
    }
}
