package vn.edu.hcmuaf.fit.webike.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.DiscountDao;
import vn.edu.hcmuaf.fit.webike.models.Discount;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DiscountListController", value = "/discountList")
public class DiscountListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiscountDao discountDao = new DiscountDao();
        List<Discount> discountList = discountDao.getAllDiscounts();
        for (Discount discount : discountList) {
            System.out.println(discount.toString());
        }
        if (!discountList.isEmpty()) {
            request.setAttribute("discountList", discountList);
            request.getRequestDispatcher("Admin/discount.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}