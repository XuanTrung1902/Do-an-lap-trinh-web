package vn.edu.hcmuaf.fit.webike.models;

import java.util.StringTokenizer;

public class Comment {
    private String content;
    private String created;
    private String username;

    public Comment() {
    }

    public Comment(String content, String created, String username) {
        this.content = content;
        this.created = created;
        this.username = username;
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

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", created='" + created + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
