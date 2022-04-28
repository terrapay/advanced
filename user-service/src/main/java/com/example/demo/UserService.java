package com.example.demo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Transactional(rollbackOn = {Exception.class}, dontRollbackOn = {IllegalArgumentException.class, IOException.class})
	public Users saveUser(Users user) {
		System.out.println(user);
		userRepository.save(user);
		validateName(user);
		return user;
	}
	@Transactional(value = TxType.REQUIRES_NEW)
	private void validateName(Users user) {
		if(user.getName().equals("")) {
			throw new IllegalArgumentException();
		}
	}
	public List<Users> getUsers() {
		return userRepository.findAll();
	}
	public Optional<Users> getUser(int id) {
		return userRepository.findById(id);
	}
	public Optional<Users> getUserByName(String name) {
		
		Optional<Users> user = userRepository.getByName(name);
		System.out.println(user);
		return user;
	}
}
