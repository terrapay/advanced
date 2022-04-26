package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	@InjectMocks
	UserController controller;
	@Mock
	UserService service;

	@Test
	void testCreateUser() {
		User user = new User();
		user.setId(1);
		when(service.saveUser(user)).thenReturn(user);
		Integer result = controller.createUser(user);
		assertEquals(1, result);
	}

}
