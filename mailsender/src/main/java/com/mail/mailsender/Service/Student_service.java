package com.mail.mailsender.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.mailsender.Entity.Student;
import com.mail.mailsender.Repository.Student_repository;

@Service
public class Student_service {
	
	@Autowired
	private Student_repository repo;

	
	public Student add(Student student) {
		return repo.save(student);
	}
	
	public List<Student> get(){
		return repo.findAll();
	}
}
