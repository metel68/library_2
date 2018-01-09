package tests.models;

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

public class BookAuthorTest {

	@Rule
	public TestRule timeout = new Timeout(200);

	public BookAuthorTest() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testCreateBookAuthor() {
		Book book1 = new Book();
		Author author1 = new Author();
		BookAuthor bookauthor = new BookAuthor(book1, author1);
		assertNotNull(bookauthor);
	}

	@Test
	public void testEqualsBookAuthor() {

		Date date = new Date(2017, 9, 19);
		Date date2 = new Date(1987, 9, 19);
		Publisher ognivo = new Publisher(1, "Ognivo");
		Publisher ks = new Publisher(2, "KS");

		Author author1 = new Author(1, "Hell Bolovich");
		Author author2 = new Author(2, "Vik Ovologov");
		List<Author> authorSet = new ArrayList<>();
		authorSet.add(author1);
		authorSet.add(author2);

		Book book1 = new Book(1, "234567", "Pekavit", authorSet, ognivo, 2018, 2, 784, "Book with history", date);
		Book book2 = new Book(3, "456789", "Woodpoint", authorSet, ks, 1987, 1, 999, "Longest tome for parents", date2);

		BookAuthor bookauthor1 = new BookAuthor(book1, author1);
		BookAuthor bookauthor11 = new BookAuthor(book2, author1);
		BookAuthor bookauthor2 = new BookAuthor(book2, author2);

		assertEquals(bookauthor1, bookauthor1);
		assertNotEquals(bookauthor1, bookauthor11);
		assertEquals(bookauthor2, bookauthor2);

		bookauthor1.setBook(book2);
		assertEquals(bookauthor1.getBook(), book2);
		assertTrue(bookauthor1.getBook() == book2);

		bookauthor1.setAuthor(author2);
		assertEquals(bookauthor1.getAuthor(), author2);
		assertTrue(bookauthor1.getAuthor() == author2);

		bookauthor2.setBook(book1);
		assertEquals(bookauthor2.getBook(), book1);
		assertTrue(bookauthor2.getBook() == book1);

		bookauthor2.setAuthor(author1);
		assertNotEquals(bookauthor2.getAuthor(), author2);
		assertEquals(bookauthor2.getAuthor(), author1);
	}

}
