package db;

import org.junit.jupiter.api.Test;
import user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Project: EmbeddedTomcat
 * FileName: DatabaseTest
 * Date: 2017-02-21
 * Time: 오후 5:10
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseTest {
    @Test
    public void addAndFind() {
        User user = new User("userId", "password", "name", "sklee@e-ncom.co.kr");
        Database.addUser(user);

        User dbuser = Database.findByUserId(user.getUserId());
        assertEquals(user, dbuser);
    }

    public void addANdFindWhenNotExisted() {
        User dbuser = Database.findByUserId("userId2");
        assertNull(dbuser);
    }

}