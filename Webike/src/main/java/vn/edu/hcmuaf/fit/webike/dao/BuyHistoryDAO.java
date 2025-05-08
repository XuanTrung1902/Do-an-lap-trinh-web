package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.OrderItem;

import java.util.List;
public class BuyHistoryDAO {
    public static void main(String[] args) {
        BuyHistoryDAO dao = new BuyHistoryDAO();
//        int accountID = 13;
//        int page = 1;
//        int itemsPerPage = 5;
//        List<OrderItem> items = dao.getPaginatedOrderItems(accountID, page, itemsPerPage);
//        System.out.println("Items on page " + page + ": " + items.size());
//        for (OrderItem o : items) {
//            System.out.println(o.toString());
//        }
//        int totalItems = dao.getTotalOrderItems(accountID);
//        System.out.println("Total items: " + totalItems);
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
