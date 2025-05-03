package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.CartItem;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class CartDAO {
    public static void main(String[] args) {
        CartDAO dao = new CartDAO();
        LocalDateTime time = LocalDateTime.of(2025, 5, 3, 14, 30);
        CartItem item = new CartItem("10-4-13",8, "Yamaha Super Cub 110",
                23000000, 2, "Còn hàng", "Tiêu chuẩn",
                "Yamaha", "Xe số",
                14, "Kem", "XYZ", 13, time);
//        System.out.println(dao.getCartItemByUID(13));
//        System.out.println(dao.insertCartItem(item));
//        System.out.println(dao.updateCartItem("1-2-13", 34));
//        System.out.println(dao.getCartItemByID("1-2-13"));
//        System.out.println(dao.removeCartItem("3-4-13"));
    }

    public List<CartItem> getCartItemByUID(int uid) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select ci.*, c.name as colorname from cartitem ci " +
                "join colors c on c.id = ci.cid " +
                "where uid = :uid " +
                "order by ci.added desc";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("uid", uid)
                .mapToBean(CartItem.class)
                .list()
        );
    }

    public CartItem getCartItemByID(String id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select ci.*, c.name as colorname " +
                "from cartitem ci join colors c on c.id = ci.cid " +
                "where ci.id = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .mapToBean(CartItem.class)
                .first()
        );
    }

    public int insertCartItem(CartItem item) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "INSERT into cartitem (id, pid, name, price, quantity, status, version, brand, type, cid, img, uid, added)" +
                " values (:id, :pid, :name, :price, :quantity, :status, :version, :brand, :type, :cid, :img, :uid, :added)";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("id", item.getId())
                .bind("pid", item.getPid())
                .bind("name", item.getName())
                .bind("price", item.getPrice())
                .bind("quantity", item.getQuantity())
                .bind("status", item.getStatus())
                .bind("version", item.getVersion())
                .bind("brand", item.getBrand())
                .bind("type", item.getType())
                .bind("cid", item.getCid())
                .bind("img", item.getImg())
                .bind("uid", item.getUid())
                .bind("added", LocalDateTime.now())
                .execute()
        );
    }

    public int updateCartItem(String id, int quantity) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "UPDATE cartitem SET quantity = :quantity, added = :added WHERE id = :id";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("quantity", quantity)
                .bind("added", LocalDateTime.now())
                .bind("id", id)
                .execute()
        );
    }

    public int removeCartItem(String id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "DELETE FROM cartitem WHERE id = :id";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("id", id)
                .execute()
        );
    }
}
