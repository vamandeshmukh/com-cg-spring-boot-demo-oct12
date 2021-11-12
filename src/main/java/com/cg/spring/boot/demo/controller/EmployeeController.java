package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;
//@Component
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	// http://localhost:8082/getallemps
	@GetMapping("/getallemps")
	public List<Employee> getAllEmps() {
		System.out.println("Controller getAllEmps");
		return empService.getAllEmployees();
	}

//	public Employee getEmpById(int eid) {
//		return null;
//	}
//
//	public Employee addEmp(Employee employee) {
//		return null;
//	}

}

//@RestController
//public class EmployeeController {
//
//	@GetMapping("/getemp")
//	public Employee getEmployee() {
//		System.out.println("getEmployee");
//		return new Employee(101, "Sonu", 10.5);
//	}
//
//	@GetMapping("/getallemp")
//	public List<Employee> getAllEmployees() {
//		System.out.println("getAllEmployees");
//		List<Employee> empList = new ArrayList<>();
//		empList.add(new Employee(101, "Sonu", 10.5));
//		empList.add(new Employee(102, "Monu", 15.5));
//		empList.add(new Employee(103, "Tonu", 12.5));
//		return empList;
//	}
//
////	@RequestMapping("/rrrrr")
////	@GetMapping("/ggggg")
////	@PostMapping("/aaaa")
////	@PutMapping("/ppp")
////	@DeleteMapping("/ddddd")
//
//}
