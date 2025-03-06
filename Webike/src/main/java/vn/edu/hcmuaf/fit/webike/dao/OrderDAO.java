package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Order;
import vn.edu.hcmuaf.fit.webike.models.OrderItem;
import vn.edu.hcmuaf.fit.webike.models.Shop;
import vn.edu.hcmuaf.fit.webike.models.User;

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
        System.out.println(dao.updateOrder(2, "ĐH NLU", "Đã thanh toán", "2022-12-12", "2023-02-12", 9));
    }

    public List<Order> getOrders() {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                select o.*,
                a.name as uname, a.phoneNum as phoneNum, a.DOB as DOB, a.created as created,
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
                    o.setDeposit(rs.getLong("deposit"));
                    o.setRemain(rs.getLong("remain"));
                    o.setAddress(rs.getString("address"));
                    o.setAppointment(rs.getString("appointment"));
                    o.setPayDate(rs.getString("payDate"));
                    o.setStatus(rs.getString("status"));

                    User u = new User();
                    u.setId(rs.getInt("accountID"));
                    u.setName(rs.getString("uname"));
                    u.setPhoneNum(rs.getString("phoneNum"));
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
                SELECT i.*, p.name, p.price, p.version, p.status, b.name as brand, t.type as type
                from orderitems as i
                join products as p on i.productID = p.id
                JOIN brands as b on p.brandID = b.id
                JOIN biketypes as t on p.typeID = t.id
                where i.orderID = :oid;
                """;
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("oid", oid)
                .mapToBean(OrderItem.class)
                .list());
    }

    public int updateOrder(int oid, String address, String status, String appointment, String payDate, int shopID) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                update orders
                set address = :address,
                status = :status,
                appointment = :appointment,
                payDate = :payDate,
                shopID = :shopID
                where id = :oid
                """;
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("oid", oid)
                .bind("address", address)
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
                a.name as uname, a.phoneNum as phoneNum, a.DOB as DOB, a.created as created,
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
                    o.setDeposit(rs.getLong("deposit"));
                    o.setRemain(rs.getLong("remain"));
                    o.setAddress(rs.getString("address"));
                    o.setAppointment(rs.getString("appointment"));
                    o.setPayDate(rs.getString("payDate"));
                    o.setStatus(rs.getString("status"));

                    User u = new User();
                    u.setId(rs.getInt("accountID"));
                    u.setName(rs.getString("uname"));
                    u.setPhoneNum(rs.getString("phoneNum"));
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
}
