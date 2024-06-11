package com.comptask.userManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comptask.userManagement.constants.UserConstant;
import com.comptask.userManagement.model.User;
import com.comptask.userManagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public boolean saveUser(User user) {

		user.setIsActive(UserConstant.isActiveTrue);
		User newUser = userRepository.save(user);
		
		if(newUser != null && newUser.getUserId() != null) {
			return true;
		}
		return false;
	}
	

	@Override
	public List<User> getAllUser() {

		List<User> allUsers = userRepository.findAll();
		
		return allUsers;
	}

	@Override
	public User getUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()){
			return user.get();
		}
		return null;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User exisingUser = user.get();
			exisingUser.setIsActive(UserConstant.isActiveFalse);
			userRepository.save(exisingUser);
			return true;
		}
		return false;
	}

}
