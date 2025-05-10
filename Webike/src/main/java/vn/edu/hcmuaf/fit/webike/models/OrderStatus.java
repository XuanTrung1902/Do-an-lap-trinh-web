package vn.edu.hcmuaf.fit.webike.models;

public class OrderStatus {
    private int id;
    private String statusCode;
    private String statusValue;
    private String valueString;

    public OrderStatus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", statusCode='" + statusCode + '\'' +
                ", statusValue='" + statusValue + '\'' +
                ", valueString='" + valueString + '\'' +
                '}';
    }
}
