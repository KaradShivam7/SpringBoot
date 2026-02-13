package com.security.Spring_Security.Config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.Spring_Security.Entity.User;
import com.security.Spring_Security.Repository.User_repository;

@Service
public class myuserdetailservice implements UserDetailsService {

	
	private User_repository repo;
	
	public myuserdetailservice(User_repository repo) {
		this.repo=repo;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repo.getUser(username);
		
		return new myuserprincipal(user);
	}

}
