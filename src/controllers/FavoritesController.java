package controllers;

import java.sql.Timestamp;

import DAL.UserDAL;
import models.Book;
import models.FavoritesItem;
import models.User;

public class FavoritesController {
	private UserDAL dal;

	public FavoritesController() {
		this.dal = new UserDAL();
		dal.initSqlSessionFactory();
	}

	public int check(int bookId, int userId) {
		Book book = new Book(bookId);
		User user = new User(userId);
		FavoritesItem fav = new FavoritesItem(book, user);
		return dal.checkUserFav(fav);
	}
	
	public int count(int bookId) {
		Book book = new Book(bookId);
		return dal.countBookFav(bookId);
	}

	public int link(int bookId, int userId) {
		Book book = new Book(bookId);
		User user = new User(userId);
		FavoritesItem fav = new FavoritesItem(book, user);
		fav.setTimestamp(new Timestamp(System.currentTimeMillis()));
		return dal.insertUserFav(fav);
	}

	public int unlink(int bookId, int userId) {
		Book book = new Book(bookId);
		User user = new User(userId);
		FavoritesItem fav = new FavoritesItem(book, user);
		return dal.deleteUserFav(fav);
	}

	public FavoritesItem get(FavoritesItem fav) {
		return dal.getUserFav(fav);
	}

	@Deprecated
	public FavoritesItem insert(FavoritesItem fav) {
		dal.insertUserFav(fav);
		return fav;
	}

	@Deprecated
	public FavoritesItem delete(FavoritesItem fav) {
		dal.deleteUserFav(fav);
		return fav;
	}

	public int deleteAll(int userId) {
		return dal.deleteUserFavs(userId);
	}
}
