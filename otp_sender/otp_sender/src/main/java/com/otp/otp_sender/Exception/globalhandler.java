package com.otp.otp_sender.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalhandler {
	
	@ExceptionHandler(invalidotpexception.class)
	public ResponseEntity<errorresponse> invalidotp(invalidotpexception ex) {
		errorresponse er=new errorresponse();
		er.setMessage(ex.getMessage());
		er.setStatuscode(400);
		er.setTime(LocalDateTime.now());
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<errorresponse>(er,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(OtpExpiredException.class)
	public ResponseEntity<errorresponse> timeout(OtpExpiredException ex) {
		errorresponse er=new errorresponse();
		er.setMessage(ex.getMessage());
		er.setStatuscode(410);
		er.setTime(LocalDateTime.now());
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<errorresponse>(er,HttpStatus.GONE);
	}
	
	
	

}
