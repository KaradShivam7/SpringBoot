package com.Ecomerce.flipcart.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Orderf {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderid;
	private String itemname;
	private double price;
	
	@JoinColumn(name="userid")
	@ManyToOne
	private User user;
	
	@ManyToOne
	@JoinColumn(name="addressid")
	private Address address;
	
	@OneToOne(mappedBy = "order")
	private review review;
	

	public review getReview() {
		return review;
	}

	public void setReview(review review) {
		this.review = review;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
