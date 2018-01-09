package tests.controllers;

import controllers.AuthorController;
import java.util.List;
import models.Author;

import org.apache.ibatis.exceptions.PersistenceException;
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
    public TestRule timeout = new Timeout(2000);
    
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
    }

    @Test
    public void testSelectById() {
        System.out.println("selectById");
        int id = 0;
        AuthorController instance = new AuthorController();
        Author expResult = null;
        Author result = instance.selectById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testSelectByName() {
        System.out.println("selectByName");
        String name = "";
        AuthorController instance = new AuthorController();
        Author expResult = null;
        Author result = instance.selectByName(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Author author1 = new Author(1, "Hell Bolovich");
        AuthorController instance = new AuthorController();
        Author result = instance.insert(author1);
        Author expResult = instance.selectById(author1.getId());
        assertEquals(expResult, result);
    }

    @Test(expected=PersistenceException.class)
    public void testInsertEmpty() {
        System.out.println("insertEmpty");
        Author author = new Author();
        AuthorController instance = new AuthorController();
        Author expResult = null;
        Author result = instance.insert(author);
        assertEquals(expResult, result);
    }
    
    

    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        AuthorController instance = new AuthorController();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
    
}
