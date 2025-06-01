package vn.edu.hcmuaf.fit.webike.dao;

import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Log;

import java.time.LocalDateTime;
import java.util.List;

public class LogDAO {
    public void insertLog(String level, LocalDateTime logTime, String location, String userInfo, String before, String after) {
        JDBIConnect.get().useHandle(handle ->
                handle.createUpdate("INSERT INTO logs (level, logTime, location, userInfo, `before`, `after`) VALUES (:level, :logTime, :location, :userInfo, :before, :after)")
                        .bind("level", level)
                        .bind("logTime", logTime)
                        .bind("location", location)
                        .bind("userInfo", userInfo)
                        .bind("before", before)
                        .bind("after", after)
                        .execute()
        );
    }
    // Lấy danh sách toàn bộ logs (sắp xếp theo thời gian mới nhất)
    public List<Log> getAllLogs() {
        return JDBIConnect.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM logs ORDER BY logTime DESC")
                        .mapToBean(Log.class)
                        .list()
        );
    }
}
