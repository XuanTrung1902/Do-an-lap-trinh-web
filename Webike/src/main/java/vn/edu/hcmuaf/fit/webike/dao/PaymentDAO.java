package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
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

    public int insertOrder(double deposit, double remain, String address, String appointment, String payDate, String status, int accountID, int shopID) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                insert into orders (deposit, remain, address, appointment, payDate, status, accountID, shopID)
                values (:deposit, :remain, :address, :appointment, :payDate, :status, :accountID, :shopID)
                """;
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                        .bind("deposit", deposit)
                        .bind("remain", remain)
                        .bind("address", address)
                        .bind("appointment", appointment)
                        .bind("payDate", payDate)
                        .bind("status", status)
                        .bind("accountID", accountID)
                        .bind("shopID", shopID)
                        .executeAndReturnGeneratedKeys()
                        .mapTo(int.class)
                        .first()
//                        .execute() > 0 ? 1 : 0
        );
    }


    public int insertOrderItem(int quantity, String img, String color, int oid, int pid) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                insert into orderItems (quantity, img, color, orderID, productID)
                values (:quantity, :img, :color, :orderID, :productID)
                """;
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("quantity", quantity)
                .bind("img", img)
                .bind("color", color)
                .bind("orderID", oid)
                .bind("productID", pid)
                .execute() > 0 ? 1 : 0
        );
    }
}
