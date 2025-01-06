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
}
