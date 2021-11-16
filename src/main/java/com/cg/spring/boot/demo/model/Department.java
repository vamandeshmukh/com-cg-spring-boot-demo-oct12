package com.cg.spring.boot.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dep_table")
public class Department implements Serializable {

	private static final long serialVersionUID = -777826216252556657L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;

	@Column
	private String departmentName;

	public Department() {
		super();
	}

	public Department(int did, String departmentName) {
		super();
		this.did = did;
		this.departmentName = departmentName;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", departmentName=" + departmentName + "]";
	}

}

//@Entity
//@Table(name = "dep_table")
//public class Department {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int did;
//
//	@Column
//	private String departmentName;
//
//	@Column
//	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//	private List<Employee> employees;
//
//	public Department() {
//		super();
//	}
//
//	public Department(int did, String departmentName) {
//		super();
//		this.did = did;
//		this.departmentName = departmentName;
//	}
//
//	public Department(int did, String departmentName, List<Employee> employees) {
//		super();
//		this.did = did;
//		this.departmentName = departmentName;
//		this.employees = employees;
//	}
//
//	public int getDid() {
//		return did;
//	}
//
//	public void setDid(int did) {
//		this.did = did;
//	}
//
//	public String getDepartmentName() {
//		return departmentName;
//	}
//
//	public void setDepartmentName(String departmentName) {
//		this.departmentName = departmentName;
//	}
//
//	public List<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}
//
//	@Override
//	public String toString() {
//		return "Department [did=" + did + ", departmentName=" + departmentName + ", employees=" + employees + "]";
//	}
//
//}
