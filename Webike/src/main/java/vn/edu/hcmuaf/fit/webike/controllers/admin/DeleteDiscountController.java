package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.DiscountDao;
import vn.edu.hcmuaf.fit.webike.models.Discount;
import vn.edu.hcmuaf.fit.webike.models.User;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;

@WebServlet(name = "DeleteDiscountController", value = "/deleteDiscount")
public class DeleteDiscountController extends HttpServlet {

    final String LEVEL_WARNING = LogService.LEVEL_WARNING;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("auth");
        int id = Integer.parseInt(request.getParameter("id"));
        DiscountDao discountDao = new DiscountDao();
        Discount discountOld = discountDao.getDiscountById(id);
        boolean isDeleted = discountDao.deleteDiscount(id);
        Discount discountNew = discountDao.getDiscountById(id);

        if (isDeleted) {
            LogService.log(LEVEL_WARNING, "Xóa Discount", user.getId()+"",discountOld.toString() ,discountNew.toString());
            response.sendRedirect(request.getContextPath() + "/discountList");
        } else {
            request.setAttribute("error", "Xóa giảm giá thất bại.");
            request.getRequestDispatcher("/Admin/discount.jsp").forward(request, response);
        }
    }

}