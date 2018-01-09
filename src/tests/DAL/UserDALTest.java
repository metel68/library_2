package tests.DAL;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAL.UserDAL;
import models.User;

import static org.junit.Assert.*;

public class UserDALTest {
    
    public UserDALTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSelectAll() {
        System.out.println("UserDAL selectAll");
        UserDAL instance = new UserDAL();
        List<User> result = instance.selectAll();
        assertTrue(result!=null && result.size()>0);
    }


    @Test
    public void testSelectById() {
        System.out.println("UserDAL selectById");
        int id = 1;
        UserDAL instance = new UserDAL();
        User result = instance.selectById(id);
        assertTrue(result!=null);
    }
    
    @Test
    public void testSelectByLogin() {
        System.out.println("UserDAL selectByLogin");
        String username = "katavova";
        UserDAL instance = new UserDAL();
        User result = instance.selectByLogin(username);
        assertTrue(result!=null);
    }
    
    @Test
    public void testInsert() {
        System.out.println("insert");
        User user = null;
        UserDAL instance = new UserDAL();
        int expResult = 0;
        int result = instance.insert(user);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
