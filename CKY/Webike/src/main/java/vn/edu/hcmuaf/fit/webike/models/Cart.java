package vn.edu.hcmuaf.fit.webike.models;

import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable {
    Map<String, CartProduct> data = new LinkedHashMap<>();

    public boolean add(Product p, String color, String img) {
        CartProduct cp = convert(p, color, img);
        String id = cp.getId();
        if (data.containsKey(id)) {
            int quantity = data.get(id).getQuantity();
            quantity += 1;
            cp.setQuantity(quantity);
            data.put(id, cp);
            return true;
        }
        data.put(id, cp);
        return true;
    }

    public boolean update(String id, int quantity) {
        if (!data.containsKey(id) || quantity < 1) return false;
        CartProduct cp = data.get(id);
        cp.setQuantity(quantity);
        data.put(id, cp);
        return true;
    }

    public boolean remove(String id) {
        if (!data.containsKey(id)) return false;
        data.remove(id);
        return true;
    }

    public List<CartProduct> getList() {
        return new ArrayList<>(data.values());
    }

    private CartProduct convert(Product p, String color, String img) {
        CartProduct cp = new CartProduct();
        cp.setId(p.getId() + "/" + color);
        cp.setName(p.getName());
        cp.setPrice(p.getPrice());
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
