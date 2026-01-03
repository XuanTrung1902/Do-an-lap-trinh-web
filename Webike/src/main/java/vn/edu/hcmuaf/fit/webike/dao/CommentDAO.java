package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;

public class CommentDAO {
    public int insertComment(String content, String created, String color, int productID, int accountID) {
        Jdbi jdbi = JDBIConnect.get();
        String sql = """
                insert into comments (content, created, color, productID, accountID)
                values (:content, :created, :color, :productID, :accountID);
                """;
        return jdbi.withHandle(handle -> handle.createUpdate(sql)
                .bind("content", content)
                .bind("created", created)
                .bind("color", color)
                .bind("productID", productID)
                .bind("accountID", accountID)
                .execute() > 0 ? 1 : 0
        );
    }
    public int updateCommented(int orderItemID){
        Jdbi jdbi = JDBIConnect.get();
        String sql = "update orderitems set commented = 1 where id = :orderItemID";
        return jdbi.withHandle(handle ->
                handle.createUpdate(sql)
                        .bind("orderItemID", orderItemID)
                        .execute()
        );
    }
}
