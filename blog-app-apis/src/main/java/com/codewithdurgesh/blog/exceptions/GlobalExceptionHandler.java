package com.codewithdurgesh.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithdurgesh.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String msg = ex.getMessage();
		ApiResponse apiResponse =  new ApiResponse(msg,false);
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> resp = new HashMap<>();
		 ex.getBindingResult().getAllErrors().forEach((error)->{
			 String fieldName =((FieldError)error).getField();
			 String defaultMessage = error.getDefaultMessage();
			 resp.put(fieldName,defaultMessage);
		 });
		return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
	}
}
