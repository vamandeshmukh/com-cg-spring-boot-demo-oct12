package com.cg.spring.boot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	// URL - http://localhost:8082/hello
	// Endpoint, API - hello

	@RequestMapping("/hello") // endpoint , API
	public String hello() {
		System.out.println("hello");
		return "Hello world!";
	}

// http://localhost:8082/hi

	@RequestMapping("/hi")
	public String hi() {
		System.out.println("hi");
		return "Hi world!";
	}

}
