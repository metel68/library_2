package tests.models;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.*;

import models.Author;


public class AuthorTest {
    
    @Rule
    public TestRule timeout = new Timeout(100);
    
    public AuthorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
	public void testCreateAuthor() {
		Author author = new Author();
		assertNotNull(author);
	}
	
    @Test
	public void testEqualsAuthor() {
		Author author1 = new Author(1, "Hell Bolovich");
		Author author11 = new Author(1, "Vik Ovologov");
		Author author2 = new Author(2, "Max Metel");
		assertEquals(author1, author1);
		assertEquals(author1, author11);
		assertEquals(author2, author2);
	}
}
