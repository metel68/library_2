package DAL;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.Publisher;

public class PublisherDAL extends BaseDAL {
	public List<Publisher> selectAll() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<Publisher> ret = session.selectList("publisher.selectAll");
		session.close();
		return ret;
	}
	
	public Publisher selectById(int id) {
		SqlSession session = getSqlSessionFactory().openSession();
		Publisher ret = session.selectOne("publisher.selectById", id);
		session.close();
		return ret;
	}
	
	public int insert(Publisher publisher) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.insert("publisher.insertPublisher", publisher);
		session.close();
		return ret;
	}
	
	public int update(Publisher publisher) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.update("publisher.updatePublisher", publisher);
		session.close();
		return ret;
	}
	
	public int delete(int id) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("publisher.deletePublisher", id);
		session.close();
		return ret;
	}
}
