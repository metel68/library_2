package controllers;

import java.util.List;

import DAL.UserDAL;
import models.User;

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

	public User insert(User user, boolean isAdmin) {
		user.hashPassword();
		user.setAdmin(isAdmin);
		dal.insert(user);
		return user;
	}
	
	public User authorize(User jsonUser) {
		User referenceUser = this.getUser(jsonUser.getUsername());
        jsonUser.hashPassword();
        
        if (jsonUser.equals(referenceUser)) {
        	return referenceUser;
        }
        return null;
	}
}
