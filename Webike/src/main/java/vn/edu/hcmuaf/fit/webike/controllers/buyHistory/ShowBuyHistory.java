package vn.edu.hcmuaf.fit.webike.controllers.buyHistory;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.BuyHistoryDAO;
import vn.edu.hcmuaf.fit.webike.dao.CommentDAO;
import vn.edu.hcmuaf.fit.webike.models.OrderItem;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ShowBuyHistory", value = "/buy-history")
public class ShowBuyHistory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyHistoryDAO dao = new BuyHistoryDAO();
        User user = (User) request.getSession().getAttribute("auth");
        int accountID = user.getId();
        List<OrderItem> ls = dao.getOrderItems(accountID);

        request.setAttribute("ls", ls);

        request.getRequestDispatcher("GKY/buyHistory.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommentDAO dao = new CommentDAO();
        String content = request.getParameter("comment");
        User user = (User) request.getSession().getAttribute("auth");
        int accountID = user.getId();
        int productID = Integer.parseInt(request.getParameter("productID"));
        LocalDate today = LocalDate.now();
        String created = String.valueOf(today);
        String color = request.getParameter("color");

        if (!content.equals("")) {
            int insert = dao.insertComment(content, created, color,productID, accountID);
        }

        BuyHistoryDAO bdao = new BuyHistoryDAO();
        List<OrderItem> ls = bdao.getOrderItems(accountID);
        request.setAttribute("ls", ls);

        request.getRequestDispatcher("GKY/buyHistory.jsp").forward(request, response);
    }
}