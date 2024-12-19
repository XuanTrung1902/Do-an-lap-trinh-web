package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Feature;
import vn.edu.hcmuaf.fit.webike.models.Products;
import vn.edu.hcmuaf.fit.webike.models.Spec;
import vn.edu.hcmuaf.fit.webike.models.Warranty;

import java.util.List;

public class ProductDAO {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        System.out.println(dao.getProduct(1));
//        System.out.println(dao.getAll());
//        System.out.println(dao.getSpec(1, "động cơ"));
//        System.out.println(dao.getFeature(1));
//        System.out.println(dao.getWarranty(1));
    }

    public List<Products> getAllProducts() { // lấy ra tca sp
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("select * from products")
                .mapToBean(Products.class).list());
    }

    public Products getProduct(int id) { // lay sp theo id
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("select * from products where id = :id")
                .bind("id", id)
                .mapToBean(Products.class)
                .findOne()
                .orElse(null));
    }

    public List<Spec> getSpec(int id, String type) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery
                        ("SELECT s.id, s.tag, s.des, s.type from products as p\n" +
                                "join productdetails as pd on pd.productID = p.id \n" +
                                "join specs as s on s.id = pd.specID where p.id = :id and s.type = :type")
                .bind("id", id)
                .bind("type", type)
                .mapToBean(Spec.class).list());
    }

    public List<Feature> getFeature(int id) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery
                        ("SELECT f.id, f.tag, f.des, f.img from products as p\n" +
                                "join productdetails as pd on p.id = pd.productID\n" +
                                "join detailrecords as dr on pd.id = dr.pdID \n" +
                                "join features as f on f.id = dr.featureID where p.id =  :id")
                .mapToBean(Feature.class).list());
    }

    public List<Warranty> getWarranty(int id) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery
                        ("select w.id, w.km, w.duration, w.productID from products as p\n"
                                + "join warranties as w on w.productID= p.id where p.id =  :id")
                .mapToBean(Warranty.class).list());
    }
}
