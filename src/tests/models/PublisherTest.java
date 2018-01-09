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
                
                publisher1.setId(3);
		assertEquals(publisher1.getId(), 3);

		publisher1.setName("New Ognivo");
		assertEquals(publisher1.getName(), "New Ognivo");
                
                publisher2.setId(4);
		assertEquals(publisher2.getId(), 4);

		publisher2.setName("KSs");
		assertEquals(publisher2.getName(), "KSs");
	}
    @Test
        public void testTruePublisher() {
                Publisher publisher5 = new Publisher(5, "The New Ray");
                publisher5.setName("New Ray");
		assertTrue(publisher5.getName() == "New Ray");
                publisher5.setId(9);
		assertTrue(publisher5.getId() == 9);
        }
    @Test
        public void testtoStringPublisher() {
                Publisher publisher11 = new Publisher(11, "Billy How Co.");
                assertEquals(publisher11.toString(), "11: Billy How Co.");  
                
                publisher11.setId(12);
                assertEquals(publisher11.toString(), "12: Billy How Co.");
                publisher11.setName("Billy How & Gool Co.");
                assertEquals(publisher11.toString(), "12: Billy How & Gool Co.");
                assertTrue(publisher11.toString() == "12: Billy How & Gool Co.");
        }
}
