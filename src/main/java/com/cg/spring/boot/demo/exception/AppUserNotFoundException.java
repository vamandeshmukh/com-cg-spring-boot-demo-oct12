package com.cg.spring.boot.demo.exception;

public class AppUserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6294836661695612441L;

	public AppUserNotFoundException() {
		super();
	}

	public AppUserNotFoundException(String message) {
		super(message);
	}
}
