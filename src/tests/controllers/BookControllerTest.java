package tests.controllers;

import controllers.BookController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Author;
import models.Book;
import models.Publisher;
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
    }

    @Test
    public void testSelectById() {
        System.out.println("selectById");
        int id = 0;
        BookController instance = new BookController();
        Book expResult = null;
        Book result = instance.selectById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testSelectByName() {
        System.out.println("selectByName");
        String name = "";
        BookController instance = new BookController();
        Book expResult = null;
        Book result = instance.selectByName(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Date date = new Date(2017, 9, 19);
        Author author1 = new Author(1, "Hell Bolovich");
	Author author2 = new Author(2, "Vik Ovologov");
        List<Author> authorSet = new ArrayList<>();
	authorSet.add(author1);
	authorSet.add(author2);
	Publisher ognivo = new Publisher(1, "Ognivo");
        Book book1 = new Book(1, "234567", "Pekavit", authorSet, ognivo, 2018, 2, 784, "Book with history", date);
        BookController instance = new BookController();
        Book result = instance.insert(book1);
        Book expResult = instance.selectById(book1.getId());
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertEmpty() {
        System.out.println("insertEmpty");
        Book book = new Book();
        BookController instance = new BookController();
        Book expResult = null;
        Book result = instance.insert(book);
        assertEquals(expResult, result);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        BookController instance = new BookController();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
    
}
