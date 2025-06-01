package vn.edu.hcmuaf.fit.webike.controllers.admin.log; import jakarta.servlet.*; 
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.LogDAO;

import java.io.IOException;
@WebServlet(name = "DeleteLog", value = "/delete-log")
public class DeleteLog extends HttpServlet { 

@Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Xử lý xóa log tại đây
    LogDAO logDAO = new LogDAO();
    String logId = request.getParameter("id");

    if (logId != null && !logId.isEmpty()) {
        try {
            int id = Integer.parseInt(logId);
            logDAO.deleteLog(id); // Gọi phương thức xóa trong LogDAO
        } catch (NumberFormatException e) {
            // Xử lý lỗi định dạng ID không hợp lệ
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID log không hợp lệ");
            return;
        }
    }

    // Chuyển hướng về trang danh sách log
    response.sendRedirect(request.getContextPath() + "/logList");


}

@Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { } 
}