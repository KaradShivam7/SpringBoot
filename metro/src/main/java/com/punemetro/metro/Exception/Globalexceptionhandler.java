package com.punemetro.metro.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class Globalexceptionhandler {
	
	@ExceptionHandler(emailexception.class)
	public ResponseEntity<ErrorResponse> validemail(emailexception ex){
		ErrorResponse er=new ErrorResponse();
		
		er.setStatuscode(404);
		er.setTime(LocalDateTime.now());
		er.setMessage(ex.getMessage());
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(passwordexception.class)
	public ResponseEntity<ErrorResponse> validpassword(passwordexception ex){
		ErrorResponse er=new ErrorResponse();
		
		er.setStatuscode(404);
		er.setTime(LocalDateTime.now());
		er.setMessage(ex.getMessage());
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(usernamecannotbenullexception.class)
	public ResponseEntity<ErrorResponse> usernotfound(usernamecannotbenullexception ex){
		ErrorResponse er=new ErrorResponse();
		
		er.setStatuscode(404);
		er.setTime(LocalDateTime.now());
		er.setMessage(ex.getMessage());
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(validmobilenumberexception.class)
	public ResponseEntity<ErrorResponse> validmobile(validmobilenumberexception ex){
		ErrorResponse er=new ErrorResponse();
		
		er.setStatuscode(404);
		er.setTime(LocalDateTime.now());
		er.setMessage(ex.getMessage());
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> messagenotredable(HttpMessageNotReadableException ex){
		ErrorResponse er=new ErrorResponse();
		
		er.setStatuscode(404);
		er.setTime(LocalDateTime.now());
		er.setMessage(ex.getMessage());
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(invalidstationexception.class)
	public ResponseEntity<ErrorResponse> validstation(invalidstationexception ex){
		ErrorResponse er=new ErrorResponse();
		
		er.setStatuscode(404);
		er.setTime(LocalDateTime.now());
		er.setMessage(ex.getMessage());
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleit(ConstraintViolationException ex){
		
		Map<String,String> mp =new HashMap<String,String>();
		
		ex.getConstraintViolations().stream()
		.forEach((i)->{mp.put(i.getPropertyPath().toString(), i.getMessage());});
		
		return mp;
	}

}
