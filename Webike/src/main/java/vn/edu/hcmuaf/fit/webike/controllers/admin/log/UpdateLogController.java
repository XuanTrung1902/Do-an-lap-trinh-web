package vn.edu.hcmuaf.fit.webike.controllers.admin.log;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.LogDAO;
import vn.edu.hcmuaf.fit.webike.models.Log;
import vn.edu.hcmuaf.fit.webike.services.LogService;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "UpdateLogController", value = "/updateLog")
public class UpdateLogController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing id");
            return;
        }
        try {
            int id = Integer.parseInt(idParam);
            LogDAO dao = new LogDAO();
            Log log = dao.getLogById(id);
            if (log != null) {
                response.setContentType("application/json");
                // chuyển log sang JSON (dùng thư viện Gson, Jackson hoặc tự viết)
                String json = convertLogToJson(log);
                response.getWriter().write(json);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Log not found");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id");
        }
    }

    // ví dụ convertLogToJson() bạn có thể dùng Gson:
    private String convertLogToJson(Log log) {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        return gson.toJson(log);
    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        int id = Integer.parseInt(request.getParameter("logId"));
        String level = request.getParameter("level");
        String logTimeStr = request.getParameter("logTime").replace("T", " ") + ":00";
        Timestamp logTime = Timestamp.valueOf(logTimeStr);
        String location = request.getParameter("location");
        String userInfo = request.getParameter("userInfo");
        String before = request.getParameter("before");
        String after = request.getParameter("after");

        LogDAO dao = new LogDAO();
        Log newLog = new Log(id, level, logTime, location, userInfo, before, after);

        boolean updated = dao.updateLog(newLog);

        if (updated) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Success");
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Cập nhật thất bại");
        }
    } catch (Exception e) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Dữ liệu không hợp lệ");
    }
}

}