package com.nagarro.service;

import com.nagarro.model.User;

public interface UserService {

	public void addUser(User user);

	public boolean authenticateUser(String userName, String password);
}
