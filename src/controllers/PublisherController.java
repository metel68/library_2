package controllers;

import java.util.List;

import DAL.PublisherDAL;
import models.Publisher;

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
	
	public Publisher insert(Publisher publisher) {
		dal.insert(publisher);
		return publisher;
	}
	
	public int update(Publisher publisher) {
		return dal.update(publisher);
	}
	
	public int delete(int id) {
		return dal.delete(id);
	}
}
