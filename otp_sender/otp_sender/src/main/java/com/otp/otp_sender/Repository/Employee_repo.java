package com.otp.otp_sender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otp.otp_sender.Entity.Employee;

@Repository
public interface Employee_repo extends JpaRepository<Employee, Integer> {

}
