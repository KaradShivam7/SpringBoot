package com.Ecomerce.flipcart.DTO;

import java.util.List;

public class User_dto {
	
	private int userid;
	private String username;
	private List<order2> orders;
	private List<address2> address;
	
	
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
