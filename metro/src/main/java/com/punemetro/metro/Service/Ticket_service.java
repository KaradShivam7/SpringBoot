package com.punemetro.metro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.punemetro.metro.DTO.TicketRequestDTO;
import com.punemetro.metro.Entity.Coupon;
import com.punemetro.metro.Entity.Station;
import com.punemetro.metro.Entity.Ticket;
import com.punemetro.metro.Exception.invalidstationexception;
import com.punemetro.metro.Repository.Coupon_repo;
import com.punemetro.metro.Repository.Station_repo;
import com.punemetro.metro.Repository.Ticket_repo;

@Service
public class Ticket_service {

    @Autowired
    private Station_repo stationRepository;

    @Autowired
    private Ticket_repo ticketRepository;
    
    @Autowired
    private Coupon_repo couponRepository;

    public Ticket bookTicket(TicketRequestDTO request) throws invalidstationexception, RuntimeException {

        Station source = stationRepository.findById(request.getSourceId())
                .orElseThrow(() -> new invalidstationexception("Invalid source station"));

        Station destination = stationRepository.findById(request.getDestinationId())
                .orElseThrow(() -> new invalidstationexception("Invalid destination station"));

        if (source.getId() == destination.getId()) {
            throw new invalidstationexception("Source and destination cannot be same");
        }

        double fare = Math.abs(source.getId() - destination.getId()) * 10; // base fare

        // Apply coupon if exists
        if (request.getCouponcode() != null && !request.getCouponcode().isEmpty()) {
            Coupon coupon = couponRepository.findByCode(request.getCouponcode())
                    .orElseThrow(() -> new RuntimeException("Invalid coupon code"));

            if (!coupon.isActive()) {
                throw new RuntimeException("Coupon is not active");
            }

            fare = fare - coupon.getDiscount();  // subtract discount
            if (fare < 0) fare = 0;             // fare should never be negative
        }

        Ticket ticket = new Ticket();
        ticket.setSource(source);
        ticket.setDestination(destination);
        ticket.setPaymentMode(request.getPaymentMode());
        ticket.setAmount(fare);
        ticket.setStatus("BOOKED");

        return ticketRepository.save(ticket);
    }
}

