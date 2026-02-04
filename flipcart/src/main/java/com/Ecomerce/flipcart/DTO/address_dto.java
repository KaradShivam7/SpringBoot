package com.Ecomerce.flipcart.DTO;

import java.util.List;

import com.Ecomerce.flipcart.Entity.Orderf;

public class address_dto {
	
	
	private String city;
	private String state;
	private String pincode;
	private int id;
	private String username;
	
	private List<Order3> orders;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Order3> getOrders() {
		return orders;
	}

	public void setOrders(List<Order3> orders) {
		this.orders = orders;
	}
	

}
