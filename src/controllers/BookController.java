package controllers;

import java.util.List;

import DAL.BookDAL;
import exceptions.ValidationException;
import models.Author;
import models.Book;
import models.BookAuthor;
import models.BookCategory;

public class BookController {
	private BookDAL dal;
	
	public BookController() {
		this.dal = new BookDAL();
		dal.initSqlSessionFactory();
	}
	
	public List<Book> selectAll() {
		return dal.selectAll();
	}
	
	public Book selectById(int id) {
		return dal.selectById(id);
	}
	
	public List<Book> findByName(String name) {
		String likePattern = String.format("%%%s%%", name);
		return dal.findByName(likePattern);
	}
	
	private void validate(Book book) {
		if (book.getYear() <= 0 || book.getYear() > 2100)  {
			throw new ValidationException("Year should be between 0 and 2100!");
		}
		if (book.getSize() <= 0) {
			throw new ValidationException("Book should have one or more pages!");
		}
		if (book.getCount() < 0) {
			throw new ValidationException("Book count should be positive!");
		}
	}
	
	public Book insert(Book book) {
		this.validate(book);
		
		dal.insert(book);
		book.getAuthors().forEach((author) -> {
			BookAuthor link = new BookAuthor(book, author);
			dal.insertAuthor(link);
		});
		book.getCategories().forEach((category) -> {
			BookCategory link = new BookCategory(book, category);
			dal.insertCategory(link);
		});
		return dal.selectById(book.getId());
	}
	
	public int update(Book book) {
		dal.deleteAuthorsFromBook(book.getId());
		book.getAuthors().forEach((author) -> {
			BookAuthor link = new BookAuthor(book, author);
			dal.insertAuthor(link);
		});
		dal.deleteCategorysFromBook(book.getId());
		book.getCategories().forEach((category) -> {
			BookCategory link = new BookCategory(book, category);
			dal.insertCategory(link);
		});
		return dal.update(book);
	}
	
	public int delete(int id) {
		dal.deleteAuthorsFromBook(id);
		dal.deleteCategorysFromBook(id);
		return dal.delete(id);
	}
}
