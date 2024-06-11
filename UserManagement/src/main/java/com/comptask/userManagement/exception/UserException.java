package com.comptask.userManagement.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserException {

	@ExceptionHandler(value= MethodArgumentNotValidException.class)
	public String methodArgumentNotValidException(Model model) {
		
		model.addAttribute("exception", "Please provide the valid data....");
		
		return "methodArg";
	}
}
