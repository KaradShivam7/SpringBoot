package com.Ecomerce.flipcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecomerce.flipcart.Entity.User;

public interface User_repository extends JpaRepository<User, Integer> {

}
