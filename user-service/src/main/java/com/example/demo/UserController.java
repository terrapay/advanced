package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;// mocked during testing

	@PostMapping
	public Integer createUser(@RequestBody Users user) throws Exception {
		userService.saveUser(user);
		System.out.println(user.getName());
		return user.getId();
	}

}
