/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ym.abis.tests.DAL;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.ym.abis.DAL.BaseDAL;

import static org.junit.Assert.*;

/**
 *
 * @author PFIQ3000
 */
public class BaseDALTest {
    
    public BaseDALTest() {
    }
    
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
