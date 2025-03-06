package vn.edu.hcmuaf.fit.webike.services;

import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;

public class ProductService {
    private ProductDAO dao;

    public ProductService() {
        this.dao = new ProductDAO();
    }

}
