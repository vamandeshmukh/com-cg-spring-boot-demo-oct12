package com.cg.spring.boot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// follow identifier naming conventions
	// findByExistingFieldName(existing field name)

	public abstract List<Employee> findByFirstName(String firstName);

	public abstract List<Employee> findBySalary(double salary);

	public abstract List<Employee> findBySalaryGreaterThan(double salary);

	public abstract List<Employee> findBySalaryLessThan(double salary);

//	public abstract List<Employee> findBySalaryBetween(double salary1, double salary2);

}
