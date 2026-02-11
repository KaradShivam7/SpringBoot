package com.exception.exceptionhandling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.exceptionhandling.Entity.Company;

@Repository
public interface Company_repo extends JpaRepository<Company, Integer>{

}
