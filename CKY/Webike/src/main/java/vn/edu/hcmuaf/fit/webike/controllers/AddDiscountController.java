package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.DiscountDao;
import vn.edu.hcmuaf.fit.webike.models.Discount;

import java.sql.Date;

import java.io.IOException;

@WebServlet(name = "AddDiscountController", value = "/addDiscount")
public class AddDiscountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        Date start = Date.valueOf(request.getParameter("start"));
        Date end = Date.valueOf(request.getParameter("end"));
        if (start.after(end)) {
            request.setAttribute("error", "Ngày bắt đầu phải nhỏ hơn ngày kết thúc.");
            request.getRequestDispatcher("/Admin/add_discount.jsp").forward(request, response);
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
            response.sendRedirect(request.getContextPath() + "/discountList");
        } else {
            request.setAttribute("error", "Thêm giảm giá thất bại.");
            request.getRequestDispatcher("/Admin/discount.jsp").forward(request, response);
        }
    }

}