package com.amazon.orderservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/add")
	public String add( @RequestParam String name) {
		System.out.println(name.toUpperCase());
		return "name Added ::"+name;
	}
	
	@PostMapping("/addname")
	public String adduser(@RequestParam(value="n") String name) {
		return "name added:"+name;
	}
	
	@PostMapping("/addn")
	public String addname(@RequestParam(value="na",required=true) String name) {
		return "entered name: "+name;
	}
	
	@PostMapping("/addna")
	public String addname1(@RequestParam(value="nam",required=false) String name) {
		return "entered name: "+name;
	}

	@PostMapping("/addnam")
	public String addname2(@RequestParam(value="na",required=true,defaultValue="shivam karad") String name) {
		return "entered name: "+name;
	}



}

class user{
	String name;
	Long mobile;
	
	public String toString() {
		return this.name+" "+this.mobile;
	}
}