package com.punemetro.metro.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int passengerid;
	
	@NotNull
	private String passengerusername;
	
	@NotNull
	private String passengerpassword;
	
	@Email
	private String passengeremail;
	
	
	private String passengermobilenumber;
	
	
	@OneToMany(mappedBy = "passenger")
	private List<Ticket> tickets;
	
	

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public int getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}

	public String getPassengerusername() {
		return passengerusername;
	}

	public void setPassengerusername(String passengerusername) {
		this.passengerusername = passengerusername;
	}

	public String getPassengerpassword() {
		return passengerpassword;
	}

	public void setPassengerpassword(String passengerpassword) {
		this.passengerpassword = passengerpassword;
	}

	public String getPassengeremail() {
		return passengeremail;
	}

	public void setPassengeremail(String passengeremail) {
		this.passengeremail = passengeremail;
	}

	public String getPassengermobilenumber() {
		return passengermobilenumber;
	}

	public void setPassengermobilenumber(String passengermobilenumber) {
		this.passengermobilenumber = passengermobilenumber;
	}
	
	

}
