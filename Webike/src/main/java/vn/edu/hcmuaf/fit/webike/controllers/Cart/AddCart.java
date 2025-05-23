package vn.edu.hcmuaf.fit.webike.controllers.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.Cart;
import vn.edu.hcmuaf.fit.webike.models.CartItem;
import vn.edu.hcmuaf.fit.webike.models.Product;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;

@WebServlet(name = "AddCart", value = "/add-cart")
public class AddCart extends HttpServlet {
    final String LEVEL_ALERT = LogService.LEVEL_ALERT;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int cid = Integer.parseInt(request.getParameter("colorID")); // lay mau duoc chon
        String colorName = request.getParameter("colorName");
        String img = request.getParameter("imgURL"); // anh theo mau sp
        User user = (User) request.getSession().getAttribute("auth");
        int uid = user.getId();

        ProductDAO dao = new ProductDAO();
        Product p = dao.getProduct(id);

        CartItem item = new CartItem();
        item.setId(p.getId() + "-" + cid + "-" + uid);
        item.setPid(p.getId());
        item.setName(p.getName());
        item.setPrice(p.getPrice() + item.getPrice());
        item.setQuantity(item.getQuantity() + 1);
        item.setStatus(p.getStatus());
        item.setVersion(p.getVersion());
        item.setBrand(p.getBrand());
        item.setType(p.getType());
        item.setCid(cid);
        item.setColorName(colorName);
        item.setImg(img);
        item.setUid(uid);

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String cartOld = cart.toString();
        cart.add(item);
        cart.setData(uid);
        LogService.log(LEVEL_ALERT, "Thêm sản phẩm vào giỏ hàng", user.getId()+"",cartOld , cart.toString());

        response.setContentType("application/json");
        response.getWriter().write("{\"status\": \"success\", \"message\": \"Đã thêm vào giỏ hàng\"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}