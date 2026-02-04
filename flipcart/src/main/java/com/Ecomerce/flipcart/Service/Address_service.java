package com.Ecomerce.flipcart.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecomerce.flipcart.DTO.Order3;
import com.Ecomerce.flipcart.DTO.address_dto;
import com.Ecomerce.flipcart.Entity.Address;
import com.Ecomerce.flipcart.Repository.Address_repository;

@Service
public class Address_service {
	
	
	@Autowired
	private Address_repository repo;
	
	
	public Address addaddressservice(Address address) {
		return repo.save(address);
	}
	
	public List<address_dto> getalladdressservice() {
	    return repo.findAll().stream()
	        .map((address) -> {
	            address_dto ad = new address_dto();

	            ad.setCity(address.getCity());
	            ad.setPincode(address.getPincode());
	            ad.setState(address.getState());

	            ad.setId(address.getUser().getUserid());
	            ad.setUsername(address.getUser().getUsername());

	            List<Order3> ol3 = address.getOrder().stream()
	                .map((order) -> {
	                    Order3 o3 = new Order3();
	                    o3.setId(order.getOrderid());
	                    o3.setItemname(order.getItemname());
	                    return o3;
	                })
	                .collect(Collectors.toList());

	            ad.setOrders(ol3);
	            return ad;
	        })
	        .collect(Collectors.toList());
	}


}
