package ru.ym.abis.controllers;

import java.util.List;

import ru.ym.abis.DAL.UserDAL;
import ru.ym.abis.models.User;

public class UserController {
	private UserDAL dal;
	
	public UserController() {
		this.dal = new UserDAL();
		dal.initSqlSessionFactory();
	}
	
	public List<User> getUserAll() {
		return dal.selectAll();
	}
	
	public User getUser(int id) {
		return dal.selectById(id);
	}
	
	public User getUser(String username) {
		return dal.selectByLogin(username);
	}

	public int insert(User user) {
		return dal.insert(user);
	}
}
