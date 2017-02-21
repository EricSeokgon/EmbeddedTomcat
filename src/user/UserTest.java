package user;

import org.junit.jupiter.api.Test;

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
    public static User user = new User("userId", "password", "name", "skee@e-ncom.co.kr");

    @Test
    public void matchPassword() {
        boolean result = user.matchPassword("password");
        assertTrue(result);
    }

    @Test
    public void notmatchPassword() {
        boolean result = user.matchPassword("password2");
        assertTrue(result);
    }

}