package com.phonepe.paymentservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class makepayment {
	
	
	//Field injection
//	@Autowired
//	private payment_interface payment;
	
	private payment_interface payment;
	
	
	//constructor injection
	@Autowired
	public makepayment(@Qualifier("phonepe") payment_interface payment) {
		this.payment=payment;
		System.out.println("makepayment object created.....");
	}
	
	public makepayment() {
		System.out.println("object created of makepayment");
	}
	
	
	//setter injection
//	@Autowired
//	public void setter(@Qualifier("googlepay") payment_interface payment) {
//		this.payment=payment;
//	}
	
	
	public void dotransaction() {
		System.out.println("making payment.....");
		payment.dopayment();
		System.out.println("payment done.......");
	}

}
