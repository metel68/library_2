package controllers;

import DAL.UserDAL;
import models.FavoritesItem;

public class FavoritesController {
	private UserDAL dal;
	
	public FavoritesController() {
		this.dal = new UserDAL();
		dal.initSqlSessionFactory();
	}
	
	public FavoritesItem insert(FavoritesItem fav) {
		dal.insertUserFav(fav);
		return fav;
	}
	
	public FavoritesItem delete(FavoritesItem fav) {
		dal.deleteUserFav(fav);
		return fav;
	}
	
	public int deleteAll(int userId) {
		return dal.deleteUserFavs(userId);
	}
}
