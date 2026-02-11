package com.exception.exceptionhandling.Service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exception.exceptionhandling.Entity.Company;
import com.exception.exceptionhandling.Exception.UserNotFoundException;
import com.exception.exceptionhandling.Repository.Company_repo;

@Service
public class Company_service {
	
	private Company_repo repo;
	
	public Company_service(Company_repo repo) {
		this.repo=repo;
	}
	
	
	public ResponseEntity<Company> addcompany(Company company){
		return new ResponseEntity<Company>(repo.save(company),HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<Optional<Company>> getcompany(int id) throws UserNotFoundException{
		Optional<Company> com=Optional.ofNullable(repo.findById(id).orElseThrow(()->(new UserNotFoundException("Company not found!!!!"))));
		return new ResponseEntity<Optional<Company>>(com,HttpStatus.FOUND);
	}

}
