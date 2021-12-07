package com.cg.spring.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.service.AppUserService;

@RestController
@CrossOrigin(origins = "*")
public class AppUserController {

	private static final Logger LOG = LoggerFactory.getLogger(AppUserController.class);

	@Autowired
	private AppUserService userService;

	// http://localhost:8082/register
	@PostMapping("/register")
	public ResponseEntity<AppUser> register(@RequestBody AppUser appUser) {
		LOG.info("register " + appUser.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User registered successfully.");
		return new ResponseEntity<AppUser>(userService.register(appUser), headers, HttpStatus.CREATED);
	}

	// http://localhost:8082/login
	@PostMapping("/login")
	public ResponseEntity<AppUser> login(@RequestBody AppUser appUser) {
		LOG.info("login " + appUser.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User logged in successfully.");
		return new ResponseEntity<AppUser>(userService.login(appUser), headers, HttpStatus.OK);
	}

	// http://localhost:8082/logout
	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestBody String userName) {
		LOG.info("Controller logout");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User logged out successfully.");
		return new ResponseEntity<String>(userService.logout(userName), headers, HttpStatus.OK);
	}
}
