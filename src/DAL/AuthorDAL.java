package DAL;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.Author;

public class AuthorDAL extends BaseDAL{
	public List<Author> selectAll() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<Author> ret = session.selectList("author.selectAll");
		session.close();
		return ret;
	}
	
	public Author selectById(int id) {
		SqlSession session = getSqlSessionFactory().openSession();
		Author ret = session.selectOne("author.selectById", id);
		session.close();
		return ret;
	}
	
	public Author selectByName(String name) {
		SqlSession session = getSqlSessionFactory().openSession();
		Author ret = session.selectOne("author.selectByName", name);
		session.close();
		return ret;
	}
	
	public int insert(Author author) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.insert("author.insertAuthor", author);
		session.close();
		return ret;
	}
	
	public int update(Author author) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.update("author.updateAuthor", author);
		session.close();
		return ret;
	}
	
	public int delete(int id) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("author.deleteAuthor", id);
		session.close();
		return ret;
	}
}
