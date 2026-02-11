package com.exception.exceptionhandling.Service;

import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exception.exceptionhandling.Entity.User;
import com.exception.exceptionhandling.Exception.UserNotFoundException;
import com.exception.exceptionhandling.Repository.User_repository;

@Service
public class User_service {
	
	private User_repository repo;
	
	public User_service(User_repository repo) {
		this.repo=repo;
	}
	
	
	public ResponseEntity<User> adduser(User user){
		return new ResponseEntity<User>(repo.save(user),HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<Optional<User>> getbyid(int id) throws UserNotFoundException{
		
		 Optional<User> u=Optional.ofNullable(repo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("User not found")));
		return new ResponseEntity<Optional<User>>(u,HttpStatus.FOUND);
	}       
	

}
