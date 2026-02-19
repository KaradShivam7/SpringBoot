package com.punemetro.metro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.punemetro.metro.Entity.Passenger;

public interface Passenger_repo extends JpaRepository<Passenger, Integer> {

}
