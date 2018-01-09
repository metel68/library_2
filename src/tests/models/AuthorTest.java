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
                
                author1.setId(3);
		assertEquals(author1.getId(), 3);

		author1.setFull_name("Vik Ov.");
		assertEquals(author1.getFull_name(), "Vik Ov.");
                
                author2.setId(4);
		assertEquals(author2.getId(), 4);

		author2.setFull_name("Gavrila Metel");
		assertEquals(author2.getFull_name(), "Gavrila Metel");
	}
    
    @Test
        public void testTrueAuthor() {
                Author author5 = new Author(5, "Hell Bolovich");
                author5.setFull_name("Gavrila Metel");
		assertTrue(author5.getFull_name() == "Gavrila Metel");
                author5.setId(7);
		assertTrue(author5.getId() == 7);
        }
}
