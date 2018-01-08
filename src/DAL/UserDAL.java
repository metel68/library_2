package DAL;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
}