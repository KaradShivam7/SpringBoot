package com.pagination.pagination.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagination.pagination.Entity.Car;

@Repository
public interface Car_repository extends JpaRepository<Car, Integer> {

}
