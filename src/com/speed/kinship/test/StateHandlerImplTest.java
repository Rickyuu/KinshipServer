package com.speed.kinship.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.speed.kinship.controller.impl.StateHandlerImpl;

public class StateHandlerImplTest {

	StateHandlerImpl stateHandlerImpl = new StateHandlerImpl();
	
	@Test
	public void testDeleteState() {
		boolean result = stateHandlerImpl.deleteState(8);
		assertEquals(false, result);
	}
	
	@Test
	public void testDeleteState2() {
		boolean result = stateHandlerImpl.deleteState(12);
		assertEquals(true, result);
	}
	
	@Test
	public void testDeleteState3() {
		boolean result = stateHandlerImpl.deleteState(6);
		assertEquals(true, result);
	}

}
