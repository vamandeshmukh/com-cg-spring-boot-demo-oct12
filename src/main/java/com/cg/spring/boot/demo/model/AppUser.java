package com.cg.spring.boot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_user_table")
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	@Column(unique = true)
	private String userName;

	@Column
	private String password;

	@Column
	private Role role;

	public AppUser() {
		super();
	}

	public AppUser(String userName, String password, Role role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public AppUser(int uid, String userName, String password, Role role) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AppUser [uid=" + uid + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}
