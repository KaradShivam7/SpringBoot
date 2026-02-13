package com.security.Spring_Security.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.Spring_Security.Entity.User;
import com.security.Spring_Security.Service.User_service;

@RestController
public class User_controller {
 
	private User_service ser;
	
	public User_controller(User_service ser) {
		this.ser=ser;
	}
	
	
	@PostMapping("/add-user")
	public ResponseEntity<User> addusercontroller(@RequestBody User user){
		return ser.adduserservice(user);
	}
	
	
	@GetMapping("/get-all-user")
	public ResponseEntity<List<User>> getallusercontroller(){
		return ser.getuserservice();
	}
}
