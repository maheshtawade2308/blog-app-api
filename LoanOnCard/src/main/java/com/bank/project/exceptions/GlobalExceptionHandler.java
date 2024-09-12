package com.bank.project.exceptions;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {


//	    Invalid credit card number, invalid OTP
	    @ExceptionHandler(ValidationException.class)
	    public ResponseEntity<?> handleValidationException(ValidationException ex, WebRequest request) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

//	    exceptions to manage issues like duplicate records or missing entities, and return appropriate responses
	    @ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<?> handleDatabaseException(DataIntegrityViolationException ex, WebRequest request) {
	        return new ResponseEntity<>("Database error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    @ExceptionHandler(HttpClientErrorException.class)
	    public ResponseEntity<?> handleExternalServiceException(HttpClientErrorException ex, WebRequest request) {
	        return new ResponseEntity<>("External service error: " + ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
	    }

//	    implement retries and fallbacks, and catch exceptions like HttpClientErrorException or ResourceAccessException.
	    @ExceptionHandler(AccessDeniedException.class)
	    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
	        return new ResponseEntity<>("Access denied: " + ex.getMessage(), HttpStatus.FORBIDDEN);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
	        return new ResponseEntity<>("Error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}


