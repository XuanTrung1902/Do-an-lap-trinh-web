package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.DiscountDao;
import vn.edu.hcmuaf.fit.webike.models.Discount;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DiscountListController", value = "/discountList")
public class DiscountListController extends HttpServlet {
    final String level = LogService.LEVEL_INFO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiscountDao discountDao = new DiscountDao();
        List<Discount> discountList = discountDao.getAllDiscounts();

        HttpSession session = request.getSession(false);
        User currentUser = (session != null) ? (User) session.getAttribute("auth") : null;
        String userName = (currentUser != null) ? currentUser.getPhoneNum() : "Unknown";
        if (!discountList.isEmpty()) {
            LogService.log(level, "lấy danh sách giảm giá", userName,discountList.toString() , "");
            request.setAttribute("discountList", discountList);
            request.getRequestDispatcher("Admin/discount.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}