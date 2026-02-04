package com.Ecomerce.flipcart.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecomerce.flipcart.DTO.User_dto;
import com.Ecomerce.flipcart.DTO.address2;
import com.Ecomerce.flipcart.Entity.User;
import com.Ecomerce.flipcart.Repository.User_repository;
import com.Ecomerce.flipcart.DTO.order2;

@Service
public class User_service {
	
	@Autowired
	private User_repository repo;
	
	
	public User add(User user) {
		return repo.save(user);
	}
	
	public List<User_dto> getall(){
		return repo.findAll()
				.stream()
				.map((user)->
				{User_dto ud=new User_dto();
				
				ud.setUserid(user.getUserid());
				ud.setUsername(user.getUsername());
				
				List<order2> order2 = user.getOrders().stream()
						.map((order)->
						{order2 o2=new order2();
						o2.setOrderid(order.getOrderid());
						o2.setItemname(order.getItemname());
						return o2;})
						.collect(Collectors.toList());
				
				List<address2> address2 = user.getAddress().stream()
						.map((address)->
						{address2 a2=new address2();
						a2.setCity(address.getCity());
						a2.setPincode(address.getPincode());
						a2.setState(address.getState());
						
						return a2;})
						.collect(Collectors.toList());
						
				ud.setOrders(order2);
				ud.setAddress(address2);
				return ud;})
				.collect(Collectors.toList());
	}

}
