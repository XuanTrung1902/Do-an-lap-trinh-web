package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.*;


import java.util.List;

public class StockDAO {
    public static void main(String[] args) {
        StockDAO dao = new StockDAO();
//        System.out.println(dao.getStockIn());
//        System.out.println(dao.getStockInByID(1));
        System.out.println(dao.getStockItemByBatchID(1));
//        System.out.println(dao.getStockBatchByStockId(1));
//        System.out.println(dao.getStockBatch());
//        String batch = dao.getStockBatch().get(0).getBatch();
//        List<String> ls = Arrays.stream(batch.split("-")).toList();
//        for (String s : ls) {
//            System.out.println(s);
//        }
//        System.out.println(dao.getStockBatchById(1));
//        for (StockItem item : dao.getStockItem()) {
//            System.out.println(item);
//        }
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

                    List<StockBatch> batches = getStockBatchByStockId(rs.getInt("id"));

                    StockIn si = new StockIn();

                    si.setId(rs.getInt("id"));
                    si.setSupplier(s);
                    si.setEmployeeID(rs.getInt("employeeID"));
                    si.setReceiptDate(rs.getString("receiptDate"));
                    si.setNote(rs.getString("note"));
                    si.setBatches(batches);
                    return si;
                })
                .list()
        );
    }

    public StockIn getStockInByID(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from stockin as si join suppliers as s on si.supplierID = s.id where si.id = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
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

                    List<StockBatch> batches = getStockBatchByStockId(rs.getInt("id"));

                    StockIn si = new StockIn();
                    si.setId(rs.getInt("id"));
                    si.setSupplier(s);
                    si.setEmployeeID(rs.getInt("employeeID"));
                    si.setReceiptDate(rs.getString("receiptDate"));
                    si.setNote(rs.getString("note"));
                    si.setBatches(batches);
                    return si;
                })
                .findOne()
                .orElse(null)
        );
    }

    public List<StockBatch> getStockBatch() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from stockbatches sb join stockin s on sb.stockID = s.id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .map((rs, ctx) -> {
                    StockBatch s = new StockBatch();
                    StockIn si = getStockInByID(rs.getInt("stockID"));
                    s.setId(rs.getInt("id"));
                    s.setStockID(si.getId());
                    s.setProductID(rs.getInt("productID"));
                    s.setQuantity(rs.getInt("quantity"));
                    s.setUnitPrice(rs.getDouble("unitPrice"));
                    s.setTotalPrice(rs.getDouble("totalPrice"));
                    s.setBatch(rs.getString("batch"));
                    s.setImportID(rs.getInt("importID"));
                    return s;
                })
                .list());
    }

    public StockBatch getStockBatchById(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from stockbatches where id = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .mapToBean(StockBatch.class)
                .findOne()
                .orElse(null)
        );
    }

    public List<StockBatch> getStockBatchByStockId(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from stockbatches where stockID = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .mapToBean(StockBatch.class)
                .list()
        );
    }

    public List<StockItem> getStockItem() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from stockitems";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .map((rs, ctx) -> {
                    StockItem si = new StockItem();
                    ProductDAO pdao = new ProductDAO();
                    Color c = pdao.getColorByID(rs.getInt("colorID"));
                    StockBatch batch = getStockBatchById(rs.getInt("batchID"));
                    Product product = pdao.getProduct(rs.getInt("productID"));
                    String status = rs.getString("status");
                    si.setId(rs.getInt("id"));
                    si.setColor(c);
                    si.setProduct(product);
                    si.setBatch(batch);
                    si.setStatus(status);
                    return si;
                })
                .list()
        );
    }

    public List<StockItem> getStockItemByBatchID(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from stockitems where batchID = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .map((rs, ctx) -> {
                    StockItem si = new StockItem();
                    ProductDAO pdao = new ProductDAO();
                    Color c = pdao.getColorByID(rs.getInt("colorID"));
                    StockBatch batch = getStockBatchById(rs.getInt("batchID"));
                    Product product = pdao.getProduct(rs.getInt("productID"));
                    String status = rs.getString("status");
                    si.setId(rs.getInt("id"));
                    si.setColor(c);
                    si.setProduct(product);
                    si.setBatch(batch);
                    si.setStatus(status);
                    return si;
                })
                .list()
        );
    }

    public StockItem getStockItemByID(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from stockitems where id = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .map((rs, ctx) -> {
                    StockItem si = new StockItem();
                    ProductDAO pdao = new ProductDAO();
                    Color c = pdao.getColorByID(rs.getInt("colorID"));
                    StockBatch batch = getStockBatchById(rs.getInt("batchID"));
                    Product product = pdao.getProduct(rs.getInt("productID"));
                    String status = rs.getString("status");
                    si.setId(id);
                    si.setColor(c);
                    si.setProduct(product);
                    si.setBatch(batch);
                    si.setStatus(status);
                    return si;
                })
                .findOne()
                .orElse(null)
        );
    }
}
