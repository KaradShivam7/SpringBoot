package com.phonepe.paymentservice.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("googlepay")
@Primary
public class googlepay implements payment_interface{

	@Override
	public void dopayment() {
		System.out.println("payment doing from googlepay");
	}
	
	public googlepay() {
		System.out.println("googlepay object created......");
	}

}
