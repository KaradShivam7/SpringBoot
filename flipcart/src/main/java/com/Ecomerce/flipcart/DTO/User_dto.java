package com.Ecomerce.flipcart.DTO;

import java.util.List;

public class User_dto {
	
	private int userid;
	private String username;
	private List<order2> orders;
	private List<address2> address;
	private List<review2>  reviews;
	
	
	
	
	public List<review2> getReviews() {
		return reviews;
	}
	public void setReviews(List<review2> reviews) {
		this.reviews = reviews;
	}
	public List<address2> getAddress() {
		return address;
	}
	public void setAddress(List<address2> address) {
		this.address = address;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<order2> getOrders() {
		return orders;
	}
	public void setOrders(List<order2> orders) {
		this.orders = orders;
	}
	
	
	

}
