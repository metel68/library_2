package ru.ym.abis.controllers;

import java.util.List;

import ru.ym.abis.DAL.BookDAL;
import ru.ym.abis.models.Book;

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
		return dal.insert(book);
	}
	
	public int update(Book book) {
		return dal.update(book);
	}
	
	public int delete(int id) {
		return dal.delete(id);
	}
}
