package ru.ym.abis.controllers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ru.ym.abis.DAL.PublisherDAL;
import ru.ym.abis.DAL.UserDAL;
import ru.ym.abis.models.Publisher;

public class PublisherController {
	private PublisherDAL dal;
	
	public PublisherController() {
		this.dal = new PublisherDAL();
		dal.initSqlSessionFactory();
	}
	
	public List<Publisher> selectAll() {
		return dal.selectAll();
	}
	
	public Publisher selectById(int id) {
		return dal.selectById(id);
	}
	
	public int insert(Publisher publisher) {
		return dal.insert(publisher);
	}
	
	public int update(Publisher publisher) {
		return dal.update(publisher);
	}
	
	public int delete(int id) {
		return dal.delete(id);
	}
}
