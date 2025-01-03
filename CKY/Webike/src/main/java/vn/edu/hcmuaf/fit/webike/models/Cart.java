package vn.edu.hcmuaf.fit.webike.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer, CartProduct> data = new HashMap<Integer, CartProduct>();


    public boolean add(Product p) {
        data.put(p.getId(), convert(p));
        return true;
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
