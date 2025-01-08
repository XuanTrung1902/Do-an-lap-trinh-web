package vn.edu.hcmuaf.fit.webike.dao;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Discount;
import java.util.List;

public class DiscountDao {
    // Lấy danh sách tất cả giảm giá
    public List<Discount> getAllDiscounts() {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM discounts")
                        .mapToBean(Discount.class)
                        .list()
        );
    }
    // Xóa giảm giá
    public boolean deleteDiscount(int id) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("DELETE FROM discounts WHERE id = :id")
                        .bind("id", id)
                        .execute() > 0
        );
    }
    // Thêm giảm giá mới
    public boolean addDiscount(Discount discount) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("INSERT INTO discounts (amount, start, end, productID) VALUES (:amount, :start, :end, :productID)")
                        .bind("amount", discount.getAmount())
                        .bind("start", discount.getStart())
                        .bind("end", discount.getEnd())
                        .bind("productID", discount.getProductID())
                        .execute() > 0
        );
    }
    // Lấy giảm giá theo ID
    public Discount getDiscountById(int id) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM discounts WHERE id = :id")
                        .bind("id", id)
                        .mapToBean(Discount.class)
                        .findOne()
                        .orElse(null)
        );
    }
    // Cập nhật giảm giá
    public boolean updateDiscount(Discount discount) {
        return JDBIConnect.get().withHandle(handle ->
                handle.createUpdate("UPDATE discounts SET amount = :amount, start = :start, end = :end, productID = :productID WHERE id = :id")
                        .bind("amount", discount.getAmount())
                        .bind("start", discount.getStart())
                        .bind("end", discount.getEnd())
                        .bind("productID", discount.getProductID())
                        .bind("id", discount.getId())
                        .execute() > 0
        );
    }

}
