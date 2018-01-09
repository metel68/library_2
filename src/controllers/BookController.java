package controllers;

import java.util.List;

import DAL.BookDAL;
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
	
	public Book selectByName(String name) {
		return dal.selectByName(name);
	}
	
	public Book insert(Book book) {
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
		return dal.update(book);
	}
	
	public int delete(int id) {
		dal.deleteAuthorsFromBook(id);
		dal.deleteCategorysFromBook(id);
		return dal.delete(id);
	}
}
