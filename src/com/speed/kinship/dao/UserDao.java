package com.speed.kinship.dao;

import java.util.List;

import com.speed.kinship.model.User;

public interface UserDao {
	
	public int insertUser(User user);
	
	public User queryUserById(int id);
	
	public List<User> queryUserByName(String userName);
	
	public User queryUserByNamePassIdentity(User user);
	
}
