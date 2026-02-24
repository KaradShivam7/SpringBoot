package com.otp.otp_sender.Controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otp.otp_sender.Entity.Company;
import com.otp.otp_sender.Exception.OtpExpiredException;
import com.otp.otp_sender.Exception.invalidotpexception;
import com.otp.otp_sender.Service.Company_service;
import com.otp.otp_sender.Service.EmailService;

@RestController
public class Company_controller {
	
	private EmailService emailservice;
	private Company_service ser;
	
	public Company_controller(Company_service ser,EmailService emailservice) {
		this.ser=ser;
		this.emailservice=emailservice;
		
	}
	
	
	@PostMapping("/add-company")
	public ResponseEntity<Company> addcom(@RequestBody Company company){
		return new ResponseEntity<Company>(ser.addcompany(company),HttpStatus.CREATED);
		
	}

	
	@GetMapping("/get-company")
	public ResponseEntity<List<Company>> getallcom(){
		return new ResponseEntity<List<Company>>(ser.getallcompany(),HttpStatus.FOUND);
	}
	
	
	
	int otp;
	LocalDateTime starttime;
	
	
	@GetMapping("/get-otp")
	public String getOtp(@RequestParam String email) {
	    otp = (int) (Math.random() * 9000) + 1000;
	    starttime=LocalDateTime.now();
	    
	    emailservice.sendOtp(email, otp);
	    
	    return "OTP Sent To Your Email!!!";
	}
	
	@PostMapping("/verify-otp")
	public String verify(@RequestParam(value="otp") int otp1) throws invalidotpexception, OtpExpiredException {
		
		Duration duration = Duration.between(starttime, LocalDateTime.now());
		if (duration.getSeconds() >= 60) {
		    throw new OtpExpiredException("OTP expired!!!");
		}
		
		if(!(otp==otp1)) {
			throw new invalidotpexception("invalid otp!!!");
		}
		else {
			return "OTP Matched!!!";
		}
	}
}
