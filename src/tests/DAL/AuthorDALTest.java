package tests.DAL;

import DAL.AuthorDAL;
import java.util.List;
import models.Author;
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
    public TestRule timeout = new Timeout(100);
    
    @Before
    public void setUp() {
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
        String name = "Katia";
        AuthorDAL instance = new AuthorDAL();
        Author result = instance.selectByName(name);
        assertTrue(result!=null);
    }
    

    @Test
    public void testInsert() {
        System.out.println("insert");
        Author author = null;
        AuthorDAL instance = new AuthorDAL();
        int expResult = 0;
        int result = instance.insert(author);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }


    @Test
    public void testUpdate() {
        System.out.println("update");
        Author author = null;
        AuthorDAL instance = new AuthorDAL();
        int expResult = 0;
        int result = instance.update(author);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }


    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 1;
        AuthorDAL instance = new AuthorDAL();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
