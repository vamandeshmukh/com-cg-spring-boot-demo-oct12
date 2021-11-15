package com.cg.spring.boot.demo.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeAlreadyExistsException() {
		super();
	}

	public EmployeeAlreadyExistsException(String message) {
		super(message);

	}
}
