
package vn.edu.hcmuaf.fit.webike.filters; import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.hcmuaf.fit.webike.dao.UserDao;
import vn.edu.hcmuaf.fit.webike.models.User;

import java.io.IOException;

@WebFilter(filterName = "/*")
public class ForceLogoutFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        System.out.println("✅ Filter chạy");
        System.out.println("Session user: " + session.getAttribute("auth"));
        if (session != null && session.getAttribute("auth") != null) {
            User user = (User) session.getAttribute("auth");
           UserDao dao = new UserDao();
            boolean needLogout = dao.checkForceLogout(user.getId());
            System.out.println("Cần logout: " + needLogout);
            if (needLogout) {
                session.invalidate();
                response.sendRedirect("login.jsp?forced=true");
                return;
            }
        }

        chain.doFilter(req, res);
    }
}