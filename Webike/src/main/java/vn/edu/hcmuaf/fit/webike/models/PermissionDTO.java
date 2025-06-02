package vn.edu.hcmuaf.fit.webike.models;

public class PermissionDTO {
    private String resource;
    private String action;

    private int id;
    private String name;

    private int resourceId;
    private int permissionId;

    public PermissionDTO() {
    }
    public PermissionDTO(String resource, String action) {
        this.resource = resource;
        this.action = action;
    }
    public PermissionDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PermissionDTO(int resourceId, int permissionId) {
        this.resourceId = resourceId;
        this.permissionId = permissionId;
    }
    // Getter & Setter
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "Permission: " + id + ", " + name + ", " + resource + ", " + action + ", " +
                resourceId + ", " + permissionId;
    }

}
