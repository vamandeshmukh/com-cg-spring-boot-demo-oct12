package com.cg.spring.boot.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Department;
import com.cg.spring.boot.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService depService;

	// http://localhost:8082/getalldeps
	@GetMapping("/getalldeps")
	public List<Department> getAllDeps() {
		System.out.println("Controller getAllDeps");
		return depService.getAllDepartments();
	}

	// http://localhost:8082/getdepbyid/11
	@GetMapping("/getdepbyid/{did}")
	public Department getDepById(@PathVariable(name = "did") int did) {
		System.out.println("Controller getDepById");
		return depService.getDepartmentById(did);
	}

	// http://localhost:8082/adddep
	@PostMapping("/adddep")
	public Department addDep(@RequestBody Department department) {
		System.out.println("Controller addDep");
		return depService.addDepartment(department);
	}

	// http://localhost:8082/updatedep
	@PutMapping("/updatedep")
	public Department updateDep(@RequestBody Department department) {
		System.out.println("Controller updateDep");
		return depService.updateDepartment(department);
	}

	@DeleteMapping("/deletedepbyid/{did}")
	public int deleteDepById(@PathVariable int did) {
		System.out.println("Controller deleteDepById");
		return depService.deleteDepartmentById(did);
	}

}
