package com.cg.spring.boot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.model.Role;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	public abstract AppUser findByUserName(String userName);

	public abstract List<AppUser> findByRole(Role role);

}
