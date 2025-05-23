package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.DiscountDao;
import vn.edu.hcmuaf.fit.webike.models.Discount;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.sql.Date;

import java.io.IOException;

@WebServlet(name = "AddDiscountController", value = "/addDiscount")
public class AddDiscountController extends HttpServlet {
    final String LEVEL_ALERT = LogService.LEVEL_ALERT;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Admin/discount_add.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("auth");
        int productID = Integer.parseInt(request.getParameter("productID"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        Date start = Date.valueOf(request.getParameter("start"));
        Date end = Date.valueOf(request.getParameter("end"));
        if (start.after(end)) {
            request.setAttribute("error", "Ngày bắt đầu phải nhỏ hơn ngày kết thúc.");
            request.getRequestDispatcher("/addDiscount").forward(request, response);
            return;
        }
        Discount discount = new Discount();
        discount.setProductID(productID);
        discount.setAmount(amount);
        discount.setStart(start);
        discount.setEnd(end);

        DiscountDao discountDao = new DiscountDao();
        boolean isAdded = discountDao.addDiscount(discount);

        if (isAdded) {
            LogService.log(LEVEL_ALERT, "Thêm Giảm giá", u.getId()+"","" ,discount.toString());
            response.sendRedirect(request.getContextPath() + "/discountList");
        } else {
            request.setAttribute("error", "Thêm giảm giá thất bại.");
            request.getRequestDispatcher("/addDiscount").forward(request, response);
        }
    }

}