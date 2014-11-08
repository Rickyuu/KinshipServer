package com.speed.kinship.dao;

import java.util.Date;
import java.util.List;

import com.speed.kinship.model.Memory;

public interface MemoryDao {

	public int insertMemory(int userId, Date time, String content);
	
	public boolean deleteMemory(int memoryId);
	
	public List<Memory> queryMemoriesByUserName(String userName);
	
}
