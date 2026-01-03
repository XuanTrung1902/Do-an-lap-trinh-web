package vn.edu.hcmuaf.fit.webike.controllers.admin.stock;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.StockDAO;
import vn.edu.hcmuaf.fit.webike.models.StockItem;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowStockItemList", value = "/list-stock-items")
public class ShowStockItemList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StockDAO dao = new StockDAO();
        List<StockItem> stockItems = dao.getStockItem();

        if (stockItems == null || stockItems.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy danh sách hàng tồn kho.");
            return;
        }

        request.setAttribute("stockItems", stockItems);
        request.getRequestDispatcher("Admin/stockItem_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}