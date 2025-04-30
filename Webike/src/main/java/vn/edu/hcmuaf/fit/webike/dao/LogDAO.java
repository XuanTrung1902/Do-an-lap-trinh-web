//package vn.edu.hcmuaf.fit.webike.dao;
//
//import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
//
//import java.time.LocalDateTime;
//
//public class LogDAO {
//    public void insertLog(String level, LocalDateTime logTime, String location, String userInfo, String before, String after) {
//        JDBIConnect.get().useHandle(handle ->
//                handle.createUpdate("INSERT INTO logs (level, logTime, location, userInfo, `before`, `after`) VALUES (:level, :logTime, :location, :userInfo, :before, :after)")
//                        .bind("level", level)
//                        .bind("logTime", logTime)
//                        .bind("location", location)
//                        .bind("userInfo", userInfo)
//                        .bind("before", before)
//                        .bind("after", after)
//                        .execute()
//        );
//    }
//}
