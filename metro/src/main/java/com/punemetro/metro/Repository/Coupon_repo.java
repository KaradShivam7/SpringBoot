package com.punemetro.metro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.punemetro.metro.Entity.Coupon;

import java.util.Optional;

public interface Coupon_repo extends JpaRepository<Coupon, Integer> {
    Optional<Coupon> findByCode(String code);
}
