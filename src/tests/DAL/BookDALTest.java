package tests.DAL;

import DAL.BaseDAL;
import DAL.BookDAL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Author;
import models.Book;
import models.BookAuthor;
import models.Publisher;
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
        System.out.println("insert");
        Date date = new Date(2017, 9, 19);
        Author author1 = new Author(1, "Hell Bolovich");
	Author author2 = new Author(2, "Vik Ovologov");
        List<Author> authorSet = new ArrayList<>();
	authorSet.add(author1);
	authorSet.add(author2);
	Publisher ognivo = new Publisher(1, "Ognivo");
        Book book1 = new Book(1, "234567", "Pekavit", authorSet, ognivo, 2018, 2, 784, "Book with history", date);
        BookDAL instance = new BookDAL();
        int result = instance.insert(book1);
        Book expResult = instance.selectById(book1.getId());
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertEmpty() {
        System.out.println("insertEmpty");
        Book book = new Book();
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.insert(book);
        assertEquals(expResult, result);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 1;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void insertAuthor() {
        System.out.println("insertAuthor");
        BookAuthor bookAuthor = null;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.insertAuthor(bookAuthor);
        assertEquals(expResult, result);
    }
    
    @Test
    public void deleteAuthor() {
        System.out.println("deleteAuthor");
        BookAuthor bookAuthor = null;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.deleteAuthor(bookAuthor);
        assertEquals(expResult, result);
    }
    
    @Test
    public void deleteAuthorsFromBook() {
        System.out.println("deleteAuthorsFromBook");
        int id = 1;
        BookDAL instance = new BookDAL();
        int expResult = 0;
        int result = instance.deleteAuthorsFromBook(id);
        assertEquals(expResult, result);
    }
}
