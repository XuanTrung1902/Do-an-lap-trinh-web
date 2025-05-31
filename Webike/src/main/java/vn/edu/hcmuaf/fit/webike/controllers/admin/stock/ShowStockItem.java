package vn.edu.hcmuaf.fit.webike.controllers.admin.stock;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.ProductDAO;
import vn.edu.hcmuaf.fit.webike.dao.StockDAO;
import vn.edu.hcmuaf.fit.webike.models.Color;
import vn.edu.hcmuaf.fit.webike.models.Product;
import vn.edu.hcmuaf.fit.webike.models.StockItem;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowStockItem", value = "/stock-item-list")
public class ShowStockItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int batchID = Integer.parseInt(request.getParameter("batchID"));
        StockDAO dao = new StockDAO();
        ProductDAO productDAO = new ProductDAO();
        List<StockItem> ls = dao.getStockItemByBatchID(batchID);

        // Lấy stockID từ batchID
        int stockID = dao.getStockIDByBatchID(batchID);
        if (stockID == -1) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy stockID cho batchID: " + batchID);
            return;
        }
        request.setAttribute("stockID", stockID);

        for (StockItem item : ls) {
            Product product = item.getProduct();
            Color color = item.getColor();

            String imagePath = productDAO.getImgByColor(product.getId(), color.getId());
            item.setImagePath(imagePath);
        }
        request.setAttribute("ls", ls);
        request.getRequestDispatcher("Admin/stockItem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}