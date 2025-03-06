package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.OrderItem;

import java.util.List;

public class BuyHistoryDAO {
    public static void main(String[] args) {
        BuyHistoryDAO dao = new BuyHistoryDAO();
        System.out.println(dao.getOrderItems(13).size());
        for (OrderItem o: dao.getOrderItems(13)){
            System.out.println(o.toString());
        }
    }

    public List<OrderItem> getOrderItems(int accountID) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                select oi.*, p.name, p.version, (oi.quantity * p.price) AS price, o.status, b.name as brand, t.type as type
                from orderitems as oi
                JOIN orders as o on oi.orderID = o.id
                JOIN products as p on oi.productID = p.id
                JOIN brands as b on p.brandID = b.id
                JOIN biketypes as t on p.typeID = t.id
                WHERE o.accountID = :accountID
                ORDER BY o.id DESC;
                """;
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("accountID", accountID)
                .mapToBean(OrderItem.class).list());
    }
}
