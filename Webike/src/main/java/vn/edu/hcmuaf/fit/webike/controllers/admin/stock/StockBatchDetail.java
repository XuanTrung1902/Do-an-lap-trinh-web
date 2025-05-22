package vn.edu.hcmuaf.fit.webike.controllers.admin.stock;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.StockDAO;
import vn.edu.hcmuaf.fit.webike.models.StockBatch;
import vn.edu.hcmuaf.fit.webike.models.StockIn;

import java.io.IOException;

@WebServlet(name = "StockBatchDetail", value = "/stock-batch-list")
public class StockBatchDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stockID = Integer.parseInt(request.getParameter("stockID"));
        System.out.println(stockID);
        StockDAO dao = new StockDAO();
        StockIn s = dao.getStockInByID(stockID);
        request.setAttribute("s", s);
        request.getRequestDispatcher("Admin/stockBatchDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}