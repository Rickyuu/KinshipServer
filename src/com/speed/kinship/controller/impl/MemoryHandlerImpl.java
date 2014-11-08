package com.speed.kinship.controller.impl;

import java.util.Date;
import java.util.List;

import com.speed.kinship.controller.MemoryHandler;
import com.speed.kinship.dao.MemoryDao;
import com.speed.kinship.dao.impl.MemoryDaoImpl;
import com.speed.kinship.model.Memory;
import com.speed.kinship.model.User;

public class MemoryHandlerImpl implements MemoryHandler {

	@Override
	public List<Memory> getAllMemories(String username) {
		MemoryDao memoryDao = new MemoryDaoImpl();
		List<Memory> memories = memoryDao.queryMemoriesByUserName(username);
		return memories;
	}

	@Override
	public Memory addMemory(User user, Date time, String content) {
		MemoryDao memoryDao = new MemoryDaoImpl();
		int id = memoryDao.insertMemory(user.getId(), time, content);
		Memory memory = new Memory();
		memory.setId(id);
		memory.setCreator(user);
		memory.setTime(time);
		memory.setContent(content);
		return memory;
	}

	@Override
	public boolean deleteMemory(int memoryId) {
		MemoryDao memoryDao = new MemoryDaoImpl();
		return memoryDao.deleteMemory(memoryId);
	}

}
