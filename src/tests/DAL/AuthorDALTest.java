package tests.DAL;

import DAL.AuthorDAL;
import DAL.BaseDAL;

import java.util.List;
import models.Author;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.*;

public class AuthorDALTest {
    
    public AuthorDALTest() {
    }
    
    @Rule
    public TestRule timeout = new Timeout(1000);
    
    @Before
    public void setUp() {
    	BaseDAL.initSqlSessionFactory();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSelectAll() {
        System.out.println("AuthorDAL selectAll");
        AuthorDAL instance = new AuthorDAL();
        List<Author> result = instance.selectAll();
        assertTrue(result!=null && result.size()>0);
    }


    @Test
    public void testSelectById() {
        System.out.println("AuthorDAL selectById");
        int id = 1;
        AuthorDAL instance = new AuthorDAL();
        Author result = instance.selectById(id);
        assertTrue(result!=null);
    }

    @Test
    public void testSelectByName() {
        System.out.println("AuthorDAL selectByName");
        String name = "";
        AuthorDAL instance = new AuthorDAL();
        Author result = instance.selectByName(name);
        assertTrue(result!=null);
    }
  
   
    @Test
    public void testInsertAndDelete() {
        System.out.println("insert");
        Author author1 = new Author(1, "Hell Bolovich");
        AuthorDAL instance = new AuthorDAL();
        int result = instance.insert(author1);
        int expResult = 1;
        assertEquals(expResult, result);
        result = instance.delete(author1.getId());
        assertEquals(expResult, result);
    }

    @Test(expected=PersistenceException.class)
    public void testInsertEmpty() {
        System.out.println("insertEmpty");
        Author author = new Author();
        AuthorDAL instance = new AuthorDAL();
        int expResult = 0;
        int result = instance.insert(author);
        assertEquals(expResult, result);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 1;
        AuthorDAL instance = new AuthorDAL();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
    
}
