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
            item = dao.getCartItemByID(item.getId()); // cập nhật lại item vì item truyền vào khác với item lưu trong DB
            int update = dao.updateCartItem(item.getId(), item.getQuantity() + 1);
            return update > 0;
        } else {
            int insert = dao.insertCartItem(item);
            return insert > 0;
        }
    }

    public boolean update(String id, int quantity) {
        CartItem item = dao.getCartItemByID(id);
        quantity += item.getQuantity();
        int insert = dao.updateCartItem(id, quantity);
        return insert > 0;
    }

    public boolean remove(String id) {
        int remove = dao.removeCartItem(id);
        return remove > 0;
    }

    public List<CartItem> getList() {
        return data;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (CartItem item : data) {
            sum += item.getPrice() * item.getQuantity();
        }
        return sum;
    }

    public int getCartLength() {
        return data.size();
    }
}
