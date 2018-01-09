package tests.DAL;

import DAL.BookDAL;
import java.util.List;
import models.Book;
import models.BookAuthor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.*;

public class BookDALTest {
    
    public BookDALTest() {
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
        System.out.println("BookDAL selectAll");
        BookDAL instance = new BookDAL();
        List<Book> result = instance.selectAll();
        assertTrue(result!=null && result.size()>0);
    }


    @Test
    public void testSelectById() {
        System.out.println("BookDAL selectById");
        int id = 1;
        BookDAL instance = new BookDAL();
        Book result = instance.selectById(id);
        assertTrue(result!=null);
    }

    @Test
    public void testSelectByName() {
        System.out.println("BookDAL selectByName");
        String title = "WoodPoint";
        BookDAL instance = new BookDAL();
        Book result = instance.selectByName(title);
        assertTrue(result!=null);
    }
    
    @Test
    public void testInsert() {
        System.out.println("insert");
        Book book = null;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.insert(book);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }


    @Test
    public void testUpdate() {
        System.out.println("update");
        Book book = null;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.update(book);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }


    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 1;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void insertAuthor() {
        System.out.println("insertAuthor");
        BookAuthor bookAuthor = null;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.insertAuthor(bookAuthor);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void deleteAuthor() {
        System.out.println("deleteAuthor");
        BookAuthor bookAuthor = null;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.deleteAuthor(bookAuthor);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void deleteAuthorsFromBook() {
        System.out.println("deleteAuthorsFromBook");
        int id = 1;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.deleteAuthorsFromBook(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
