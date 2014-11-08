package com.speed.kinship.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.speed.kinship.controller.impl.StateHandlerImpl;
import com.speed.kinship.model.Feedback;
import com.speed.kinship.model.State;
import com.speed.kinship.model.User;

public class StateHandlerImplTest {

	StateHandlerImpl stateHandlerImpl = new StateHandlerImpl();

	@Test
	public void testAddState() {
		User user = new User();
		user.setId(8);
		byte[] pic = {'A', 'C', 'M'};
		State state = stateHandlerImpl.addState(user, "today is happy", pic);
		assertEquals(8, state.getCreator().getId());
	}
	
	@Test
	public void testAddFeedback() {
		User user = new User();
		user.setId(8);
		Feedback feedback = stateHandlerImpl.addFeedback(2, user, "interesting....");
		assertEquals(8, feedback.getCreator().getId());
	}
	
	@Test
	public void testDeleteState() {
		boolean result = stateHandlerImpl.deleteState(10);
		assertEquals(true, result);
	}

}
