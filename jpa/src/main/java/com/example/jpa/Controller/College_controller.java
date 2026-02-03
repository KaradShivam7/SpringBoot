package com.example.jpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.Entity.College;
import com.example.jpa.Exception.collegenotfoundexception;
import com.example.jpa.Exception.idnotfoundexception;
import com.example.jpa.Exception.invalidnameexception;
import com.example.jpa.Services.College_service;

@RestController
@RequestMapping("/college")
public class College_controller {
	
	@Autowired
	private College_service service;
	
	@PostMapping("/add")
	public College addcontroller(@RequestBody College college) throws invalidnameexception {
		return service.add(college);
	}
	
	@GetMapping("/get-all")
	public List<College> getcontroller() throws collegenotfoundexception{
		return service.getallservice();
	}
	
	@GetMapping("/getbyid/{id}")
	public College getbyidcontroller(@PathVariable("id") int id) throws idnotfoundexception {
		return service.getbyidservice(id);
	}
	
	
	@DeleteMapping("/deletebyid/{id}")
	public String deletebyidcontroller(@PathVariable("id") int id) throws idnotfoundexception {
		return service.deletebyid(id);
	}

}
