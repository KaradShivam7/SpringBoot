package com.Ecomerce.flipcart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecomerce.flipcart.DTO.User_dto;
import com.Ecomerce.flipcart.Entity.User;
import com.Ecomerce.flipcart.Service.User_service;

@RestController
@RequestMapping("/user")
public class User_controller {
	
	@Autowired
	private User_service service;
	
	
	@PostMapping("/add-user")
	public User addusercontroller(@RequestBody User user) {
		return service.add(user);
	}
	
	@GetMapping("/get-all-user")
	public List<User_dto> getusercontroller(){
		return service.getall();
	}
	

}
