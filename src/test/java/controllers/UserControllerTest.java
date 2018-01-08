/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.controllers;

import controllers.UserController;
import java.util.List;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
