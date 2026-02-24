package com.otp.otp_sender.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.otp.otp_sender.Entity.Employee;
import com.otp.otp_sender.Repository.Employee_repo;

@Service
public class Employee_service {
	
	private Employee_repo repo;
	
	public Employee_service(Employee_repo repo) {
		this.repo=repo;
	}
	
	public Employee addemp(Employee employee) {
		return repo.save(employee);
	}
	
	
	public List<Employee> getemp(){
		return repo.findAll();
		}

	
}
