package tests.DAL;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAL.BaseDAL;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.*;

public class BaseDALTest {
    
    public BaseDALTest() {
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
    public void testInitSqlSessionFactory() {
        System.out.println("initSqlSessionFactory");
        boolean expResult = false;
        boolean result = BaseDAL.initSqlSessionFactory();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSqlSessionFactory() {
        System.out.println("getSqlSessionFactory");
        SqlSessionFactory expResult = null;
        SqlSessionFactory result = BaseDAL.getSqlSessionFactory();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
