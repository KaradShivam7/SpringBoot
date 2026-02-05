package com.Ecomerce.flipcart.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String rating;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	@OneToOne
	@JoinColumn(name="orderid")
	private Orderf order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Orderf getOrder() {
		return order;
	}

	public void setOrder(Orderf order) {
		this.order = order;
	}
	
	
	

}
