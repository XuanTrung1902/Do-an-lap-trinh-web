package vn.edu.hcmuaf.fit.webike.controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.LogDAO;
import vn.edu.hcmuaf.fit.webike.models.Log;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LogListServlet", value = "/logList")
public class LogListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Log> logs = new LogDAO().getAllLogs();
        req.setAttribute("logs", logs);
        req.getRequestDispatcher("/Admin/log_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}