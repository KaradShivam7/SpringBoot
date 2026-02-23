package com.file.fileupload.Exception;

import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(FileAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> filealreadyexist(FileAlreadyExistsException ex){
		ErrorResponse er=new ErrorResponse();
		
		er.setStatuscode(409);
		er.setTime(LocalDateTime.now());
		er.setMessage(ex.getMessage());
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.CONFLICT);
	}
	

}
