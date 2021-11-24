package com.cg.spring.boot.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class EmployeeControllerTests {

	@Autowired
	private EmployeeController controller;

	@Test
	public void testGetAllEmps() {
		HttpStatus expected = controller.getEmpById(2).getStatusCode();
		HttpStatus actual = HttpStatus.OK;
		
		assertEquals(expected, actual);
		
	}

}
