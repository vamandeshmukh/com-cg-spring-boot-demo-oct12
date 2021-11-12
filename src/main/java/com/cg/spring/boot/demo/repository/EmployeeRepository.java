package com.cg.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spring.boot.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
