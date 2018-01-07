package ru.ym.abis.controllers;

import java.util.List;

import ru.ym.abis.DAL.BookDAL;
import ru.ym.abis.models.Author;
import ru.ym.abis.models.Book;
import ru.ym.abis.models.BookAuthor;

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
	
	public int insert(Book book) {
		int res = dal.insert(book); // we need to have saved book to make m2m relation
		for (Author author : book.getAuthors()) {
			BookAuthor link = new BookAuthor(book, author);
			dal.insertAuthor(link);
		}
		return res;
	}
	
	public int update(Book book) {
		return dal.update(book);
	}
	
	public int delete(int id) {
		dal.deleteAuthorsFromBook(id);
		return dal.delete(id);
	}
}
