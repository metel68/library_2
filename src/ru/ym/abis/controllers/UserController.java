package ru.ym.abis.controllers;

import java.util.List;

import ru.ym.abis.DAL.UserDAL;
import ru.ym.abis.models.User;

public class UserController {
	private UserDAL dal;
	
	public UserController() {
		this.dal = new UserDAL();
	}
	
	public List<User> getUserAll() {
		return dal.selectAll();
	}
	
	public User getUser(int id) {
		return dal.selectById(id);
	}

	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return dal.insertUser(user);
	}
}
