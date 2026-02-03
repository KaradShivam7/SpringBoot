package com.example.jpa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.Entity.Student;
import com.example.jpa.Exception.idnotfoundexception;
import com.example.jpa.Exception.invalidmobileexception;
import com.example.jpa.Exception.invalidnameexception;
import com.example.jpa.Exception.studentnotfound;
import com.example.jpa.Repository.Student_repository;

@Service
public class Student_services {
	
	@Autowired
	private Student_repository repo;
	
	
	public Student add(Student student) throws invalidnameexception,invalidmobileexception {
		if (student.getName() == null || student.getName().isBlank()) {
		    throw new invalidnameexception("name can not be null or empty");
		}

		else if(student.getMobile().length()!=10){
			throw new invalidmobileexception("mobile number must be 10 digit");
		}
		
		return repo.save(student);
	}
	
	
	public List<Student> getall() throws studentnotfound{
		List<Student> students=repo.findAll();
		
		if(students.isEmpty()) {
			throw new studentnotfound("student not found");
		}
		
		return students;
	}
	
	
	public Student getbyid(int id) throws idnotfoundexception {
		
	    Optional<Student> studentOpt = repo.findById(id);

	    if (studentOpt.isEmpty()) {
	        throw new idnotfoundexception("Student not found with id: " + id);
	    }
	    return studentOpt.get();
	}
	
	public String deletebyid(int id) throws idnotfoundexception {
		
		Optional<Student> studentOpt = repo.findById(id);
	    if (studentOpt.isEmpty()) {
	        throw new idnotfoundexception("Student not found with id: " + id);
	    }
	    repo.deleteById(id);
	    
	    return "ID " +id+" : deleted successfully";
	}

}
