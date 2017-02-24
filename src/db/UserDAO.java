package db;

import user.User;
import user.UserTest;

import java.sql.*;

/**
 * Project: EmbeddedTomcat
 * FileName: UserDAO
 * Date: 2017-02-24
 * Time: 오후 1:35
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class UserDAO {
    public Connection getConnection() {
        String url = "jdbc:h2:tcp://localhost/~/hadeslee";
        String user = "sa";
        String pwds = "sa";
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(url, user, pwds);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(User test_user) throws SQLException {
        String sql = "insert into USERS values(?,?,?,?)";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setString(1, test_user.getUserId());
        pstmt.setString(2, test_user.getPassword());
        pstmt.setString(3, test_user.getName());
        pstmt.setString(4, test_user.getEmail());

        pstmt.executeUpdate();
    }

    public User findByUserId(String userId) throws SQLException {
        String sql = "select * from USERS where userId = ?";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getString("userId"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("email"));
    }

    public void addUser(User user) throws SQLException {
        UserDAO userDAO = new UserDAO();
        userDAO.insert(UserTest.test_user);
    }
}

