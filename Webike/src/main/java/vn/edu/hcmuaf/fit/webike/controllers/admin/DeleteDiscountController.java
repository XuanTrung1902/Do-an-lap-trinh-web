package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.DiscountDao;

import java.io.IOException;

@WebServlet(name = "DeleteDiscountController", value = "/deleteDiscount")
public class DeleteDiscountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DiscountDao discountDao = new DiscountDao();
        boolean isDeleted = discountDao.deleteDiscount(id);

        if (isDeleted) {
            response.sendRedirect(request.getContextPath() + "/discountList");
        } else {
            request.setAttribute("error", "Xóa giảm giá thất bại.");
            request.getRequestDispatcher("/Admin/discount.jsp").forward(request, response);
        }
    }

}