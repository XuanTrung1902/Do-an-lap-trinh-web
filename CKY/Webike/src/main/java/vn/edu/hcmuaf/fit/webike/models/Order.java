package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.util.*;

public class Order implements Serializable {
    private List<OrderItem> data = new ArrayList<>();
    private double deposit;
    private double remain;
    private String appointment;
    private String payDate;
    private String status;
    private User user;
    private Shop shop;

    public Order() {
    }
    public void add(Cart c){
        for (CartProduct p : c.getList()){
            OrderItem i= convert(p);
            data.add(i);
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

    public List<OrderItem> getList() {
        return data;
    }


    public OrderItem convert(CartProduct c) {
        OrderItem item = new OrderItem();
        StringTokenizer cid = new StringTokenizer(c.getId(), "/");
        String img = c.getImg().entrySet().iterator().next().getValue();

        item.setId(Integer.parseInt(cid.nextToken()));
        item.setColor(cid.nextToken());
        item.setPrice(c.getPrice());
        item.setQuantity(c.getQuantity());
        item.setVersion(c.getVersion());
        item.setStatus(c.getStatus());
        item.setBrand(c.getBrand());
        item.setType(c.getType());
        item.setImg(img);
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
