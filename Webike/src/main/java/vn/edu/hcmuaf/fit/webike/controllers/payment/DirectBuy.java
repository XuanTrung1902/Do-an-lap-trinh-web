package vn.edu.hcmuaf.fit.webike.controllers.payment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;
import vn.edu.hcmuaf.fit.webike.dao.PaymentDAO;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.models.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "DirectBuy", value = "/direct-buy")
public class DirectBuy extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDAO dao = new PaymentDAO();
        ProductDAO pdao = new ProductDAO();

        String method = request.getParameter("method");
        int id = Integer.parseInt(request.getParameter("id"));
        int cid = Integer.parseInt(request.getParameter("color"));
        String img = request.getParameter("img");

        Order order = new Order();
        Product p = pdao.getProduct(id);
        Color color = pdao.getColorByID(cid);
        List<Shop> shops = dao.getShops();

        double percent = 0.25;
        double total = p.getPrice();

        HashMap<Color, String> map = new HashMap();
        map.put(color, img);
        p.setImg(map);

        order.add(null, p, method);

        request.getSession().setAttribute("order", order);
        request.setAttribute("method", method);
        request.setAttribute("percent", percent);
        request.setAttribute("total", total);
        request.setAttribute("shops", shops);
        request.getRequestDispatcher("GKY/payment.jsp").forward(request, response);
    }
}