package com.example.jpa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.Entity.College;
import com.example.jpa.Exception.collegenotfoundexception;
import com.example.jpa.Exception.idnotfoundexception;
import com.example.jpa.Exception.invalidnameexception;
import com.example.jpa.Repository.College_repository;

@Service
public class College_service {
	
	@Autowired
	private College_repository repo;
	
	public College add(College college) throws invalidnameexception {
		if(college.getCname()==null||college.getCname().isBlank()) {
			throw new invalidnameexception("college name cannot be null or blank");
		}
		if(college.getCcity()==null||college.getCcity().isBlank()) {
			throw new invalidnameexception("city cannot be null or blank");
		}
		return repo.save(college);
	}
	
	public List<College> getallservice() throws collegenotfoundexception{
		
		List<College> college=repo.findAll();
		
		if(college.isEmpty()) {
			throw new collegenotfoundexception("College not found!!!!!!!!!!!!");
		}
		
		return college;
	}
	
	public College getbyidservice(int id) throws idnotfoundexception {
		
		Optional<College> college=repo.findById(id);
		
		if(college.isEmpty()) {
			throw new idnotfoundexception("dtecode not found!!!!!!!!!!!");
		}
		
		return college.get();
		
	}
	
	public String deletebyid(int id) throws idnotfoundexception {
		Optional<College> college = repo.findById(id);
		
		if(college.isEmpty()) {
			throw new idnotfoundexception("DTECODE not found!!!!!!!!!!");
		}
		
		repo.deleteById(id);
		
		return "ID "+id+" : Deleted Successfully";
	}

}
