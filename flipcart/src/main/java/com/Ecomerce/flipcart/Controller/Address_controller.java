package com.Ecomerce.flipcart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecomerce.flipcart.DTO.address_dto;
import com.Ecomerce.flipcart.Entity.Address;
import com.Ecomerce.flipcart.Service.Address_service;

@RestController
@RequestMapping("/address")
public class Address_controller {
	
	@Autowired
	private Address_service service;
	
	
	@PostMapping("/add-address")
	public Address addaddresscontroller(@RequestBody Address address) {
		return service.addaddressservice(address);
	}
	
	@GetMapping("/get-all-address")
	public List<address_dto> getalladdress(){
		return service.getalladdressservice();
	}

}
