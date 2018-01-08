package controllers;

import java.util.List;

import DAL.AuthorDAL;
import models.Author;

public class AuthorController {
	private AuthorDAL dal;
	
	public AuthorController() {
		this.dal = new AuthorDAL();
		dal.initSqlSessionFactory();
	}
	
	public List<Author> selectAll() {
		return dal.selectAll();
	}
	
	public Author selectById(int id) {
		return dal.selectById(id);
	}
	
	public Author insert(Author author) {
		dal.insert(author);
		return author;
	}
	
	public int update(Author author) {
		return dal.update(author);
	}
	
	public int delete(int id) {
		return dal.delete(id);
	}
}
