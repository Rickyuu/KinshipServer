package com.speed.kinship.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.speed.kinship.controller.impl.MemoryHandlerImpl;
import com.speed.kinship.model.Memory;
import com.speed.kinship.model.User;

public class MemoryHandlerImplTest {

	MemoryHandlerImpl memoryHandlerImpl = new MemoryHandlerImpl();
	
	@Test
	public void testAddMemory1() {
		User user = new User();
		user.setId(7);
		Date date = Calendar.getInstance().getTime();
		date.setTime(date.getTime() - 1000*60*60*24*1);
		Memory memory = memoryHandlerImpl.addMemory(user, date, "hahaha");
		assertEquals(7, memory.getCreator().getId());
	}
	
	@Test
	public void testAddMemory2() {
		User user = new User();
		user.setId(8);
		Date date = Calendar.getInstance().getTime();
		date.setTime(date.getTime() - 1000*60*60*24*5);
		Memory memory = memoryHandlerImpl.addMemory(user, date, "hahaha");
		assertEquals(8, memory.getCreator().getId());
	}
	
	@Test
	public void testAddMemory3() {
		User user = new User();
		user.setId(7);
		Date date = Calendar.getInstance().getTime();
		date.setTime(date.getTime() - 1000*60*60*24*4);
		Memory memory = memoryHandlerImpl.addMemory(user, date, "hahaha");
		assertEquals(7, memory.getCreator().getId());
	}

}
