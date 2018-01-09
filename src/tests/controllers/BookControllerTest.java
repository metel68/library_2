package tests.controllers;

import controllers.BookController;
import java.util.List;
import models.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.*;

public class BookControllerTest {
    
    public BookControllerTest() {
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
        BookController instance = new BookController();
        List<Book> expResult = null;
        List<Book> result = instance.selectAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectById() {
        System.out.println("selectById");
        int id = 0;
        BookController instance = new BookController();
        Book expResult = null;
        Book result = instance.selectById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectByName() {
        System.out.println("selectByName");
        String name = "";
        BookController instance = new BookController();
        Book expResult = null;
        Book result = instance.selectByName(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Book book = null;
        BookController instance = new BookController();
        Book expResult = null;
        Book result = instance.insert(book);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        Book book = null;
        BookController instance = new BookController();
        int expResult = 0;
        int result = instance.update(book);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        BookController instance = new BookController();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
