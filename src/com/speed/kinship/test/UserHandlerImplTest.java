package com.speed.kinship.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.speed.kinship.controller.impl.UserHandlerImpl;
import com.speed.kinship.model.Identity;
import com.speed.kinship.model.User;

public class UserHandlerImplTest {

	UserHandlerImpl userHandlerImpl = new UserHandlerImpl();
	
	@Test
	public void testLogin1() {
		User user = userHandlerImpl.login("rickyuu", "123", Identity.PARENT);
		assertNotEquals(null, user);
	}
	
	@Test
	public void testLogin2() {
		User user = userHandlerImpl.login("ricky", "123", Identity.PARENT);
		assertEquals(null, user);
	}
	
	@Test
	public void testLogin3() {
		User user = userHandlerImpl.login("rickyuu", "123123", Identity.PARENT);
		assertEquals(null, user);
	}

}
