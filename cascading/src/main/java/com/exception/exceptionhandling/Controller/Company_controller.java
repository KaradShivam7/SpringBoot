package com.exception.exceptionhandling.Controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.exceptionhandling.Entity.Company;
import com.exception.exceptionhandling.Exception.UserNotFoundException;
import com.exception.exceptionhandling.Service.Company_service;

import jakarta.validation.Valid;

@RestController
public class Company_controller {
	
	private Company_service service;
	
	public Company_controller(Company_service service) {
		this.service=service;
	}
	
	
	@PostMapping("/add-company")
	public ResponseEntity<Company> addcom(@Valid @RequestBody Company company){
		return service.addcompany(company);
	}
	
	@GetMapping("/get-company-by-id/{id}")
	public ResponseEntity<Optional<Company>> getcom(@PathVariable(value="id") int id) throws UserNotFoundException{
		return service.getcompany(id);
	}

}
