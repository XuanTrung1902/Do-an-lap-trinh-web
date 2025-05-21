package vn.edu.hcmuaf.fit.webike.controllers.admin.stock;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.StockDAO;
import vn.edu.hcmuaf.fit.webike.models.StockBatch;
import vn.edu.hcmuaf.fit.webike.models.StockIn;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowStockIn", value = "/stock")
public class ShowStockIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StockDAO dao = new StockDAO();
        List<StockIn> stock = dao.getStockIn();
        System.out.println(stock);

        request.setAttribute("stock", stock);
        request.getRequestDispatcher("Admin/stock.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}