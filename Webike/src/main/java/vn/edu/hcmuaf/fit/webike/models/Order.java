package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Order implements Serializable {
    private int id;
    private List<OrderItem> data;
    private double deposit;
    private double remain;
    private String address;
    private String appointment;
    private String payDate;
    private String status;
    private User user;
    private Shop shop;

    public Order() {
        this.id = id;
        this.data = new ArrayList<OrderItem>();
        this.deposit = deposit;
        this.remain = remain;
        this.address = address;
        this.appointment = appointment;
        this.payDate = payDate;
        this.status = status;
        this.user = user;
        this.shop = shop;
    }

    public Order(int id, List<OrderItem> data, double deposit, double remain, String address, String appointment, String payDate, String status, User user, Shop shop) {
        this.id = id;
        this.data = new ArrayList<OrderItem>();
        this.deposit = deposit;
        this.remain = remain;
        this.address = address;
        this.appointment = appointment;
        this.payDate = payDate;
        this.status = status;
        this.user = user;
        this.shop = shop;
    }

    public void add(Cart c, Product p, String method) {
        if (method.equalsIgnoreCase("direct")) {
            OrderItem i = convertProduct(p);
            data.add(i);
        } else if (method.equalsIgnoreCase("from cart")) {
            for (CartItem cp : c.getList()) {
                OrderItem i = convertCartProduct(cp);
                data.add(i);
            }
        }
    }

    public boolean update(Cart cart, CartItem c, int quantity) {
        cart.update(c.getId(), quantity);
        return true;
    }

    public boolean remove(String id) {
        if (!data.contains(id)) return false;
        data.remove(id);
        return true;
    }

    public List<OrderItem> getData() {
        return data;
    }

    public void setData(List<OrderItem> data) {
        this.data = data;
    }


    public OrderItem convertCartProduct(CartItem c) {
        OrderItem item = new OrderItem();
        item.setQuantity(c.getQuantity());
        item.setImg(c.getImg());
        item.setColor(c.getColorName());
        item.setProductID(c.getPid());
        item.setName(c.getName());
        item.setPrice(c.getPrice());
        item.setVersion(c.getVersion());
        item.setBrand(c.getBrand());
        item.setType(c.getType());
        return item;
    }

    public OrderItem convertProduct(Product p) {
        OrderItem item = new OrderItem();
        item.setName(p.getName());
        item.setQuantity(1);
        Map.Entry<Color, String> entry = p.getImg().entrySet().iterator().next(); // map ở direct buy chỉ còn 1 cặp key-value mà theo màu mà người dùng đã chọn
        item.setImg(entry.getValue());
        item.setColor(entry.getKey().getName());
        item.setProductID(p.getId());
        if (p.getDiscount() > 0) {
            item.setPrice(p.getPrice() * (1 - p.getDiscount()));
        } else {
            item.setPrice(p.getPrice());
        }
        item.setVersion(p.getVersion());
        item.setBrand(p.getBrand());
        item.setType(p.getType());
        return item;
    }


    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", data=" + data +
                ", deposit=" + deposit +
                ", remain=" + remain +
                ", address='" + address + '\'' +
                ", appointment='" + appointment + '\'' +
                ", payDate='" + payDate + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", shop=" + shop +
                '}';
    }
}
