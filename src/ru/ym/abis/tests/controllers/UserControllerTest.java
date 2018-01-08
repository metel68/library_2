package ru.ym.abis.tests.controllers;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.ym.abis.controllers.UserController;
import ru.ym.abis.models.User;

import static org.junit.Assert.*;

/**
 *
 * @author PFIQ3000
 */
public class UserControllerTest {
    
    public UserControllerTest() {
    }
    
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
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int id = 0;
        UserController instance = new UserController();
        User expResult = null;
        User result = instance.getUser(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
