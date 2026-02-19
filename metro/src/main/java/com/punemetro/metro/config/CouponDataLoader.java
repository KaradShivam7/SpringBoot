package com.punemetro.metro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.punemetro.metro.Entity.Coupon;
import com.punemetro.metro.Repository.Coupon_repo;

@Component
public class CouponDataLoader implements CommandLineRunner {

    @Autowired
    private Coupon_repo couponRepository;

    @Override
    public void run(String... args) throws Exception {
        if (couponRepository.count() == 0) {
            couponRepository.save(new Coupon("NEWUSER50", 50, true));
            couponRepository.save(new Coupon("WEEKEND10", 10, true));
        }
    }
}

