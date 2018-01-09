package tests.controllers;

import controllers.PublisherController;
import java.util.Date;
import java.util.List;
import models.Publisher;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.*;

public class PublisherControllerTest {
    
    public PublisherControllerTest() {
    }
    
    @Rule
    public TestRule timeout = new Timeout(1000);
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        PublisherController instance = new PublisherController();
        List<Publisher> expResult = null;
        List<Publisher> result = instance.selectAll();
        assertEquals(expResult, result);
    }

    @Test
    public void testSelectById() {
        System.out.println("selectById");
        int id = 0;
        PublisherController instance = new PublisherController();
        Publisher expResult = null;
        Publisher result = instance.selectById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Publisher publisher1 = new Publisher(1, "Ognivo");
        PublisherController instance = new PublisherController();
        Publisher result = instance.insert(publisher1);
        Publisher expResult = instance.selectById(publisher1.getId());
        assertEquals(expResult, result);
    }

    @Test(expected=PersistenceException.class)
    public void testInsertEmpty() {
        System.out.println("insertEmpty");
        Publisher book = new Publisher();
        PublisherController instance = new PublisherController();
        Publisher expResult = null;
        Publisher result = instance.insert(book);
        assertEquals(expResult, result);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        PublisherController instance = new PublisherController();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
    
}
