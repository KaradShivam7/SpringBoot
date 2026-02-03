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

import com.example.jpa.Entity.Student;
import com.example.jpa.Exception.idnotfoundexception;
import com.example.jpa.Exception.invalidmobileexception;
import com.example.jpa.Exception.invalidnameexception;
import com.example.jpa.Exception.studentnotfound;
import com.example.jpa.Repository.Student_repository;
import com.example.jpa.Services.Student_services;

@RestController
@RequestMapping("/student")
public class Student_controller {
	
	
	@Autowired
	private Student_services service;
	
	@PostMapping("/add")
	public Student add(@RequestBody Student student) throws invalidmobileexception, invalidnameexception {
		return service.add(student);
	}
	
	@GetMapping("/get-all")
	public List<Student> getallcontroller() throws studentnotfound{
		return service.getall();
	}
	
	@GetMapping("/getbyid/{id}")
	public Student getbyidcontroller(@PathVariable("id") int id) throws idnotfoundexception {
		return service.getbyid(id);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String deletebyidController(@PathVariable("id") int id) throws idnotfoundexception {
		return service.deletebyid(id);
	}
	
}
