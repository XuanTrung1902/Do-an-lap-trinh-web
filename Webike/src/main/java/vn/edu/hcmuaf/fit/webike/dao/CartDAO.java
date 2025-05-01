package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.CartItem;

import java.util.List;

public class CartDAO {
    public static void main(String[] args) {
        CartDAO dao = new CartDAO();
        CartItem item = new CartItem(0, 8, "Yamaha Super Cub 110",
                23000000, 2, "Còn hàng", "Tiêu chuẩn",
                "Yamaha", "Xe số",
                14, "XYZ", 13);
//        System.out.println(dao.getCartItemByUID(13));
        System.out.println(dao.insertCartItem(item));
    }

    public List<CartItem> getCartItemByUID(int uid) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from cartitem where uid = :uid";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("uid", uid)
                .mapToBean(CartItem.class)
                .list()
        );
    }

    public CartItem getCartItemByID(int id) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "select * from cartitem where id = :id";
        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .mapTo(CartItem.class)
                .first()
        );
    }

    public int insertCartItem(CartItem item) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "INSERT into cartitem (pid, name, price, quantity, status, version, brand, type, cid, img, uid)" +
                " values (:pid, :name, :price, :quantity, :status, :version, :brand, :type, :cid, :img, :uid)";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
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
                .execute()
        );
    }

    public int updateCartItem(CartItem item, int quantity) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "UPDATE cartitem SET quantity = :quantity WHERE id = :id";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("quantity", quantity)
                .bind("id", item.getId())
                .execute()
        );
    }

    public int removeCartItem(CartItem item) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = "DELETE FROM cartitem WHERE id = :id";
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("id", item.getId())
                .execute()
        );
    }
}
