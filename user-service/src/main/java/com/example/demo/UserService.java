package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	UserMongoRepository userRepository;

	@Transactional
	public Users saveUser(Users user) {
		System.out.println(user.getAddresses());
		userRepository.save(user);
		return user;
	}

	public List<Users> getUsers() {
		return userRepository.findAll();
	}

//	public Optional<Users> getUser(int id) {
//		return userRepository.findById(id);
//	}
//
//	public Optional<Users> getUserByName(String name) {
//
//		Optional<Users> user = userRepository.getByName(name);
//		System.out.println(user);
//		return user;
//	}

//	public void deleteUser(int id) {
//		userRepository.deleteById(id);
//	}
}
