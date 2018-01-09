package tests.DAL;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAL.BaseDAL;
import DAL.UserDAL;
import models.User;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.*;

public class UserDALTest {
    
    public UserDALTest() {
    }
    
    @Rule
    public TestRule timeout = new Timeout(1000);
    
    @Before
    public void setUp() {
    	BaseDAL.initSqlSessionFactory();
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
        User user1 = new User(1, "Bro122", "password123", false);
        UserDAL instance = new UserDAL();
        int result = instance.insert(user1);
        User expResult = instance.selectById(user1.getId());
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertEmpty() {
        System.out.println("insertEmpty");
        User user1 = new User();
        UserDAL instance = new UserDAL();
        int expResult = 0;
        int result = instance.insert(user1);
        assertEquals(expResult, result);
    }
    
}
