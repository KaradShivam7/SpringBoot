package com.mail.mailsender.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mail.mailsender.Entity.Student;
import com.mail.mailsender.Service.Mailsender_service;
import com.mail.mailsender.Service.Student_service;

import jakarta.mail.MessagingException;

@RestController
public class Student_controller {
	
	@Autowired
	private Student_service ser;
	
	@Autowired
	private Mailsender_service mser;
	
	
	@PostMapping("/add")
	public Student addstudent(@RequestBody Student student) throws MessagingException {
		
		//mser.sendMessage(student.getStudentemail());
		mser.sendMIMEMessage(student);
		return ser.add(student);
	}
	
	@GetMapping("/get")
	public List<Student> getstudent(){
		return ser.get();
	}

}
