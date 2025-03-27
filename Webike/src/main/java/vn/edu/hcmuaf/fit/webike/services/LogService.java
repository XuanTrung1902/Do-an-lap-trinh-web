package vn.edu.hcmuaf.fit.webike.services;

import vn.edu.hcmuaf.fit.webike.dao.LogDao;

import java.time.LocalDateTime;

public class LogService {
    public static final String LEVEL_INFO = "INFO";
    public static final String LEVEL_WARNING = "WARNING";

    public static void log(String level, String location, String userInfo, String before, String after) {
        LogDao logDao = new LogDao();
        logDao.insertLog(level, LocalDateTime.now(), location, userInfo, before, after);
//        System.out.println(level + ": " + location + ": " + userInfo + ": " + before + ": " + after);
    }

}
