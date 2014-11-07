package com.speed.kinship.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.speed.kinship.controller.impl.ThingHandlerImpl;
import com.speed.kinship.model.Thing;
import com.speed.kinship.model.User;

public class ThingHandlerImplTest {
	
	ThingHandlerImpl thingHandlerImpl = new ThingHandlerImpl();

	@Test
	public void testAddThing1() {
		User user = new User();
		user.setId(7);
		byte[] bytes = {'A','B'};
		Thing thing = thingHandlerImpl.addThing(user, "kidding", Calendar.getInstance().getTime(), "I am kidding", bytes);
		assertEquals(7, thing.getCreator().getId());
	}
	
	@Test
	public void testAddThing2() {
		User user = new User();
		user.setId(7);
		byte[] bytes = {'A','B'};
		Thing thing = thingHandlerImpl.addThing(user, "kidding", Calendar.getInstance().getTime(), "I am kidding", bytes);
		assertEquals(7, thing.getCreator().getId());
	}
	
	@Test
	public void testAddThing3() {
		User user = new User();
		user.setId(8);
		byte[] bytes = {'A','B'};
		Thing thing = thingHandlerImpl.addThing(user, "kidding", Calendar.getInstance().getTime(), "I am kidding", bytes);
		assertEquals(8, thing.getCreator().getId());
	}

}
