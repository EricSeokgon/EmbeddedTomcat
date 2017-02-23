package user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Project: EmbeddedTomcat
 * FileName: LogoutServlet
 * Date: 2017-02-23
 * Time: 오전 10:54
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/users/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("userId");
        response.sendRedirect("/");
    }
}
