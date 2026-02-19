package com.punemetro.metro.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.punemetro.metro.Entity.Passenger;
import com.punemetro.metro.Exception.emailexception;
import com.punemetro.metro.Exception.passwordexception;
import com.punemetro.metro.Exception.usernamecannotbenullexception;
import com.punemetro.metro.Exception.validmobilenumberexception;
import com.punemetro.metro.Repository.Passenger_repo;

import jakarta.validation.Valid;

@Service
public class Passenger_service {
	
	private Passenger_repo repo;
	
	public Passenger_service(Passenger_repo repo) {
		this.repo=repo;
	}
	
	
	public ResponseEntity<Passenger> addpassengerservice(Passenger passenger) throws usernamecannotbenullexception, validmobilenumberexception, passwordexception, emailexception{
		if(passenger.getPassengerusername()==null || passenger.getPassengerusername().isBlank()) {
			throw new usernamecannotbenullexception("Please enter the username!!!");
		}
		else if(!(passenger.getPassengermobilenumber().length()==10)) {
			throw new validmobilenumberexception("please enter the valid mobile number!!!");
		}
		else if(passenger.getPassengerpassword()==null || passenger.getPassengerpassword().isBlank()) {
			throw new passwordexception("Please enter the password!!!");
		}
		else if(!passenger.getPassengeremail().endsWith("@gmail.com")) {
			throw new emailexception("please enter the valid Email");
		}
		else {
		return new ResponseEntity<Passenger>(repo.save(passenger),HttpStatus.CREATED);
		}
	}

}
