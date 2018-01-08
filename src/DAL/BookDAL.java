package DAL;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.Book;
import models.BookAuthor;

public class BookDAL extends BaseDAL {
	public List<Book> selectAll() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<Book> ret = session.selectList("book.selectAll");
		session.close();
		return ret;
	}
	
	public Book selectById(int id) {
		SqlSession session = getSqlSessionFactory().openSession();
		Book ret = session.selectOne("book.selectById", id);
		session.close();
		return ret;
	}
	
	public Book selectByName(String title) {
		SqlSession session = getSqlSessionFactory().openSession();
		Book ret = session.selectOne("book.selectByTitle", title);
		session.close();
		return ret;
	}
	
	public int insert(Book book) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.insert("book.insertBook", book);
		session.close();
		return ret;
	}
	
	public int update(Book book) {
		SqlSession session = getSqlSessionFactory().openSession(true);
        System.out.println(book);
		int ret = session.update("book.updateBook", book);
		session.close();
		return ret;
	}
	
	public int delete(int id) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("book.deleteBook", id);
		session.close();
		return ret;
	}
	
	public int insertAuthor(BookAuthor author) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.insert("book.insertBookAuthor", author);
		session.close();
		return ret;
	}
	
	public int deleteAuthor(BookAuthor author) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("book.deleteBookAuthor", author);
		session.close();
		return ret;
	}

	public int deleteAuthorsFromBook(int id) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("book.deleteBookAuthors", id);
		session.close();
		return ret;
	}
}
