package user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Project: EmbeddedTomcat
 * FileName: LoginServlet
 * Date: 2017-02-23
 * Time: 오전 10:46
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        try {
            User.login(userId, password);
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);

            response.sendRedirect("/index.jsp");
        } catch (UserNotFoundException e) {
            request.setAttribute("errorMessage", "존재하지 않는 사용자 입니다. 다시 로그인하세요");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } catch (PasswordMismatchException e) {
            request.setAttribute("errorMessage", "존재하지 않는 패스워드 입니다. 다시 로그인하세요");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}
