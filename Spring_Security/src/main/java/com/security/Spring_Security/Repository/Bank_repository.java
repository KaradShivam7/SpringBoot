package com.security.Spring_Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.Spring_Security.Entity.Bank;

@Repository
public interface Bank_repository extends JpaRepository<Bank, Integer>  {

}
