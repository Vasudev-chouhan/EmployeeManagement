package com.nagarro.dao;

import com.nagarro.model.User;

/*
* Class name: UserDao 

* Author: vasudev.chouhan

* Created on: 06/03/2021

* Last updated by: vasudev.chouhan

* Last updated: 10/03/2021

* Description: This is the Dao of User

*/

public interface UserDao {

	public void addUser(User user);

	public boolean authenticateUser(String userName, String password);

}
