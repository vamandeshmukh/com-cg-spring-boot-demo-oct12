package com.cg.spring.boot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/getemp")
	public Employee getEmployee() {
		System.out.println("getEmployee");
		return new Employee(101, "Sonu", 10.5);
	}

	@GetMapping("/getallemp")
	public List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees");
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 10.5));
		empList.add(new Employee(102, "Monu", 15.5));
		empList.add(new Employee(103, "Tonu", 12.5));
		return empList;
	}

}
