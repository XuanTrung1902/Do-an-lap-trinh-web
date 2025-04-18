package vn.edu.hcmuaf.fit.webike.controllers.admin;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.webike.dao.PermissionDao;
import vn.edu.hcmuaf.fit.webike.models.PermissionPair;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GetUserPermissionsServlet", value = "/getUserPermissions")
public class GetUserPermissionsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        PermissionDao permissionDAO = new PermissionDao(); // bạn tự cấu trúc DAO này theo project bạn
        List<PermissionPair> permissions = permissionDAO.getUserPermissions(userId);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(permissions));
        out.flush();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}