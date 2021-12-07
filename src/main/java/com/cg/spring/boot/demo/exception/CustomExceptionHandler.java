package com.cg.spring.boot.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.spring.boot.demo.model.AppUser;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException() {
		LOG.error("handleEmployeeNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Object> handleDepartmentNotFoundException() {
		LOG.error("handleDepartmentNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This department is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppUserAlreadyExistsException.class)
	public ResponseEntity<AppUser> handleAppUserAlreadyExistsException() {
		LOG.error("handleAppUserAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This username is already registered.");
		return new ResponseEntity<AppUser>(null, headers, HttpStatus.valueOf(403));
	}

	@ExceptionHandler(AppUserNotFoundException.class)
	public ResponseEntity<Object> handleAppUserNotFoundException() {
		LOG.error("handleAppUserNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This username is not found.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.valueOf(404));
	}

	// @ExceptionHandler(SomeOtherException.class)
//	public ResponseEntity<Object> handleSomeOtherException() {
//		// code 
//	}

}