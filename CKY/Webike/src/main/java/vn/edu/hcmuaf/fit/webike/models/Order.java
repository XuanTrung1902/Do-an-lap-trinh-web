package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Order implements Serializable {
    private List<OrderItem> data;
    private double deposit;
    private double remain;
    private String appointment;
    private String payDate;
    private String status;
    private User user;
    private Shop shop;

    public Order() {
        this.data = new ArrayList<OrderItem>();
        this.deposit = deposit;
        this.remain = remain;
        this.appointment = appointment;
        this.payDate = payDate;
        this.status = status;
        this.user = user;
        this.shop = shop;
    }

    public Order(List<OrderItem> data, double deposit, double remain, String appointment, String payDate, String status, User user, Shop shop) {
        this.data = new ArrayList<OrderItem>();
        this.deposit = deposit;
        this.remain = remain;
        this.appointment = appointment;
        this.payDate = payDate;
        this.status = status;
        this.user = user;
        this.shop = shop;
    }

    public void add(Cart c, Product p, String method, String pid, String color, String img) {
        if (method.equalsIgnoreCase("direct")) {
            OrderItem i = convertProduct(p, pid, color, img);
            data.add(i);
        } else if (method.equalsIgnoreCase("from cart")) {
            for (CartProduct cp : c.getList()) {

                StringTokenizer token = new StringTokenizer(cp.getId(), "/");
                String itemID = token.nextToken();
                String itemColor = token.nextToken();

                int quantity = cp.getQuantity();
                String itemImg = cp.getImg().get(itemColor);
                OrderItem i = convertCartProduct(cp, quantity, itemImg, itemColor, itemID);
                data.add(i);
            }
        }
    }

    public boolean update(Cart cart, CartProduct c, int quantity) {
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

    public OrderItem convertCartProduct(CartProduct c, int quantity, String img, String color, String pid) {
        OrderItem item = new OrderItem();
        item.setQuantity(quantity);
        item.setImg(img);
        item.setColor(color);
        item.setProductID(pid);

        item.setName(c.getName());
        item.setPrice(c.getPrice());
        item.setVersion(c.getVersion());
        item.setStatus(c.getStatus());
        item.setBrand(c.getBrand());
        item.setType(c.getType());
        return item;
    }

    public OrderItem convertProduct(Product p, String pid, String color, String img) {
        OrderItem item = new OrderItem();
        item.setQuantity(1);
        item.setImg(img);
        item.setColor(color);
        item.setProductID(pid);

        item.setName(p.getName());
        if (p.getDiscount() > 0) {
            item.setPrice(p.getPrice() - (p.getPrice() * p.getDiscount() / 100));
        } else {
            item.setPrice(p.getPrice());
        }

        item.setVersion(p.getVersion());
        item.setStatus(p.getStatus());
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

    @Override
    public String toString() {
        return "Order{" +
                "deposit=" + deposit +
                ", remain=" + remain +
                ", appointment='" + appointment + '\'' +
                ", payDate='" + payDate + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", shop=" + shop +
                '}';
    }
}
