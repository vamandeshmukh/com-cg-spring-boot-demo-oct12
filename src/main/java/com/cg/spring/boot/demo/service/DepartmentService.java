package com.cg.spring.boot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Department;
import com.cg.spring.boot.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository depRepository;

	public List<Department> getAllDepartments() {
		System.out.println("Service getAllDepartments");
		return depRepository.findAll();
	}

	public Department getDepartmentById(int did) {
		System.out.println("Service getDepartmentById");
		return depRepository.findById(did).get();
	}

	public Department addDepartment(Department department) {
		System.out.println("Service addDepartment");
		if (!depRepository.existsById(department.getDid()))
			return depRepository.save(department);
		System.out.println(department.getDid() + " already exists.");
		return null;
	}

	public Department updateDepartment(Department department) {
		System.out.println("Service updateDepartment");
		if (depRepository.existsById(department.getDid()))
			return depRepository.save(department);
		System.out.println(department.getDid() + " does not exist.");
		return null;
	}

	public int deleteDepartmentById(int did) {
		System.out.println("Service deleteDepartmentById");
		if (depRepository.existsById(did)) {
			depRepository.deleteById(did);
			return did;
		}
		System.out.println(did + " does not exist.");
		return 0;
	}
}
