package com.codewithdurgesh.blog.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.UserDto;
import com.codewithdurgesh.blog.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto createdUser = this.userService.createUser(userDto);
		
		return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);
	}
	
	//update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userdto, @PathVariable Integer userId){
		UserDto updatedUser = this.userService.updateUser(userdto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	//delete user
	
	@DeleteMapping("/{userId}")
//	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
//		
//		userService.deletUser(userId);
//		
//		return new ResponseEntity<>(Map.of("message","User Deleted Successfully"),HttpStatus.OK);
//	}
	
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deletUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
	
	// get user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
	// get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		return ResponseEntity.ok(userService.getAllUsers());
	}
}
