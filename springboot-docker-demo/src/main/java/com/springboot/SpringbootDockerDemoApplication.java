package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDockerDemoApplication 
{

	@GetMapping("/welcome")
	public String getmsg()
	{
		return "Welcome to Docker demo";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerDemoApplication.class, args);
	}

}
