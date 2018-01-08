package ru.ym.abis.controllers;

import java.util.List;

import ru.ym.abis.DAL.AuthorDAL;
import ru.ym.abis.models.Author;

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
	
	public int insert(Author author) {
		return dal.insert(author);
	}
	
	public int update(Author author) {
		return dal.update(author);
	}
	
	public int delete(int id) {
		return dal.delete(id);
	}
}
