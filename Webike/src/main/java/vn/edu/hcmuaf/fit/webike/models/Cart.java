package vn.edu.hcmuaf.fit.webike.models;

import vn.edu.hcmuaf.fit.webike.dao.CartDAO;

import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable {
    CartDAO dao = new CartDAO();
    List<CartItem> data = new ArrayList<>();

    public List<CartItem> getData() {
        return data;
    }

    public void setData(int uid) {
        this.data = dao.getCartItemByUID(uid);
    }

    public boolean add(CartItem item) {
        if (data.contains(item)) {
            int update = dao.updateCartItem(item, item.getQuantity() + 1);
            return update > 0;
        } else {
            int insert = dao.insertCartItem(item);
            return insert > 0;
        }
    }

    public boolean update(CartItem item, int quantity) {
        int insert = dao.updateCartItem(item, quantity);
        return insert > 0;
    }

    public boolean remove(CartItem item) {
        int remove = dao.removeCartItem(item);
        return remove > 0;
    }

    public List<CartItem> getList() {
        return data;
    }

    public double getTotalPrice() {
        double sum = 0;

        for (CartItem item : data) {
            sum += item.getPrice();
        }
        return sum;
    }

    public int getCartLength() {
        return data.size();
    }
}
