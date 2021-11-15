package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.EmployeeNotFoundException;
import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		System.out.println("Service getAllEmployees");
		return empRepository.findAll();
	}

//	public Employee getEmployeeById(int eid) {
//		Log.info("getEmployeeById");
//		return empRepository.findById(eid).get();
//	}

	public Employee getEmployeeById(int eid) {
		LOG.info("getEmployeeById");
		Optional<Employee> empOpt = empRepository.findById(eid);
		if (empOpt.isPresent()) {
			LOG.info("Employee is available.");
			return empOpt.get();
		} else {
			LOG.info("Employee is NOT available.");
			throw new EmployeeNotFoundException(eid + " this employee is not found.");
		}
	}

	public Employee addEmployee(Employee employee) {
		System.out.println("Service addEmployee");
		if (!empRepository.existsById(employee.getEid()))
			return empRepository.save(employee);
		System.out.println(employee.getEid() + " already exists.");
		return null;
	}

	public Employee updateEmployee(Employee employee) {
		System.out.println("Service updateEmployee");
		if (empRepository.existsById(employee.getEid()))
			return empRepository.save(employee);
		System.out.println(employee.getEid() + " does not exist.");
		return null;
	}

	public int deleteEmployeeById(int eid) {
		System.out.println("Service deleteEmployeeById");
		if (empRepository.existsById(eid)) {
			empRepository.deleteById(eid);
			return eid;
		}
		System.out.println(eid + " does not exist.");
		return 0;
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
