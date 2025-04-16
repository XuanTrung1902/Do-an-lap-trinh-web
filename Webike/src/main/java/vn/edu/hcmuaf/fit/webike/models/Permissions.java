package vn.edu.hcmuaf.fit.webike.models;

public class Permissions {
    private int id;
    private String name;

    public Permissions() {}

    public Permissions(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public Permissions(String id, String name) {
        this.id = Integer.parseInt( id);
        this.name = name;
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

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
