package com.cg.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComCgSpringBootDemoApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ComCgSpringBootDemoApplication.class);

	public static void main(String[] args) {

		LOG.info("Start");
		SpringApplication.run(ComCgSpringBootDemoApplication.class);
		LOG.info("End");

	}
}
