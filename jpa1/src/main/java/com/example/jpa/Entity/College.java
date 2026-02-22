package com.example.jpa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class College {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int dtecode;
	public int getDtecode() {
		return dtecode;
	}
//	public void setDtecode(int dtecode) {
//		this.dtecode = dtecode;
//	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	String cname;
	String ccity;

}
