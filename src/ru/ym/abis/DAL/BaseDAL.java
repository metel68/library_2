package ru.ym.abis.DAL;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDAL {
	private static SqlSessionFactory sqlSessionFactory;

	public static boolean initSqlSessionFactory() {
		try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
