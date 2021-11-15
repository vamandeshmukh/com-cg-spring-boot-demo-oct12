package com.cg.spring.boot.demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

//@Component
@RestController
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empService;

	// http://localhost:8082/getallemps
	@GetMapping("/getallemps")
	public List<Employee> getAllEmps() {
		LOG.info("getAllEmps"); // in normal block
		LOG.warn("getAllEmps"); // in normal or exception block
		LOG.error("getAllEmps"); // in exception block
//		LOG.debug("getAllEmps"); // in debug mode 
		return empService.getAllEmployees();
	}

	// http://localhost:8082/getempbyid/101
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

	// http://localhost:8082/updateemp
	@PutMapping("/updateemp")
	public Employee updateEmp(@RequestBody Employee employee) {
		System.out.println("Controller updateEmp");
		return empService.updateEmployee(employee);
	}

	@DeleteMapping("/deleteempbyid/{eid}")
	public int deleteEmpById(@PathVariable int eid) {
		System.out.println("Controller deleteEmpById");
		return empService.deleteEmployeeById(eid);
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
