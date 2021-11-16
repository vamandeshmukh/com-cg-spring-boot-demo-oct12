package com.cg.spring.boot.demo.exception;

public class DepartmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 407249825957210123L;

	public DepartmentNotFoundException() {
		super();

	}

	public DepartmentNotFoundException(String message) {
		super(message);
	}
}
