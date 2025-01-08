package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.DiscountDao;
import vn.edu.hcmuaf.fit.webike.models.Discount;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "UpdateDiscountController", value = "/updateDiscount")
public class UpdateDiscountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DiscountDao discountDao = new DiscountDao();
        Discount discount = discountDao.getDiscountById(id);

        if (discount != null) {
            request.setAttribute("discount", discount);
            request.getRequestDispatcher("/Admin/edit_discount.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/discountList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int productID = Integer.parseInt(request.getParameter("productID"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        Date start = Date.valueOf(request.getParameter("start"));
        Date end = Date.valueOf(request.getParameter("end"));

        if (start.after(end)) {
            request.setAttribute("error", "Ngày bắt đầu phải nhỏ hơn ngày kết thúc.");
            request.getRequestDispatcher("/Admin/edit_discount.jsp").forward(request, response);
            return;
        }

        Discount discount = new Discount(id, amount, start, end, productID);
        DiscountDao discountDao = new DiscountDao();
        boolean isUpdated = discountDao.updateDiscount(discount);

        if (isUpdated) {
            response.sendRedirect(request.getContextPath() + "/discountList");
        } else {
            request.setAttribute("error", "Cập nhật giảm giá thất bại.");
            request.getRequestDispatcher("/Admin/edit_discount.jsp").forward(request, response);
        }
    }

}