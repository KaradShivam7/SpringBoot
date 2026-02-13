package com.security.Spring_Security.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.Spring_Security.Entity.Bank;
import com.security.Spring_Security.Service.Bank_service;

@RestController
public class Bank_controller {
	
	private Bank_service ser;
	
	public Bank_controller(Bank_service ser) {
		this.ser=ser;
	}
	
	
	@PostMapping("/add-bank")
	public ResponseEntity<Bank> addbankcontroller(@RequestBody Bank bank){
		return ser.addbankservice(bank);
	}
	
	
	@GetMapping("/get-all-bank")
	public ResponseEntity<List<Bank>> getallbankcontroller(){
		return ser.getallbankservice();
	}

}
