/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.DAL;

import DAL.UserDAL;
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
        System.out.println("selectAll");
        UserDAL instance = new UserDAL();
        List<User> expResult = null;
        List<User> result = instance.selectAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectById() {
        System.out.println("selectById");
        int id = 0;
        UserDAL instance = new UserDAL();
        User expResult = null;
        User result = instance.selectById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
