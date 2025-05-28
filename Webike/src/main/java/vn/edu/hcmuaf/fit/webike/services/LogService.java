package vn.edu.hcmuaf.fit.webike.services;

import vn.edu.hcmuaf.fit.webike.dao.LogDAO;

import java.time.LocalDateTime;

public class LogService {
    public static final String LEVEL_INFO = "INFO";
    public static final String LEVEL_ALERT = "ALERT";
    public static final String LEVEL_WARNING = "WARNING";
    public static final String LEVEL_DENGER = "DENGER";


    public static void log(String level, String location, String userInfo, String before, String after) {
        LogDAO logDao = new LogDAO();
        logDao.insertLog(level, LocalDateTime.now(), location, userInfo, before, after);
    }
}
