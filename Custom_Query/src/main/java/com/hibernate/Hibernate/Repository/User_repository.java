package com.hibernate.Hibernate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hibernate.Hibernate.Entity.User;


@Repository
public interface User_repository extends JpaRepository<User, Integer> {
	
	
	@Query( value = "SELECT * FROM user WHERE name = :name", nativeQuery = true)
    public List<User> findByName(@Param("name") String name);
	
	
	
	
	

}
