package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.util.StringTokenizer;

public class Comment implements Serializable {
    private String content;
    private String created;
    private String username;
    private String color;
    private String avt;

    public Comment() {
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        StringTokenizer t = new StringTokenizer(this.created, "-");
        String year = t.nextToken();
        String month = t.nextToken();
        String day = t.nextToken();
        this.created = day + "/" + month + "/" + year;
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Comment: " + content + ", " + created + ", " + username + ", " + color + ", " + avt;
    }
}
