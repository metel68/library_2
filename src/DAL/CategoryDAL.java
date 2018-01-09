package DAL;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.Category;

public class CategoryDAL extends BaseDAL{
	public List<Category> selectAll() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<Category> ret = session.selectList("category.selectAll");
		session.close();
		return ret;
	}
	
	public Category selectById(int id) {
		SqlSession session = getSqlSessionFactory().openSession();
		Category ret = session.selectOne("category.selectById", id);
		session.close();
		return ret;
	}
	
	public int insert(Category category) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.insert("category.insertCategory", category);
		session.close();
		return ret;
	}
	
	public int update(Category category) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.update("category.updateCategory", category);
		session.close();
		return ret;
	}
	
	public int delete(int id) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("category.deleteCategory", id);
		session.close();
		return ret;
	}
}
