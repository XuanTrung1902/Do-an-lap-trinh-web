package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Color;
import vn.edu.hcmuaf.fit.webike.models.Order;
import vn.edu.hcmuaf.fit.webike.models.Shop;

import java.util.List;

public class PaymentDAO {
    public static void main(String[] args) {
        PaymentDAO dao = new PaymentDAO();
//        System.out.println(dao.getShops());
//        dao.insertOrder(12.9,12.8, "Address", "2020-02-01", "2020-02-01","Status", 1,1);
//        System.out.println(dao.creatOrderID());
    }

    public List<Shop> getShops() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from shops";
        return jdbi.withHandle(handle -> handle.createQuery(sql).mapToBean(Shop.class).list());
    }

    public int creatOrderID() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "SELECT max(id) from orders";
        int rs = jdbi.withHandle(handle -> handle.createQuery(sql)
                .mapTo(Integer.class)
                .one() + 1);
        return rs;
    }

    public int insertOrder(String phoneNum, double deposit, double remain, String address, String appointment, String depositDate, String payDate, String status, int accountID, int shopID) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                insert into orders (phoneNum, deposit, remain, address, appointment, depositDate, payDate, status, accountID, shopID)
                values (:phoneNum, :deposit, :remain, :address, :appointment, :depositDate, :payDate, :status, :accountID, :shopID)
                """;
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                        .bind("phoneNum", phoneNum)
                        .bind("deposit", deposit)
                        .bind("remain", remain)
                        .bind("address", address)
                        .bind("appointment", appointment)
                        .bind("depositDate", depositDate)
                        .bind("payDate", payDate)
                        .bind("status", status)
                        .bind("accountID", accountID)
                        .bind("shopID", shopID)
                        .executeAndReturnGeneratedKeys()
                        .mapTo(int.class)
                        .first()
        );
    }


    public int insertOrderItem(int quantity, String img, Color color, int oid, int pid) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                insert into orderitems (quantity, img, color, orderID, productID)
                values (:quantity, :img, :color, :orderID, :productID)
                """;
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("quantity", quantity)
                .bind("img", img)
                .bind("color", color.getId())
                .bind("orderID", oid)
                .bind("productID", pid)
                .executeAndReturnGeneratedKeys()
                .mapTo(Integer.class)
                .findOne().orElse(null)
        );
    }
    public Order getOrderById(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "SELECT * FROM orders WHERE id = :id";
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("id", id)
                        .mapToBean(Order.class)
                        .findOne()
                        .orElse(null)
        );
    }
    public int orderItem_stockItem(int orderItemID, int stockItemID) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "update orderitems set stockItemID = :stockItemID where id = :orderItemID";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("orderItemID", orderItemID)
                .bind("stockItemID", stockItemID)
                .execute()
        );
    }
    public int getOneStockItemByPID(int pid) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select distinct id from stockitems where productID = :pid and status = 'Trong kho' limit 1";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("pid", pid)
                .mapTo(Integer.class)
                .findOne().orElse(null)
        );
    }
    public int updateStockItemStatus(int id, String status){
        Jdbi jdbi = JDBIConnect.get();
        String sql = "update stockitems set status = :status where id = :id";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("id", id)
                .bind("status", status)
                .execute()
        );
    }
}
