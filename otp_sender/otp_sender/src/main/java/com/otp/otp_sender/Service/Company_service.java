package com.otp.otp_sender.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.otp.otp_sender.Entity.Company;
import com.otp.otp_sender.Repository.Company_repo;

@Service
public class Company_service {
	
	private Company_repo repo;
	
	public Company_service(Company_repo repo) {
		this.repo=repo;
	}
	
	
	
	public Company addcompany(Company company) {
		return repo.save(company);
	}
	
	
	
	public List<Company> getallcompany(){
		return repo.findAll();
		}

}
