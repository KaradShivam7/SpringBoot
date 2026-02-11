package com.exception.exceptionhandling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.exceptionhandling.Entity.User;

@Repository
public interface User_repository extends JpaRepository<User, Integer>{

}
