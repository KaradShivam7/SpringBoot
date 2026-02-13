package com.security.Spring_Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.security.Spring_Security.Entity.User;

@Repository
public interface User_repository extends JpaRepository<User, Integer>{
	
	@Query(value="select * from user where username= :nm;",nativeQuery=true)
	public User getUser(@Param(value="nm") String nm);

}
