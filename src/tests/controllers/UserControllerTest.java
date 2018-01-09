package tests.controllers;

import controllers.UserController;
import java.util.List;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.*;

public class UserControllerTest {
    
    public UserControllerTest() {
    }
    
    @Rule
    public TestRule timeout = new Timeout(1000);
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetUserAll() {
        System.out.println("getUserAll");
        UserController instance = new UserController();
        List<User> expResult = null;
        List<User> result = instance.getUserAll();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUser_int() {
        System.out.println("getUser");
        int id = 0;
        UserController instance = new UserController();
        User expResult = null;
        User result = instance.getUser(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUser_String() {
        System.out.println("getUser");
        String username = "";
        UserController instance = new UserController();
        User expResult = null;
        User result = instance.getUser(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        User user = null;
        boolean isAdmin = false;
        UserController instance = new UserController();
        User expResult = null;
        User result = instance.insert(user, isAdmin);
        assertEquals(expResult, result);
    }

    @Test
    public void testAuthorize() {
        System.out.println("authorize");
        User jsonUser = null;
        UserController instance = new UserController();
        User expResult = null;
        User result = instance.authorize(jsonUser);
        assertEquals(expResult, result);
    }
    
}
