package ru.ym.abis.tests.manual;

import java.util.List;

import ru.ym.abis.DAL.BaseDAL;
import ru.ym.abis.DAL.BookDAL;
import ru.ym.abis.models.Book;

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
