package com.amazon.orderservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class user_control {
	
	user user=new user();
	
	
	@GetMapping("/getuser")
	public String getuser() {
		user.name="shivam";
		user.mobile=8329870807l;
		return user.toString();
	}
 

}
class user{
	String name;
	Long mobile;
	
	public String toString() {
		return this.name+" "+this.mobile;
	}
}