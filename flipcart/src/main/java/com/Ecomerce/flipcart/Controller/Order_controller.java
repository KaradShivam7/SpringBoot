package com.Ecomerce.flipcart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecomerce.flipcart.DTO.order_dto;
import com.Ecomerce.flipcart.Entity.Orderf;
import com.Ecomerce.flipcart.Service.Order_service;

@RestController
public class Order_controller {
	
	@Autowired
	private Order_service service;
	
	@PostMapping("/add-order")
	public Orderf addordercontroller(@RequestBody Orderf order) {
		return service.addorderservice(order);
	}
	
	@GetMapping("/get-all-order")
	public List<order_dto> getallordercontroller(){
		return service.getallordersercvice();
	}

}
