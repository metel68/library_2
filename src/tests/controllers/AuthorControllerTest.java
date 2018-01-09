package tests.controllers;

import controllers.AuthorController;
import java.util.List;
import models.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.*;

public class AuthorControllerTest {
    
    public AuthorControllerTest() {
    }
    
    @Rule
    public TestRule timeout = new Timeout(100);
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        AuthorController instance = new AuthorController();
        List<Author> expResult = null;
        List<Author> result = instance.selectAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectById() {
        System.out.println("selectById");
        int id = 0;
        AuthorController instance = new AuthorController();
        Author expResult = null;
        Author result = instance.selectById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectByName() {
        System.out.println("selectByName");
        String name = "";
        AuthorController instance = new AuthorController();
        Author expResult = null;
        Author result = instance.selectByName(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Author author = null;
        AuthorController instance = new AuthorController();
        Author expResult = null;
        Author result = instance.insert(author);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        Author author = null;
        AuthorController instance = new AuthorController();
        int expResult = 0;
        int result = instance.update(author);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        AuthorController instance = new AuthorController();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
