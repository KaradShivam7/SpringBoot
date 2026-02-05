package com.Ecomerce.flipcart.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecomerce.flipcart.DTO.order_dto;
import com.Ecomerce.flipcart.Entity.Orderf;
import com.Ecomerce.flipcart.Repository.Order_repository;

@Service
public class Order_service {
	
	@Autowired
	private Order_repository repo;
	
	public Orderf addorderservice(Orderf order) {
		return repo.save(order);
	}
	
	public List<order_dto> getallordersercvice() {
		return repo.findAll().stream()
				.map((order)->
				{order_dto od =new order_dto();
				od.setItemname(order.getItemname());
				od.setOrderid(order.getOrderid());
				od.setUserid(order.getUser().getUserid());
				od.setUsername(order.getUser().getUsername());
				od.setCity(order.getAddress().getCity());
				od.setState(order.getAddress().getState());
				od.setPincode(order.getAddress().getPincode());
				od.setRating(order.getReview().getRating());
				
				
				return od;})
				.collect(Collectors.toList());
	}

}
