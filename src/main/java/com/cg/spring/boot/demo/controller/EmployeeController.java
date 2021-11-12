package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// http://localhost:8082/getempbyid/{eid}
	@GetMapping("/getempbyid/{eid}")
	public Employee getEmpById(@PathVariable(name = "eid") int eid) {
		System.out.println("Controller getEmpById");
		return empService.getEmployeeById(eid);
	}

	// http://localhost:8082/addemp
	@PostMapping("/addemp")
	public Employee addEmp(@RequestBody Employee employee) {
		System.out.println("Controller addEmp");
		return empService.addEmployee(employee);
	}

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
