package controllers;

import java.util.List;

import DAL.CategoryDAL;
import models.Category;

public class CategoryController {
	private CategoryDAL dal;
	
	public CategoryController() {
		this.dal = new CategoryDAL();
		dal.initSqlSessionFactory();
	}
	
	public List<Category> selectAll() {
		return dal.selectAll();
	}
	
	public Category selectById(int id) {
		return dal.selectById(id);
	}
	
	public Category insert(Category category) {
		dal.insert(category);
		return category;
	}
	
	public int update(Category category) {
		return dal.update(category);
	}
	
	public int delete(int id) {
		return dal.delete(id);
	}
}
