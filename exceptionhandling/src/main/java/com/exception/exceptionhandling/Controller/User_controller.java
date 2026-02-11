package com.exception.exceptionhandling.Controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.exceptionhandling.Entity.User;
import com.exception.exceptionhandling.Exception.UserNotFoundException;
import com.exception.exceptionhandling.Service.User_service;

@RestController
public class User_controller {
	
	private User_service ser;
	
	public User_controller(User_service ser) {
		this.ser=ser;
	}
	
	
	@PostMapping("/add-user")
	public ResponseEntity<User> adduser(@RequestBody User user){
		return ser.adduser(user);
	}
	
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<Optional<User>> getuser(@PathVariable(value="id") int id) throws UserNotFoundException{
		return ser.getbyid(id);
	}

}
