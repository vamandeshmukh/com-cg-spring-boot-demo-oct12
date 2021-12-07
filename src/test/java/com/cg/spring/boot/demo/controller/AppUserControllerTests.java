package com.cg.spring.boot.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.model.Role;

@SpringBootTest

public class AppUserControllerTests {

	@Autowired
	AppUserController controller;

	@Test
	public void testLogin() {
		AppUser expected = new AppUser("vaman", "vaman", Role.ADMIN);

		ResponseEntity<AppUser> actual = controller.login(expected);

		assertEquals(expected, actual);

	}

}
