package com.cg.spring.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.AppUserAlreadyExistsException;
import com.cg.spring.boot.demo.exception.AppUserNotFoundException;
import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.repository.AppUserRepository;

@Service
public class AppUserService {

	// use this field to give access to different controller APIs 
	public boolean isLoggedIn;

	private AppUser tempUser;

	private static final Logger LOG = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	AppUserRepository appUserRepository;

	public AppUser register(AppUser appUser) {
		LOG.info("register");
		if (appUserRepository.findByUserName(appUser.getUserName()).getUserName()
				.equalsIgnoreCase(appUser.getUserName()))
			throw new AppUserAlreadyExistsException();
		return appUserRepository.save(appUser);
	}

	public AppUser login(AppUser appUser) {
		LOG.info("login");
		tempUser = appUserRepository.findByUserName(appUser.getUserName());
		if (tempUser.getUserName().equalsIgnoreCase(appUser.getUserName())) {
			isLoggedIn = true;
			return tempUser;
		}
		throw new AppUserNotFoundException();
	}

	public String logout(String userName) {
		LOG.info("logout");
		if (isLoggedIn) {
			isLoggedIn = false;
			return "User logged out successfully.";
		}
		throw new AppUserNotFoundException();
	}
}
