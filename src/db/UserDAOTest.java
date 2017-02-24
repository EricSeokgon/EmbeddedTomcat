package db;

import org.junit.Before;
import org.junit.Test;
import user.UserTest;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

/**
 * Project: EmbeddedTomcat
 * FileName: UserDAOTest
 * Date: 2017-02-24
 * Time: 오후 1:34
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOTest {

    private UserDAO userDao;

    @Before
    public void setup() {
        userDao = new UserDAO();
    }


    @Test
    public void connection() throws SQLException, ClassNotFoundException {
        Connection con = userDao.getConnection();
        assertNotNull(con);
    }

    @Test
    public void insert() throws Exception {
        userDao.insert(UserTest.test_user);
    }


}
