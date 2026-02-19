package com.punemetro.metro.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;         // e.g., "NEWUSER50"
    private double discount;     // e.g., 50.0 for 50 Rs off
    private boolean active;      // true if coupon is valid

    public Coupon() { }

    public Coupon(String code, double discount, boolean active) {
        this.code = code;
        this.discount = discount;
        this.active = active;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
