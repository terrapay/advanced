package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Optional<Users> getByName(String name);
//	@Query("SELECT u from users where name= :name")
//	Optional<Users> getByNameWithQuery(String name);

}
