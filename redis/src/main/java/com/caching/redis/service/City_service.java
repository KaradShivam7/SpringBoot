package com.caching.redis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import com.caching.redis.Entity.City;
import com.caching.redis.Repository.City_repo;



@Service
public class City_service {
	
	private City_repo repo;
	
	
	public City_service(City_repo repo) {
		this.repo=repo;
	}
	
	@CacheEvict(value="cities", allEntries =true)
	public City addcity(City city) {
		return repo.save(city);
	}
	
	@Cacheable("cities")
	public List<City> getallcity() throws InterruptedException{
		System.out.println("calling db");
		Thread.sleep(10000);
		return repo.findAll();
	}
	
	@Cacheable(value = "cities", key = "#id")
	public City getbyid(int id) throws InterruptedException {
		Thread.sleep(5000);
		return repo.findById(id).get();
	}
	
	@CacheEvict(value = "cities", allEntries = true)
	public String deletebyid(int id) {
	   repo.deleteById(id);
	   return "city deleted successfully";
	}
	
	
	@CachePut(value = "cities", key = "#city.id")
	@CacheEvict(value = "cities", allEntries = true)
	public City updatecity(City city) {
		return repo.save(city);
	}

}
