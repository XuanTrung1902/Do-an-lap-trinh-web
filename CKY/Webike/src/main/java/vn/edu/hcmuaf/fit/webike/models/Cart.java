package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable {
    Map<String, CartProduct> data = new LinkedHashMap<String, CartProduct>();


    public boolean add(Product p, String color, String img) {
        CartProduct cp = convert(p, color, img);
        if (data.containsKey(cp.getId())) {
            update(cp.getId(), data.get(cp.getId()).getQuantity() + 1);
            return true;
        }
        data.put(cp.getId(), cp);
        return true;
    }

    public boolean update(String id, int quantity) {
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

    public List<CartProduct> getList() {
        List<CartProduct> rs = new ArrayList<>(data.values());
        return rs;
    }

    private CartProduct convert(Product p, String color, String img) {
        CartProduct cp = new CartProduct();
        cp.setId(p.getId() + "/" + color);
//        cp.setId(String.valueOf(p.getId()));

        cp.setName(p.getName());
        double price = p.getPrice();
        cp.setPrice(price);
        cp.setQuantity(1);
        cp.setVersion(p.getVersion());
        cp.setStatus(p.getStatus());
        cp.setBrand(p.getBrand());
        cp.setType(p.getType());

        Map<String, String> imgColor = new HashMap<>();
        imgColor.put(color, img);
        cp.setImg(imgColor);
        return cp;
    }
}
