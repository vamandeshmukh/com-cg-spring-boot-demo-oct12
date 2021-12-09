package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.DepartmentNotFoundException;
import com.cg.spring.boot.demo.exception.EmployeeAlreadyExistsException;
import com.cg.spring.boot.demo.exception.EmployeeNotFoundException;
import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.DepartmentRepository;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository empRepository;

	@Autowired
	private DepartmentRepository depRepository;

	public List<Employee> getAllEmployees() {
		System.out.println("Service getAllEmployees");
		return empRepository.findAll();
	}

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
		LOG.info("Service addEmployee");
		if (!empRepository.existsById(employee.getEid())) {
			if (employee.getDepartment() != null)
				return empRepository.save(employee);
			else if (depRepository.existsById(employee.getDepartment().getDid()))
				return empRepository.save(employee);
			else
				throw new DepartmentNotFoundException(
						"Deparement with did " + employee.getDepartment().getDid() + " does not exist.");
		} else
			throw new EmployeeAlreadyExistsException("Employee with eid " + employee.getEid() + " already exists.");
	}

	public Employee updateEmployee(Employee employee) {
		System.out.println("Service updateEmployee");
		if (empRepository.existsById(employee.getEid()))
			return empRepository.save(employee);
		throw new EmployeeNotFoundException("Employee with eid " + employee.getEid() + " does not exist.");
	}

	public Employee deleteEmployeeById(int eid) {
		LOG.info("deleteEmployeeById");
		Optional<Employee> empOpt = empRepository.findById(eid);
		if (empOpt.isPresent()) {
			empRepository.deleteById(eid);
			return empOpt.get();
		} else {
			throw new EmployeeNotFoundException(eid + " this employee does not exist.");
		}
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		LOG.info("getEmployeeByFirstName");
		return empRepository.findByFirstName(firstName);
	}

	public List<Employee> getEmployeeBySalaryInBetween(double salary1, double salary2) {
		LOG.info("getEmployeeBySalaryInBetween");
		return empRepository.findBySalaryBetween(salary1, salary2);
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
