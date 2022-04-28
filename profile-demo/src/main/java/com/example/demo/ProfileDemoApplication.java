package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProfileDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ProfileDemoApplication.class, args);
		
		context.getBean(UserService.class);
	}

}
