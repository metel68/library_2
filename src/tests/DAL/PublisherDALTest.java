package tests.DAL;

import DAL.BaseDAL;
import DAL.PublisherDAL;
import java.util.List;
import models.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.*;

public class PublisherDALTest {
    
    public PublisherDALTest() {
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
        System.out.println("PublisherDAL selectAll");
        PublisherDAL instance = new PublisherDAL();
        List<Publisher> result = instance.selectAll();
        assertTrue(result!=null && result.size()>0);
    }


    @Test
    public void testSelectById() {
        System.out.println("PublisherDAL selectById");
        int id = 1;
        PublisherDAL instance = new PublisherDAL();
        Publisher result = instance.selectById(id);
        assertTrue(result!=null);
    }
    
    @Test
    public void testInsert() {
        System.out.println("insert");
        Publisher publisher = null;
        PublisherDAL instance = new PublisherDAL();
        int expResult = 0;
        int result = instance.insert(publisher);
        assertEquals(expResult, result);
    }


    @Test
    public void testUpdate() {
        System.out.println("update");
        Publisher publisher = null;
        PublisherDAL instance = new PublisherDAL();
        int expResult = 0;
        int result = instance.update(publisher);
        assertEquals(expResult, result);
    }


    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 1;
        PublisherDAL instance = new PublisherDAL();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
    
}
