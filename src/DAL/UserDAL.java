package DAL;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.FavoritesItem;
import models.User;

public class UserDAL extends BaseDAL {
	public List<User> selectAll() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<User> ret = session.selectList("user.selectAll");
		session.close();
		return ret;
	}
	
	public User selectById(int id) {
		SqlSession session = getSqlSessionFactory().openSession();
		User ret = session.selectOne("user.selectById", id);
		session.close();
		return ret;
	}

	public User selectByLogin(String username) {
		SqlSession session = getSqlSessionFactory().openSession();
		User ret = session.selectOne("user.selectByLogin", username);
		session.close();
		return ret;
	}
	
	public int insert(User user) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.insert("user.insertUser", user);
		session.close();
		return ret;
	}
	
	public int update(User user) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.update("user.updateUser", user);
		session.close();
		return ret;
	}	
	
	public int delete(int id) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("user.deleteUser", id);
		session.close();
		return ret;
	}
	
	public int countBookFav(int bookId) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		Integer tmp = session.selectOne("book.countBookFav", bookId); // happy debugging! xD
		session.close();
		return tmp;
	}
	
	public int checkUserFav(FavoritesItem fav) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		Integer tmp = session.selectOne("user.checkUserFav", fav);
		session.close();
		return tmp;
	}
	
	public int insertUserFav(FavoritesItem fav) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.insert("user.insertUserFav", fav);
		session.close();
		return ret;
	}
	
	public int deleteUserFav(FavoritesItem fav) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("user.deleteUserFav", fav);
		session.close();
		return ret;
	}

	public int deleteUserFavs(int id) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("user.deleteUserFavs", id);
		session.close();
		return ret;
	}
	
}
