package com.caching.redis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caching.redis.Entity.City;

public interface City_repo extends JpaRepository<City, Integer>{

}
