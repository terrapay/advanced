package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		System.out.println(user);
		if(user.getName().equals("")) {
			throw new IllegalArgumentException();
		}
		userRepository.save(user);
		return user;
	}
}
