package com.cg.spring.boot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "Hello world!";
	}

}
