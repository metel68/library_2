package test.java.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import models.Author;
import models.Book;
import models.Publisher;
import static models.Rights.READER;
import models.User;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.*;

public class BookTest {
    
    @Rule
    public TestRule timeout = new Timeout(100);
    
    public BookTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
	public void testCreateBook() {
		Book book = new Book();
		assertNotNull(book);
	}
	
    @Test
	public void testEqualsBook() {
                Date date = new Date(2017, 9, 19);
                Date date2 = new Date(1987, 9, 19);
                Author author1 = new Author(1, "Hell Bolovich");
		Author author2 = new Author(1, "Vik Ovologov");
                
                assertEquals(author1.getId(), 1);
                assertEquals(author1.getFull_name(), "Hell Bolovich");
                assertEquals(author2.getId(), 1);
                assertEquals(author2.getFull_name(), "Vik Ovologov");
                
                List<Author> authorSet = new ArrayList<>();
                authorSet.add(author1);
                authorSet.add(author2);
                
		Book book1 = new Book(1, 234567, "Pekavit", authorSet, "Ognivo", 2018, 2, "Book with history", date);
		Book book11 = new Book(1, 345678, "Dobroe Utro", authorSet, "Ognivo", 2000, 24, "Good story about animals", date);
		Book book2 = new Book(2, 456789, "Woodpoint", authorSet, "KS", 1987, 1, "Longest tome for parents", date2);
		
                assertEquals(book1, book1);
		assertEquals(book1, book11);
		assertEquals(book2, book2);
	}
    
}
