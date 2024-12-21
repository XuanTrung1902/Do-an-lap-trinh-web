package vn.edu.hcmuaf.fit.webike.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.webike.db.JDBIConnect;
import vn.edu.hcmuaf.fit.webike.models.Feature;
import vn.edu.hcmuaf.fit.webike.models.Product;
import vn.edu.hcmuaf.fit.webike.models.Spec;
import vn.edu.hcmuaf.fit.webike.models.Warranty;

import java.util.List;

public class ProductDAO {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
//        System.out.println(dao.getProduct(1));
//        System.out.println(dao.getAll());
//        System.out.println(dao.getSpec(1, "động cơ"));
        System.out.println(dao.getFeature(1));
//        System.out.println(dao.getWarranty(1));
//        System.out.println(dao.getSpecType());
    }

    public List<Product> getAllProducts() { // lấy ra tca sp
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("select * from products")
                .mapToBean(Product.class).list());
    }

    public Product getProduct(int id) { // lay sp theo id
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("select * from products where id = :id")
                .bind("id", id)
                .mapToBean(Product.class)
                .findOne()
                .orElse(null));
    }

    public List<String> getSpecType() { // lay ra cac type trong specs [ho tro cho getSpec() ]
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery(
                "SELECT DISTINCT s.type from specs as s").mapTo(String.class).list());
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
                                "join productdetails as pd on pd.productID = p.id\n" +
                                "join features as f on f.id = pd.featureID where p.id =  :id")
                .bind("id", id)
                .mapToBean(Feature.class).list());
    }

    public List<Warranty> getWarranty(int id) {
        Jdbi jdbi = JDBIConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery
                        ("select w.id, w.km, w.duration, w.productID from products as p\n"
                                + "join warranties as w on w.productID= p.id where p.id =  :id")
                .bind("id", id)
                .mapToBean(Warranty.class).list());
    }
}
