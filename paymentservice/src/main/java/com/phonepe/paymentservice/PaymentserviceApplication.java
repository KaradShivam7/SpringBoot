package com.phonepe.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.phonepe.paymentservice.demo.makepayment;
import com.phonepe.paymentservice.demo.phonepe;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentserviceApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(PaymentserviceApplication.class, args);
		
		String[] arr=context.getBeanDefinitionNames();
		
		System.out.println("total number of Beans= "+arr.length);
		
		phonepe pe=context.getBean(phonepe.class);
		
		makepayment mp=context.getBean(makepayment.class);
		mp.dotransaction();
	}

}
