package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.User;

public class UserTest {

	@Test
	public void testCreateUser() {
		User user = new User();
		assertNotNull(user); //xD
	}
	
	@Test
	public void testEquals() {
		User user1 = new User(1, "Rak", "Rakovich");
		User user11 = new User(1, "Rak", "Rakovich");
		User user2 = new User(2, "Max", "Too");
		assertNotEquals(user1, user2);
		assertEquals(user1, user1);
		assertEquals(user1, user11);
		assertEquals(user2, user2);
	}

}
