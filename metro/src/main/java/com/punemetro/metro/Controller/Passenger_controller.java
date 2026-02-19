package com.punemetro.metro.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.punemetro.metro.Entity.Passenger;
import com.punemetro.metro.Exception.emailexception;
import com.punemetro.metro.Exception.passwordexception;
import com.punemetro.metro.Exception.usernamecannotbenullexception;
import com.punemetro.metro.Exception.validmobilenumberexception;
import com.punemetro.metro.Service.Passenger_service;

import jakarta.validation.Valid;

@RestController
public class Passenger_controller {
	
	private Passenger_service service;
	
	public Passenger_controller(Passenger_service service) {
		this.service=service;
	}
	
	
	@PostMapping("/add-passenger")
	public ResponseEntity<Passenger> addpassenger(@Valid @RequestBody Passenger passenger) throws usernamecannotbenullexception, validmobilenumberexception, passwordexception, emailexception{
		return service.addpassengerservice(passenger);
	}

}
