package user;

import db.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Project: EmbeddedTomcat
 * FileName: SaveUserServlet
 * Date: 2017-02-23
 * Time: 오전 10:34
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/users/save")
public class SaveUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User user = new User(userId, password, name, email);
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/");

    }
}
