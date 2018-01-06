package ru.ym.abis.services;

import java.util.List;

import ru.ym.abis.controllers.UserController;
import ru.ym.abis.models.User;

public class UserService {
	UserController controller;
	
	public UserService() {
		this.controller = new UserController();
	}
	
	public List<User> getUserAll() {
		return controller.getUserAll();
	}
	
	public User getUser(int id) {
		return controller.getUser(id);
	}
}
