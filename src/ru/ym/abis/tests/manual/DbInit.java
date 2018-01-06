package ru.ym.abis.tests.manual;

import java.util.List;

import ru.ym.abis.DAL.BaseDAL;
import ru.ym.abis.DAL.UserDAL;
import ru.ym.abis.models.User;

public class DbInit {

	public static void main(String[] args) {
		if (BaseDAL.initSqlSessionFactory()) {
			UserDAL userdal = new UserDAL();
			List<User> users = userdal.selectAll();
			for (User user : users) {
				System.out.println(user);
			}
		} else {
			System.out.println("Йоб твойу мать!!!");
		}
	}

}
