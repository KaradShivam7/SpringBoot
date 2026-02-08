package com.hibernate.Hibernate.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hibernate.Hibernate.Entity.User;
import com.hibernate.Hibernate.Repository.User_repository;

@Service
public class User_service {
	
	private User_repository repo;
	
	public User_service(User_repository repo) {
		this.repo=repo;
	}
	
	
	public User adduserservice(User user) {
		return repo.save(user);
	}
	
	public List<User> getuserservice(){
		return repo.findAll();
	}
	
	public List<User> getuserbynameservice(String name){
		return repo.findByName(name);
	}

}
