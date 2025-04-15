package vn.edu.hcmuaf.fit.webike.models;

public class Permission {
    private String resource;
    private String action;

    public Permission(String resource, String action) {
        this.resource = resource;
        this.action = action;
    }

    public String getResource() { return resource; }
    public String getAction() { return action; }
}
