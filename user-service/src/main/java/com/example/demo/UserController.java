package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Integer createUser(@Valid @RequestBody Users user) throws Exception {
		userService.saveUser(user);
		System.out.println(user.getName());
		return user.getId();
	}

	@GetMapping
	List<Users> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{id}")
	ResponseEntity<Users> getUser(@PathVariable int id) {
		Optional<Users> user = userService.getUser(id);
		return generateResponse(user);
	}

	private ResponseEntity<Users> generateResponse(Optional<Users> user) {
		return user.isPresent() ? new ResponseEntity(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/name/{name}")
	ResponseEntity<Users> getUserByName(@PathVariable String name) {
		Optional<Users> user = userService.getUserByName(name);
		return generateResponse(user);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = ((FieldError) error).getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
