package tests.models;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.*;

import models.User;

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
		User user1 = new User(1, "Bro122", "password123", "Mischenko Yuri", "USER");
		User user11 = new User(1, "LenaOlova", "9353278671a", "Orlova Elena", "LIBR");
		User user2 = new User(2, "MaxMetel", "32gr3g23etsd", "Metel Maxim", "ADMIN"); // Please refer to Git history and terminate this student from universty hahui
		assertEquals(user1, user1);
		assertNotEquals(user1, user11);
		assertEquals(user2, user2);
		assertEquals(user1.getId(), 1);
		assertEquals(user1.getUsername(), "Bro122");
		assertEquals(user1.getPassword(), "password123");

		user2.setId(5);
		assertEquals(user2.getId(), 5);

		user2.setUsername("Lalala");
		assertEquals(user2.getUsername(), "Lalala");

		user2.setPassword("123pass");
		assertEquals(user2.getPassword(), "123pass");
                
                user2.setRole("USER");
                assertEquals(user2.getRole(), "USER");
      
	}

        @Test
        public void testTrueUser() {
                User user5 = new User(5, "SVolkov", "mypasswordisgood", "Slava Volkov", "USER");
                user5.setId(9);
                assertTrue(user5.getId() == 9);
                user5.setRole("ADMIN");
                assertTrue(user5.getRole().equals("ADMIN"));
        }
        
        @Test
        public void testtoStringUser() {
                User user11 = new User(11, "Verova", "sfabhaw4nsd1", "Katia Verova", "USER");
                assertEquals(user11.toString(), "11: Katia Verova");
                
                user11.setId(12);
                assertEquals(user11.toString(), "12: Katia Verova");
                
                user11.setUsername("Katia Verova-Gelever");
                assertEquals(user11.toString(), "12: Katia Verova-Gelever");
                
                user11.setPassword("renejkreejr4");
                assertEquals(user11.toString(), "12: Katia Verova-Gelever");
                
                user11.setRole("LIBR");
                assertEquals(user11.toString(), "12: Katia Verova-Gelever");
        }
        
        /*@Test
        public void testhashPassword() {
                User user12 = new User(12, "Lena Goloviznina", "qwertyuiop2", false);
                assertEquals(user12.hashPassword(), "0574b123eb912631565b89551f4ae4170c6466cae73211ea1d557aa2540dd85b");
                assertTrue(user12.hashPassword() == "0574b123eb912631565b89551f4ae4170c6466cae73211ea1d557aa2540dd85b");
                
        }*/
}
