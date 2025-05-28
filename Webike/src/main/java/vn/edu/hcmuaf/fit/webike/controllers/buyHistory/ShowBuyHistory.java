package vn.edu.hcmuaf.fit.webike.controllers.buyHistory;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.BuyHistoryDAO;
import vn.edu.hcmuaf.fit.webike.dao.CommentDAO;
import vn.edu.hcmuaf.fit.webike.models.OrderItem;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ShowBuyHistory", value = "/buy-history")
public class ShowBuyHistory extends HttpServlet {
    private static final int ITEMS_PER_PAGE = 5;
    final String levelInfo = LogService.LEVEL_INFO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuyHistoryDAO dao = new BuyHistoryDAO();
        User user = (User) request.getSession().getAttribute("auth");
        int accountID = user.getId();

        // Lấy số trang từ request, mặc định là 1 nếu không có
        String pageStr = request.getParameter("page");
        int page = 1;
        try {
            page = Integer.parseInt(pageStr);
            if (page < 1) page = 1;
        } catch (NumberFormatException e) {
            page = 1;
        }

        // Lấy tổng số order items
        int totalItems = dao.getTotalOrderItems(accountID);
        int totalPages = (int) Math.ceil((double) totalItems / ITEMS_PER_PAGE);

        // Đảm bảo số trang không vượt quá tổng số trang
        if (page > totalPages && totalPages > 0) {
            page = totalPages;
        }

        // Lấy danh sách phân trang từ cơ sở dữ liệu
        List<OrderItem> paginatedItems = dao.getPaginatedOrderItems(accountID, page, ITEMS_PER_PAGE);

        LogService.log(levelInfo, "Xem lịch sử mua hàng", user.getId()+"",paginatedItems.toString() , "");
        request.setAttribute("ls", paginatedItems);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalItems", totalItems);

        LogService.log(levelInfo, "Xem lịch sử mua hàng", user.getId()+"", "", "Xem trang " + page);
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
            int orderItemID = Integer.parseInt(request.getParameter("orderItemID"));
            int insert = dao.insertComment(content, created, color, productID, accountID);
            int updateCommented = dao.updateCommented(orderItemID);
            String after = "Gửi bình luận cho sản phẩm ID: " + productID + ", nội dung: \"" + content + "\", màu: " + color;
        }

        // Xử lý phân trang sau khi gửi bình luận
        String pageStr = request.getParameter("page");
        int page = 1;
        try {
            page = Integer.parseInt(pageStr);
            if (page < 1) page = 1;
        } catch (NumberFormatException e) {
            page = 1;
        }

        BuyHistoryDAO bdao = new BuyHistoryDAO();
        int totalItems = bdao.getTotalOrderItems(accountID);
        int totalPages = (int) Math.ceil((double) totalItems / ITEMS_PER_PAGE);

        if (page > totalPages && totalPages > 0) {
            page = totalPages;
        }

        List<OrderItem> paginatedItems = bdao.getPaginatedOrderItems(accountID, page, ITEMS_PER_PAGE);

        request.setAttribute("ls", paginatedItems);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalItems", totalItems);

        request.getRequestDispatcher("GKY/buyHistory.jsp").forward(request, response);
    }
}