package com.amazon.orderservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class order_control {

	@GetMapping("/getorder")
	public List<String> getallorder(){
		List<String> list=Arrays.asList("Order 1-mobile","Order 2-laptop","Order 3-mouse");
		return list;
	}
}
