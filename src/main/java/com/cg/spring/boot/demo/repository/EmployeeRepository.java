package com.cg.spring.boot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.model.Employee;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// follow identifier naming conventions
	// findByExistingFieldName(existing field name)

	public abstract List<Employee> findByFirstName(String firstName);

	public abstract List<Employee> findByFirstNameStartsWith(String firstName);

	public abstract List<Employee> findBySalary(double salary);

	public abstract List<Employee> findBySalaryGreaterThan(double salary);

	public abstract List<Employee> findBySalaryLessThan(double salary);

	@Query(name = "SELECT e FROM Employee WHERE e.salary BETWEEN ?1 AND ?2") // JPQL
	public abstract List<Employee> findBySalaryBetween(double salary1, double salary2);

//	public abstract List<Employee> findBySalaryBetween(double salary1, double salary2);

}
