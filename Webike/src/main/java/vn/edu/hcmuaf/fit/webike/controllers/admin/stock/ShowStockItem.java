package vn.edu.hcmuaf.fit.webike.controllers.admin.stock;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.StockDAO;
import vn.edu.hcmuaf.fit.webike.models.StockItem;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowStockItem", value = "/stock-item-list")
public class ShowStockItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int batchID = Integer.parseInt(request.getParameter("batchID"));
        StockDAO dao = new StockDAO();
        List<StockItem> ls = dao.getStockItemByBatchID(batchID);
        request.setAttribute("ls", ls);
        request.getRequestDispatcher("Admin/stockItem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}