package tests.manual;

import java.util.List;

import DAL.BaseDAL;
import DAL.BookDAL;
import models.Book;

public class DbInit {

	public static void main(String[] args) {
		if (BaseDAL.initSqlSessionFactory()) {
			BookDAL dal = new BookDAL();
			List<Book> books = dal.selectAll();
			for (Book book : books) {
				System.out.println(book);
			}
		} else {
			System.out.println("Йоб твойу мать!!!");
		}
	}

}
