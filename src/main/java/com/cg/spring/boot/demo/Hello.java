package com.cg.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	private static final Logger LOG = LoggerFactory.getLogger(Hello.class);

	// http://localhost:8082/hello
	@RequestMapping("/hello")
	public String hello() {
//		System.out.println("hello");
		LOG.info("hello");
		return "Hello world....!";
	}

// http://localhost:8082/hi
	@RequestMapping("/hi")
	public String hi() {
		System.out.println("hi");
		return "Hi world!";
	}

	// http://localhost:8082/some-other-api
	@RequestMapping("/some-other-api")
	public String someOtherApi() {
		System.out.println("someOtherApi");
		return "<!DOCTYPE html>\r\n" + "<html>\r\n" + "\r\n" + "<head>\r\n" + "</head>\r\n" + "\r\n" + "<body>\r\n"
				+ "    <h1 style='color: blue; font-family: Arial, Helvetica;'>Welcome to Capgemini</h1>\r\n"
				+ "    <p style='color: darkblue; font-family: consolas, Monospace;'>You are most welcome to Capgemini.</p>\r\n"
				+ "    <img src='https://www.capgemini.com/us-en/wp-content/uploads/sites/4/2018/08/cropped-cropped-capgemini_logo_color_rgb.png'>\r\n"
				+ "</body>\r\n" + "\r\n" + "</html>";
	}
}
