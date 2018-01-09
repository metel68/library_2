package tests.controllers;

import controllers.PublisherController;
import java.util.List;
import models.Publisher;
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
    public TestRule timeout = new Timeout(100);
    
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
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectById() {
        System.out.println("selectById");
        int id = 0;
        PublisherController instance = new PublisherController();
        Publisher expResult = null;
        Publisher result = instance.selectById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Publisher publisher = null;
        PublisherController instance = new PublisherController();
        Publisher expResult = null;
        Publisher result = instance.insert(publisher);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        Publisher publisher = null;
        PublisherController instance = new PublisherController();
        int expResult = 0;
        int result = instance.update(publisher);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        PublisherController instance = new PublisherController();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
