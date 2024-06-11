package com.codewithdurgesh.blog.service;

import java.util.List;

import com.codewithdurgesh.blog.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List <UserDto> getAllUsers();
	
	void deletUser(Integer userId);
}
