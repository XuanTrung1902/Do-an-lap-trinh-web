package vn.edu.hcmuaf.fit.webike.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    Map<Integer, CartProduct> data = new HashMap<Integer, CartProduct>();


    public boolean add(Product p) {
        if (data.containsKey(p.getId())) {
            update(p.getId(), data.get(p.getId()).getQuantity() + 1);
            return true;
        }
        data.put(p.getId(), convert(p));
        return true;
    }

    public boolean update(int id, int quantity) {
        if (!data.containsKey(id) || quantity < 1) return false;
        CartProduct cp = data.get(id);
        cp.setQuantity(quantity);
        data.put(id, cp);
        return true;
    }

    public boolean remove(int id) {
        if (!data.containsKey(id)) return false;
        data.remove(id);
        return true;
    }

    public List<CartProduct> getProducts() {
        List<CartProduct> rs = new ArrayList<>(data.values());
        return rs;
    }

    private CartProduct convert(Product p) {
        CartProduct cp = new CartProduct();
        cp.setId(p.getId());
        cp.setName(p.getName());
        cp.setPrice(p.getPrice());
        cp.setQuantity(1);
        return cp;
    }
}
