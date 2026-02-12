package com.pagination.pagination.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.pagination.DTO.Cardto;
import com.pagination.pagination.Entity.Car;
import com.pagination.pagination.Service.Car_service;

import jakarta.validation.Valid;

@RestController
public class Car_controller {
	
	private Car_service ser;
	
	public Car_controller(Car_service ser) {
		this.ser=ser;
	}
	
	
	@PostMapping("/add-car")
	public ResponseEntity<Car> addcar(@Valid @RequestBody Car car){
		return ser.addcar(car);
	}
	
	
	@GetMapping("/get-car")
	public ResponseEntity<List<Cardto>> getcar(@RequestParam(value="number") int number, @RequestParam(value="size") int size,@RequestParam(value="direction") String direction, @RequestParam(value="field") String field){
		return ser.getcar(number, size,direction,field);  
		
	}

}
