package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.StockIn;
import vn.edu.hcmuaf.fit.webike.models.Supplier;

import java.util.Arrays;
import java.util.List;

public class StockDAO {
    public static void main(String[] args) {
        StockDAO dao = new StockDAO();
        System.out.println(dao.getStockIn());
        System.out.println(dao.getStockBatch());
        String batch = dao.getStockBatch().get(0).getBatch();
        List<String> ls =  Arrays.stream(batch.split("-")).toList();
        for (String s : ls) {
            System.out.println(s);
        }
    }

    public List<StockIn> getStockIn() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from stockin as si join suppliers as s on si.supplierID = s.id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .map((rs, ctx) -> {
                    Supplier s = new Supplier();
                    s.setId(rs.getInt("supplierID"));
                    s.setName(rs.getString("name"));
                    s.setContact_name(rs.getString("contact_name"));
                    s.setPhone(rs.getString("phone"));
                    s.setEmail(rs.getString("email"));
                    s.setAddress(rs.getString("address"));
                    s.setStatus(rs.getInt("status"));
                    s.setCreated(rs.getString("created"));

                    StockIn si = new StockIn();
                    si.setId(rs.getInt("id"));
                    si.setSupplier(s);
                    si.setEmployeeID(rs.getInt("employeeID"));
                    si.setReceiptDate(rs.getString("receiptDate"));
                    si.setNote(rs.getString("note"));
                    return si;
                })
                .list()
        );
    }

    public List<StockBatch> getStockBatch() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from stockbatches";
        return jdbi.withHandle(handle -> handle.createQuery(sql).mapToBean(StockBatch.class).list());
    }
    
}
