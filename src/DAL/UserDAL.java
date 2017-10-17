package DAL;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import models.User;

public class UserDAL extends BaseDAL {
	public List<User> selectAll() {
		SqlSession session = getSqlSessionFactory().openSession();
		return session.selectList("user.selectAll");
	}
	
	public User selectById(int id) {
		SqlSession session = getSqlSessionFactory().openSession();
		return session.selectOne("user:selectById");
	}
}
