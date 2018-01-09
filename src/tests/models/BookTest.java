package tests.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.*;

import models.Author;
import models.Book;
import models.Publisher;

public class BookTest {

	@Rule
	public TestRule timeout = new Timeout(500);

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
		Author author2 = new Author(2, "Vik Ovologov");

		assertEquals(author1.getId(), 1);
		assertEquals(author1.getFull_name(), "Hell Bolovich");
		assertEquals(author2.getId(), 2);
		assertEquals(author2.getFull_name(), "Vik Ovologov");

		List<Author> authorSet = new ArrayList<>();
		authorSet.add(author1);
		authorSet.add(author2);
		
		Publisher ognivo = new Publisher(1, "Ognivo");
		Publisher ks = new Publisher(2, "KS");

		Book book1 = new Book(1, "234567", "Pekavit", authorSet, ognivo, 2018, 2, 784, "Book with history", date);
		Book book11 = new Book(2, "345678", "Dobroe Utro", authorSet, ognivo, 2000, 24, 321, "Good story about animals", date);
		Book book2 = new Book(3, "456789", "Woodpoint", authorSet, ks, 1987, 1, 999, "Longest tome for parents", date2);

		assertEquals(book1, book1);
		assertNotEquals(book1, book11);
		assertEquals(book2, book2);
                
                book1.setId(4);
		assertEquals(book1.getId(), 4);

		book1.setTitle("Pekavit again!");
		assertEquals(book1.getTitle(), "Pekavit again!");
                
                book1.setIsbn("243567");
		assertEquals(book1.getIsbn(), "243567");
                
                Author author5 = new Author(5, "NickN");
		Author author6 = new Author(6, "Roma Glazov");
                List<Author> authorSet2 = new ArrayList<>();
		authorSet.add(author5);
		authorSet.add(author6);
                
                book1.setAuthors(authorSet2);
		assertEquals(book1.getAuthors(), authorSet2);
                
                Publisher bom = new Publisher(7, "Bom-go-vo-ro");
                
                book1.setPublisher(bom);
		assertEquals(book1.getPublisher(), bom);
                
                
                book1.setYear(1999);
		assertEquals(book1.getYear(), 1999);
                book1.setYear(9999);
		assertEquals(book1.getYear(), 9999);
                book1.setYear(-1999);
		assertEquals(book1.getYear(), -1999);
                book1.setYear(0);
		assertEquals(book1.getYear(), 0);
                
                book1.setCount(5);
		assertEquals(book1.getCount(), 5);
                book1.setCount(0);
		assertEquals(book1.getCount(), 0);
                book1.setCount(-5);
		assertEquals(book1.getCount(), -5);
                
                book1.setSize(12);
		assertEquals(book1.getSize(), 12);
                book1.setSize(0);
		assertEquals(book1.getSize(), 0);
                book1.setSize(-12);
		assertEquals(book1.getSize(), -12);
                
                book1.setDescription("Good Tests");
		assertEquals(book1.getDescription(), "Good Tests");
                
                book1.setAddedAt(date2);
		assertEquals(book1.getAddedAt(), date2);
                Date date3 = new Date(-1987, -9, 0);
                book1.setAddedAt(date3);
		assertEquals(book1.getAddedAt(), date3);
                
                book2.setId(5);
		assertTrue(book2.getId() == 5);

		book2.setTitle("Black Woodpoint");
		assertTrue(book2.getTitle() == "Black Woodpoint");
                
                book2.setIsbn("243567");
		assertTrue(book2.getIsbn() == "243567");
                
                book2.setAuthors(authorSet2);
		assertTrue(book2.getAuthors() == authorSet2);
                
                
                book2.setPublisher(bom);
		assertTrue(book2.getPublisher() == bom);
                
                
                book2.setYear(1999);
		assertTrue(book2.getYear() == 1999);
                book2.setYear(9999);
		assertTrue(book2.getYear() == 9999);
                book2.setYear(-1999);
		assertTrue(book2.getYear() == -1999);
                book2.setYear(0);
		assertTrue(book2.getYear() == 0);
                
                book2.setCount(5);
		assertTrue(book2.getCount() == 5);
                book2.setCount(0);
		assertTrue(book2.getCount() == 0);
                book2.setCount(-5);
		assertTrue(book2.getCount() == -5);
                
                book2.setSize(12);
		assertTrue(book2.getSize() == 12);
                book2.setSize(0);
		assertTrue(book2.getSize() == 0);
                book2.setSize(-12);
		assertTrue(book2.getSize() == -12);
                
                book2.setDescription("Good Tests");
		assertTrue(book2.getDescription() == "Good Tests");
                
                book2.setAddedAt(date2);
		assertTrue(book2.getAddedAt() == date2);
                book2.setAddedAt(date3);
		assertTrue(book2.getAddedAt() == date3);
	}

}
