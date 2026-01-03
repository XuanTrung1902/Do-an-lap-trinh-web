package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class OrderDAO {


    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
//        List<Order> orders = dao.getOrders();
//        for (Order o : orders) {
//            System.out.println(o);
//        }
//        List<OrderItem> oi = dao.getOrderItems(18);
//        for (OrderItem i : oi) {
//            System.out.println(i);
//        }
//        System.out.println(dao.getOrdersByID(18));
//        System.out.println(dao.updateOrder(2, "ĐH NLU", "Đã thanh toán", "2022-12-12", "2023-02-12", 9));
    }

    public List<Order> getOrders() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                select o.*,
                a.name as uname, a.phoneNum as uPhoneNum, a.DOB as DOB, a.created as created,
                    a.locked as locked, a.verify as verify, a.role as role, a.address as uaddress,
                    a.sex, a.password,
                s.name as sname, s.address as saddress
                from orders as o
                join accounts as a on o.accountID = a.id
                join shops as s on o.shopID = s.id
                ORDER BY o.id
                """;
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .map((rs, ctx) -> {
                    Order o = new Order();
                    o.setId(rs.getInt("id"));
                    o.setPhoneNum(rs.getString("phoneNum"));
                    o.setDeposit(rs.getLong("deposit"));
                    o.setRemain(rs.getLong("remain"));
                    o.setAddress(rs.getString("address"));
                    o.setAppointment(rs.getString("appointment"));
                    o.setDepositDate(rs.getString("depositDate"));
                    o.setPayDate(rs.getString("payDate"));
                    o.setStatus(rs.getString("status"));
                    o.setLeadtime(rs.getString("leadtime"));

                    User u = new User();
                    u.setId(rs.getInt("accountID"));
                    u.setName(rs.getString("uname"));
                    u.setPhoneNum(rs.getString("uPhoneNum"));
                    u.setDOB(rs.getDate("DOB"));
                    u.setSex(rs.getString("sex"));
                    u.setPassword(rs.getString("password"));
                    u.setCreated(rs.getString("created"));
                    u.setLocked(rs.getInt("locked"));
                    u.setVerify(rs.getInt("verify"));
                    u.setRole(rs.getInt("role"));
                    u.setAddress(rs.getString("uaddress"));

                    Shop s = new Shop();
                    s.setId(rs.getInt("shopID"));
                    s.setName(rs.getString("sname"));
                    s.setAddress(rs.getString("saddress"));

                    o.setUser(u);
                    o.setShop(s);
                    return o;
                })
                .list()
        );
    }

    public List<OrderItem> getOrderItems(int oid) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                SELECT i.*, p.name, p.price, p.version, p.status, b.name as brand, t.type as type, c.name as colorName, c.code as colorCode
                from orderitems as i
                join products as p on i.productID = p.id
                JOIN brands as b on p.brandID = b.id
                JOIN biketypes as t on p.typeID = t.id
                JOIN colors as c on c.id = i.color
                where i.orderID = :oid;
                """;
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("oid", oid)
                        .map((rs, ctx) -> {
                            OrderItem oi = new OrderItem();

                            Color c = new Color();
                            c.setId(rs.getInt("color"));
                            c.setName(rs.getString("colorName"));
                            c.setCode(rs.getString("colorCode"));

                            oi.setId(rs.getInt("id"));
                            oi.setName(rs.getString("name"));
                            oi.setQuantity(rs.getInt("quantity"));
                            oi.setImg(rs.getString("img"));
                            oi.setColor(c);
                            oi.setProductID(rs.getInt("productID"));
                            oi.setOrderID(rs.getString("orderID"));
                            oi.setPrice(rs.getDouble("price"));
                            oi.setVersion(rs.getString("version"));
                            oi.setStatus(rs.getString("status"));
                            oi.setBrand(rs.getString("brand"));
                            oi.setType(rs.getString("type"));

                            StockDAO dao = new StockDAO();
                            StockItem si = dao.getStockItemByOrderItemID(rs.getInt("stockItemID"));
                            oi.setStockItem(si);
                            return oi;
                        })
                        .list()
        );
    }

    public int updateOrder(int oid, String phoneNum, String address, String status, String appointment, String payDate, int shopID) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                update orders
                set address = :address,
                phoneNum = :phoneNum,
                status = :status,
                appointment = :appointment,
                payDate = :payDate,
                shopID = :shopID
                where id = :oid
                """;
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("oid", oid)
                .bind("address", address)
                .bind("phoneNum", phoneNum)
                .bind("status", status)
                .bind("appointment", appointment)
                .bind("payDate", payDate)
                .bind("shopID", shopID)
                .execute() > 0 ? 1 : 0);
    }

    public Order getOrdersByID(int oid) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                select o.*,
                a.name as uname, a.phoneNum as uPhoneNum, a.DOB as DOB, a.created as created,
                a.locked as locked, a.verify as verify, a.role as role, a.address as uaddress,
                a.sex, a.password,
                s.name as sname, s.address as saddress
                from orders as o
                join accounts as a on o.accountID = a.id
                join shops as s on o.shopID = s.id
                WHERE o.id = :oid
                """;
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("oid", oid)
                .map((rs, ctx) -> {
                    Order o = new Order();
                    o.setId(rs.getInt("id"));
                    o.setPhoneNum(rs.getString("phoneNum"));
                    o.setDeposit(rs.getLong("deposit"));
                    o.setRemain(rs.getLong("remain"));
                    o.setAddress(rs.getString("address"));
                    o.setAppointment(rs.getString("appointment"));
                    o.setDepositDate(rs.getString("depositDate"));
                    o.setPayDate(rs.getString("payDate"));
                    o.setStatus(rs.getString("status"));

                    User u = new User();
                    u.setId(rs.getInt("accountID"));
                    u.setName(rs.getString("uname"));
                    u.setPhoneNum(rs.getString("uPhoneNum"));
                    u.setDOB(rs.getDate("DOB"));
                    u.setSex(rs.getString("sex"));
                    u.setPassword(rs.getString("password"));
                    u.setCreated(rs.getString("created"));
                    u.setLocked(rs.getInt("locked"));
                    u.setVerify(rs.getInt("verify"));
                    u.setRole(rs.getInt("role"));
                    u.setAddress(rs.getString("uaddress"));

                    Shop s = new Shop();
                    s.setId(rs.getInt("shopID"));
                    s.setName(rs.getString("sname"));
                    s.setAddress(rs.getString("saddress"));

                    o.setUser(u);
                    o.setShop(s);
                    return o;
                }).one()
        );
    }

    public List<OrderStatus> getOrderStatus() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "SELECT * FROM orderstatus";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .mapToBean(OrderStatus.class)
                .list()
        );
    }

    public List<Color> mapOfColorsAndProductID(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "SELECT c.* FROM colors c JOIN productdetails p ON p.colorID = c.id WHERE p.productID = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .mapToBean(Color.class)
                .list()
        );
    }

    public int updateOrderStatus(String oid, String status) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "UPDATE orders SET status = :status WHERE id = :id";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("id", oid)
                .bind("status", status)
                .execute() > 0 ? 1 : 0
        );
    }

    public String find_oid_by_GHN_order_code(String order_code) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select order_code from orderghn where order_code = :order_code";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("order_code", order_code)
                .mapTo(String.class)
                .findOne().orElse(null)
        );
    }

    public String find_GHN_order_code_by_oid(String oid) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select order_code from orderghn where oid = :oid";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("oid", oid)
                .mapTo(String.class)
                .findOne().orElse(null)
        );
    }

    public int insert_order_code(int oid, String order_code) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "INSERT INTO orderghn (oid, order_code) VALUES (:oid, :order_code)";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("oid", oid)
                .bind("order_code", order_code)
                .execute() > 0 ? 1 : 0
        );
    }
    public int updateLeadTime(String id, String time){
        Jdbi jdbi = JDBIConnect.get();
        String sql = "update orders set leadtime = :leadtime where id = :id";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("id", id)
                .bind("leadtime", time)
                .execute() > 0 ? 1 : 0
        );
    }

    public String getOrderCode(int oid) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select order_code from orderghn where oid = :oid";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("oid", oid)
                .mapTo(String.class)
                .findOne().orElse(null)
        );
    }
}
