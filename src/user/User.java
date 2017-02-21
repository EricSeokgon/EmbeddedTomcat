package user;

import db.Database;

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

    public boolean matchPassword(String newPassword) {
        return this.password.equals(newPassword);
    }

    public static boolean login(String userId, String password) throws UserNotFoundException, PasswordMismatchException {
        User user = Database.findByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (!user.matchPassword(password)) {
            throw new PasswordMismatchException();
        }
        return true;
    }
}
