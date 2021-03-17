package com.nagarro.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.UserDao;
import com.nagarro.model.User;
import com.nagarro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public boolean authenticateUser(String userName, String password) {
		return userDao.authenticateUser(userName, password);
	}

}
