package vn.edu.hcmuaf.fit.webike.models;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class ImportType {
    private int id;
    private int code;
    private String name;
    private String description;

    public ImportType() {
    }

    public ImportType(int id, int code, String name, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ColumnName("des")
    public String getDescription() {
        return description;
    }

    @ColumnName("des")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ImportType{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
