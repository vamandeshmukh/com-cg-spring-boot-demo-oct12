package com.cg.spring.boot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

//@Component

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		System.out.println("Service getAllEmployees");
		return empRepository.findAll();
	}

	public Employee getEmployeeById(int eid) {
		System.out.println("Service getEmployeeById");
		return empRepository.findById(eid).get();
	}

	public Employee addEmployee(Employee employee) {
		return empRepository.save(employee);
	}

}

////@Component
//
//@Service
//public class EmployeeService {
//
//	private List<Employee> empList = new ArrayList<>();
//
//	{
//		empList.add(new Employee(101, "Sonu", 10.5));
//		empList.add(new Employee(102, "Monu", 15.5));
//		empList.add(new Employee(103, "Tonu", 12.5));
//	}
//
//	public List<Employee> getAllEmployees() {
//		System.out.println("Service getAllEmployees");
//		return empList;
//	}
//
//	public Employee getEmployeeById(int eid) {
//		System.out.println("Service getEmployeeById");
//		return empList.stream().filter(e -> eid == e.getEid()).findAny().orElse(null);
//	}
//
//	public Employee addEmployee(Employee employee) {
//		empList.add(employee);
//		return employee;
//	}
//
//}
