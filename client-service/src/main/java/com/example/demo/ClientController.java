package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class ClientController {
	@Autowired
	RestTemplate restTemplate;
	@PostMapping
	private ResponseEntity<Integer> callme(@RequestBody User user) {
		return restTemplate.postForEntity("http://localhost:8081/user", user, Integer.class);
	}
}

