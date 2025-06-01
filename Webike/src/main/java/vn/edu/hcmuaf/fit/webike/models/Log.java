package vn.edu.hcmuaf.fit.webike.models;
import java.sql.Timestamp;

public class Log {
    private int id;
    private String level;
    private Timestamp logTime;
    private String location;
    private String userInfo;
    private String before;
    private String after;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public Timestamp getLogTime() { return logTime; }
    public void setLogTime(Timestamp logTime) { this.logTime = logTime; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getUserInfo() { return userInfo; }
    public void setUserInfo(String userInfo) { this.userInfo = userInfo; }

    public String getBefore() { return before; }
    public void setBefore(String before) { this.before = before; }

    public String getAfter() { return after; }
    public void setAfter(String after) { this.after = after; }
}
