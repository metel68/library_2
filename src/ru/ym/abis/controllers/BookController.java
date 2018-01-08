package controllers;

import java.util.List;

import DAL.BookDAL;
import models.Author;
import models.Book;
import models.BookAuthor;

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
	
	public Book insert(Book book) {
		dal.insert(book);
		for (Author author : book.getAuthors()) {
			BookAuthor link = new BookAuthor(book, author);
			dal.insertAuthor(link);
		}
		return dal.selectById(book.getId());
	}
	
	public int update(Book book) {
		return dal.update(book);
	}
	
	public int delete(int id) {
		dal.deleteAuthorsFromBook(id);
		return dal.delete(id);
	}
}
