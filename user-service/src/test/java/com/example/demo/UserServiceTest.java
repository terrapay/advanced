package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@InjectMocks
	UserService service;
	@Mock
	UserRepository repository;
	
	@Test
	void testSaveUser() {
		Users user = new Users();
		user.setId(1);
		user.setName("Pariwesh");
		when(repository.save(user)).thenReturn(user);
		Users result = service.saveUser(user);
		assertEquals(1, result.getId());
	}
	
	@Test
	void testSaveUserWithBlankName() {
		Users user = new Users();
		user.setId(1);
		user.setName("");
		assertThrowsExactly(IllegalArgumentException.class,
				()-> service.saveUser(user));
	}

}
