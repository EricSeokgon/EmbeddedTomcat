package user;

import db.Database;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Project: EmbeddedTomcat
 * FileName: UserTest
 * Date: 2017-02-21
 * Time: 오후 5:28
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {
    public static User test_user = new User("userId", "password", "name", "skee@e-ncom.co.kr");

    @Test
    public void matchPassword() {
        assertTrue(test_user.matchPassword("password"));
    }

    @Test
    public void notmatchPassword() {
        assertTrue(test_user.matchPassword("password2"));
    }

    @Test
    public void login() throws Exception {
        User user = UserTest.test_user;
        Database.addUser(user);
        assertTrue(User.login(test_user.getUserId(), test_user.getPassword()));
    }

    @Test(expected = UserNotFoundException.class)
    public void loginWhenNotExitedUser() throws Exception {
        User.login("userId2", test_user.getPassword());
    }

    @Test(expected = PasswordMismatchException.class)
    public void loginWhenNotPasswordMismatch() throws Exception {
        User user = UserTest.test_user;
        User.login(test_user.getUserId(), "password");
    }

}