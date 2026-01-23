package com.phonepe.paymentservice.demo;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("phonepe")
@Primary
public class phonepe implements payment_interface {

	@Override
	public void dopayment() {
		System.out.println("payment done from phonepe");
		
	}
	
	public phonepe() {
		System.out.println("phonepe object created.....");
	}

}
