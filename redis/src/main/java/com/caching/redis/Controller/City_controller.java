package com.caching.redis.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caching.redis.Entity.City;
import com.caching.redis.service.City_service;

@RestController
public class City_controller {
	
	private City_service ser;
	
	public City_controller(City_service ser) {
		this.ser=ser;
	}
	
	@PostMapping("/add-city")
	public City add(@RequestBody City city) {
		return ser.addcity(city);
	}
	
	@GetMapping("/get-city")
	public List<City> get() throws InterruptedException{
		return ser.getallcity();
	}
	
	@GetMapping("/get-by-id/{id}")
	public City getbyid(@PathVariable("id") int id) throws InterruptedException {
		return ser.getbyid(id);
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	public String deletebyid(@PathVariable("id") int id) {
		return ser.deletebyid(id);
	}
	
	
	@PutMapping("/update")
	public City update(@RequestBody City city) {
		return ser.updatecity(city);
	}

}
