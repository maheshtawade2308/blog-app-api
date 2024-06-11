package com.comptask.userManagement.service;

import java.util.List;

import com.comptask.userManagement.model.User;

public interface UserService {

	public boolean saveUser(User user);
	
	public List<User> getAllUser();
	
	public User getUser(Integer userId);
	
	public boolean deleteUser(Integer userId);
}
