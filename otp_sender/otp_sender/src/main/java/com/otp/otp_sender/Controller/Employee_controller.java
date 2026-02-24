package com.otp.otp_sender.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.otp.otp_sender.Entity.Employee;
import com.otp.otp_sender.Service.Employee_service;

@RestController
public class Employee_controller {
	
	private Employee_service ser;
	
	public Employee_controller(Employee_service ser) {
		this.ser=ser;
	}
	
	@PostMapping("/add-employeee")
	public ResponseEntity<Employee> addemployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(ser.addemp(emp),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-employee")
	public ResponseEntity<List<Employee>> getall(){
		return new ResponseEntity<List<Employee>>(ser.getemp(),HttpStatus.FOUND);
	}

}
