package com.speed.kinship.controller.impl;

import java.util.List;

import com.speed.kinship.controller.UserHandler;
import com.speed.kinship.dao.UserDao;
import com.speed.kinship.dao.impl.UserDaoImpl;
import com.speed.kinship.model.Identity;
import com.speed.kinship.model.User;

public class UserHandlerImpl implements UserHandler {

	@Override
	public User login(String username, String password, Identity identity) {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setIdentity(identity);
		User resultUser = userDao.queryUserByNamePassIdentity(user);
		return resultUser;
	}

	@Override
	public User register(String username, String password, Identity identity) {
		UserDao userDao = new UserDaoImpl();
		List<User> users = userDao.queryUserByName(username);
		if(users != null && users.size() != 0) {
			return null;
		}
		Identity[] identities = Identity.values();
		int resultUserId = 0;
		User currentUser = new User();
		currentUser.setUserName(username);
		currentUser.setPassword(password);
		for(int i=0; i<identities.length; i++) {
			currentUser.setIdentity(identities[i]);
			if(identities[i] == identity) {
				resultUserId = userDao.insertUser(currentUser);
			} else {
				userDao.insertUser(currentUser);
			}
		}
		currentUser.setId(resultUserId);
		currentUser.setIdentity(identity);
		return currentUser;
	}

}
