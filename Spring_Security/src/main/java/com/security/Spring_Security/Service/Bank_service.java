package com.security.Spring_Security.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.security.Spring_Security.Entity.Bank;
import com.security.Spring_Security.Repository.Bank_repository;

@Service
public class Bank_service {
	
	private Bank_repository repo;
	
	public Bank_service(Bank_repository repo) {
		this.repo=repo;
	}
	
	
	public ResponseEntity<Bank> addbankservice(Bank bank){
		return new ResponseEntity<Bank>(repo.save(bank),HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<List<Bank>> getallbankservice(){
		return new ResponseEntity<List<Bank>>(repo.findAll(),HttpStatus.OK); 
	}

}
