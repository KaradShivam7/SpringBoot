package com.security.Spring_Security.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.Spring_Security.Entity.User;
import com.security.Spring_Security.Repository.User_repository;

@Service
public class User_service {
	
	private User_repository repo;
	
	public User_service(User_repository repo) {
		this.repo=repo;
	}
	
	
	public ResponseEntity<User> adduserservice(User user){
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(5);
		
		User us=new User();
		us.setUserid(user.getUserid());
		us.setUsername(user.getUsername());
		us.setUserpassword(bcrypt.encode(user.getUserpassword()));
		us.setRoles(user.getRoles());
		
		return new ResponseEntity<User>(repo.save(us),HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<User>> getuserservice(){
		return new ResponseEntity<List<User>>(repo.findAll(),HttpStatus.OK);
	}

}
