package vn.edu.hcmuaf.fit.webike.controllers.admin.stock;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.StockDAO;
import vn.edu.hcmuaf.fit.webike.models.StockBatch;
import vn.edu.hcmuaf.fit.webike.models.StockIn;
import vn.edu.hcmuaf.fit.webike.models.Supplier;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowStockIn", value = "/stock-in-list")
public class ShowStockIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StockDAO dao = new StockDAO();
        List<StockIn> stock = dao.getStockIn();
        List<Supplier> suppliers = dao.getAllSuppliers();

        request.setAttribute("suppliers", suppliers);
        request.setAttribute("stock", stock);
        request.getRequestDispatcher("Admin/stockIn.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}