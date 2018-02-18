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

	public User insert(User user, String role) {
		user.hashPassword();
		user.setRole(role);
		dal.insert(user);
		return user;
	}
	
	public int update(User user) {
		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			User oldUser = this.getUser(user.getId());
			user.setPassword(oldUser.getPassword());
		} else {
			user.hashPassword();
		}
		return dal.update(user);
	}
	
	public int delete(int id) {
		return dal.delete(id);
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
