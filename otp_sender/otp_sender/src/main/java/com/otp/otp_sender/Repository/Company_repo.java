package com.otp.otp_sender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otp.otp_sender.Entity.Company;

@Repository
public interface Company_repo extends JpaRepository<Company, Integer> {

}
