package com.punemetro.metro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.punemetro.metro.Entity.Ticket;

public interface Ticket_repo extends JpaRepository<Ticket, Integer> {

}
