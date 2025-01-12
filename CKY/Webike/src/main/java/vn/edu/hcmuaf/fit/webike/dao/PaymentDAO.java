package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Order;
import vn.edu.hcmuaf.fit.webike.models.OrderItem;
import vn.edu.hcmuaf.fit.webike.models.Shop;

import java.util.List;

public class PaymentDAO {
    public static void main(String[] args) {
        PaymentDAO dao = new PaymentDAO();
        System.out.println(dao.getShops());
    }

    public List<Shop> getShops() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from shops";
        return jdbi.withHandle(handle -> handle.createQuery(sql).mapToBean(Shop.class).list());
    }

    public int insertOrder(Order o) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                insert into orders (deposit, remain, appointment, payDate, status, accountID, shopID)
                values (:deposit, :remain, :appointment, :payDate, :status, :accountID, :shopID) 
                """;
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("deposit", o.getDeposit())
                .bind("remain", o.getDeposit())
                .bind("appointment", o.getAppointment())
                .bind("payDate", o.getPayDate())
                .bind("status", o.getStatus())
                .bind("accountID", o.getUser().getId())
                .bind("shopID", o.getShop().getId())
                .execute());
    }

    public int insertOrderItem(OrderItem i) {
        return 1;
    }

}
