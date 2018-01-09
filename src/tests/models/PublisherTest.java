package tests.models;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.*;

import models.Publisher;

public class PublisherTest {
    
    @Rule
    public TestRule timeout = new Timeout(100);
    
    public PublisherTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
	public void testCreatePublisher() {
		Publisher publisher = new Publisher();
		assertNotNull(publisher);
	}
	
    @Test
	public void testEqualsPublisher() {
		Publisher publisher1 = new Publisher(1, "Ognivo");
		Publisher publisher11 = new Publisher(1, "OOO Roga&Kopita");
		Publisher publisher2 = new Publisher(2, "KS");
		assertEquals(publisher1, publisher1);
		assertEquals(publisher1, publisher11);
		assertEquals(publisher2, publisher2);
	}
    
}
