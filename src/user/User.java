package user;

import db.UserDAO;

import java.sql.SQLException;

/**
 * Project: EmbeddedTomcat
 * FileName: User
 * Date: 2017-02-21
 * Time: 오후 4:51
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String userId;
    private String password;
    private String name;
    private String email;

    public User(String userId, String password, String name, String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public boolean matchPassword(String newPassword) {
        return this.password.equals(newPassword);
    }

    public static boolean login(String userId, String password) throws UserNotFoundException, PasswordMismatchException {
        UserDAO userDAO = new UserDAO();
        User user = null;
        try {
            user = userDAO.findByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (!user.matchPassword(password)) {
            throw new PasswordMismatchException();
        }
        return true;
    }
}
