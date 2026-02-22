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
import com.example.jpa.Repository.Student_repository;

@RestController
@RequestMapping("/student")
public class Student_controller {
	
	
	@Autowired
	private Student_repository repo;
	
	@PostMapping("/add")
	public Student add(@RequestBody Student student) {
		
		repo.save(student);
		return student;
	}
	
	@GetMapping("/get-all")
	public List<Student> get_all(){
		
		return repo.findAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public Student getbyid(@PathVariable("id") int id) {
		return repo.getById(id);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String delete(@PathVariable("id") int id) {
		repo.deleteById(id);
		return id+": deleted Successfully";
	}

}
