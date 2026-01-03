package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Color;
import vn.edu.hcmuaf.fit.webike.models.OrderItem;

import java.util.List;
public class BuyHistoryDAO {
    public static void main(String[] args) {
        BuyHistoryDAO dao = new BuyHistoryDAO();
        int accountID = 13;
        int page = 1;
        int itemsPerPage = 5;
        List<OrderItem> items = dao.getPaginatedOrderItems(accountID, page, itemsPerPage);
        System.out.println("Items on page " + page + ": " + items.size());
        for (OrderItem o : items) {
            System.out.println(o.toString());
        }
//        int totalItems = dao.getTotalOrderItems(accountID);
//        System.out.println("Total items: " + totalItems);
    }

    public List<OrderItem> getPaginatedOrderItems(int accountID, int page, int itemsPerPage) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                SELECT oi.*, c.*, p.name, p.version, (oi.quantity * p.price) AS price, o.status, o.leadtime, b.name as brand, t.type as type
                FROM orderitems AS oi
                JOIN orders AS o ON oi.orderID = o.id
                JOIN products AS p ON oi.productID = p.id
                JOIN brands AS b ON p.brandID = b.id
                JOIN biketypes AS t ON p.typeID = t.id
                JOIN colors AS c ON oi.color = c.id
                WHERE o.accountID = :accountID
                ORDER BY o.id DESC
                LIMIT :limit OFFSET :offset
                """;
        int offset = (page - 1) * itemsPerPage;
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("accountID", accountID)
                .bind("limit", itemsPerPage)
                .bind("offset", offset)
                .map((rs, ctx) -> {
                    Color color = new Color();
                    color.setId(rs.getInt("c.id"));
                    color.setName(rs.getString("c.name"));
                    color.setCode(rs.getString("c.code"));

                    OrderItem item = new OrderItem();
                    item.setId(rs.getInt("oi.id"));
                    item.setName(rs.getString("p.name"));
                    item.setQuantity(rs.getInt("oi.quantity"));
                    item.setImg(rs.getString("oi.img"));
                    item.setColor(color);
                    item.setProductID(rs.getInt("oi.productID"));
                    item.setOrderID(rs.getString("oi.orderID"));
                    item.setPrice(rs.getDouble("price"));
                    item.setVersion(rs.getString("p.version"));
                    item.setBrand(rs.getString("brand"));
                    item.setType(rs.getString("t.type"));
                    item.setCommented(rs.getInt("oi.commented"));
                    item.setStatus(rs.getString("o.status"));
                    item.setLeadtime(rs.getString("leadtime"));
//                    item.setOrder_code(rs.getString("order_code"));
                    return item;
                })
//                .mapToBean(OrderItem.class)
                .list());
    }

    public List<OrderItem> getPaginatedOrderItemsByStatus(String status, int accountID, int page, int itemsPerPage) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                SELECT oi.*, c.*, p.name, p.version, (oi.quantity * p.price) AS price, o.status, o.leadtime, b.name as brand, t.type as type, ghn.order_code
                FROM orderitems AS oi
                JOIN orders AS o ON oi.orderID = o.id
                JOIN products AS p ON oi.productID = p.id
                JOIN brands AS b ON p.brandID = b.id
                JOIN biketypes AS t ON p.typeID = t.id
                JOIN colors AS c ON oi.color = c.id
                JOIN orderghn AS ghn ON oi.orderID = ghn.oid
                WHERE o.accountID = :accountID AND o.status = :status
                ORDER BY o.id DESC
                LIMIT :limit OFFSET :offset
                """;
        int offset = (page - 1) * itemsPerPage;
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("accountID", accountID)
                .bind("limit", itemsPerPage)
                .bind("offset", offset)
                .bind("status", status)
                .map((rs, ctx) -> {
                    Color color = new Color();
                    color.setId(rs.getInt("c.id"));
                    color.setName(rs.getString("c.name"));
                    color.setCode(rs.getString("c.code"));

                    OrderItem item = new OrderItem();
                    item.setId(rs.getInt("oi.id"));
                    item.setName(rs.getString("p.name"));
                    item.setQuantity(rs.getInt("oi.quantity"));
                    item.setImg(rs.getString("oi.img"));
                    item.setColor(color);
                    item.setProductID(rs.getInt("oi.productID"));
                    item.setOrderID(rs.getString("oi.orderID"));
                    item.setPrice(rs.getDouble("price"));
                    item.setVersion(rs.getString("p.version"));
                    item.setBrand(rs.getString("brand"));
                    item.setType(rs.getString("t.type"));
                    item.setCommented(rs.getInt("oi.commented"));
                    item.setStatus(rs.getString("o.status"));
                    item.setLeadtime(rs.getString("leadtime"));
                    item.setOrder_code(rs.getString("order_code"));
                    return item;
                })
                .list());
    }

    public List<OrderItem> getPaginatedOrderItemsByStatus1(String status, int accountID, int page, int itemsPerPage) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                SELECT oi.*, c.*, p.name, p.version, (oi.quantity * p.price) AS price, o.status, o.leadtime, b.name as brand, t.type as type
                FROM orderitems AS oi
                JOIN orders AS o ON oi.orderID = o.id
                JOIN products AS p ON oi.productID = p.id
                JOIN brands AS b ON p.brandID = b.id
                JOIN biketypes AS t ON p.typeID = t.id
                JOIN colors AS c ON oi.color = c.id
                WHERE o.accountID = :accountID AND o.status = :status
                ORDER BY o.id DESC
                LIMIT :limit OFFSET :offset
                """;
        int offset = (page - 1) * itemsPerPage;
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("accountID", accountID)
                .bind("limit", itemsPerPage)
                .bind("offset", offset)
                .bind("status", status)
                .map((rs, ctx) -> {
                    Color color = new Color();
                    color.setId(rs.getInt("c.id"));
                    color.setName(rs.getString("c.name"));
                    color.setCode(rs.getString("c.code"));

                    OrderItem item = new OrderItem();
                    item.setId(rs.getInt("oi.id"));
                    item.setName(rs.getString("p.name"));
                    item.setQuantity(rs.getInt("oi.quantity"));
                    item.setImg(rs.getString("oi.img"));
                    item.setColor(color);
                    item.setProductID(rs.getInt("oi.productID"));
                    item.setOrderID(rs.getString("oi.orderID"));
                    item.setPrice(rs.getDouble("price"));
                    item.setVersion(rs.getString("p.version"));
                    item.setBrand(rs.getString("brand"));
                    item.setType(rs.getString("t.type"));
                    item.setCommented(rs.getInt("oi.commented"));
                    item.setStatus(rs.getString("o.status"));
                    item.setLeadtime(rs.getString("leadtime"));
//                    item.setOrder_code(rs.getString("order_code"));
                    return item;
                })
                .list());
    }

    public int getTotalOrderItems(int accountID) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                SELECT COUNT(*) 
                FROM orderitems AS oi
                JOIN orders AS o ON oi.orderID = o.id
                WHERE o.accountID = :accountID
                """;
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("accountID", accountID)
                .mapTo(Integer.class)
                .one());
    }

    public int getTotalOrderItemsByStatus(int accountID, String status) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                SELECT COUNT(*) 
                FROM orderitems AS oi
                JOIN orders AS o ON oi.orderID = o.id
                WHERE o.accountID = :accountID and o.status = :status
                """;
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("accountID", accountID)
                .bind("status", status)
                .mapTo(Integer.class)
                .one());
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
