package com.pagination.pagination.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pagination.pagination.DTO.Cardto;
import com.pagination.pagination.Entity.Car;
import com.pagination.pagination.Repository.Car_repository;

@Service
public class Car_service {
	
	private Car_repository repo;
	
	public Car_service(Car_repository repo) {
		this.repo=repo;
	}
	
	
	public ResponseEntity<Car> addcar(Car car){
		return new ResponseEntity<Car>(repo.save(car),HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<List<Cardto>> getcar(int number, int size,String direction, String field) {
	  
		Sort sor;
		if(direction.equals("desc")|| direction.equals("DESC")) {
			sor=Sort.by(Sort.Direction.DESC,field);
		}
		else {
			 sor=Sort.by(Sort.Direction.ASC,field);
		}
		
		
	    Pageable pageable = PageRequest.of(number, size, sor);
	         List<Cardto> page=  repo.findAll(pageable).stream()
	    		.map((c)->{Cardto car=new Cardto();
	    		car.setCarid(c.getCarid());
	    		car.setCarname(c.getCarname());
	    		car.setPrice(c.getPrice());
	    		car.setAverage(c.getAverage());
	    		return car;})
	    		.collect(Collectors.toList());
	    		
	          
	          return new ResponseEntity<List<Cardto>>(page,HttpStatus.FOUND);
	}


}
