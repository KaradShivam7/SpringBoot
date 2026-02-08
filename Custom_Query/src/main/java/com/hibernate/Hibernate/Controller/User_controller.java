package com.hibernate.Hibernate.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.Hibernate.Entity.User;
import com.hibernate.Hibernate.Service.User_service;

@RestController
public class User_controller {
	
	private User_service service;
	
	public User_controller(User_service service) {
		this.service=service;
	}
	
	
	@PostMapping("/add-user")
	public User addusercontroller(@RequestBody User user) {
		return service.adduserservice(user);
	}
	
	@GetMapping("/get-all-user")
	public List<User> getallusercontroller(){
		return service.getuserservice();
	}
	
	
	@GetMapping("/get-all/{name}")
	public List<User> getall(@PathVariable("name") String name){
		return service.getuserbynameservice(name);
	}

}
