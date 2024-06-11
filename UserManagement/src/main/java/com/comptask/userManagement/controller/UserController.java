package com.comptask.userManagement.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comptask.userManagement.constants.UserConstant;
import com.comptask.userManagement.model.User;
import com.comptask.userManagement.props.AppProperties;
import com.comptask.userManagement.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AppProperties appProperties;
	
	@GetMapping("/user")
	public String loadUserDetails(Model model) {
		
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "userinfo";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(User user, Model model) {
		Map<String, String> messages = appProperties.getMessages();
		boolean saved = userService.saveUser(user);
		
		if(saved) {
			model.addAttribute("SUCCESS", messages.get("saveSuccess"));
		}else {
			model.addAttribute("saveFail", messages.get("saveFail"));
		}
		return "userinfo";
	}
	
	@GetMapping("/viewAllUser")
	public String viewAllUser(Model model) {
		List<User> allUser = userService.getAllUser();
		List<User> collect= allUser.stream().filter(newUser -> newUser.getIsActive()== UserConstant.isActiveTrue)
		.collect(Collectors.toList());
		model.addAttribute("contact", collect);
		return "contact";
	}
	
	@GetMapping("/edit")
	public String editUser(@RequestParam("userId") Integer userId, Model model) {
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
		return "userinfo";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") Integer userId, Model model) {
		userService.deleteUser(userId);
		return "redirect:viewAllUser";
	}
}
