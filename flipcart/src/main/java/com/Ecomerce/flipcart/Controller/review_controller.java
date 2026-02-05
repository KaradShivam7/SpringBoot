package com.Ecomerce.flipcart.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecomerce.flipcart.DTO.review_dto;
import com.Ecomerce.flipcart.Entity.review;
import com.Ecomerce.flipcart.Service.review_service;

@RestController
@RequestMapping("/review")
public class review_controller {
	
	private review_service service;
	
	public review_controller(review_service service) {
		this.service=service;
	}
	
	@PostMapping("/add-review")
	public review addreviewservice(@RequestBody review review) {
		return service.addreviewservice(review);
	}
	
	
	@GetMapping("/get-all-review")
	public List<review_dto> getallreviewcontroller(){
		return service.getallreviewservice();
	}

}
