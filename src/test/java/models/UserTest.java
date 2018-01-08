package test.java.models;

import models.Rights;
import static models.Rights.ADMIN;
import static models.Rights.READER;
import models.User;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.*;

public class UserTest {
    
    @Rule
    public TestRule timeout = new Timeout(100);
    
    public UserTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
	public void testCreateUser() {
		User user = new User();
		assertNotNull(user);
	}
	
    @Test
	public void testEqualsUser() {
		User user1 = new User(1, "Bro122", "password123", READER);
		User user11 = new User(1, "LenaOlova", "9353278671a", READER);
		User user2 = new User(2, "MaxMetel", "32gr3g23etsd", ADMIN);
		assertEquals(user1, user1);
		assertEquals(user1, user11);
		assertEquals(user2, user2);
                assertEquals(user1.getId(), 1);
                assertEquals(user1.getUsername(), "Bro122");
                assertEquals(user1.getPassword(), "password123");
                
                user2.setId(5);
                assertEquals(user2.getId(), 5);
        
                user2.setUsername("Lalala");
                assertEquals(user2.setUsername(), "Lalala");
        
                user2.setPassword("123pass");
                assertEquals(user2.getPassword(), "123pass");
            }
    
}
